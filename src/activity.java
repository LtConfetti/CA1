import java.util.*;

public class activity implements Comparable<activity>{

    @Override
    public int compareTo(activity o) {
        if (this == null && o == null) return 0;
        if (o == null) return 1;
        return this.date.compareTo(o.getDate());
    }

    private String type;
    private double duration;
    private Date date;
    private double distance;
    private int avgHeartRate;
    private int caloriesBurned;
    private double intensity = 1;

    public void setIntensity(double intensity) {
        this.intensity = intensity;
    }

    public double getIntensity() {
        return intensity;
    }

    public activity(String type, double duration, Date date, double distance, int avgHeartRate) {
        this.type = type;
        this.duration = duration;
        this.date = date;
        this.distance = distance;
        this.avgHeartRate = avgHeartRate;
    }



    // Getters and Setters for each field
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getAvgHeartRate() {
        return avgHeartRate;
    }

    public void setAvgHeartRate(int avgHeartRate) {this.avgHeartRate = avgHeartRate;}

    public int getCaloriesBurned() {
        return caloriesBurned;
    }

    public void setCaloriesBurned(int caloriesBurned) {this.caloriesBurned = caloriesBurned;}

    public double getKph(){
        if(this.duration > 0)
            return (this.distance / this.duration) * 60;//60 minutes calculating in hours
        else
            return 0;
    }

    public int calorieCalculator(){
        return (int)(intensity * duration);
    }




    @Override
    public String toString() {
        return "Activity{" +
                "type='" + type + '\'' +
                ", duration=" + duration +
                ", date=" + date +
                ", distance=" + distance +
                ", avgHeartRate=" + avgHeartRate +
                ", caloriesBurned=" + caloriesBurned +
                '}';
    }

}
