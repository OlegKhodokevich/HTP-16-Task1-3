package by.khodokevich.task.service;

import by.khodokevich.task.entity.CustomerArray;
import by.khodokevich.task.exception.CustomerArrayException;

public interface ArrayLogic {

    double findMinValueOfArray(CustomerArray arrayForFirstTask) throws CustomerArrayException;

    double findMaxValueOfArray(CustomerArray arrayForFirstTask) throws CustomerArrayException;

    CustomerArray exchangeNumberOfArrayToOtherNumber(CustomerArray arrayForFirstTask, double borrowedValue, double substituteValue) throws CustomerArrayException;

    double sumElementsOfArray(CustomerArray arrayForFirstTask) throws CustomerArrayException;

    double findAverageValueOfArray(CustomerArray arrayForFirstTask) throws CustomerArrayException;

    int countNegativeValueOfArray(CustomerArray arrayForFirstTask) throws CustomerArrayException;

    int countPositiveValueOfArray(CustomerArray arrayForFirstTask) throws CustomerArrayException;

}
