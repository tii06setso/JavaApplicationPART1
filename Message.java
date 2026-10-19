package qana;

import java.util.ArrayList;
import java.util.Random;

public class Message {
    
    private String messageID;
    private int messageNumber;
    private String recipient;
    private String message;
    private String messageHash;
    private static final ArrayList<String> sentMessages =
        new ArrayList<>();

private static final ArrayList<String> storedMessages =
        new ArrayList<>();

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
    // Return all sent messages
public static ArrayList<String> getSentMessages() {
    return new ArrayList<>(sentMessages);
}

// Return all stored messages
public static ArrayList<String> getStoredMessages() {
    return new ArrayList<>(storedMessages);
}

// Count sent messages
public static int getSentMessageCount() {
    return sentMessages.size();
}

// Count stored messages
public static int getStoredMessageCount() {
    return storedMessages.size();
}

// Search sent messages by recipient
public static ArrayList<String> searchSentByRecipient(
        String recipient) {

    ArrayList<String> results = new ArrayList<>();

    for (String item : sentMessages) {
        if (item.contains("Recipient: " + recipient)) {
            results.add(item);
        }
    }

    return results;
}

// Search stored messages by recipient
public static ArrayList<String> searchStoredByRecipient(
        String recipient) {

    ArrayList<String> results = new ArrayList<>();

    for (String item : storedMessages) {
        if (item.contains("Recipient: " + recipient)) {
            results.add(item);
        }
    }

    return results;
}

// Search sent messages by message content
public static ArrayList<String> searchSentByContent(
        String keyword) {

    ArrayList<String> results = new ArrayList<>();

    for (String item : sentMessages) {
        if (item.toLowerCase().contains(
                keyword.toLowerCase())) {
            results.add(item);
        }
    }

    return results;
}

// Search stored messages by message content
public static ArrayList<String> searchStoredByContent(
        String keyword) {

    ArrayList<String> results = new ArrayList<>();

    for (String item : storedMessages) {
        if (item.toLowerCase().contains(
                keyword.toLowerCase())) {
            results.add(item);
        }
    }

    return results;
}

// Delete a sent message using its list position
public static boolean deleteSentMessage(int index) {

    if (index >= 0 && index < sentMessages.size()) {
        sentMessages.remove(index);
        return true;
    }

    return false;
}

// Delete a stored message using its list position
public static boolean deleteStoredMessage(int index) {

    if (index >= 0 && index < storedMessages.size()) {
        storedMessages.remove(index);
        return true;
    }

    return false;
}

// Clear all sent messages
public static void clearSentMessages() {
    sentMessages.clear();
}

// Clear all stored messages
public static void clearStoredMessages() {
    storedMessages.clear();
}

// Display all sent messages
public static String displaySentMessages() {

    if (sentMessages.isEmpty()) {
        return "No sent messages available.";
    }

    StringBuilder result = new StringBuilder();

    for (int i = 0; i < sentMessages.size(); i++) {
        result.append("Sent Message ")
              .append(i + 1)
              .append("\n")
              .append(sentMessages.get(i))
              .append("\n\n");
    }

    return result.toString();
}

// Display all stored messages
public static String displayStoredMessages() {

    if (storedMessages.isEmpty()) {
        return "No stored messages available.";
    }

    StringBuilder result = new StringBuilder();

    for (int i = 0; i < storedMessages.size(); i++) {
        result.append("Stored Message ")
              .append(i + 1)
              .append("\n")
              .append(storedMessages.get(i))
              .append("\n\n");
    }

    return result.toString();
}

// Check whether any messages have been sent
public static boolean hasSentMessages() {
    return !sentMessages.isEmpty();
}

// Check whether any messages have been stored
public static boolean hasStoredMessages() {
    return !storedMessages.isEmpty();
}

// Get the most recently sent message
public static String getLastSentMessage() {

    if (sentMessages.isEmpty()) {
        return "No sent messages available.";
    }

    return sentMessages.get(sentMessages.size() - 1);
}

// Get the most recently stored message
public static String getLastStoredMessage() {

    if (storedMessages.isEmpty()) {
        return "No stored messages available.";
    }

    return storedMessages.get(storedMessages.size() - 1);
}

// Count all sent and stored messages
public static int getTotalMessageCount() {
    return sentMessages.size() + storedMessages.size();
}

// Display a message summary
public static String getMessageSummary() {

    return "Total sent messages: "
            + getSentMessageCount()
            + "\nTotal stored messages: "
            + getStoredMessageCount()
            + "\nTotal messages: "
            + getTotalMessageCount();
}

// Check whether a recipient has sent messages
public static boolean hasMessagesForRecipient(
        String recipient) {

    return !searchSentByRecipient(recipient).isEmpty();
}

// Check whether a recipient has stored messages
public static boolean hasStoredMessagesForRecipient(
        String recipient) {

    return !searchStoredByRecipient(recipient).isEmpty();
}

