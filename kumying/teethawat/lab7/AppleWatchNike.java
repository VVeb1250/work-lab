/* This class using interface for more understanding
 * extend from AppleWatch and implement two interface 
 */

package kumying.teethawat.lab7;

// interface
interface RunnerStatsCollector {
    public void displayRunningStats();
    public void displayHeartRates();
}
interface HealthMonitorer  {
    public void displaySleepHours();
}
// class that extend and implement two interface
public class AppleWatchNike extends AppleWatch implements RunnerStatsCollector, HealthMonitorer{
    // more att.
    private double pace;
    private double distance;
    private double time;
    private double avgHeartRate;
    private double maxHeartRate;
    private double sleepHours;
    // constructor
    public AppleWatchNike(String color, double prize, String modelName) {
        super(color, prize, modelName);
    }
    public AppleWatchNike(String color, double prize, String modelName, 
    double pace, double distance, double time, double avgHeartRate, double maxHeartRate, double sleepHours) {
        super(color, prize, modelName);
        this.pace = pace;
        this.distance = distance;
        this.time = time;
        this.avgHeartRate = avgHeartRate;
        this.maxHeartRate = maxHeartRate;
        this.sleepHours = sleepHours;
    }
    // write own method from interface
    public void displayRunningStats() {
        System.out.print("Total distance run: ");
        System.out.printf("%.2f", distance);
        System.out.println(" km");
    }
    public void displayHeartRates() {
        System.out.print("Average heart rate: ");
        System.out.printf("%.0f", avgHeartRate);
        System.out.println(" bpm");
    }
    public void displaySleepHours() {
        System.out.print("Average sleep duration: ");
        System.out.printf("%.2f", sleepHours);
        System.out.println(" hours");
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        StringBuffer text = new StringBuffer();
        text.append("AppleWatchNike");
        text.append("(" + "color: " + this.getColor());
        text.append(" prize:" + this.getPrice());
        text.append(" model name:" + getModelName());
        text.append(" distance:" + distance + " km)");
        return text.toString();
    }
}