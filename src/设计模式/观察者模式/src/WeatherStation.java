package 设计模式.观察者模式.src;

public class WeatherStation {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        //注册看板，在WeatherData 这边把看板注册进去
        //每次更新 都会循环 去调用 看板的update方法
        CurrentConditionsDisplay currentConditionsDisplay =
                new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay =
                new StatisticsDisplay(weatherData);

        weatherData.setMeasurements(0,0,0);
        weatherData.setMeasurements(1,1,1);

    }
}
