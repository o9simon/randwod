package randwod.randwod;

import android.os.Handler;

import java.util.Observable;

/**
 * Created by simon on 2017-02-20.
 */

public class Timer extends Observable {

    private enum TickDirection {UP, DOWN};

    private TickDirection direction;
    private int initialSeconds;
    private int currentSeconds;
    private Handler handler;

    Runnable timerRunnable = new Runnable() {
        @Override
        public void run() {
            tick();
            handler.postDelayed(this, 1000);
        }
    };

    public Timer() {
        this.initialSeconds = 0;
        this.currentSeconds = 0;
        this.handler = new Handler();
        this.direction = TickDirection.DOWN;
    }

    public void setSeconds(int seconds) {
        initialSeconds = seconds;
        stop();
    }

    public void start() {
        handler.postDelayed(timerRunnable, 0);
        setChanged();
        notifyObservers(currentSeconds);
    }

    public void pause() {
        handler.removeCallbacks(timerRunnable);
        setChanged();
        notifyObservers(currentSeconds);
    }

    public void stop() {
        handler.removeCallbacks(timerRunnable);
        currentSeconds = initialSeconds;
        setChanged();
        notifyObservers(currentSeconds);
    }

    private void tick() {
        if (currentSeconds == 0 && direction == TickDirection.DOWN) {
            direction = TickDirection.UP;
        }

        if (direction == TickDirection.DOWN) {
            currentSeconds--;
        } else {
            currentSeconds++;
        }

        setChanged();
        notifyObservers(currentSeconds);
    }

}
