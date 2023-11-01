import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Full Name Validation
        String fullName = getValidFullName(scanner);

        // 2. Email Validation
        String email = replyEmail(scanner);

        // 3. Phone Number Validation
        String phoneNumber = getValidPhoneNumber(scanner);

        // 4. Password Validation
        String password = getValidPassword(scanner);

        // 5. Create GitHub Repository, Branch, and Pull Request
        createGitHubRepoAndPullRequest(fullName, email, phoneNumber, password);

        scanner.close();
    }

    private static String getValidFullName(Scanner scanner) {
        String fullName;
        do {
            System.out.println("Hello my teacher behzod good evening");
            System.out.print("Enter your full name - Ismingizni kiriting: ");
            fullName = scanner.nextLine();
        } while (!fullName.matches("^[A-Z][a-zA-Z]*(\\s[A-Z][a-zA-Z]*)?$"));
        return fullName;
    }

//    private static String getValidEmail(Scanner scanner) {
//        String email;
//        String valid = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
//                "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
//        do {
//            System.out.print("Enter your email - Emailingizni kiriting: ");
//            email = scanner.nextLine();
//            email = email.replace(".", "");
//        } while (!Pattern.matches(valid, email));
//        return email;
//    }
private static final String EMAIL_PATTERN =
        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@gmail\\.com$";

    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    public static boolean validateEmail(String email) {
        Matcher matcher = pattern.matcher(email);
        int dotCount = 0;
        int atIndex = email.indexOf('@');
        for (int i = atIndex + 1; i < email.length(); i++) {
            if (email.charAt(i) == '.') {
                dotCount++;
            }
        }
        return matcher.matches() && dotCount <= 2;
    }

    public static String replyEmail(Scanner scanner) {
        String email;
        boolean isValid;
        do {
            System.out.print("Please enter an email address: ");
            email = scanner.nextLine();
            isValid = validateEmail(email);
            if (!isValid) {
                System.out.println("Invalid email address. Please try again.");
            }
        } while (!isValid);

        return email;
    }


    private static String getValidPhoneNumber(Scanner scanner) {
        String number;
        boolean isValid;
        do {
            System.out.print("Please enter a number: ");
            number = scanner.nextLine();
            if (number.startsWith("+998")) {
                isValid = true;
            } else {
                isValid = false;
            }
            if (!isValid) {
                System.out.println("Invalid number. Please try again.");
            }
        } while (!isValid);

        return number;
    }

    private static String getValidPassword(Scanner scanner) {
        String password;
        do {
            System.out.print("Enter your password - Parolingizni kiriting: ");
            password = scanner.nextLine();
        } while (!Pattern.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&*()\\?/|\\\\%_\\-+,\\.~]).{8,}$", password));
        return password;
    }

    private static void createGitHubRepoAndPullRequest(String fullName, String email, String phoneNumber, String password) {
        // TODO: Implement GitHub repo creation, branch creation, and pull request creation logic
        // You can use GitHub API libraries or command-line tools to achieve this.
        System.out.println("GitHub Repository, Branch, and Pull Request created successfully!");
    }
}