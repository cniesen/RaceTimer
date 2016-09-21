package com.niesen.racetimer;

import java.util.HashMap;
import java.util.Map;

public class Timers {
    private Map<Integer, Long> timers = new HashMap<Integer, Long>();

    /**
     * Start the timer for racer
     *
     * @param racerId id of racer
     */
    protected void startTimer(int racerId) {
        timers.put(racerId, System.nanoTime());
    }

    /**
     * Cancel the timer for racer
     *
     * @param racerId id of racer
     */
    protected void cancelTimer(int racerId) {
        timers.remove(racerId);
    }

    /**
     * Stop the timer for racer and return elapsed time
     *
     * @param racerId id of racer
     * @return elapsed time in milliseconds, null if racer has no timer
     */
    protected Long stopTimer(int racerId) {
        Long stopNanoTime = System.nanoTime();
        Long startNanoTime = timers.remove(racerId);
        if (startNanoTime == null) {
            return null;
        } else {
            return stopNanoTime - startNanoTime;
        }
    }
}
