import java.util.Scanner;

public class Dasgal_01 {
    private String login;
    private String password;
    private String confirmPassword;
    public static void main(String[] args) {
        new Dasgal_01();
    }

    void input() {
        Scanner input = new Scanner(System.in);
        System.out.print("Нэвтрэх нэр: ");
        login = input.nextLine();
        System.out.print("Нууц үг: ");
        password = input.nextLine();
        System.out.print("Нууц үг баталгаажуулах: ");
        confirmPassword = input.nextLine();
    }

    public  Dasgal_01() {
        input();
        try {
            boolean isValidate = validateLoginName(login) && validatePassword(password,confirmPassword );
            if (isValidate) {
                System.out.println("Нэвтрэх нэр болон нууц үг зөв байна.");
            } else {
                System.out.println("Нэвтрэх нэр болон нууц үг буруу байна.");
            }
        } catch (LoginException ex) {
        }
    }

    public boolean validateLoginName(String login) throws LoginException {
        try {
            if (!login.matches("^[a-zA-Z0-9-]+$")) {
                throw new LoginException("Нэвтрэх нэрийг зөвхөн латин үсэн, цифр, доогуур зураас тэмдэгтээр бичнэ.");
            }

            if (login.length() > 20) {
                throw new LoginException("Нэвтрэх нэр нь 20 тэмдэгтээс богино байх ёстой.");
            }
            return true;
        }catch (LoginException ex){
            System.err.println( ex.getMessage());
            return false;
        }
    }

    public boolean validatePassword(String password, String confirmPassword) throws LoginException {
        try {
            if (!password.matches("^[a-zA-Z0-9-]+$")) {
                throw new LoginException("Нууц үгийг зөвхөн латин үсэг, цифр, доогуур зураас тэмдэгтээр бичнэ");
            }

            if (!password.equals(confirmPassword)) {
                throw new LoginException("Нууц үг ба нууц үгийн баталгаажуулалт үг адил байх ёстой.");
            }
            return true;
        }catch (LoginException ex){
            System.err.println(ex.getMessage());
            return false;
        }
    }
}

class LoginException extends Exception {
    public LoginException() {
        super();
    }

    public LoginException(String message) {
        super(message);
    }
}
