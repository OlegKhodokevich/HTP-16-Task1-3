package by.khodokevich.task.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ValidatorParseStringOfDouble {
    private static final String LINE_WITH_DOUBLE_REG_EXP = "(\\s*[-+]?\\d*\\.*\\d+\\s*,*\\s*)+";
    final static Logger logger = LogManager.getLogger(ValidatorParseStringOfDouble.class);

    public static boolean validateStringOfDouble(String lineString){
        logger.info("Start to validate string: " + lineString);
        boolean result = false;

        if (lineString.matches(LINE_WITH_DOUBLE_REG_EXP)){
            result = true;
        }
        logger.info("Validating is: " + result);
        return result;
    }
}
