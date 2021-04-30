package by.khodokevich.task.validator;

import by.khodokevich.task.entity.CustomerArray;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidatorCustomerArrayTest {

    @Test(groups = "base_flow")
    public void testCheckSizeOfArray1() {
        CustomerArray customerArray = new CustomerArray(new double[]{});

        boolean validSize = ValidatorCustomerArray.checkSizeOfArray(customerArray);

        Assert.assertFalse(validSize);
    }

    @Test(groups = "negative_group")
    public void testCheckSizeOfArray2() {
        CustomerArray customerArray = new CustomerArray(new double[]{1,2});

        boolean validSize = ValidatorCustomerArray.checkSizeOfArray(customerArray);

        Assert.assertTrue(validSize);
    }
}
