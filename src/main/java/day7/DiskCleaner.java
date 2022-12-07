package day7;

import common.Solution;

import java.util.Comparator;
import java.util.Scanner;

import static day7.DirectoryListing.processInstruction;
import static day7.DirectoryListing.processOutput;

public class DiskCleaner implements Solution<Scanner, Long> {

    private static final int TOTAL_DISK_SIZE = 70_000_000;
    private static final int NEEDED_DISK_SIZE = 30_000_000;

    private final Directory rootDirectory = new Directory("/");

    @Override
    public Long solve(Scanner input) {
        var workingDirectory = rootDirectory;
        while (input.hasNextLine()) {
            var instruction = input.nextLine();
            if (instruction.startsWith("$")) {
                workingDirectory = processInstruction(workingDirectory, instruction.substring(2));
            } else {
                processOutput(workingDirectory, instruction);
            }
        }

        var clearSpace = NEEDED_DISK_SIZE - (TOTAL_DISK_SIZE - rootDirectory.size());
        var directoriesOnly = rootDirectory.directories();

        return directoriesOnly.stream()
                .filter(dir -> dir.size() >= clearSpace)
                .sorted(Comparator.comparingLong(Directory::size))
                .findFirst()
                .map(Directory::size)
                .get();
    }
}
