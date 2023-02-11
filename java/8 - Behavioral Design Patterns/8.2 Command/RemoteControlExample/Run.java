interface Command {
  void execute();
}

class Light {
  void turnOn() {
    System.out.println("The light is on");
  }

  void turnOff() {
    System.out.println("The light is off");
  }
}

class TurnOnLightCommand implements Command {
  private Light light;

  TurnOnLightCommand(Light light) {
    this.light = light;
  }

  @Override
  public void execute() {
    light.turnOn();
  }
}

class TurnOffLightCommand implements Command {
  private Light light;

  TurnOffLightCommand(Light light) {
    this.light = light;
  }

  @Override
  public void execute() {
    light.turnOff();
  }
}

class RemoteControl {
  private Command command;

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
    RemoteControl remoteControl = new RemoteControl();

    remoteControl.setCommand(new TurnOnLightCommand(light));
    remoteControl.pressButton();

    remoteControl.setCommand(new TurnOffLightCommand(light));
    remoteControl.pressButton();
  }
}