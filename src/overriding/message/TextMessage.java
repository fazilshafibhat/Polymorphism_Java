package overriding.message;

public class TextMessage extends Message {
    private String textMessageContent;

    public TextMessage() {
        super();
        this.setMessageType(MessageType.TEXT);
    }

    public TextMessage(String senderId, String receiverId) {
        super(senderId, receiverId);
        this.setMessageType(MessageType.TEXT);
    }

    public String getTextMessageContent() {
        return textMessageContent;
    }

    public void setTextMessageContent(String textMessageContent) {
        this.textMessageContent = textMessageContent;
    }

    @Override
    public String toString() {
        return "TextMessage [textMessageContent=" + textMessageContent + "messageId=" + this.getMessageId()
                + ", messageStatus="
                + this.getMessageStatus() + ", receiverId=" + this.getReceiverId() + ", senderId=" + this.getSenderId()
                + "]";
    }

    public int getTextMessageContentSize() {
        return textMessageContent.length();
    }

    @Override
    public boolean isValid() {
        if (this.getTextMessageContentSize() > 100) {
            return true;
        }
        return false;
    }

}
