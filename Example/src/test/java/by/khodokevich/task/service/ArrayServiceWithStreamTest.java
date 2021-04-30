package by.khodokevich.task.service;

import by.khodokevich.task.entity.CustomerArray;
import by.khodokevich.task.exception.CustomerArrayException;
import by.khodokevich.task.service.impl.ArrayArithmeticLogicWithStreamImpl;
import org.testng.Assert;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ArrayServiceWithStreamTest {
    ArrayLogic arrayServiceWithStream;

    @BeforeGroups(groups = {"function_min_max_condition", "function_count_elements", "base_flow"})
    public void setUp() {
        arrayServiceWithStream = new ArrayArithmeticLogicWithStreamImpl();
    }

    @Test(dataProvider = "array_chek_min_2", groups = {"function_min_max_condition", "base_flow"})
    public void testFindMinValueOfArrayWithStream1(double[] array, double expectedValue) throws CustomerArrayException {
        CustomerArray customerArray = new CustomerArray(array);
        double valueMin = arrayServiceWithStream.findMinValueOfArray(customerArray);

        Assert.assertEquals(valueMin, expectedValue);
    }

    @Test(expectedExceptions = CustomerArrayException.class, groups = "function_min_max_condition")
    public void testFindMinValueOfArrayWithStream2() throws CustomerArrayException {
        CustomerArray customerArray = null;
        double valueMin = arrayServiceWithStream.findMinValueOfArray(customerArray);
    }

    @Test(dataProvider = "array_chek_max_2", groups = {"function_min_max_condition", "base_flow"})
    public void testFindMaxValueOfArrayWithStream1(double[] array, double expectedValue) throws CustomerArrayException {
        CustomerArray customerArray = new CustomerArray(array);
        double valueMax = arrayServiceWithStream.findMaxValueOfArray(customerArray);

        Assert.assertEquals(valueMax, expectedValue);
    }

    @Test(expectedExceptions = CustomerArrayException.class, groups = "function_min_max_condition")
    public void testFindMaxValueOfArrayWithStream2() throws CustomerArrayException {
        CustomerArray customerArray = null;
        double valueMax = arrayServiceWithStream.findMaxValueOfArray(customerArray);
    }

    @Test(groups = {"function_min_max_condition", "base_flow"})
    public void testExchangeNumberOfArrayToOtherNumberWithStream1() throws CustomerArrayException {
        CustomerArray givenCustomerArray = new CustomerArray(new double[]{1.0, 2.5, -3.1, 6.0});
        CustomerArray expectedCustomerArray = new CustomerArray(new double[]{2.0, 2.5, -3.1, 6.0});

        CustomerArray realCustomerArray = arrayServiceWithStream.exchangeNumberOfArrayToOtherNumber(givenCustomerArray, 1.0, 2.0);

        Assert.assertEquals(realCustomerArray, expectedCustomerArray);
    }

    @Test(expectedExceptions = CustomerArrayException.class, groups = "function_min_max_condition")
    public void testExchangeNumberOfArrayToOtherNumberWithStream2() throws CustomerArrayException {
        CustomerArray customerArray = null;
        CustomerArray realCustomerArray = arrayServiceWithStream.exchangeNumberOfArrayToOtherNumber(customerArray, 0.0, 1.0);
    }

    @Test(expectedExceptions = CustomerArrayException.class, groups = "function_min_max_condition")
    public void testSumElementsOfArray1() throws CustomerArrayException {
        CustomerArray customerArray = null;
        double realCustomerArray = arrayServiceWithStream.sumElementsOfArray(customerArray);
    }

    @Test(groups = {"function_count_elements", "base_flow"})
    public void testSumElementsOfArray2() throws CustomerArrayException {
        CustomerArray givenCustomerArray = new CustomerArray(new double[]{1.0, 2.5, -3.1, 6.0});
        double expectedSum = 6.4;

        double realSum = arrayServiceWithStream.sumElementsOfArray(givenCustomerArray);

        Assert.assertEquals(realSum, expectedSum);
    }

    @Test(expectedExceptions = CustomerArrayException.class, groups = "function_min_max_condition")
    public void testFindAverageValueOfArray1() throws CustomerArrayException {
        CustomerArray customerArray = null;
        double realCustomerArray = arrayServiceWithStream.findAverageValueOfArray(customerArray);
    }

    @Test(groups = {"function_count_elements", "base_flow"})
    public void testFindAverageValueOfArray2() throws CustomerArrayException {
        CustomerArray givenCustomerArray = new CustomerArray(new double[]{1.0, 2.5, -3.1, 6.0});
        double expectedAverage = 6.4 / 4;

        double realAverage = arrayServiceWithStream.findAverageValueOfArray(givenCustomerArray);

        Assert.assertEquals(realAverage, expectedAverage);
    }


    @Test(groups = {"function_count_elements", "base_flow"})
    public void testCountNegativeValueOfArrayWithStream1() throws CustomerArrayException {
        CustomerArray givenCustomerArray = new CustomerArray(new double[]{1.0, 2.5, -3.1, 6.0});
        int expectedNumberOfNegativeElements = 1;

        int realNumberOfNegativeElements = arrayServiceWithStream.countNegativeValueOfArray(givenCustomerArray);

        Assert.assertEquals(realNumberOfNegativeElements, expectedNumberOfNegativeElements);
    }


    @Test(expectedExceptions = CustomerArrayException.class, groups = "function_count_elements")
    public void testCountNegativeValueOfArrayWithStream2() throws CustomerArrayException {
        CustomerArray customerArray = null;

        int realNumberOfNegativeElements = arrayServiceWithStream.countNegativeValueOfArray(customerArray);
    }

    @Test(groups = {"function_count_elements", "base_flow"})
    public void testCountPositiveValueOfArrayWithStream1() throws CustomerArrayException {
        CustomerArray givenCustomerArray = new CustomerArray(new double[]{1.0, 2.5, -3.1, 6.0});
        int expectedNumberOfPositiveElements = 3;

        int realNumberOfPositiveElements = arrayServiceWithStream.countPositiveValueOfArray(givenCustomerArray);

        Assert.assertEquals(realNumberOfPositiveElements, expectedNumberOfPositiveElements);
    }


    @Test(expectedExceptions = CustomerArrayException.class, groups = {"function_count_elements", "base_flow"})
    public void testCountPositiveValueOfArrayWithStream2() throws CustomerArrayException {
        CustomerArray customerArray = null;

        int realNumberOfNegativeElements = arrayServiceWithStream.countPositiveValueOfArray(customerArray);
    }

    @DataProvider(name = "array_chek_min_2")
    public Object[][] createDataForMin() {
        return new Object[][]{
                {new double[]{-3.6, 0.7, 2.7, 2.6, 2.4, 1.3, -1.0, -2.2, -3.6, 2.6}, -3.6},
                {new double[]{1.8, -4.3, -3.5, 1.8, -0.9, -4.5, 0.4, 1.1, 1.3, 2.4}, -4.5}};

    }

    @DataProvider(name = "array_chek_max_2")
    public Object[][] createDataForMax() {
        return new Object[][]{
                {new double[]{-3.6, 0.7, 2.7, 2.6, 2.4, 1.3, -1.0, -2.2, -1.5, 2.6}, 2.7},
                {new double[]{1.8, -4.3, -3.5, 1.8, -0.9, -4.5, 0.4, 1.1, 1.3, 2.4}, 2.4}};

    }

    @AfterGroups
    public void tierDown() {
        arrayServiceWithStream = null;
    }
}
