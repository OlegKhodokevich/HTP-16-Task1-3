package by.khodokevich.task.service.impl;

import by.khodokevich.task.entity.CustomerArray;
import by.khodokevich.task.exception.CustomerArrayException;
import by.khodokevich.task.service.ArrayLogic;
import by.khodokevich.task.validator.ValidatorCustomerArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.stream.DoubleStream;

public class ArrayArithmeticLogicWithStreamImpl implements ArrayLogic {
    static final Logger logger = LogManager.getLogger(ArrayArithmeticLogicWithStreamImpl.class);

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

        double minValue = DoubleStream.of(arrayForFirstTask.getArray()).summaryStatistics().getMin();

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

        double maxValue = DoubleStream.of(arrayForFirstTask.getArray()).summaryStatistics().getMax();

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

        double[] newArray = Arrays.stream(arrayForFirstTask.getArray()).map(x -> x == borrowedValue ? substituteValue : x).toArray();

        logger.info("New array = " + Arrays.toString(newArray));

        return new CustomerArray(newArray);
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

        double sum = Arrays.stream(arrayForFirstTask.getArray()).summaryStatistics().getSum();
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

        double averageOfArray = Arrays.stream(arrayForFirstTask.getArray()).summaryStatistics().getAverage();
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

        int count = (int) Arrays.stream(arrayForFirstTask.getArray()).filter(x -> x < 0).count();

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

        int count = (int) Arrays.stream(arrayForFirstTask.getArray()).filter(x -> x > 0).count();

        logger.info("Number positive elements of array = " + count + "\n");

        return count;
    }
}
