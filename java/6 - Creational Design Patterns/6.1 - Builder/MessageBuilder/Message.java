import java.time.LocalDateTime;

abstract class Message {
    protected final String text;
    protected final LocalDateTime datetime;
    protected final String chat;
    protected final String author;
    protected final String file;
    protected final String platform;

    protected Message(MessageBuilder builder) {
        this.text = builder.text;
        this.datetime = builder.datetime;
        this.chat = builder.chat;
        this.author = builder.author;
        this.file = builder.file;
        this.platform = builder.platform;
    }

    public void sendMessage() {
        System.out.println("Sending message");
    }

    public abstract void print();

    public abstract void copy();

    public static abstract class MessageBuilder {
        protected String text;
        protected LocalDateTime datetime;
        protected String chat;
        protected String author;
        protected String file;
        protected String platform;

        public MessageBuilder withText(String text) {
            this.text = text;
            return this;
        }

        public MessageBuilder withDatetime(LocalDateTime datetime) {
            this.datetime = datetime;
            return this;
        }

        public MessageBuilder withChat(String chat) {
            this.chat = chat;
            return this;
        }

        public MessageBuilder withAuthor(String author) {
            this.author = author;
            return this;
        }

        public MessageBuilder withFile(String file) {
            this.file = file;
            return this;
        }

        public MessageBuilder withPlatform(String platform) {
            this.platform = platform;
            return this;
        }

        public abstract Message build();
    }
}

class RemoteMessage extends Message {
    private RemoteMessage(RemoteMessageBuilder builder) {
        super(builder);
    }

    public static class RemoteMessageBuilder extends MessageBuilder {
        @Override
        public Message build() {
            return new RemoteMessage(this);
        }
    }

    @Override
    public void print() {
        System.out.println(new StringBuilder(author).append(": ").append(text).toString());
    }
}

class LocalMessage extends Message {

    private LocalMessage(LocalMessageBuilder builder) {
        super(builder);
    }

    public static class LocalMessageBuilder extends MessageBuilder {
        @Override
        public Message build() {
            return new LocalMessage(this);
        }
    }

    @Override
    public void print() {
        System.out.println("You: " + this.text);
    }
}

class SystemMessage extends Message {
    private SystemMessage(MessageBuilder builder) {
        super(builder);
    }

    public static class SystemMessageBuilder extends MessageBuilder {
        @Override
        public Message build() {
            return new SystemMessage(this);
        }
    }

    @Override
    public void print() {
        System.out.println(new StringBuilder("System: ").append(text).toString());
    }
}