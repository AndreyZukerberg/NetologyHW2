import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PasswordChecker checker = new PasswordChecker();

        try {
            System.out.print("Введите мин. длину пароля: ");
            int minLen = Integer.parseInt(scanner.nextLine());
            checker.setMinLength(minLen);

            System.out.print("Введите макс. допустимое количество повторений символа подряд: ");
            int maxRep = Integer.parseInt(scanner.nextLine());
            checker.setMaxRepeats(maxRep);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
            System.out.println("Программа завершена");
            scanner.close();
            return;
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: введено не число");
            System.out.println("Программа завершена");
            scanner.close();
            return;
        }

        while (true) {
            System.out.print("Введите пароль или end: ");
            String input = scanner.nextLine();

            if ("end".equalsIgnoreCase(input)) {
                System.out.println("Программа завершена");
                break;
            }

            try {
                boolean result = checker.verify(input);
                if (result) {
                    System.out.println("Подходит!");
                } else {
                    System.out.println("Не подходит!");
                }
            } catch (IllegalStateException e) {
                System.out.println("Ошибка: " + e.getMessage());
                System.out.println("Программа завершена");
                break;
            }
        }
        scanner.close();
    }
}
