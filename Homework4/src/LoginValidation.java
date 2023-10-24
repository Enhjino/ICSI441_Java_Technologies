import java.util.Scanner;

public class LoginValidation {
    private String login;
    private String password;
    private String confirmPassword;

    public static void main(String[] args) {
        LoginValidation Validation = new LoginValidation();
        Validation.input();

        try {
            boolean isValid = Validation.validate();
            if (isValid) {
                System.out.println("Нэвтрэх нэр болон нууц үг зөв байна.");
            } else {
                System.out.println("Нэвтрэх нэр болон нууц үг буруу байна.");
            }
        } catch (Exceptions e) {
            System.err.println("Алдаа гарлаа: " + e.getMessage());
        }
    }

    void input() {
        Scanner input = new Scanner(System.in);
        System.out.print("Нэвтрэх нэр: ");
        login = input.nextLine();
        System.out.print("Нууц үг: ");
        password = input.nextLine();
        System.out.print("Нууц үг баталгаажуулах: ");
        confirmPassword = input.nextLine();
        input.close();
    }

    public boolean validate() throws Exceptions {
        try {
            if (!login.matches("^[a-zA-Z0-9-]+$")) {
                throw new Exceptions("Нэвтрэх нэрийг зөвхөн латин үсэн, цифр, доогуур зураас тэмдэгтээр бичнэ.");
            }

            if (login.length() > 20) {
                throw new Exceptions("Нэвтрэх нэр нь 20 тэмдэгтээс богино байх ёстой.");
            }

            if (!password.matches("^[a-zA-Z0-9-]+$")) {
                throw new Exceptions("Нууц үгийг зөвхөн латин үсэг, цифр, доогуур зураас тэмдэгтээр бичнэ");
            }

            if (!password.equals(confirmPassword)) {
                throw new Exceptions("Нууц үг ба нууц үгийн баталгаажуулалт үг адил байх ёстой.");
            }

            return true;
        } catch (Exceptions ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }
}

class Exceptions extends Exception {
    public Exceptions() {
        super();
    }

    public Exceptions(String message) {
        super(message);
    }
}
