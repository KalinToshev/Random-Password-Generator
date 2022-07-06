import java.util.Random;
import java.util.Scanner;

public class Main {
    static String passwordSafety = null;
    static boolean invalidLength = false;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Input the length of the wanted password
        System.out.println("Please, enter the wanted length for the password:");
        int passwordLength = Integer.parseInt(scanner.nextLine());

        //Print the generated password
        passwordGenerator(passwordLength);
    }

    private static void passwordGenerator(int passwordLength) {
        //We validate the password length and based on it, we
        //decide the password safety level. If password length is
        //0 or lower we sout the error message and end the program.
        lengthValidator(passwordLength);
        if (invalidLength) {
            return;
        }
        // A strong password has Cap_chars, Lower_chars,
        // numeric value and symbols. So we are using all of
        // them to generate our password
        String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_chars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%^&*_=+-/.?<>)";

        String values = Capital_chars + Small_chars +
                numbers + symbols;

        // Using random method
        Random random = new Random();

        StringBuilder password = new StringBuilder();

        for (int i = 0; i < passwordLength; i++) {
            password.append(values.charAt(random.nextInt(values.length())));
        }

        System.out.println("Your new password is: " + password.toString());
        System.out.println("Password security: " + passwordSafety);
    }

    private static void lengthValidator(int passwordLength) {
        if (passwordLength <= 0) {
            System.out.println(Errors.INVALID_LENGTH);
            invalidLength = true;
        } else if (passwordLength <= 5) {
            passwordSafety = "Low";
        } else if (passwordLength <= 10) {
            passwordSafety = "Medium";
        } else {
            passwordSafety = "Hard";
        }
    }
}
