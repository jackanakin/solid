class RemoteMessageCreator implements MessageCreator {
    @Override
    public Message createMessage() {
        return new RemoteMessage();
    }
}