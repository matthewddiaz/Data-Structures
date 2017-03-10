package data;

/**
 * Created by matthewdiaz on 3/6/17.
 */
public class TestData {
    //sets of Data
    private static Integer[] integerArray = {15, 1, 19, 16, 17, 100, 105, 103, 11, 4, 20,180};
    private static Double[] doubleArray = {15.1, 18.18, 1.1, 16.5, 19.3, 16.6, 17.4, 100.4, 105.4, 103.2, 11.1, 4.3, 2.3, -180.2};
    private static String[] stringArray = {"Goku", "Krillian", "Gohan", "Vegeta","Master Roshi", "Piccolo", "Bulma", "Cell"};

    public static Integer[] getIntegerArray() {
        return integerArray;
    }

    public static Double[] getDoubleArray() {
        return doubleArray;
    }

    public static String[] getStringArray() {
        return stringArray;
    }
}
