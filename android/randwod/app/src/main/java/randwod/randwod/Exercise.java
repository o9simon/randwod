package randwod.randwod;

/**
 * Created by simon on 2017-02-20.
 */

public class Exercise {

    private String name;
    private int reps;
    private int time;

    public Exercise(String name, int reps, int time) {
        this.name = name;
        this.reps = reps;
        this.time = time;
    }

    /**
     * Exercise with random rep count generated from
     * an exercice definition.
     * @param def An exercice definition
     */
    public Exercise(ExerciseDefinition def) {
        int reps = def.getRandomReps();
        this.name = def.getName();
        this.reps = reps;
        this.time = reps * def.getTimeToRep();
    }

    public String getName() {
        return name;
    }

    public int getReps() {
        return reps;
    }

    public int getTime() {
        return time;
    }

}
