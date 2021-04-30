package by.khodokevich.task.parser;

import by.khodokevich.task.exception.CustomerArrayException;
import by.khodokevich.task.reader.impl.DataStringReaderImpl;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Arrays;

public class ParserStringToArrayDoubleStreamTest {
    ParserStringToArrayDoubleStream parserStringToArrayDoubleStream;

    DataStringReaderImpl dataStringReader;

    @BeforeGroups(groups = {"base_flow", "negative_group"})
    public void setUp(){
        parserStringToArrayDoubleStream = new ParserStringToArrayDoubleStream();
    }

    @Test(expectedExceptions = CustomerArrayException.class, groups = "negative_group")
    public void testParseStringToArrayOfDouble1() throws CustomerArrayException {
        double [] realArray = parserStringToArrayDoubleStream.parseStringToDouble(null);
    }

    @Test(expectedExceptions = CustomerArrayException.class, groups = "negative_group")
    public void testParseStringToArrayOfDouble2() throws CustomerArrayException {
        double[] realArray = parserStringToArrayDoubleStream.parseStringToDouble("ff21");
    }

    @Test(dataProvider = "line_for_parsing", groups = "base_flow")
    public void testParseStringToArrayOfDouble3(String line, double[] expectedArray) throws CustomerArrayException {

        double[]  realArray = parserStringToArrayDoubleStream.parseStringToDouble(line);

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
        parserStringToArrayDoubleStream = null;
    }

}