package by.khodokevich.task.service;

import by.khodokevich.task.entity.CustomerArray;
import by.khodokevich.task.exception.CustomerArrayException;
import by.khodokevich.task.service.impl.ArrayArithmeticLogicImpl;
import org.testng.Assert;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ArrayServiceTest {
    ArrayArithmeticLogicImpl arrayArithmeticLogicImpl;

    @BeforeGroups(groups = {"function_min_max_condition", "function_count_elements", "base_flow"})
    public void setUp() {
        arrayArithmeticLogicImpl = new ArrayArithmeticLogicImpl();
    }

    @Test(dataProvider = "array_chek_min_2", groups = {"function_min_max_condition", "base_flow"})
    public void testFindMinValueOfArray1(double[] array, double expectedValue) throws CustomerArrayException {
        CustomerArray customerArray = new CustomerArray(array);
        double valueMin = arrayArithmeticLogicImpl.findMinValueOfArray(customerArray);

        Assert.assertEquals(valueMin, expectedValue);
    }

    @Test(expectedExceptions = CustomerArrayException.class, groups = "function_min_max_condition")
    public void testFindMinValueOfArray2() throws CustomerArrayException {
        CustomerArray customerArray = null;
        double valueMin = arrayArithmeticLogicImpl.findMinValueOfArray(customerArray);
    }

    @Test(dataProvider = "array_chek_max_2", groups = {"function_min_max_condition", "base_flow"})
    public void testFindMaxValueOfArray1(double[] array, double expectedValue) throws CustomerArrayException {
        CustomerArray customerArray = new CustomerArray(array);
        double valueMax = arrayArithmeticLogicImpl.findMaxValueOfArray(customerArray);

        Assert.assertEquals(valueMax, expectedValue);
    }

    @Test(expectedExceptions = CustomerArrayException.class, groups = "function_min_max_condition")
    public void testFindMaxValueOfArray2() throws CustomerArrayException {
        CustomerArray customerArray = null;
        double valueMax = arrayArithmeticLogicImpl.findMaxValueOfArray(customerArray);
    }

    @Test(groups = {"function_min_max_condition", "base_flow"})
    public void testExchangeNumberOfArrayToOtherNumber1() throws CustomerArrayException {
        CustomerArray givenCustomerArray = new CustomerArray(new double[]{1.0, 2.5, -3.1, 6.0});
        CustomerArray expectedCustomerArray = new CustomerArray(new double[]{2.0, 2.5, -3.1, 6.0});

        CustomerArray realCustomerArray = arrayArithmeticLogicImpl.exchangeNumberOfArrayToOtherNumber(givenCustomerArray, 1.0, 2.0);

        Assert.assertEquals(realCustomerArray, expectedCustomerArray);
    }


    @Test(expectedExceptions = CustomerArrayException.class, groups = "function_min_max_condition")
    public void testExchangeNumberOfArrayToOtherNumber2() throws CustomerArrayException {
        CustomerArray customerArray = null;
        CustomerArray realCustomerArray = arrayArithmeticLogicImpl.exchangeNumberOfArrayToOtherNumber(customerArray, 0.0, 1.0);
    }

    @Test(groups = {"function_count_elements", "base_flow"})
    public void testCountNegativeValueOfArray1() throws CustomerArrayException {
        CustomerArray givenCustomerArray = new CustomerArray(new double[]{1.0, 2.5, -3.1, 6.0});
        int expectedNumberOfNegativeElements = 1;

        int realNumberOfNegativeElements = arrayArithmeticLogicImpl.countNegativeValueOfArray(givenCustomerArray);

        Assert.assertEquals(realNumberOfNegativeElements, expectedNumberOfNegativeElements);
    }


    @Test(expectedExceptions = CustomerArrayException.class, groups = "function_count_elements")
    public void testCountNegativeValueOfArray2() throws CustomerArrayException {
        CustomerArray customerArray = null;

        int realNumberOfNegativeElements = arrayArithmeticLogicImpl.countNegativeValueOfArray(customerArray);
    }

    @Test(groups = {"function_count_elements", "base_flow"})
    public void testCountPositiveValueOfArray1() throws CustomerArrayException {
        CustomerArray givenCustomerArray = new CustomerArray(new double[]{1.0, 2.5, -3.1, 6.0});
        int expectedNumberOfPositiveElements = 3;

        int realNumberOfPositiveElements = arrayArithmeticLogicImpl.countPositiveValueOfArray(givenCustomerArray);

        Assert.assertEquals(realNumberOfPositiveElements, expectedNumberOfPositiveElements);
    }


    @Test(expectedExceptions = CustomerArrayException.class, groups = "function_count_elements")
    public void testCountPositiveValueOfArray2() throws CustomerArrayException {
        CustomerArray customerArray = null;

        int realNumberOfNegativeElements = arrayArithmeticLogicImpl.countPositiveValueOfArray(customerArray);
    }

    @DataProvider(name = "array_chek_min_2")
    public Object[][] createDataForMin() {
        return new Object[][]{
                {new double[]{-3.6, 0.7, 2.7, 2.6, 2.4, 1.3, -1.0, -2.2, -1.5, 2.6}, -3.6},
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
        arrayArithmeticLogicImpl = null;
    }

}
