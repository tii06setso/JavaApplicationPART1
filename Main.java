package qana;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Login login = new Login();

        // REGISTER
        System.out.println("===== REGISTER =====");

        System.out.print("First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        System.out.print("Cell Number (+27...): ");
        String phone = scanner.nextLine();

        String registerMessage =
                login.registerUser(username,
                        password,
                        phone);

        System.out.println(registerMessage);

        if (registerMessage.contains("successfully")) {

            login.setUserDetails(firstName,
                    lastName,
                    username,
                    password);

            // LOGIN
            System.out.println("\n===== LOGIN =====");

            System.out.print("Username: ");
            String loginUser = scanner.nextLine();

            System.out.print("Password: ");
            String loginPass = scanner.nextLine();

            boolean loginStatus =
                    login.loginUser(loginUser,
                            loginPass);

            System.out.println(
                    login.returnLoginStatus(loginStatus));

            // QUICKCHAT
            if (loginStatus) {

                System.out.println("\nWelcome to QuickChat.");

                System.out.print(
                        "How many messages would you like to send? ");

                int totalMessages =
                        Integer.parseInt(scanner.nextLine());

                int option = 0;
                int sentMessages = 0;

                while (option != 3) {

                    System.out.println("\n===== MENU =====");

                    System.out.println("1. Send Messages");
                    System.out.println(
                            "2. Show recently sent messages");
                    System.out.println("3. Quit");

                    System.out.print("Choose option: ");

                    option =
                            Integer.parseInt(scanner.nextLine());

                    switch (option) {

                        case 1:

                            for (int i = 1;
                                 i <= totalMessages;
                                 i++) {

                                Message msg = new Message();

                                System.out.println(
                                        "\nMessage " + i);

                                System.out.print("Recipient: ");

                                String recipient =
                                        scanner.nextLine();

                                System.out.println(
                                        msg.checkRecipientCell(
                                                recipient));

                                System.out.print(
                                        "Enter message: ");

                                String text =
                                        scanner.nextLine();

                                System.out.println(
                                        msg.checkMessageLength(
                                                text));

                                msg.setMessageData(
                                        i,
                                        recipient,
                                        text);

                                System.out.println("\n1. Send");
                                System.out.println("2. Disregard");
                                System.out.println("3. Store");

                                int sendOption =
                                        Integer.parseInt(
                                                scanner.nextLine());

                                System.out.println(
                                        msg.sentMessage(sendOption));

                                if (sendOption == 1) {

                                    sentMessages++;

                                    System.out.println(
                                            msg.printMessages());
                                }
                            }

                            break;

                        case 2:

                            System.out.println("Coming Soon.");

                            break;

                        case 3:

                            System.out.println("Goodbye.");

                            break;

                        default:

                            System.out.println(
                                    "Invalid option.");
                    }
                }

                System.out.println(
                        "\nTotal Messages Sent: "
                                + sentMessages);
            }
        }

        scanner.close();
    }
}