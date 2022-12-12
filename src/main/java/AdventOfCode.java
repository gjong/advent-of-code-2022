import common.DayExecutor;
import day1.CalorieCounting;
import day1.GroupedCounter;
import day10.CrtArtSolver;
import day10.SignalStrengthSolver;
import day11.KeepAwaySolver;
import day11.WorryResolver;
import day12.PathSolver;
import day12.PrettiestPathSolver;
import day2.RockPaperScissors;
import day2.RockPaperScissorsResult;
import day3.GroupedRucksack;
import day3.Rucksack;
import day4.CleanupCampAnyOverlap;
import day4.CleanupCampFullOverlap;
import day5.CrateMover9000;
import day5.SupplyStacks;
import day6.TuningTrouble;
import day7.DirectoryListing;
import day7.DiskCleaner;
import day7.optimized.Day7Part1;
import day7.optimized.Day7Part2;
import day8.ScenicSolver;
import day8.TreeTopVisibility;
import day9.RopeSolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static common.InputSuppliers.*;

public class AdventOfCode {

    private static final Logger LOG = LoggerFactory.getLogger(AdventOfCode.class);

    public static void main(String[] args) {
        LOG.info("Starting the execution of all known exercises.");
        List.of(
                new DayExecutor<>("Day 1 - Part 1", new CalorieCounting(), stringSupplier("/day1-caloric-input.txt")),
                new DayExecutor<>("Day 1 - Part 2", new GroupedCounter(), stringSupplier("/day1-caloric-input.txt")),

                new DayExecutor<>("Day 2 - Part 1", new RockPaperScissors(), listSupplier("/day2-rock-paper-scissors.txt")),
                new DayExecutor<>("Day 2 - Part 1", new RockPaperScissorsResult(), listSupplier("/day2-rock-paper-scissors.txt")),

                new DayExecutor<>("Day 3 - Part 1", new Rucksack(), listSupplier("/day3-rucksack.txt")),
                new DayExecutor<>("Day 3 - Part 2", new GroupedRucksack(), listSupplier("/day3-rucksack.txt")),

                new DayExecutor<>("Day 4 - Part 1", new CleanupCampFullOverlap(), scannerSupplier("/day4-cleanup.txt")),
                new DayExecutor<>("Day 4 - Part 2", new CleanupCampAnyOverlap(), scannerSupplier("/day4-cleanup.txt")),

                new DayExecutor<>("Day 5 - Part 1", new SupplyStacks(), scannerSupplier("/day5-boxes.txt")),
                new DayExecutor<>("Day 5 - Part 2", new CrateMover9000(), scannerSupplier("/day5-boxes.txt")),

                new DayExecutor<>("Day 6 - Part 1", new TuningTrouble(4), stringSupplier("/day6-code.txt")),
                new DayExecutor<>("Day 6 - Part 2", new TuningTrouble(14), stringSupplier("/day6-code.txt")),

                new DayExecutor<>("Day 7 - Part 1", new DirectoryListing(), scannerSupplier("/day7-instructions.txt")),
                new DayExecutor<>("Day 7 - Part 2", new DiskCleaner(), scannerSupplier("/day7-instructions.txt")),

                new DayExecutor<>("Day 7 (Optimized) - Part 1", new Day7Part1(), scannerSupplier("/day7-instructions.txt")),
                new DayExecutor<>("Day 7 (Optimized) - Part 2", new Day7Part2(), scannerSupplier("/day7-instructions.txt")),

                new DayExecutor<>("Day 8 - Part 1", new TreeTopVisibility(), listSupplier("/day8-trees.txt")),
                new DayExecutor<>("Day 8 - Part 2", new ScenicSolver(), listSupplier("/day8-trees.txt")),

                new DayExecutor<>("Day 9 - Part 1", new RopeSolver(2), scannerSupplier("/day9-moves.txt")),
                new DayExecutor<>("Day 9 - Part 2", new RopeSolver(10), scannerSupplier("/day9-moves.txt")),

                new DayExecutor<>("Day 10 - Part 1", new SignalStrengthSolver(), scannerSupplier("/day10-cycles.txt")),
                new DayExecutor<>("Day 10 - Part 2", new CrtArtSolver(), scannerSupplier("/day10-cycles.txt")),

                new DayExecutor<>("Day 11 - Part 1", new KeepAwaySolver(20,  WorryResolver.DIV3()), stringSupplier("/day11-monkeys.txt")),
                new DayExecutor<>("Day 11 - Part 2", new KeepAwaySolver(10000,  WorryResolver.noop()), stringSupplier("/day11-monkeys.txt")),

                new DayExecutor<>("Day 12 - Part 1", new PathSolver(), listSupplier("/day12-mountain.txt")),
                new DayExecutor<>("Day 12 - Part 2", new PrettiestPathSolver(), listSupplier("/day12-mountain.txt"))

        ).forEach(DayExecutor::execute);
        LOG.info("Executed all found exercises.");
    }

}
