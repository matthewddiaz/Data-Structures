package com.matthewddiaz.algorithms.sorting.comparisonSorts;

/**
 * Created by matthewdiaz on 3/6/17.
 */
public class InputDataAndResultsHelper {
    //unsorted arrays
    private Integer[] integerArray = {15, 1, 19, 16, 17, 100, 105, 103, 11, 4, 20,180};
    private Double[] doubleArray = {15.1, 18.18, 1.1, 16.5, 19.3, 16.6, 17.4, 100.4, 105.4, 103.2, 11.1, 4.3, 2.3, -180.2};
    private String[] stringArray = {"Goku", "Krillian", "Gohan", "Vegeta","Master Roshi", "Piccolo", "Bulma", "Cell"};

    //sorted arrays
    private Integer[] sortedIntegerArray = {1, 4, 15, 11, 16, 17, 19, 20, 100, 103, 105,180};
    private Double[] sortedDoubleArray = {-180.2, 1.1, 2.3, 4.3, 11.1, 15.1, 16.5, 16.6, 17.4, 18.18, 19.3, 100.4, 103.2, 105.4};
    private String[] sortedStringArray = {"Bulma", "Cell", "Gohan", "Goku", "Krillian", "Master Roshi", "Piccolo", "Vegeta"};

    public InputDataAndResultsHelper(){}

    public Integer[] getIntegerArray() {
        return integerArray;
    }

    public Double[] getDoubleArray() {
        return doubleArray;
    }

    public String[] getStringArray() {
        return stringArray;
    }

    public Integer[] getSortedIntegerArray() {
        return sortedIntegerArray;
    }

    public Double[] getSortedDoubleArray() {
        return sortedDoubleArray;
    }

    public String[] getSortedStringArray() {
        return sortedStringArray;
    }
}
