// Abstraction interface
interface Vehicle {
  void drive();
}

// Refined Abstraction
class Car implements Vehicle {
  protected Engine engine;

  public Car(Engine engine) {
    this.engine = engine;
  }

  @Override
  public void drive() {
    engine.start();
    System.out.println("Driving a car.");
    engine.stop();
  }
}

// Implementor interface
interface Engine {
  void start();

  void stop();
}

// Concrete Implementor
class PetrolEngine implements Engine {
  @Override
  public void start() {
    System.out.println("Starting a petrol engine.");
  }

  @Override
  public void stop() {
    System.out.println("Stopping a petrol engine.");
  }
}

public class Main {

  public static void main(String[] args) {
    Engine engine = new PetrolEngine();
    Vehicle car = new Car(engine);

    car.drive();
  }
}