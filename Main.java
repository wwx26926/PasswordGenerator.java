import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj długość hasła: ");
        int length = scanner.nextInt();

        if (length > 0) {
            String password = PasswordGenerator.generatePassword(length);
            System.out.println("Wygenerowane hasło: " + password);

            System.out.println("Czy chcesz zapisać hasło do pliku? (t/n): ");
            String choice = scanner.next();

            if (choice.equalsIgnoreCase("t")) {
                PasswordGenerator.savePasswordToFile(password);
                System.out.println("Hasło zapisane do pliku.");
            } else {
                System.out.println("Hasło nie zostało zapisane.");
            }
        } else {
            System.out.println("Długość hasła musi być większa niż 0.");
        }

        scanner.close();
    }
}
