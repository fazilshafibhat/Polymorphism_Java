package overriding;

import overriding.message.ImageMessage;
import overriding.message.Message;
import overriding.message.TextMessage;

public class AndroidHandler {
    public static void sendText(TextMessage message) {
        // 1. Discard empty strings.
        if (message.getTextMessageContent().isEmpty()) {
            try {
                throw new Exception("Cannot Send Empty Message!");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        // 2. Validate message.
        checkMessageValidity(message);

        // 3. Store the Message Safely.
        save(message);

        // 4.Deliver the message.
        deliverText(message);

    }

    public static void sendImage(ImageMessage message) {
        // 1. Discard empty strings.
        if (message.getImageMessageContent().isEmpty()) {
            try {
                throw new Exception("Cannot Send Empty Image!");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        // 2. Validate message.
        checkMessageValidity(message);

        // 3. Store the Message Safely.
        save(message);

        // 4.Deliver the message.
        deliverImage(message);

    }

    private static void save(Message message) {
        // Write logic to store the message
        System.out.println(message + " stored successfully.");
    }

    private static void deliverText(TextMessage message) {
        // Logic to actually send the message to the user. It may happen through some
        // queueing mechanism.
        // Out of syllabus for this exercise :')

        // # If the message is too large, don't deliver the message directly.
        // For now, drop the message, in future it can be sent as a link to a storage
        // bucket.
        if (message.getTextMessageContentSize() > 100) {
            try {
                throw new Exception("Message too large to send >" + message.getTextMessageContentSize() + " 100 bytes");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        System.out.println(message + " delivered successfully.");
    }

    private static void deliverImage(Message message) {
        // Logic to actually send the message to the user. It may happen through some
        // queueing mechanism.
        // Out of syllabus for this exercise :')
        System.out.println("Image" + message + " delivered successfully.");
    }

    private static boolean checkMessageValidity(Message message) {
        return message.isValid();
    }

}
