package by.khodokevich.task.reader.impl;

import by.khodokevich.task.exception.CustomerArrayException;
import by.khodokevich.task.parser.ParserStringToArrayDoubleStream;
import by.khodokevich.task.reader.DataDoubleReader;
import by.khodokevich.task.validator.ValidatorParseStringOfDouble;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class DataStringReaderImpl implements DataDoubleReader {
    Logger logger = LogManager.getLogger(DataStringReaderImpl.class);

    @Override
    public String readLineOfDoubleFromTXT(String path) throws CustomerArrayException {
        logger.info("Start read from txt.");

        String trueLine;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line = bufferedReader.readLine();

            logger.info("Line is : " + line);
            while (line != null && !ValidatorParseStringOfDouble.validateStringOfDouble(line)) {
                line = bufferedReader.readLine();
                logger.info("Line is : " + line);
            }

            trueLine = line;

        } catch (FileNotFoundException e) {
            throw new CustomerArrayException("File not found by path: " + path);
        } catch (IOException e) {
            throw new CustomerArrayException("Cant read the file :" + path);
        }

        if (trueLine == null) {
            throw new CustomerArrayException("File has not valid line. File : " + path);
        }

        logger.info("Finish read from txt. True line is : " + trueLine);

        return trueLine;
    }
}
