class MessageFactory {
    
    public static Message createMessage(String messageType) {
        switch (messageType) {
            case "Remote":
                return new RemoteMessage();
            case "Local":
                return new LocalMessage();
            case "System":
                return new SystemMessage();
            default:
                return null;
        }
    }

}