package by.khodokevich.task.service.impl;

import by.khodokevich.task.entity.CustomerArray;
import by.khodokevich.task.exception.CustomerArrayException;
import by.khodokevich.task.service.ArrayServiceSort2;
import by.khodokevich.task.validator.ValidatorCustomerArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class ArrayServiceSortImpl2 implements ArrayServiceSort2 {

    static final Logger logger = LogManager.getLogger(ArrayServiceSortImpl2.class);

    @Override
    public void quickSortArray(CustomerArray customerArray, int low, int high) throws CustomerArrayException {
        logger.info("Start quick sort.");

        if (customerArray == null || customerArray.getArray() == null) {
            logger.info(" Array is null.");
            throw new CustomerArrayException(" Array is null.");
        }

        if (!ValidatorCustomerArray.checkSizeOfArray(customerArray)) {
            throw new CustomerArrayException(" Length of array = 0");
        }

        double[] array = customerArray.getArray();
        logger.info("Array :" + Arrays.toString(array));

        int middle = low + (high - low) / 2;
        double pivot = array[middle];

        int i = low;
        int j = high;
        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }

            if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }
        customerArray.setArray(array);

        if (i < high) {
            quickSortArray(customerArray, i, high);
        }
        if (j > low) {
            quickSortArray(customerArray, low, j);
        }
    }

    @Override
    public CustomerArray sortArrayByMerge(CustomerArray customerArrayA) throws CustomerArrayException {
        logger.info("Start sort by merge.");

        if (customerArrayA == null || customerArrayA.getArray() == null) {
            logger.info(" Array is null or empty.");
            throw new CustomerArrayException(" Array is null.");
        }

        if (!ValidatorCustomerArray.checkSizeOfArray(customerArrayA)) {
            throw new CustomerArrayException(" Length of array = 0");
        }

        double[] arrayA = customerArrayA.getArray();

        logger.info("Array :" + Arrays.toString(arrayA));
        if (arrayA.length < 2) {

            return customerArrayA;
        }

        double[] arrayB = new double[arrayA.length / 2];
        System.arraycopy(arrayA, 0, arrayB, 0, arrayA.length / 2);

        double[] arrayC = new double[arrayA.length - arrayA.length / 2];
        System.arraycopy(arrayA, arrayA.length / 2, arrayC, 0, arrayA.length - arrayA.length / 2);

        CustomerArray customerArrayB = new CustomerArray(arrayB);
        CustomerArray customerArrayC = new CustomerArray(arrayC);

        customerArrayB = sortArrayByMerge(customerArrayB);
        customerArrayC = sortArrayByMerge(customerArrayC);

        return mergeArrays(customerArrayB, customerArrayC);
    }

    private CustomerArray mergeArrays(CustomerArray customerArrayB, CustomerArray customerArrayC) {

        double[] arrayB = customerArrayB.getArray();
        double[] arrayC = customerArrayC.getArray();

        int length = arrayB.length + arrayC.length;
        double[] arrayA = new double[length];

        int indexB = 0;
        int indexC = 0;
        for (int i = 0; i < arrayA.length; i++) {
            if (indexB == arrayB.length) {
                arrayA[i] = arrayC[indexC];
                indexC++;
            } else if (indexC == arrayC.length) {
                arrayA[i] = arrayB[indexB];
                indexB++;
            } else if (arrayB[indexB] < arrayC[indexC]) {
                arrayA[i] = arrayB[indexB];
                indexB++;
            } else {
                arrayA[i] = arrayC[indexC];
                indexC++;
            }

        }
        CustomerArray customerArrayA = new CustomerArray(arrayA);

        return customerArrayA;
    }

    @Override
    public void shellSort(CustomerArray customerArray) throws CustomerArrayException {
        logger.info("Start Shell sort.");
        if (customerArray == null || customerArray.getArray() == null) {
            logger.info(" Array is null.");
            throw new CustomerArrayException(" Array is null.");
        }

        if (!ValidatorCustomerArray.checkSizeOfArray(customerArray)) {
            throw new CustomerArrayException(" Length of array <= 0");
        }

        double[] array = customerArray.getArray();
        logger.info("Array :" + Arrays.toString(array));
        int step = array.length / 2;

        while (step > 0) {

            for (int i = step; i < array.length; i++) {

                for (int j = i - step; j >= 0; j = j - step) {

                    if (array[j + step] < array[j]) {
                        swap(array, j, j + step);
                    }
                }
            }
            step = step / 2;
        }

        customerArray.setArray(array);
        logger.info("Shell sorting have finished. Sorted array: " + customerArray);
    }

    private void swap(double[] array, int i, int j) {
        double transfer = array[i];
        array[i] = array[j];
        array[j] = transfer;
    }
}
