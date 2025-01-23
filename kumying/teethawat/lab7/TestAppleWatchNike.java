package kumying.teethawat.lab7;

public class TestAppleWatchNike {
    public static void main(String[] args) {
        AppleWatchNike nikeWatch = new AppleWatchNike("Space Gray", 12900.0, 
        "Nike SE GPS", 0, 42.5, 0, 75, 0, 7.5);

        System.out.println(nikeWatch);

        nikeWatch.displayRunningStats();
        nikeWatch.displayHeartRates();
        nikeWatch.displaySleepHours();

        System.out.println("Is this a watch? " + nikeWatch.isWatch());

        AppleWatch baseWatch = nikeWatch;
        System.out.println("Through base reference: " + baseWatch);
    }
}
