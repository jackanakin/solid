interface Command {
    void execute();
}

class Light {
    void turnOn() {
        System.out.println("Light is on");
    }
}

class TurnOnLightCommand implements Command {
    Light light;

    TurnOnLightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
    }

    class RemoteControl {
    Command command;

    void setCommand(Command command) {
        this.command = command;
    }

    void pressButton() {
        command.execute();
    }
}

public class Run {
    public static void main(String[] args) {
        Light light = new Light();
        Command turnOnCommand = new TurnOnLightCommand(light);
        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(turnOnCommand);
        remoteControl.pressButton();
    }
}