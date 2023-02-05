interface Message {
    void display();
}

class RemoteMessage implements Message {
    @Override
    public void display() {
        System.out.println("Displaying Remote Message");
    }
}

class LocalMessage implements Message {
    @Override
    public void display() {
        System.out.println("Displaying Local Message");
    }
}

class SystemMessage implements Message {
    @Override
    public void display() {
        System.out.println("Displaying System Message");
    }
}

