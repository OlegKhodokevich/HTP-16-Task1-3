package by.khodokevich.task.service.impl;

import by.khodokevich.task.entity.CustomerArray;
import by.khodokevich.task.exception.CustomerArrayException;
import by.khodokevich.task.service.ArrayLogic;
import by.khodokevich.task.validator.ValidatorCustomerArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class ArrayArithmeticLogicImpl implements ArrayLogic {

    static final Logger logger = LogManager.getLogger(ArrayArithmeticLogicImpl.class);

    @Override
    public double findMinValueOfArray(CustomerArray arrayForFirstTask) throws CustomerArrayException {
        if (arrayForFirstTask == null) {
            throw new CustomerArrayException("Array = null");
        }

        if (!ValidatorCustomerArray.checkSizeOfArray(arrayForFirstTask)) {
            throw new CustomerArrayException(" Length of array = 0");
        }

        logger.info("Start ArrayLogic.findMinValueOfArray()");
        logger.info("Array = " + arrayForFirstTask);

        double[] array = arrayForFirstTask.getArray();

        double minValue = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
            }
        }
        logger.info("Min value of array = " + minValue + "\n");

        return minValue;
    }

    @Override
    public double findMaxValueOfArray(CustomerArray arrayForFirstTask) throws CustomerArrayException {
        logger.info("Start ArrayLogic.findMaxValueOfArray()");
        if (arrayForFirstTask == null) {
            throw new CustomerArrayException("Array = null");
        }

        if (!ValidatorCustomerArray.checkSizeOfArray(arrayForFirstTask)) {
            throw new CustomerArrayException(" Length of array = 0");
        }

        logger.info("Array = " + arrayForFirstTask);

        double[] array = arrayForFirstTask.getArray();
        double maxValue = array[0];

        for (double value : array) {
            if (value > maxValue) {
                maxValue = value;
            }
        }
        logger.info("Max value of array = " + maxValue + "\n");

        return maxValue;
    }

    @Override
    public CustomerArray exchangeNumberOfArrayToOtherNumber(CustomerArray arrayForFirstTask, double borrowedValue, double substituteValue) throws CustomerArrayException {
        logger.info("Start ArrayLogic.exchangeNumberOfArrayToOtherNumber()");
        if (arrayForFirstTask == null) {
            throw new CustomerArrayException("Array = null");
        }

        if (!ValidatorCustomerArray.checkSizeOfArray(arrayForFirstTask)) {
            throw new CustomerArrayException(" Length of array = 0");
        }

        logger.info("Array = " + arrayForFirstTask);

        double[] array = arrayForFirstTask.getArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == borrowedValue) {
                array[i] = substituteValue;
            }
        }
        logger.info("New array = " + Arrays.toString(array));

        arrayForFirstTask.setArray(array);

        logger.info("New array = " + arrayForFirstTask + "\n");

        return arrayForFirstTask;
    }

    @Override
    public double sumElementsOfArray(CustomerArray arrayForFirstTask) throws CustomerArrayException {
        logger.info("Start ArrayLogic.sumElementsOfArray()");
        if (arrayForFirstTask == null) {
            throw new CustomerArrayException("Array = null");
        }

        if (!ValidatorCustomerArray.checkSizeOfArray(arrayForFirstTask)) {
            throw new CustomerArrayException(" Length of array = 0");
        }

        logger.info("Array = " + arrayForFirstTask);

        double sum = 0;
        double[] array = arrayForFirstTask.getArray();

        for (double value : array) {
            sum = value;
        }
        logger.info("Sum of array = " + sum + "\n");

        return sum;
    }

    @Override
    public double findAverageValueOfArray(CustomerArray arrayForFirstTask) throws CustomerArrayException {
        logger.info("Start findAverageValueOfArray()");
        if (arrayForFirstTask == null) {
            throw new CustomerArrayException("Array = null");
        }

        if (!ValidatorCustomerArray.checkSizeOfArray(arrayForFirstTask)) {
            throw new CustomerArrayException(" Length of array = 0");
        }

        logger.info("Array = " + arrayForFirstTask);

        double sum = sumElementsOfArray(arrayForFirstTask);
        double averageOfArray = sum / arrayForFirstTask.getArray().length;

        logger.info("Average value of array = " + averageOfArray + "\n");

        return averageOfArray;
    }

    @Override
    public int countNegativeValueOfArray(CustomerArray arrayForFirstTask) throws CustomerArrayException {
        logger.info("Start countNegativeValueOfArray()");
        if (arrayForFirstTask == null) {
            throw new CustomerArrayException("Array = null");
        }

        if (!ValidatorCustomerArray.checkSizeOfArray(arrayForFirstTask)) {
            throw new CustomerArrayException(" Length of array = 0");
        }

        logger.info("Array = " + arrayForFirstTask);

        int count = 0;

        for (double value : arrayForFirstTask.getArray()) {
            if (value < 0) {
                count++;
            }
        }

        logger.info("Number negative elements of array = " + count + "\n");
        return count;
    }

    @Override
    public int countPositiveValueOfArray(CustomerArray arrayForFirstTask) throws CustomerArrayException {
        logger.info("Start countPositiveValueOfArray()");
        if (arrayForFirstTask == null) {
            throw new CustomerArrayException("Array = null");
        }

        if (!ValidatorCustomerArray.checkSizeOfArray(arrayForFirstTask)) {
            throw new CustomerArrayException(" Length of array = 0");
        }

        logger.info("Array = " + arrayForFirstTask);
        int count = 0;

        for (double value : arrayForFirstTask.getArray()) {
            if (value > 0) {
                count++;
            }
        }
        logger.info("Number positive elements of array = " + count + "\n");

        return count;
    }

}
