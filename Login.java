package qana;

public class Login {

    private String storedUsername;
    private String storedPassword;
    private String firstName;
    private String lastName;

    public void setUserDetails(String firstName, String lastName,
                               String username, String password) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.storedUsername = username;
        this.storedPassword = password;
    }

    public boolean checkUserName(String username) {

        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity(String password) {

        boolean length = password.length() >= 8;
        boolean capital = password.matches(".*[A-Z].*");
        boolean number = password.matches(".*\\d.*");
        boolean special = password.matches(".*[^a-zA-Z0-9].*");

        return length && capital && number && special;
    }

    public boolean checkCellPhoneNumber(String phone) {

        return phone.matches("^\\+27\\d{9}$");
    }

    public String registerUser(String username,
                               String password,
                               String phone) {

        if (!checkUserName(username)) {

            return "Username is not correctly formatted.";
        }

        if (!checkPasswordComplexity(password)) {

            return "Password is not correctly formatted.";
        }

        if (!checkCellPhoneNumber(phone)) {

            return "Cell phone number incorrectly formatted.";
        }

        return "User successfully registered.";
    }

    public boolean loginUser(String username, String password) {

        return username.equals(storedUsername)
                && password.equals(storedPassword);
    }

    public String returnLoginStatus(boolean status) {

        if (status) {

            return "Welcome "
                    + firstName
                    + " "
                    + lastName
                    + ", it is great to see you again.";

        } else {

            return "Username or password incorrect.";
        }
    }
}