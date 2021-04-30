package by.khodokevich.task.parser;

import by.khodokevich.task.creator.CustomerArrayCreator;
import by.khodokevich.task.exception.CustomerArrayException;
import by.khodokevich.task.validator.ValidatorParseStringOfDouble;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class ParserStringToArrayDouble {
    private static final String SPLITTER_TO_NUMBER_REG_EXP = "(\\s*,*\\s+)|(\\s*,+\\s*)";
    private static final String MINUS = "-";

    Logger logger = LogManager.getLogger(ParserStringToArrayDouble.class);

    public double[] parseStringToDouble(String line) throws CustomerArrayException {
        logger.info("Start parse in parseStringToDouble(String line). Line = " + line);
        if (line == null) {
            throw new CustomerArrayException(" Parsed line = null.");
        }
        if (line.length() == 0) {
            throw new CustomerArrayException(" Parsed line is empty.");
        }

        if (!ValidatorParseStringOfDouble.validateStringOfDouble(line)) {
            throw new CustomerArrayException(" The String not validate. Line: " + line);
        }

        String[] arrayOfString = line.split(SPLITTER_TO_NUMBER_REG_EXP);
        double[] arrayDouble = new double[arrayOfString.length];

        for (int i = 0; i < arrayOfString.length; i++) {

            if (arrayOfString[i].contains(MINUS)) {

                int indexSign = arrayOfString[i].indexOf('-');
                arrayOfString[i] = arrayOfString[i].substring(indexSign + 1);
                arrayDouble[i] = -Double.parseDouble(arrayOfString[i]);

            } else {
                arrayDouble[i] = Double.parseDouble(arrayOfString[i]);
            }
        }
        logger.info("Finish parse in parseStringToDouble(String line). Array : " + Arrays.toString(arrayDouble));

        return arrayDouble;
    }


}
