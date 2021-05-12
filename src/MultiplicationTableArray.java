import java.util.Arrays;

public class MultiplicationTableArray {
    private static final int MULTIPLICATION_TABLE_MAXIMUM_MULTIPLIER = 10;

    public static void main(String[] args) {
        int tableSize = 6;
        String[][] multiplicationTableArray = getMultiplicationTable(tableSize);

        System.out.println("Массив таблицы умножения:");

        for (String[] s : multiplicationTableArray) {
            System.out.println(Arrays.toString(s));
        }

        String[][] multiplicationTableArray2 = getInvertedMultiplicationTable(tableSize);

        System.out.println("Массив таблицы умножения инвертированный:");

        for (String[] s : multiplicationTableArray2) {
            System.out.println(Arrays.toString(s));
        }
    }

    private static String[][] getMultiplicationTable(int tableSize) {
        String[][] multiplicationTableArray = new String[tableSize][MULTIPLICATION_TABLE_MAXIMUM_MULTIPLIER];

        for (int i = tableSize; i > 0; i--) {

            for (int j = 1; j <= MULTIPLICATION_TABLE_MAXIMUM_MULTIPLIER; j++) {
                multiplicationTableArray[i - 1][j - 1] = i + " * " + j + " = " + i * j;
            }
        }

        return multiplicationTableArray;
    }

    private static String[][] getInvertedMultiplicationTable(int tableSize) {
        String[][] multiplicationTableArray = new String[MULTIPLICATION_TABLE_MAXIMUM_MULTIPLIER][tableSize];

        for (int i = 1; i <= MULTIPLICATION_TABLE_MAXIMUM_MULTIPLIER; i++) {

            for (int j = 1; j <= tableSize; j++) {
                multiplicationTableArray[i - 1][j - 1] = j + " * " + i + " = " + j * i;
            }
        }

        return multiplicationTableArray;
    }
}