package randwod.randwod;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by simon on 2017-02-20.
 */

public class ExerciseDefinitionList {

    private ArrayList<ExerciseDefinition> exercises = new ArrayList<ExerciseDefinition>();

    public ExerciseDefinitionList() {
        exercises.add(new ExerciseDefinition("box jump", 1, 20, 1));
        exercises.add(new ExerciseDefinition("thruster", 1, 10, 1));
        exercises.add(new ExerciseDefinition("power snatch", 1, 10, 1));
        exercises.add(new ExerciseDefinition("rope climb", 1, 2, 1));
        exercises.add(new ExerciseDefinition("clean and jerk", 1, 10, 1));
        exercises.add(new ExerciseDefinition("wall ball", 10, 20, 1));
    }

    public ExerciseList getExerciseList(int count) {
        Exercise[] arr = new Exercise[count];
        Random r = new Random();
        int randomIndex = 0;

        ArrayList<Integer> usedIndexes = new ArrayList<Integer>();

        for (int i = 0; i < count; i++) {
            randomIndex = r.nextInt((this.exercises.size()));

            while (usedIndexes.contains(randomIndex)) {
                randomIndex = r.nextInt((this.exercises.size()));
            }

            arr[i] = new Exercise(exercises.get(randomIndex));
            usedIndexes.add(randomIndex);
        }

        return new ExerciseList(arr);
    }

}
