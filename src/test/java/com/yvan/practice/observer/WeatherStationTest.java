package com.yvan.practice.observer;

import org.junit.Test;

/**
 * Created by yvan on 2016/12/15.
 */
public class WeatherStationTest {

    @Test
    public void test() {
        WeatherData weatherData = new WeatherData();
        GeneralDisplay generalDisplay = new GeneralDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        weatherData.setMeasurements(80, 33, 10.4f);
        weatherData.setMeasurements(28, 53, 60.4f);
        weatherData.setMeasurements(45, 13, 10.4f);
    }

}