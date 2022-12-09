package common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.Instant;
import java.util.function.Supplier;

public record DayExecutor<T>(String day, Solution<T, ?> solution, Supplier<T> inputSupplier) {
    private static final Logger LOG = LoggerFactory.getLogger(DayExecutor.class);

    public void execute() {
        LOG.info("\tExercise: \u001b[1;34m{}\u001b[m", day);
        var input = inputSupplier.get();

        var startTime = Instant.now();
        var answer = solution.solve(input);
        var endTime = Instant.now();

        LOG.info("\tComputation time: \u001b[36m{}ms\u001b[m", Duration.between(startTime, endTime).toMillis());
        LOG.info("\tAnswer: \u001b[32m{}\u001b[m\n", answer);
    }

}
