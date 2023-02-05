interface PrototypeMessage extends Cloneable {
    PrototypeMessage clone();

    void display();
}

class RemoteMessage implements PrototypeMessage {
    @Override
    public PrototypeMessage clone() {
        try {
            return (RemoteMessage) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void display() {
        System.out.println("Displaying Remote Message");
    }
}

class LocalMessage implements PrototypeMessage {
    @Override
    public PrototypeMessage clone() {
        try {
            return (LocalMessage) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void display() {
        System.out.println("Displaying Local Message");
    }
}

class SystemMessage implements PrototypeMessage {
    @Override
    public PrototypeMessage clone() {
        try {
            return (SystemMessage) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void display() {
        System.out.println("Displaying System Message");
    }
}