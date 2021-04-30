package by.khodokevich.task.reader;

import by.khodokevich.task.exception.CustomerArrayException;

public interface DataDoubleReader {
    String readLineOfDoubleFromTXT(String path) throws CustomerArrayException;
}
