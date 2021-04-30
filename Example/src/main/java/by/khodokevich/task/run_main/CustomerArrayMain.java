package by.khodokevich.task.run_main;

import by.khodokevich.task.creator.CustomerArrayCreator;
import by.khodokevich.task.entity.CustomerArray;
import by.khodokevich.task.exception.CustomerArrayException;
import by.khodokevich.task.parser.ParserStringToArrayDouble;
import by.khodokevich.task.parser.ParserStringToArrayDoubleStream;
import by.khodokevich.task.reader.impl.DataStringReaderImpl;
import by.khodokevich.task.reader.impl.DataStringReaderStreamImpl;
import by.khodokevich.task.service.impl.ArrayArithmeticLogicImpl;
import by.khodokevich.task.service.impl.ArrayArithmeticLogicWithStreamImpl;
import by.khodokevich.task.service.impl.ArrayServiceSortImpl2;
import by.khodokevich.task.service.impl.ArraySortStreamImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.Arrays;


public class CustomerArrayMain {
    static final Logger logger = LogManager.getRootLogger();
    private static final String SOURCE_DATA_FILE = "data/data.txt";

    public static void main(String[] args) throws CustomerArrayException {
        logger.info("Start Main test...");

        DataStringReaderImpl dataStringReader = new DataStringReaderImpl();
        String numberLine = dataStringReader.readLineOfDoubleFromTXT(SOURCE_DATA_FILE);
        System.out.println("Searched numberLine = " + numberLine);

        DataStringReaderStreamImpl dataStringReaderStream = new DataStringReaderStreamImpl();
        if (dataStringReaderStream.readLineOfDoubleFromTXT(SOURCE_DATA_FILE) != null){
            numberLine = String.valueOf(dataStringReaderStream.readLineOfDoubleFromTXT(SOURCE_DATA_FILE));
        } else {
            logger.info("Searched numberLine has not found. ");
        }

        String numberLineForParsing = "-1.8, 9.6,8.7, 1.3 6.1 8 0";
        logger.info("numberLineForParsing = " + numberLineForParsing);
        ParserStringToArrayDouble parserStringToArrayDouble = new ParserStringToArrayDouble();
        double[] parsedArray = parserStringToArrayDouble.parseStringToDouble(numberLineForParsing);
        logger.info("Parsed array = " + Arrays.toString(parsedArray) + "\n");

        logger.info("numberLineForParsing = " + numberLineForParsing);
        ParserStringToArrayDoubleStream parserStringToArrayDoubleStream = new ParserStringToArrayDoubleStream();
        parsedArray = parserStringToArrayDoubleStream.parseStringToDouble(numberLineForParsing);
        logger.info("Parsed array = " + Arrays.toString(parsedArray) + "\n");

        double[] arrayForCreating = new double[]{-1.8, 9.6, 8.7, 1.3,6.1, 8.0};
        logger.info("Array for creating = " + Arrays.toString(arrayForCreating));
        CustomerArrayCreator customerArrayCreator = new CustomerArrayCreator();
        CustomerArray customerArray = customerArrayCreator.createCustomerArray(new double[]{-1.8, 9.6, 8.7, 1.3,6.1, 8.0});
        logger.info("CustomerArray  = " + customerArray + "\n");



        double result = 0;
        customerArray = customerArrayCreator.createCustomerArray(new double[]{-1.8, 9.6, 8.7, 1.3,6.1, 8.0});
        logger.info("Array for arithmetic operation  = " + customerArray);
        try {
            ArrayArithmeticLogicImpl arrayArithmeticLogicImpl = new ArrayArithmeticLogicImpl();
            result = arrayArithmeticLogicImpl.findMaxValueOfArray(customerArray);
            result = arrayArithmeticLogicImpl.findMinValueOfArray(customerArray);
            result = arrayArithmeticLogicImpl.findAverageValueOfArray(customerArray);
            CustomerArray changedArray = arrayArithmeticLogicImpl.exchangeNumberOfArrayToOtherNumber(customerArray, 9.6, -1);
            int count = arrayArithmeticLogicImpl.countNegativeValueOfArray(customerArray);
            count = arrayArithmeticLogicImpl.countPositiveValueOfArray(customerArray);

            ArrayArithmeticLogicWithStreamImpl arrayArithmeticLogicWithStream = new ArrayArithmeticLogicWithStreamImpl();
            result = arrayArithmeticLogicImpl.findMaxValueOfArray(changedArray);
            result = arrayArithmeticLogicImpl.findMinValueOfArray(customerArray);
            result = arrayArithmeticLogicImpl.sumElementsOfArray(customerArray);
            result = arrayArithmeticLogicImpl.findAverageValueOfArray(customerArray);
            changedArray = arrayArithmeticLogicWithStream.exchangeNumberOfArrayToOtherNumber(customerArray, 9.6,-1);
            count = arrayArithmeticLogicWithStream.countNegativeValueOfArray(customerArray);
            count = arrayArithmeticLogicWithStream.countPositiveValueOfArray(customerArray);

            customerArray = customerArrayCreator.createCustomerArray(new double[]{-1.8, 9.6, 8.7, 1.3,6.1, 8.0});
            logger.info("Array for sort  = " + customerArray);
            ArrayServiceSortImpl2 arrayServiceSortImpl2 = new ArrayServiceSortImpl2();
            arrayServiceSortImpl2.quickSortArray(customerArray,0, customerArray.getArray().length - 1);
            logger.info("Array after sort  = " + customerArray + "\n");

            customerArray = customerArrayCreator.createCustomerArray(new double[]{-1.8, 9.6, 8.7, 1.3,6.1, 8.0});
            logger.info("Array for sort  = " + customerArray);
            CustomerArray customerArrayAfterSort = arrayServiceSortImpl2.sortArrayByMerge(customerArray);
            logger.info("Array after sort  = " + customerArrayAfterSort + "\n");

            customerArray = customerArrayCreator.createCustomerArray(new double[]{-1.8, 9.6, 8.7, 1.3,6.1, 8.0});
            logger.info("Array for sort  = " + customerArray);
            arrayServiceSortImpl2.shellSort(customerArray);
            logger.info("Array after sort  = " + customerArray + "\n");


            ArraySortStreamImpl arraySortStream = new ArraySortStreamImpl();
            customerArray = customerArrayCreator.createCustomerArray(new double[]{-1.8, 9.6, 8.7, 1.3,6.1, 8.0});
            logger.info("Array for sort  = " + customerArray);
            arraySortStream.sortCustomerArray(customerArray);
            logger.info("Array after sort  = " + customerArray + "\n");

            String path = "data/data.txt";
            String expectedString = "-1.8, 9.6,8.7, 1.3 6.1 8 0";
            String realString = dataStringReaderStream.readLineOfDoubleFromTXT(path).orElse("");
            System.out.println(expectedString.length() + "  " + realString.length());
            System.out.println(expectedString+ "  " + realString);

        } catch (CustomerArrayException e) {
            e.printStackTrace();
        }

    }
}
