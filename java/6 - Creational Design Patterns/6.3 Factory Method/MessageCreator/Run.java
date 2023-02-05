import creators.RemoteMessageCreator;
import creators.LocalMessageCreator;
import creators.SystemMessageCreator;

import messages.Message;

public class Run {

        public static void main(String[] args) {
                MessageCreator remoteMessageCreator = new RemoteMessageCreator();
                Message remoteMessage = remoteMessageCreator.createMessage();
                remoteMessage.display();

                MessageCreator localMessageCreator = new LocalMessageCreator();
                Message localMessage = localMessageCreator.createMessage();
                localMessage.display();

                MessageCreator systemMessageCreator = new SystemMessageCreator();
                Message systemMessage = systemMessageCreator.createMessage();
                systemMessage.display();
        }
}
