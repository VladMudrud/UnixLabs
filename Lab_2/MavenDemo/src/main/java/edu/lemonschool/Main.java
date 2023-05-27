package edu.lemonschool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger("Some class output");

    public static void main(String[] args) {
        Marker marker = MarkerFactory.getMarker("Some marker:");
        logger.info(marker, "Some log");
        int[] array = {45, 54, 77, 8, 8, 9, 88, 125, 9};
        System.out.println(getMax(array));
        System.out.println(getMin(array));
        System.out.println(getNumberByIndex(2, array));
        System.out.println(getNumberByIndex(1, array));
    }

    private static int getMax(int[] array) {
        int max = array[0];
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > max) {
                max = array[i + 1];
            }
        }
        return max;
    }

    private static int getNumberByIndex(int index, int[] array) {
        return array[index];
    }

    private static int getMin(int[] array) {
        int min = array[0];
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < min) {
                min = array[i + 1];
            }
        }
        return min;
    }
}