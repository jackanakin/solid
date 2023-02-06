import java.util.ArrayList;
import java.util.List;

interface Graphic {
  void draw();
}

class Ellipse implements Graphic {
  @Override
  public void draw() {
    System.out.println("Drawing Ellipse");
  }
}

class CompositeGraphic implements Graphic {
  private List<Graphic> graphics = new ArrayList<>();

  @Override
  public void draw() {
    for (Graphic graphic : graphics) {
      graphic.draw();
    }
  }

  public void add(Graphic graphic) {
    graphics.add(graphic);
  }

  public void remove(Graphic graphic) {
    graphics.remove(graphic);
  }
}

public class Main {
  public static void main(String[] args) {
    Graphic ellipse1 = new Ellipse();
    Graphic ellipse2 = new Ellipse();
    Graphic ellipse3 = new Ellipse();

    CompositeGraphic compositeGraphic = new CompositeGraphic();
    compositeGraphic.add(ellipse1);
    compositeGraphic.add(ellipse2);
    compositeGraphic.add(ellipse3);

    Graphic ellipse4 = new Ellipse();
    CompositeGraphic compositeGraphic2 = new CompositeGraphic();
    compositeGraphic2.add(ellipse4);
    compositeGraphic2.add(compositeGraphic);

    compositeGraphic2.draw();
  }
}