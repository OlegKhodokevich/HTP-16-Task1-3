package by.khodokevich.task.service;

import by.khodokevich.task.entity.CustomerArray;
import by.khodokevich.task.exception.CustomerArrayException;

public interface ArrayServiceSort2 {
    void quickSortArray(CustomerArray customerArray, int low, int high) throws CustomerArrayException;

    CustomerArray sortArrayByMerge(CustomerArray array) throws CustomerArrayException;

    void shellSort(CustomerArray array) throws CustomerArrayException;

}
