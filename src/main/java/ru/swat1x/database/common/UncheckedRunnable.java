package ru.swat1x.database.common;

public interface UncheckedRunnable extends Runnable {
    void execute() throws Throwable;

    default void run() {
        try {
            this.execute();
        } catch (Throwable var2) {
            throw new RuntimeException("Exception due to running: " + var2.getMessage());
        }
    }

    default UncheckedRunnable andThen(UncheckedRunnable after) {
        return () -> {
            this.run();
            after.run();
        };
    }
}
