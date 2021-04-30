package by.khodokevich.task.service.impl;


import by.khodokevich.task.entity.CustomerArray;
import by.khodokevich.task.exception.CustomerArrayException;
import by.khodokevich.task.service.ArraySortStream;
import by.khodokevich.task.validator.ValidatorCustomerArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class ArraySortStreamImpl implements ArraySortStream {
    Logger logger = LogManager.getLogger(ArraySortStreamImpl.class);

    @Override
    public void sortCustomerArray(CustomerArray customerArray) throws CustomerArrayException {
        logger.info("Sort with stream \"sortCustomerArray(CustomerArray customerArray)\" start");

        if (customerArray == null || customerArray.getArray() == null) {
            logger.info(" Array is null.");
            throw new CustomerArrayException(" Array is null.");
        }

        if (!ValidatorCustomerArray.checkSizeOfArray(customerArray)) {
            throw new CustomerArrayException(" Length of array = 0");
        }
        logger.info("Transmitted array : " + customerArray);

        double[] newArray = Arrays.stream(customerArray.getArray()).sorted().toArray();

        logger.info("Sort with stream sortCustomerArray(CustomerArray customerArray) has finished. Sorted array :" + customerArray);
        customerArray.setArray(newArray);

    }

}
