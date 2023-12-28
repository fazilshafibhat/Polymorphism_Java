package overriding;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

import overriding.message.ImageMessage;
import overriding.message.TextMessage;

public class Main {
    public static void main(String[] args) {
        // In real world, these functions will be called from your REST API server
        // methods.
        // Don't worry about them for now - let's live in a simple world :)

        // Fazil sends a text message to Irfan
        TextMessage message1 = new TextMessage();
        message1.setSenderId("Fazil");
        message1.setReceiverId("Irfan");
        message1.setTextMessageContent("Hello, Have you checked out my blog post?");
        AndroidHandler.sendText(message1);

        // Aakil sends a message to Rizwan
        ImageMessage message2 = new ImageMessage();
        message2.setSenderId("Aakil");
        message2.setReceiverId("Rizwan");

        String imagePath = getFilePathFromResource("MyBlog.png");
        message2.setImageMessageContent(imageToBase64StringConversion(imagePath), "1080x1920",
                "Some Random Image MetaData");
        AndroidHandler.sendImage(message2);
    }

    public static String imageToBase64StringConversion(String filePath) {
        byte[] fileContent;
        try {
            fileContent = Files.readAllBytes(Paths.get(filePath));
            return Base64.getEncoder().encodeToString(fileContent);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    private static String getFilePathFromResource(String fileName) {
        return Main.class.getClassLoader().getResource(fileName).getPath();
    }
}
