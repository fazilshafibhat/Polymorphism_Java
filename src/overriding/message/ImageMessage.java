package overriding.message;

public class ImageMessage extends Message {

    private String imageMessageContent;
    private String imageResolution;
    private String imageMetaData;

    public ImageMessage() {
        super();
        this.setMessageType(MessageType.IMAGE);
    }

    public ImageMessage(String senderId, String receiverId) {
        super(senderId, receiverId);
        this.setMessageType(MessageType.IMAGE);
    }

    public String getImageMessageContent() {
        return imageMessageContent;
    }

    public void setImageMessageContent(String imageMessageContent, String imageResolution, String imageMetaData) {
        this.imageMessageContent = imageMessageContent;
        this.imageResolution = imageResolution;
        this.imageMetaData = imageMetaData;
    }

    @Override
    public String toString() {
        return "ImageMessage [imageMessageContent=" + imageMessageContent + "messageId=" + this.getMessageId()
                + ", imageMetaData=" + imageMetaData + ", imageResolution=" + imageResolution + ", messageStatus="
                + this.getMessageStatus() + ", receiverId=" + this.getReceiverId() + ", senderId=" + this.getSenderId()
                + "]";
    }

    @Override
    public boolean isValid() {
        if (this.getImageMessageContent() != null) {
            return true;
        }
        return false;
    }
}
