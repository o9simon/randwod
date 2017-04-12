package randwod.randwod;

/**
 * Created by simon on 2017-02-21.
 */

public class ExerciseList {

    private Exercise[] exercises;

    public ExerciseList(Exercise[] exercises) {
        this.exercises = exercises;
    }

    public Exercise get(int index) {
        return exercises[index];
    }

    public int size() {
        return exercises.length;
    }

    public int getTime() {
        int time = 0;

        for (int i = 0; i < exercises.length; i++) {
            time += exercises[i].getTime();
        }

        return time;
    }

}