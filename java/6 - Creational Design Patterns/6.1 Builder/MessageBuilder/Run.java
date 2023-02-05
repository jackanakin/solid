import java.time.LocalDateTime;

public class Run {

        public static void main(String[] args) {
                Message remoteMessage = new RemoteMessage.RemoteMessageBuilder()
                                .withText("Hello, how are you?")
                                .withDatetime(LocalDateTime.now())
                                .withChat("General")
                                .withAuthor("John Doe")
                                .withFile("example.txt")
                                .build();

                Message localMessage = new LocalMessage.LocalMessageBuilder()
                                .withText("Goodbye")
                                .withDatetime(LocalDateTime.now())
                                .withChat("General")
                                .withPlatform("Android")
                                .build();

                Message systemMessage = new SystemMessage.SystemMessageBuilder()
                                .withText("User joined the chat")
                                .withDatetime(LocalDateTime.now())
                                .withChat("General")
                                .build();

                systemMessage.print();
                remoteMessage.print();
                localMessage.print();
        }
}
