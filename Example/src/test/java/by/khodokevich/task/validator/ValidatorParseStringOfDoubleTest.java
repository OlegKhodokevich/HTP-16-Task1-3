package by.khodokevich.task.validator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ValidatorParseStringOfDoubleTest {

    @Test(dataProvider = "line_for_validate", groups = "base_flow")
    public void testValidateLineOfDouble(String line, boolean expectedBoolean) {
        boolean validString = ValidatorParseStringOfDouble.validateStringOfDouble(line);

        Assert.assertEquals(validString, expectedBoolean);
    }

    @DataProvider(name = "line_for_validate")
    public Object[][] createStringForValidate() {
        return new Object[][]{
                {"3.6 5.9 5в6 -9.7", false}
                , {"-1.8, 9.6,8.7, 1.3 6.1 8 0", true}
                , {"9.8 6 8.7, 8.9", true}};
    }

}
