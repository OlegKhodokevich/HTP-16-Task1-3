package by.khodokevich.task.reader.impl;

import by.khodokevich.task.exception.CustomerArrayException;
import by.khodokevich.task.reader.DataDoubleReader;
import org.testng.Assert;
import org.testng.annotations.*;

public class DataStringReaderImplTest {
    DataDoubleReader dataDoubleReader;

    @BeforeGroups(groups = {"base_flow", "negative_group"})
    public void setUpBeforeClass() {
        dataDoubleReader = new DataStringReaderImpl();
    }

    @Test(expectedExceptions = CustomerArrayException.class, groups = {"negative_group"})
    public void testReadLineOfDoubleFromTXT1() throws CustomerArrayException {
        String path = "data/data1.txt";
        String realString = dataDoubleReader.readLineOfDoubleFromTXT(path);
    }

    @Test(expectedExceptions = CustomerArrayException.class, groups = {"negative_group"})
    public void testReadLineOfDoubleFromTXT2() throws CustomerArrayException {
        String path = "data/data_false_source.txt";
        String realString = dataDoubleReader.readLineOfDoubleFromTXT(path);

    }

    @Test(priority = 3, groups = {"base_flow", "dependence_test"})
    public void testReadLineOfDoubleFromTXT3() throws CustomerArrayException {
        String path = "data/data.txt";
        String expectedString = "-1.8, 9.6,8.7, 1.3 6.1 8 0";
        String realString = dataDoubleReader.readLineOfDoubleFromTXT(path);

        Assert.assertEquals(realString, expectedString);
    }

    @AfterGroups
    public void tierDown() {
        dataDoubleReader = null;
    }
}