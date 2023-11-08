import java.util.Date;

public class Swimmin extends activity {
    public Swimmin(String type, double duration, Date date, double distance, int avgHeartRate) {
        super(type, duration, date, distance, avgHeartRate);

        if (super.getKph() > 3.5) {
            super.setIntensity(10.2);
        } else if (super.getKph() > 2.75) {
            super.setIntensity(8.9);
        } else if (super.getKph() > 2) {
            super.setIntensity(7.6);
        } else if (super.getKph() > 1.25) {
            super.setIntensity(6.3);
        } else if (super.getKph() > .5) {
            super.setIntensity(5);
        }

        super.setCaloriesBurned(super.calorieCalculator());

    }
}
