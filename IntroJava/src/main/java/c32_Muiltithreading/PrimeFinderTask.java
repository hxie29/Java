package c32_Muiltithreading;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;

public class PrimeFinderTask extends Task<ObservableList<Long>> {
    private long lowerLimit = 1;
    private long upperLimit = 30;
    private long sleepTimeMillis = 500;

    public PrimeFinderTask() {}

    public PrimeFinderTask(long lowerLimit, long upperLimit) {
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
    }
    public PrimeFinderTask(long lowerLimit, long upperLimit, long sleepTimeMillis) {
        this(lowerLimit, upperLimit);
        this.sleepTimeMillis = sleepTimeMillis;
    }

    @Override
    protected ObservableList<Long> call() throws Exception {
        // codes that we want to run
        final ObservableList<Long> result = FXCollections.observableArrayList();
        this.updateTitle("Prime Number Finder Task");

        long count = 0;
        for (long i = lowerLimit; i <= upperLimit; i++) {
            if (this.isCancelled())
                break;

            count++;
            this.updateMessage("Checking " + i + " for a prime number");
            try {
                Thread.sleep(sleepTimeMillis);
            }
            catch (InterruptedException ex) {
                if (this.isCancelled())
                    break;
                            }

            if (PrimeUtil.isPrime(i)) {
                result.add(i);
                /*In this case, you are creating a new unmodifiable list every time you find a new prime number, which is
                  not acceptable in a production environment for performance reasons. The efficient way of publishing the partial
                  results would be to declare a read-only property for the Task; update the read-only property regularly on the
                  JavaFX Application Thread; let the client bind to the read-only property to see the partial results.*/
                updateValue(FXCollections.unmodifiableObservableList(result));
            }
            updateProgress(count, upperLimit - lowerLimit + 1);
        }
        return result;
    }

    @Override
    protected void cancelled() {
        super.cancelled();
        updateMessage("The task was cancelled.");
    }

    @Override
    protected void failed() {
        super.failed();
        updateMessage("The task failed.");
    }

    @Override
    protected void succeeded() {
        super.succeeded();
        updateMessage("The task finished successfully.");
    }
}
