class LocalMessageCreator implements MessageCreator {
    @Override
    public Message createMessage() {
        return new LocalMessage();
    }
}