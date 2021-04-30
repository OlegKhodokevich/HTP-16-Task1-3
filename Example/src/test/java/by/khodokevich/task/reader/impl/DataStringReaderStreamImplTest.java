package by.khodokevich.task.reader.impl;

import by.khodokevich.task.exception.CustomerArrayException;
import by.khodokevich.task.reader.DataDoubleReader;
import by.khodokevich.task.reader.DataStringReaderStream;
import junit.framework.TestCase;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Optional;

public class DataStringReaderStreamImplTest extends TestCase {
    DataStringReaderStream dataStringReaderStream;

    @BeforeGroups(groups = {"base_flow","negative_group"})
    public void setUpBeforeClass() {
        dataStringReaderStream = new DataStringReaderStreamImpl();
    }

    @Test(expectedExceptions = CustomerArrayException.class, groups = "negative_group")
    public void testReadLineOfDoubleFromTXT1() throws CustomerArrayException {
        String path = "data/data1.txt";
        String realString = dataStringReaderStream.readLineOfDoubleFromTXT(path).orElse("");

    }

    @Test(groups = {"negative_group"})
    public void testReadLineOfDoubleFromTXT2() throws CustomerArrayException {
        String path = "data/data_false_source.txt";
        String expectedString = "";
        String realString = dataStringReaderStream.readLineOfDoubleFromTXT(path).orElse("");

        Assert.assertEquals(realString, expectedString);
    }

    @Test(groups = "base_flow")
    public void testReadLineOfDoubleFromTXT3() throws CustomerArrayException {
        String path = "data/data.txt";
        String expectedString = "-1.8, 9.6,8.7, 1.3 6.1 8 0";
        String realString = dataStringReaderStream.readLineOfDoubleFromTXT(path).orElse("");

        Assert.assertTrue(realString.length() == expectedString.length()  && realString.contains(expectedString));
    }


    @AfterGroups
    public void tierDown() {
        dataStringReaderStream = null;
    }
}