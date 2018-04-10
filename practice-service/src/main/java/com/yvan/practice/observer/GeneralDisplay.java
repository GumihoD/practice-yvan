package com.yvan.practice.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by yvan on 16/8/23.
 */
public class GeneralDisplay implements Observer, DisplayElement {
    private Observable observable;
    private float tempreature;
    private float humidity;

    public GeneralDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            this.tempreature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }

    @Override
    public void display() {
        System.out.println("Current conditions: " + tempreature + "F degrees and " + humidity + "% humidity");
    }
}