    // Validate message content
    public static boolean isValidMessageContent(String text) {
        return text != null
                && !text.trim().isEmpty()
                && text.length() <= 250;
    }

    // Check whether a recipient is provided
    public static boolean isValidRecipient(String recipient) {
        return recipient != null
                && !recipient.trim().isEmpty();
    }

    // Get a sent message by its position
    public static String getSentMessageAt(int index) {
        if (index >= 0 && index < sentMessages.size()) {
            return sentMessages.get(index);
        }
        return "Invalid sent message index.";
    }

    // Get a stored message by its position
    public static String getStoredMessageAt(int index) {
        if (index >= 0 && index < storedMessages.size()) {
            return storedMessages.get(index);
        }
        return "Invalid stored message index.";
    }

    // Count sent messages containing a keyword
    public static int countSentMessagesContaining(String keyword) {
        if (keyword == null) {
            return 0;
        }

        int count = 0;
        for (String item : sentMessages) {
            if (item.toLowerCase().contains(keyword.toLowerCase())) {
                count++;
            }
        }
        return count;
    }

    // Count stored messages containing a keyword
    public static int countStoredMessagesContaining(String keyword) {
        if (keyword == null) {
            return 0;
        }

        int count = 0;
        for (String item : storedMessages) {
            if (item.toLowerCase().contains(keyword.toLowerCase())) {
                count++;
            }
        }
        return count;
    }

    // Check whether a message exists in sent messages
    public static boolean sentMessageExists(String text) {
        return text != null && sentMessages.contains(text);
    }

    // Check whether a message exists in stored messages
    public static boolean storedMessageExists(String text) {
        return text != null && storedMessages.contains(text);
    }

    // Get the number of messages in both lists
    public static int getAllMessageCount() {
        return sentMessages.size() + storedMessages.size();
    }

    // Get a summary of message storage
    public static String getStorageStatus() {
        return "Sent messages: " + sentMessages.size()
                + "\nStored messages: " + storedMessages.size()
                + "\nTotal entries: " + getAllMessageCount();
    }

    // Check whether both lists are empty
    public static boolean areAllMessageListsEmpty() {
        return sentMessages.isEmpty() && storedMessages.isEmpty();
    }

    // Find a sent message by exact content
    public static int findSentMessageIndex(String text) {
        if (text == null) {
            return -1;
        }
        return sentMessages.indexOf(text);
    }

    // Find a stored message by exact content
    public static int findStoredMessageIndex(String text) {
        if (text == null) {
            return -1;
        }
        return storedMessages.indexOf(text);
    }

    // Remove a sent message by exact content
    public static boolean removeSentMessage(String text) {
        return text != null && sentMessages.remove(text);
    }

    // Remove a stored message by exact content
    public static boolean removeStoredMessage(String text) {
        return text != null && storedMessages.remove(text);
    }

    // Get the number of stored and sent entries together
    public static String getMessageStatistics() {
        return "Message Statistics"
                + "\n------------------"
                + "\nSent: " + getSentMessageCount()
                + "\nStored: " + getStoredMessageCount()
                + "\nTotal: " + getAllMessageCount();
    }

}