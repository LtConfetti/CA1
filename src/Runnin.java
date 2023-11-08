import java.util.Date;

public class Runnin extends activity {
    public Runnin(String type, double duration, Date date, double distance, int avgHeartRate) {
        super(type, duration, date, distance, avgHeartRate);

        if (super.getKph() > 24) {
            super.setIntensity(20.8);
        } else if (super.getKph() > 16) {
            super.setIntensity(15.4);
        } else if (super.getKph() > 12) {
            super.setIntensity(10);
        } else if (super.getKph() > 8) {
            super.setIntensity(7.2);
        } else if (super.getKph() > 4) {
            super.setIntensity(4.1);
        }

        super.setCaloriesBurned(super.calorieCalculator());
    }
}
