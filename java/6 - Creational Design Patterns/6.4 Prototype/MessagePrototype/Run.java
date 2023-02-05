import creators.RemoteMessageCreator;
import creators.LocalMessageCreator;
import creators.SystemMessageCreator;

import messages.Message;

public class Run {

        public static void main(String[] args) {
                PrototypeMessage remoteMessage = new RemoteMessage();
                PrototypeMessage clonedRemoteMessage = remoteMessage.clone();
                clonedRemoteMessage.display();

                PrototypeMessage localMessage = new LocalMessage();
                PrototypeMessage clonedLocalMessage = localMessage.clone();
                clonedLocalMessage.display();

                PrototypeMessage systemMessage = new SystemMessage();
                PrototypeMessage clonedSystemMessage = systemMessage.clone();
                clonedSystemMessage.display();
        }
}
