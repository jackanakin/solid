class SystemMessageCreator implements MessageCreator {
    @Override
    public Message createMessage() {
        return new SystemMessage();
    }
}