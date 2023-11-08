import java.util.Date;

public class Cycling extends activity {
    public Cycling(String type, double duration, Date date, double distance, int avgHeartRate) {
        super(type, duration, date, distance, avgHeartRate);

        if (super.getKph() > 40) {
            super.setIntensity(15);
        } else if (super.getKph() > 33) {
            super.setIntensity(13);
        } else if (super.getKph() > 25) {
            super.setIntensity(7);
        } else if (super.getKph() > 16) {
            super.setIntensity(5);
        } else if (super.getKph() > 8) {
            super.setIntensity(2);
        }

        super.setCaloriesBurned(super.calorieCalculator());
    }
}
