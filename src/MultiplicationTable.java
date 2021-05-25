public class MultiplicationTable {
    private int startMultiplier;
    private int endMultiplier;
    private int[][] numbers;

    public MultiplicationTable(int startNumber, int finishNumber) {
        this.startMultiplier = startNumber;
        this.endMultiplier = finishNumber;
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
        numbers = new int[Math.abs(endMultiplier - startMultiplier) + 1][Math.abs(endMultiplier - startMultiplier) + 1];

        int maxCounter = endMultiplier - startMultiplier + 1;

        for (int i = 0; i < maxCounter; i++) {
            for (int j = 0; j < maxCounter; j++) {
                numbers[i][j] = (startMultiplier + i) * (startMultiplier + j);
            }
        }
    }

    public void print() {
        System.out.println("Вывод массива в виде таблицы умножения:");

        int maxAbsTableValue = (int) Math.pow(Math.max(Math.abs(startMultiplier), Math.abs(endMultiplier)), 2);
        int minusStampLength = startMultiplier < 0 ? 1 : 0;
        int maxTableValueOutputLength = minusStampLength + (int) (Math.log10(maxAbsTableValue) + 1) + 1; // console output length = minus sign + all digits + whitespace before

        String tableOutputFormatTemplate = "%" + maxTableValueOutputLength + "d"; // waiting result like "%5d" for use in format string operation

        printHeader(maxTableValueOutputLength, tableOutputFormatTemplate);

        int rowsQuantity = endMultiplier - startMultiplier + 1;

        for (int i = 0; i < rowsQuantity; i++) {
            System.out.printf(tableOutputFormatTemplate + "|", (int) Math.sqrt(numbers[0][0]) + i);

            for (int j = 0; j < rowsQuantity; j++) {
                if (j != rowsQuantity - 1) {
                    System.out.printf(tableOutputFormatTemplate, numbers[i][j]);
                } else {
                    System.out.printf(tableOutputFormatTemplate, numbers[i][j]);
                    System.out.println();
                }
            }
        }
    }

    private void printHeader(int maxTableValueOutputLength, String tableOutputFormatTemplate) {
        int columnsQuantity = numbers.length;

        System.out.printf("%" + (maxTableValueOutputLength + 1) + "s", "");

        for (int i = 0; i < columnsQuantity; i++) {
            System.out.printf(tableOutputFormatTemplate, (int) Math.sqrt(numbers[i][i]));
        }

        int delimiterLineLength = maxTableValueOutputLength * numbers.length + maxTableValueOutputLength + 1;
        System.out.printf("%n%s%n", "¯".repeat(delimiterLineLength));
    }
}