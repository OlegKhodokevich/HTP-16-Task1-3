package by.khodokevich.task.parser;

import by.khodokevich.task.exception.CustomerArrayException;
import org.testng.Assert;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class ParserStringToArrayOfDoubleTest {
    ParserStringToArrayDouble parserStringToArrayDouble;

     @BeforeGroups(groups = {"base_flow", "negative_group"})
     public void seUp(){
         parserStringToArrayDouble = new ParserStringToArrayDouble();
     }

    @Test(expectedExceptions = CustomerArrayException.class, groups = "negative_group")
    public void testParseStringToArrayOfDouble1() throws CustomerArrayException {

        double[] realArray = parserStringToArrayDouble.parseStringToDouble(null);
    }

    @Test(expectedExceptions = CustomerArrayException.class, groups = "negative_group")
    public void testParseStringToArrayOfDouble2() throws CustomerArrayException {

        double[] realArray = parserStringToArrayDouble.parseStringToDouble("d12");
    }

    @Test(priority = 4, dependsOnGroups = {"dependence_test"}, dataProvider = "line_for_parsing", groups = "base_flow")
    public void testParseStringToArrayOfDouble3(String line, double[] expectedArray) throws CustomerArrayException {

        double[] realArray = parserStringToArrayDouble.parseStringToDouble(line);

        Assert.assertTrue(Arrays.equals(realArray, expectedArray));
    }

    @DataProvider(name = "line_for_parsing")
    public Object[][] createArrayForSort() {
        return new Object[][]{
                {"-1.8, 9.6,8.7, 1.3 6.1 8 0", new double[]{-1.8, 9.6, 8.7, 1.3, 6.1, 8, 0}}
                , {"9.8 6 8.7, 8.9", new double[]{9.8, 6, 8.7, 8.9}}};
    }

    @AfterGroups
    public void tierDown(){
        parserStringToArrayDouble = null;
    }
}
