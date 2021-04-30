package by.khodokevich.task.validator;

import by.khodokevich.task.entity.CustomerArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ValidatorCustomerArray {
    static Logger logger = LogManager.getLogger(ValidatorCustomerArray.class);

    public static boolean checkSizeOfArray(CustomerArray customerArray) {
        logger.info("Start validating array: " + customerArray.toString());
        boolean validSize = true;

        if (customerArray.getArray().length == 0) {
            validSize = false;
        }

        logger.info("Validating is: " + validSize);
        return validSize;
    }
}
