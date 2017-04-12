package randwod.randwod;

import java.util.Random;

/**
 * Created by simon on 2017-02-20.
 */

public class ExerciseDefinition {

    private String name;
    private int minRep;
    private int maxRep;
    private int timeToRep;

    public ExerciseDefinition(String name, int minRep, int maxRep, int timeToRep) {
        this.name = name;
        this.minRep = minRep;
        this.maxRep = maxRep;
        this.timeToRep = timeToRep;
    }

    public String getName() {
        return name;
    }

    public int getRandomReps() {
        Random r = new Random();
        return r.nextInt(maxRep - minRep + 1) + minRep;
    }

    public int getTimeToRep() {
        return timeToRep;
    }

}
