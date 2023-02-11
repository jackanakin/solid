abstract class CaffeineBeverage {
  final void prepareRecipe() {
    boilWater();
    brew();
    pourInCup();
    addCondiments();
  }

  abstract void brew();

  abstract void addCondiments();

  void boilWater() {
    System.out.println("Boiling water");
  }

  void pourInCup() {
    System.out.println("Pouring into cup");
  }
}

class Tea extends CaffeineBeverage {
  @Override
  void brew() {
    System.out.println("Steeping the tea");
  }

  @Override
  void addCondiments() {
    System.out.println("Adding Lemon");
  }
}

class Coffee extends CaffeineBeverage {
  @Override
  void brew() {
    System.out.println("Dripping Coffee through filter");
  }

  @Override
  void addCondiments() {
    System.out.println("Adding Sugar and Milk");
  }
}

public class Run {
  public static void main(String[] args) {
    CaffeineBeverage tea = new Tea();
    tea.prepareRecipe();

    CaffeineBeverage coffee = new Coffee();
    coffee.prepareRecipe();
  }
}