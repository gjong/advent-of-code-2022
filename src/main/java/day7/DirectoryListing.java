package day7;

import common.Solution;

import java.util.Scanner;

import static java.lang.Long.parseLong;

public class DirectoryListing implements Solution<Scanner, Integer> {

    private final Directory rootDirectory = new Directory("/");

    @Override
    public Integer solve(Scanner input) {
        var workingDirectory = rootDirectory;
        while (input.hasNextLine()) {
            var instruction = input.nextLine();
            if (instruction.startsWith("$")) {
                workingDirectory = processInstruction(workingDirectory, instruction.substring(2));
            } else {
                processOutput(workingDirectory, instruction);
            }
        }

        return (int) computeTotalSize(rootDirectory);
    }

    private long computeTotalSize(Directory directory) {
        var size = 0L;
        if (directory.size() <= 100000) {
            size += directory.size();
        }

        size += directory.contents().stream()
                .filter(ListingElement::isDirectory)
                .map(Directory.class::cast)
                .mapToLong(this::computeTotalSize)
                .sum();

        return size;
    }

    static void processOutput(Directory workingDirectory, String instruction) {
        if (instruction.startsWith("dir")) {
            // do nothing
        } else {
            var sizeAndFile = instruction.split(" ");
            workingDirectory.add(new File(sizeAndFile[1], parseLong(sizeAndFile[0])));
        }
    }

    static Directory processInstruction(Directory workingDirectory, String instruction) {
        if (instruction.startsWith("ls")) {
            return workingDirectory;
        } else if (instruction.startsWith("cd")) {
            var directory = instruction.substring("cd ".length());
            if (directory.equals("..")) {
                return workingDirectory.parent();
            } else {
                var childDir = new Directory(workingDirectory, directory);
                workingDirectory.add(childDir);
                return childDir;
            }
        }
        throw new IllegalStateException("Unknown instruction " + instruction);
    }


}
