import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {

    public static final Pattern pattern = Pattern.compile("^[А-Я][А-Яа-я-]*\\s[А-Я][а-я]*\\s[А-Я][а-я]*$");

    public static void main(String[] args) {
        String[][] book = new String[3][2];
        init(book);

        Scanner scanner = new Scanner(System.in);
        int value = 0;
        while (value != 3) {
            System.out.println("Введите цифру (1 - добавить в справочник, 2 - печать справочника, 3 - выход): ");
            value = scanner.nextInt();
            scanner.nextLine();
            switch (value) {
                case 1:
                    boolean isCorrectName = false;
                    System.out.println("Введите имя (<Фамилия Имя Отчество>): ");
                    String name = "";
                    while (!isCorrectName) {
                        name = scanner.nextLine();
                        isCorrectName = checkName(name);
                        if (!isCorrectName) {
                            System.out.println("Введите корректное имя (<Фамилия Имя Отчество>): ");
                        }
                    }

                    if (checkExist(book, name)) {
                        System.out.println("Имя уже существует в телефонном справочнике.");
                        break;
                    }

                    boolean isCorrectNumber = false;
                    System.out.println("Введите номер телефона: ");
                    String phoneNumber = "";
                    while (!isCorrectNumber) {
                        phoneNumber = scanner.nextLine();
                        isCorrectNumber = checkPhoneNumber(phoneNumber);
                        if (!isCorrectNumber) {
                            System.out.println("Введите корректный номер!");
                        }
                    }
                    phoneNumber = formatPhoneNumber(phoneNumber);
                    book = add(book, name, phoneNumber);

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
        book[0][1] = "+7 888 454 33 33";

        book[1][0] = "Иванов Иван Иванович";
        book[1][1] = "+7 911 999 99 99";

        book[2][0] = "Яшкин Валентин Петрович";
        book[2][1] = "+7 788 567 44 44";
    }

    private static boolean checkPhoneNumber(String phoneNumber) {
        String clean = phoneNumber.replaceAll("[^0-9]", "");
        return clean.length() == 11;
    }

    private static boolean checkName(String name) {
        String[] words = name.trim().split(" ");
        if (words.length != 3) {
            return false;
        }

        Pattern p = Pattern.compile("^[А-Я][А-Яа-я-]*\\s[А-Я][а-я]*\\s[А-Я][а-я]*$");
        Matcher m = p.matcher(name);
        return m.matches();
    }

    private static String formatPhoneNumber(String phoneNumber) {
        String clean = phoneNumber.replaceAll("[^0-9]", "");
        return "+7" + " " + clean.substring(1, 4) + " " + clean.substring(4, 7) + " " + clean.substring(7, 9) + " " + clean.substring(9);
    }

    private static String[][] add(String[][] book, String name, String number) {
        int n = book.length;
        String[][] book_new = new String[n + 1][2];
        System.arraycopy(book, 0, book_new, 0, n);
        book_new[n][0] = name;
        book_new[n][1] = number;

        System.out.printf("--> Имя %s и телефон %s добавлены в телефонный справочник \n\n", name, number);
        return book_new;
    }

    private static boolean checkExist(String[][] book, String name) {
        for(String[] s: book){
            if(s[0].equals(name))
                return true;
        }
        return false;
    }

    private static void list(String[][] book) {

        Arrays.sort(book, Comparator.comparing(a -> a[0]));
        System.out.println("**********************************************************************");
        System.out.println("ТЕЛЕФОННЫЙ СПРАВОЧНИК");
        for (String[] item : book) {
            System.out.println(item[0] + ": " + item[1]);
        }
        System.out.println("********************************************************************** \n\n");
    }
}
