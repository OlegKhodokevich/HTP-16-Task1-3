package by.khodokevich.task.parser;

import by.khodokevich.task.entity.CustomerArray;
import by.khodokevich.task.exception.CustomerArrayException;
import by.khodokevich.task.validator.ValidatorParseStringOfDouble;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParserStringToArrayDoubleStream {
    private static final String SPLITTER_TO_NUMBER_REG_EXP = "(\\s*,*\\s+)|(\\s*,+\\s*)";
    private static final String MINUS = "-";

    Logger logger = LogManager.getLogger(ParserStringToArrayDoubleStream.class);

    public double[] parseStringToDouble(String line) throws CustomerArrayException {
        logger.info("Start parse in parseStringToDouble(String line). Line = " + line);
        if (line == null) {
            throw new CustomerArrayException(" Parse line = null.");
        }

        if (!ValidatorParseStringOfDouble.validateStringOfDouble(line)) {
            throw new CustomerArrayException(" The String not validate. Line :" + line);
        }

        List<String> arrayString =  Arrays.stream(line.split(SPLITTER_TO_NUMBER_REG_EXP)).collect(Collectors.toList());

        double[] arrayDouble = arrayString.stream()
                .mapToDouble(s -> Double.valueOf(s))
                .toArray();

        logger.info("Finish parse in parseStringToDouble(String line). Array : " + Arrays.toString(arrayDouble) + "\n");
        return arrayDouble;
    }
}
