package by.khodokevich.task.service;

import by.khodokevich.task.creator.CustomerArrayCreator;
import by.khodokevich.task.entity.CustomerArray;
import by.khodokevich.task.exception.CustomerArrayException;
import by.khodokevich.task.service.impl.ArrayServiceSortImpl2;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Arrays;

public class ArrayServiceSortTest {
    ArrayServiceSortImpl2 arrayServiceSortImpl2;
    CustomerArrayCreator customerArrayCreator;


    @BeforeGroups(groups = {"base_flow", "negative_group"})
    public void setUpBeforeClass() {
        arrayServiceSortImpl2 = new ArrayServiceSortImpl2();
        customerArrayCreator = new CustomerArrayCreator();

    }

    @Test(expectedExceptions = CustomerArrayException.class, groups = "negative_group")
    public void quickSortTest1() throws CustomerArrayException {
        CustomerArray realArray = null;
        arrayServiceSortImpl2.quickSortArray(realArray, 0, 1);
    }

    @Test(expectedExceptions = CustomerArrayException.class)
    public void quickSortTest2() throws CustomerArrayException {
        CustomerArray realArray = customerArrayCreator.createCustomerArray(null);
        arrayServiceSortImpl2.quickSortArray(realArray, 0, 1);
    }

    @Test(dataProvider = "array_for_sort", groups = "base_flow")
    public void quickSortTest3(double[] array, double[] expectedArray) throws CustomerArrayException {

        CustomerArray actualCustomerArray = new CustomerArray(array);

        arrayServiceSortImpl2.quickSortArray(actualCustomerArray, 0, actualCustomerArray.getArray().length - 1);

        Assert.assertTrue(Arrays.equals(actualCustomerArray.getArray(), expectedArray));
    }

    @Test(expectedExceptions = CustomerArrayException.class, groups = "negative_group")
    public void sortByMergeTest1() throws CustomerArrayException {
        CustomerArray customerArray = null;
        arrayServiceSortImpl2.sortArrayByMerge(customerArray);
    }

    @Test(dataProvider = "array_for_sort", groups = "base_flow")
    public void sortByMergeTest2(double[] array, double[] expectedArray) throws CustomerArrayException {

        CustomerArray realArray = arrayServiceSortImpl2.sortArrayByMerge(new CustomerArray(array));

        Assert.assertTrue(Arrays.equals(realArray.getArray(), expectedArray));
    }

    @Test(expectedExceptions = CustomerArrayException.class)
    public void shellSortTest1() throws CustomerArrayException {
        CustomerArray actaulCustomerArray = null;
        arrayServiceSortImpl2.shellSort(actaulCustomerArray);
    }

    @Test(dataProvider = "array_for_sort", groups = "base_flow")
    public void shellSortTest2(double[] array, double[] expectedArray) throws CustomerArrayException {
        CustomerArray actualCustomerArray = new CustomerArray(array);
        arrayServiceSortImpl2.shellSort(actualCustomerArray);

        Assert.assertTrue(Arrays.equals(actualCustomerArray.getArray(), expectedArray));
    }


    @DataProvider(name = "array_for_sort")
    public Object[][] createArrayForSort() {
        return new Object[][]{
                {new double[]{1, 2.5, -3, 5.8, 9.6, 6.3, 8.7, -6.0}, new double[]{-6.0, -3, 1, 2.5, 5.8, 6.3, 8.7, 9.6}}
                , {new double[]{9.0, 3.3, 5.6, 8.9, 5.6, -8.0, -4.5, 1.2}, new double[]{-8.0, -4.5, 1.2, 3.3, 5.6, 5.6, 8.9, 9.0,}}
                , {new double[]{5.6, 4.8, -1.2, -6.3, -8, -5, 6.3, 5.7}, new double[]{-8, -6.3, -5, -1.2, 4.8, 5.6, 5.7, 6.3}}
        };
    }

    @AfterGroups
    public void tierDownAfterClass() {
        arrayServiceSortImpl2 = null;
        customerArrayCreator = null;
    }
}
