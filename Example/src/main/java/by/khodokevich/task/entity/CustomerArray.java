package by.khodokevich.task.entity;

import java.util.Arrays;

public class CustomerArray {

    private double[] array;
    private static final double[] EMPTY_ELEMENTDATA = {};

    public CustomerArray() {
    }

    public CustomerArray(double... array) {
        if (array.length != 0) {
            this.array = new double[array.length];
            System.arraycopy(array, 0, this.array, 0, array.length);
        } else {
            this.array = EMPTY_ELEMENTDATA;
        }
    }

    public double[] getArray() {
        double[] newArray = new double[array.length];

        System.arraycopy(array, 0, newArray, 0, array.length);

        return newArray;
    }

    public boolean setArray(double... array) {
        if (array.length == 0) {
            return false;
        }

        System.arraycopy(array, 0, this.array, 0, array.length);
        return true;
    }

    public void setElementOfArray(int index, double element) {
        array[index] = element;
    }

    public double getElementOfArray(int index) {
        return array[index];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerArray that = (CustomerArray) o;
        return Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(getClass().getSimpleName());
        stringBuilder.append(Arrays.toString(array));

        return stringBuilder.toString();
    }
}
