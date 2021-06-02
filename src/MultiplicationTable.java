public class MultiplicationTable {
    private int startMultiplier;
    private int endMultiplier;
    private int[][] numbers;

    public MultiplicationTable(int startMultiplier, int endMultiplier) {
        this.startMultiplier = startMultiplier;
        this.endMultiplier = endMultiplier;
        calculateNumbers();
    }

    public int[][] getNumbers() {
        return numbers;
    }

    public int getStartMultiplier() {
        return startMultiplier;
    }

    public void setStartMultiplier(int startMultiplier) {
        this.startMultiplier = startMultiplier;
        calculateNumbers();
    }

    public int getEndMultiplier() {
        return endMultiplier;
    }

    public void setEndMultiplier(int endMultiplier) {
        this.endMultiplier = endMultiplier;
        calculateNumbers();
    }

    private void calculateNumbers() {
        int maxCounter = Math.abs(startMultiplier - endMultiplier) + 1;

        numbers = new int[maxCounter][maxCounter];

        for (int i = 0; i < maxCounter; i++) {
            for (int j = 0; j < maxCounter; j++) {
                numbers[i][j] = (startMultiplier + i) * (startMultiplier + j);
            }
        }
    }

    public void print() {
        System.out.println("Вывод массива в виде таблицы умножения:");

        int maxAbsTableValue = Math.max(numbers[0][0], numbers[numbers.length - 1][numbers.length - 1]);
        int tableMinusStampLength = isOnlyStartTableBorderNumberNegative() ? 1 : 0;
        int maxTableValueOutputLength = tableMinusStampLength + (int) (Math.log10(maxAbsTableValue) + 1) + 1; // console output length = minus sign + all digits + whitespace before

        String tableOutputFormatTemplate = "%" + maxTableValueOutputLength + "d"; // waiting result like "%5d" for use in format string operation

        int rowMinusStampLength = isStartTableBorderNumberNegative() ? 1 : 0;
        int maxStartRowValueOutputLength = (int) (Math.log10(Math.max(Math.sqrt(numbers[0][0]), Math.sqrt(numbers[numbers.length - 1][numbers.length - 1]))) + 1) + rowMinusStampLength;
        String rowStartFormatTemplate = "%" + maxStartRowValueOutputLength + "d" + "|";

        printHeader(maxStartRowValueOutputLength, maxTableValueOutputLength, tableOutputFormatTemplate);

        int rowsQuantity = numbers.length;
        int startNumber = isStartTableBorderNumberNegative() ? -(int) Math.sqrt(numbers[0][0]) : (int) Math.sqrt(numbers[0][0]);

        for (int i = 0; i < rowsQuantity; i++) {
            System.out.printf(rowStartFormatTemplate, startNumber + i);

            for (int j = 0; j < rowsQuantity; j++) {
                System.out.printf(tableOutputFormatTemplate, numbers[i][j]);

                if (j == rowsQuantity - 1) {
                    System.out.println();
                }
            }
        }
    }

    private void printHeader(int maxStartRowValueOutputLength, int maxTableValueOutputLength, String tableOutputFormatTemplate) {
        System.out.printf("%" + (maxStartRowValueOutputLength + 1) + "s", "");

        int columnsQuantity = numbers.length;
        int startNumber = isStartTableBorderNumberNegative() ? -(int) Math.sqrt(numbers[0][0]) : (int) Math.sqrt(numbers[0][0]);

        for (int i = 0; i < columnsQuantity; i++) {
            System.out.printf(tableOutputFormatTemplate, startNumber + i);
        }

        int delimiterLineLength = maxTableValueOutputLength * numbers.length + maxStartRowValueOutputLength + 1;
        System.out.printf("%n%s%n", "¯".repeat(delimiterLineLength));
    }

    private boolean isStartTableBorderNumberNegative() {
        return isOnlyStartTableBorderNumberNegative() || isBothTableBordersNumbersNegative();
    }

    private boolean isBothTableBordersNumbersNegative() {
        return (numbers[0][(numbers[0].length - 1)] > 0 && numbers[0][0] > numbers[0][(numbers[0].length - 1)]);
    }

    private boolean isOnlyStartTableBorderNumberNegative() {
        return numbers[0][(numbers[0].length - 1)] < 0;
    }
}