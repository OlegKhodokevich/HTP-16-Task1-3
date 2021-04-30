package by.khodokevich.task.service;

import by.khodokevich.task.entity.CustomerArray;
import by.khodokevich.task.exception.CustomerArrayException;
import by.khodokevich.task.service.impl.ArraySortStreamImpl;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Arrays;

public class ArraySortStreamTest {
    ArraySortStream arraySortStream;

    @BeforeClass(groups = {"base_flow"})
    public void setUp() {
        arraySortStream = new ArraySortStreamImpl();
    }


    @Test(expectedExceptions = CustomerArrayException.class)
    public void testSortCustomerArray1() throws CustomerArrayException {
        CustomerArray actualCustomerArray = null;
        arraySortStream.sortCustomerArray(actualCustomerArray);
    }

    @Test(dataProvider = "array_for_sort",groups = "base_flow")
    public void testSortCustomerArray2(double[] array, double[] expectedArray) throws CustomerArrayException {
        CustomerArray customerArray = new CustomerArray(array);

        arraySortStream.sortCustomerArray(customerArray);

        Assert.assertTrue(Arrays.equals(customerArray.getArray(), expectedArray));
    }

    @DataProvider(name = "array_for_sort")
    public Object[][] createArrayForSort() {
        return new Object[][]{
                {new double[]{1, 2.5, -3, 5.8, 9.6, 6.3, 8.7, -6.0}, new double[]{-6.0, -3, 1, 2.5, 5.8, 6.3, 8.7, 9.6}}
                , {new double[]{9.0, 3.3, 5.6, 8.9, 5.6, -8.0, -4.5, 1.2}, new double[]{-8.0, -4.5, 1.2, 3.3, 5.6, 5.6, 8.9, 9.0,}}
                , {new double[]{5.6, 4.8, -1.2, -6.3, -8, -5, 6.3, 5.7}, new double[]{-8, -6.3, -5, -1.2, 4.8, 5.6, 5.7, 6.3}}
        };
    }


    @AfterClass
    public void tierDown() {
        arraySortStream = null;
    }
}
