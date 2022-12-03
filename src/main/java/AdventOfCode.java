import common.Solution;
import day1.CalorieCounting;
import day1.GroupedCounter;
import day2.RockPaperScissors;
import day2.RockPaperScissorsResult;
import day3.GroupedRucksack;
import day3.Rucksack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.function.Supplier;

import static common.InputSuppliers.listSupplier;
import static common.InputSuppliers.stringSupplier;

public class AdventOfCode {

    private static final Logger LOG = LoggerFactory.getLogger(AdventOfCode.class);

    record DayExecution<T>(String day, Solution<T, ?> solution, Supplier<T> inputSupplier) {
        void execute() {
            LOG.info("\tExercise: \u001b[1;34m{}\u001b[m", day);
            var input = inputSupplier.get();

            var startTime = Instant.now();
            var answer = solution.solve(input);
            var endTime = Instant.now();

            LOG.info("\tComputation time: \u001b[36m{}ms\u001b[m", Duration.between(startTime, endTime).toMillis());
            LOG.info("\tAnswer: \u001b[32m{}\u001b[m\n", answer);
        }
    }

    public static void main(String[] args) {
        LOG.info("Starting the execution of all known exercises.");
        List.of(
                new DayExecution<>("Day 1 - Part 1", new CalorieCounting(), stringSupplier("/day1-caloric-input.txt")),
                new DayExecution<>("Day 1 - Part 2", new GroupedCounter(), stringSupplier("/day1-caloric-input.txt")),

                new DayExecution<>("Day 2 - Part 1", new RockPaperScissors(), listSupplier("/day2-rock-paper-scissors.txt")),
                new DayExecution<>("Day 2 - Part 1", new RockPaperScissorsResult(), listSupplier("/day2-rock-paper-scissors.txt")),

                new DayExecution<>("Day 3 - Part 1", new Rucksack(), listSupplier("/day3-rucksack.txt")),
                new DayExecution<>("Day 3 - Part 2", new GroupedRucksack(), listSupplier("/day3-rucksack.txt"))

        ).forEach(DayExecution::execute);
        LOG.info("Executed all found exercises.");
    }

}
