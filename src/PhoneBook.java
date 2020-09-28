import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PhoneBook {

    public static void main(String[] args) {
        String[][] book = new String[3][2];
        init(book);

        Scanner scanner = new Scanner(System.in);
        int value = 0;
        while (value != 3) {
            System.out.println("Введите цифру (1 - добавить в справочник, 2 - печать справочника, 3 - выход): ");
            value = scanner.nextInt();
            switch (value) {
                case 1:
                    break;
                case 2:
                    list(book);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Неверный символ! Пожалуйста, повторите ввод.");
            }
        }

    }

    private static void init(String[][] book) {
        book[0][0] = "Сергеева Мария Анатольевна";
        book[0][1] = "8 888 454 33 33";

        book[1][0] = "Иванов Иван Иванович";
        book[1][1] = "8 911 999 99 99";

        book[2][0] = "Яшкин Валентин Петрович";
        book[2][1] = "8 788 567 44 44";
    }

    public static boolean checkPhoneNumber(String phoneNumber) {
        return true;
    }

    public static boolean checkName(String name) {
        return true;
    }

    public static String formatName(String name) {
        return "";
    }

    public static String formatPhoneNumber(String number) {
        return "";
    }

    public static void add(String[][] book, String name, String number) {

    }

    public static void list(String[][] book) {
        //print phone book
    }
}
