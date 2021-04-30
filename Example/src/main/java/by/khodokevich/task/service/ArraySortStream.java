package by.khodokevich.task.service;

import by.khodokevich.task.entity.CustomerArray;
import by.khodokevich.task.exception.CustomerArrayException;

public interface ArraySortStream {
    void sortCustomerArray(CustomerArray customerArray) throws CustomerArrayException;
}
