package by.khodokevich.task.creator;

import by.khodokevich.task.entity.CustomerArray;
import by.khodokevich.task.exception.CustomerArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class CustomerArrayCreator {
    static Logger logger = LogManager.getLogger(CustomerArrayCreator.class);

    public CustomerArray createCustomerArray(double [] array) throws CustomerArrayException {
        logger.info("Start creating CustomArray");
        if (array == null || array.length == 0) {
            throw new CustomerArrayException("Array is null or empty.");
        }
        CustomerArray customerArray = new CustomerArray(array);

        logger.info(customerArray);

        return customerArray;
    }
}
