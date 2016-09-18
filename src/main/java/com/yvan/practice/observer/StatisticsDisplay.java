package com.yvan.practice.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by yvan on 16/8/23.
 */
public class StatisticsDisplay implements Observer, DisplayElement {
    private Observable observable;
    private float pressure;
    private float humidity;

    public StatisticsDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Statistics conditions: " + pressure + " pressure and " + humidity + "% humidity");
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            this.pressure = weatherData.getPressure();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }
}
