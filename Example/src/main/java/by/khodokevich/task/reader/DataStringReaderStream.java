package by.khodokevich.task.reader;

import by.khodokevich.task.exception.CustomerArrayException;

import java.util.Optional;

public interface DataStringReaderStream {
    public Optional<String> readLineOfDoubleFromTXT(String path) throws CustomerArrayException;
}
