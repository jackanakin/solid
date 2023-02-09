import java.util.ArrayList;
import java.util.List;

interface FlightController {
    void register(Aircraft aircraft);
    void sendMessage(Aircraft sender, String message);
}

class AirTrafficController implements FlightController {
    private List<Aircraft> aircrafts = new ArrayList<>();

    @Override
    public void register(Aircraft aircraft) {
        aircrafts.add(aircraft);
    }

    @Override
    public void sendMessage(Aircraft sender, String message) {
        for (Aircraft aircraft : aircrafts) {
            if (aircraft != sender) {
                aircraft.receive(sender, message);
            }
        }
    }
}

abstract class Aircraft {
    protected FlightController flightController;
    protected String name;

    public Aircraft(FlightController flightController, String name) {
        this.name = name;
        this.flightController = flightController;

        flightController.register(this);
    }

    public void send(String message){
        flightController.sendMessage(this, message);
    }

    abstract void receive(Aircraft sender, String message);
}

class Airplane extends Aircraft {

    public Airplane(FlightController flightController, String name) {
        super(flightController, name);
    }

    @Override
    public void receive(Aircraft sender, String message) {
        System.out.println(this.name + " received message from " + sender.name + ": " + message);
    }
}

class Helicopter extends Aircraft {
    public Helicopter(FlightController flightController, String name) {
        super(flightController, name);
    }

    @Override
    public void receive(Aircraft sender, String message) {
        System.out.println(this.name + " received message from " + sender.name + ": " + message);
    }
}

public class Run {
    public static void main(String[] args) {
        FlightController flightController = new AirTrafficController();
        Aircraft airplane1 = new Airplane(flightController, "Airplane 1");
        Aircraft airplane2 = new Airplane(flightController, "Airplane 2");
        Aircraft airplane3 = new Airplane(flightController, "Airplane 3");
        
        Aircraft helicopter1 = new Helicopter(flightController, "Helicopter 1");
        Aircraft helicopter2 = new Helicopter(flightController, "Helicopter 2");

        airplane1.send("Request for landing");
    }
}