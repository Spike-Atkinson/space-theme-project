import java.lang.reflect.Array;

public class Rocket {
    private int[] payload;

    Rocket (int[] payload){
        this.payload = payload;
    }
    public int getLaunchWeight(){
        int sum = 0;
        for (int i = 0; i < Array.getLength(payload); i++) {
            sum += payload[i];
        }
        return sum;
    }
    public double getAverageWeight(){
        double avg = (double)getLaunchWeight() / (double)Array.getLength(payload);
        return avg;
    }
    public int getMaxWeight() {
        int max = payload[0];
        for (int i = 1; i < Array.getLength(payload); i++) {
            if (payload[i] > max){
                max = payload[i];
            }
        }
        return max;
    }
    public int getMinWeight(){
        int min = payload[0];
        for (int i = 1; i < Array.getLength(payload); i++) {
            if (payload[i] < min) {
                min = payload[i];
            }
        }
        return min;
    }
    public void printCountdown(int t){
        if (t < 1){
            System.out.println("Invalid time.");
        }
        else {
            for (int i = 0; i < t; i++) {
                System.out.println(t-i);
            }
            System.out.println("Lift off!");
        }
    }
}
