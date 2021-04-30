package by.khodokevich.task.reader.impl;

import by.khodokevich.task.exception.CustomerArrayException;
import by.khodokevich.task.reader.DataDoubleReader;
import by.khodokevich.task.reader.DataStringReaderStream;
import by.khodokevich.task.validator.ValidatorParseStringOfDouble;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class DataStringReaderStreamImpl implements DataStringReaderStream {
    static Logger logger = LogManager.getLogger(DataStringReaderStreamImpl.class);

    @Override
    public Optional<String> readLineOfDoubleFromTXT(String fileName) throws CustomerArrayException {
        logger.info("Start read from txt.");

        List<String> arrayOfString = new ArrayList<>();
        Path path = Paths.get(fileName);
        if (Files.exists(path) && !Files.isDirectory(path) && Files.isReadable(path)) {
            try {
                arrayOfString = Files.readAllLines(path)
                        .stream()
                        .collect(Collectors.toList());
            } catch (InvalidPathException e) {
                throw new CustomerArrayException("File is not found. Or something else." + path);
            }  catch (IOException e) {
                throw new CustomerArrayException("String cannot be converted into a Path" + path);
            }
        }

        if (arrayOfString.size() == 0){
            throw new CustomerArrayException("File is empty. File : " + path);
        }

        Optional<String> line = Optional.ofNullable(arrayOfString.stream()
                .filter(s -> ValidatorParseStringOfDouble.validateStringOfDouble(s))
                .findFirst().map(Objects::toString)
                .orElse(null));

        logger.info("Reading from txt has finished. Line  = " + line);
        return line;
    }
}
