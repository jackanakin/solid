
public class Run {

        public static void main(String[] args) {
                Message remoteMessage = MessageFactory.createMessage("Remote");
                remoteMessage.display();

                Message localMessage = MessageFactory.createMessage("Local");
                localMessage.display();

                Message systemMessage = MessageFactory.createMessage("System");
                systemMessage.display();
        }
}
