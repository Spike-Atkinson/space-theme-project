import java.lang.Math;
import java.util.Arrays;

public class MainRocket {
    public static void main(String[] args) {
        int[] cargo = new int[10];

        for (int x = 0; x < 10; x++){
            cargo[x] = (int)(Math.random()*(100+1));
        }
        System.out.println(Arrays.toString(cargo));
        Rocket atlas = new Rocket(cargo);
        System.out.println("Max weight: "+atlas.getMaxWeight());
        System.out.println("Average weight: "+ atlas.getAverageWeight());
        System.out.println("Min weight: "+atlas.getMinWeight());
        System.out.println("launch weight: "+atlas.getLaunchWeight());
        //atlas.printCountdown(10);

    }
}
