import java.util.Scanner;

public class MultiplicationTableArrayApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите начальное число таблицы умножения,");
        System.out.println("например, -10 или 4:");
        int startNumber = scanner.nextInt();

        System.out.println("Введите последнее число таблицы умножения (больше первого):");
        int finishNumber = scanner.nextInt();

        if (startNumber > finishNumber) { // fix incorrect input
            int temp = finishNumber;
            finishNumber = startNumber;
            startNumber = temp;
        }

        MultiplicationTable multiplicationTableArray = new MultiplicationTable(startNumber, finishNumber);
        multiplicationTableArray.print();
    }
}