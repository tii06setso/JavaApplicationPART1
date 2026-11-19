package qana;

import java.util.Random;

public class Message {

    private String messageID;
    private int messageNumber;
    private String recipient;
    private String message;
    private String messageHash;

    // Generate random message ID
    public void generateMessageID() {

        Random random = new Random();

        messageID = String.valueOf(
                1000000000L
                        + (long)(random.nextDouble()
                        * 8999999999L));
    }

    // Validate recipient number
    public String checkRecipientCell(String recipient) {

        if (recipient.matches("^\\+27\\d{9}$")) {

            return "Cell phone number successfully captured.";

        } else {

            return "Cell phone number incorrectly formatted.";
        }
    }

    // Validate message length
    public String checkMessageLength(String message) {

        if (message.length() <= 250) {

            return "Message ready to send.";

        } else {

            int excess = message.length() - 250;

            return "Message exceeds 250 characters by "
                    + excess;
        }
    }

    // Create message hash
    public String createMessageHash() {

        String[] words = message.split(" ");

        String firstWord = words[0];
        String lastWord = words[words.length - 1];

        return messageID.substring(0, 2)
                + ":" + messageNumber
                + ":" + firstWord.toUpperCase()
                + lastWord.toUpperCase();
    }

    // Send message options
    public String sentMessage(int option) {

        switch (option) {

            case 1:
                return "Message successfully sent.";

            case 2:
                return "Message disregarded.";

            case 3:
                return "Message successfully stored.";

            default:
                return "Invalid option.";
        }
    }

    // Set data
    public void setMessageData(int number,
                               String recipient,
                               String message) {

        this.messageNumber = number;
        this.recipient = recipient;
        this.message = message;

        generateMessageID();

        this.messageHash = createMessageHash();
    }

    // Display message
    public String printMessages() {

        return "Message ID: " + messageID
                + "\nMessage Hash: " + messageHash
                + "\nRecipient: " + recipient
                + "\nMessage: " + message;
    }
}