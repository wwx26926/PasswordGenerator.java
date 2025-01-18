import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class PasswordGenerator {
    public static String generatePassword(int length) {
        final String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()";
        StringBuilder password = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            password.append(characters.charAt(index));
        }

        return password.toString();
    }

    public static void savePasswordToFile(String password) {
        try {
            // Tworzy folder Passwords (jeśli nie istnieje)
            java.nio.file.Path path = java.nio.file.Paths.get("Passwords");
            java.nio.file.Files.createDirectories(path);

            // Zapisuje hasło do pliku
            FileWriter writer = new FileWriter("Passwords/password.txt", true);
            writer.write(password + System.lineSeparator());
            writer.close();
        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas zapisywania hasła do pliku.");
            e.printStackTrace();
        }
    }
}
