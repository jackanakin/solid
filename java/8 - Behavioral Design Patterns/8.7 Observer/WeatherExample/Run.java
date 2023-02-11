import java.util.ArrayList;
import java.util.List;

interface WeatherObserver {
  void update(int temperature, int humidity, int pressure);
}

interface Subject {
  void registerObserver(WeatherObserver observer);
  void removeObserver(WeatherObserver observer);
  void notifyObservers();
}

class WeatherData implements Subject {
  private List<WeatherObserver> observers;
  private int temperature;
  private int humidity;
  private int pressure;

  public WeatherData() {
    observers = new ArrayList<>();
  }

  @Override
  public void registerObserver(WeatherObserver observer) {
    observers.add(observer);
  }

  @Override
  public void removeObserver(WeatherObserver observer) {
    int i = observers.indexOf(observer);
    if (i >= 0) {
      observers.remove(i);
    }
  }

  @Override
  public void notifyObservers() {
    for (WeatherObserver observer : observers) {
      observer.update(temperature, humidity, pressure);
    }
  }

  public void setMeasurements(int temperature, int humidity, int pressure) {
    this.temperature = temperature;
    this.humidity = humidity;
    this.pressure = pressure;
    notifyObservers();
  }
}

class CurrentConditionsDisplay implements WeatherObserver {
  private int temperature;
  private int humidity;
  private Subject weatherData;

  public CurrentConditionsDisplay(Subject weatherData) {
    this.weatherData = weatherData;
    weatherData.registerObserver(this);
  }

  @Override
  public void update(int temperature, int humidity, int pressure) {
    this.temperature = temperature;
    this.humidity = humidity;
    display();
  }

  public void display() {
    System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
  }
}

class StatisticsDisplay implements WeatherObserver {
  private int temperatureSum = 0;
  private int temperatureCount = 0;
  private Subject weatherData;

  public StatisticsDisplay(Subject weatherData) {
    this.weatherData = weatherData;
    weatherData.registerObserver(this);
  }

  @Override
  public void update(int temperature, int humidity, int pressure) {
    temperatureSum += temperature;
    temperatureCount++;
    display();
  }

  public void display() {
    System.out.println("Avg/Max/Min temperature = " + (temperatureSum / temperatureCount) + "/" + temperatureSum + "/" + temperatureCount);
  }
}

public class Run {
  public static void main(String[] args) {
    WeatherData weatherData = new WeatherData();
    CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
    StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);

    weatherData.setMeasurements(80, 65, 30);
    weatherData.setMeasurements(82, 70, 29);
    weatherData.setMeasurements(78, 90, 29);
  }
}