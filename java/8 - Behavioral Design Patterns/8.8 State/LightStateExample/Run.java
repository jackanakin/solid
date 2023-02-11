interface LightState {
    void switchLight(Light light);
}

class OffState implements LightState {
    @Override
    public void switchLight(Light light) {
        light.setState(new OnState());
        System.out.println("Light switched on.");
    }
}

class OnState implements LightState {
    @Override
    public void switchLight(Light light) {
        light.setState(new OffState());
        System.out.println("Light switched off.");
    }
}

class Light {
    private LightState state;

    public Light() {
        this.state = new OffState();
    }

    public void setState(LightState state) {
        this.state = state;
    }

    public void switchLight() {
        state.switchLight(this);
    }

    public void print()
    {
        System.out.println(state.getClass().getName());
    }
}

public class Run {
    public static void main(String[] args) {
        Light light = new Light();
        light.print();

        light.switchLight();
        light.print();

        light.switchLight();
        light.print();
    }

}
