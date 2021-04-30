package by.khodokevich.task.creator;

import by.khodokevich.task.entity.CustomerArray;
import by.khodokevich.task.exception.CustomerArrayException;
import junit.framework.TestCase;
import org.testng.Assert;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class CustomerArrayCreatorTest extends TestCase {

    CustomerArrayCreator customerArrayCreator;

    @BeforeGroups(groups = {"base_flow", "negative_group"})
    public void setUp() {
        customerArrayCreator = new CustomerArrayCreator();
    }

    @Test(expectedExceptions = CustomerArrayException.class, groups = "negative_group")
    public void testCreateCustomerArray1() throws CustomerArrayException {
        CustomerArray actualCustomerArray = customerArrayCreator.createCustomerArray(new double[]{});

    }

    @Test(groups = "base_flow")
    public void testCreateCustomerArray2() throws CustomerArrayException {
        CustomerArray actualCustomerArray = customerArrayCreator.createCustomerArray(new double[]{1,1.5,9.3});
        CustomerArray expectedCustomerArray = new CustomerArray(new double[]{1,1.5,9.3});

        Assert.assertEquals(actualCustomerArray, expectedCustomerArray);
    }

    @AfterGroups
    public void tearDown() throws Exception {
        customerArrayCreator = null;
    }
}