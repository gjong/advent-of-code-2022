package day7.optimized;

import common.Solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Day7Part1 implements Solution<Scanner, Integer> {

    private class Directory {
        private int size;
        private Directory parent;
        private List<Directory> subdirs = new ArrayList<>();

        Directory changeDir(String name) {
            if (name.equals("..")) {
                size += subdirs.stream().mapToInt(d -> d.size).sum();
                return parent;
            } else {
                var subDir = new Directory();
                subDir.parent = this;
                subdirs.add(subDir);
                return subDir;
            }
        }
    }
    @Override
    public Integer solve(Scanner input) {
        var flattenDirs = new HashSet<Directory>();
        var rootDir = new Directory();

        var workingDir = rootDir;
        while (input.hasNextLine()) {
            var line = input.nextLine();
            if (line.charAt(0) == '$') {
                workingDir = switch (line.substring(2, 4)) {
                    case "cd" -> workingDir.changeDir(line.substring(5));
                    case "ls" -> workingDir;
                    default -> throw new IllegalStateException("Unknown instruction ");
                };
                flattenDirs.add(workingDir);
            } else if (!line.startsWith("dir")) {
                var fileAndSize = line.split(" ");
                workingDir.size += parseInt(fileAndSize[0]);
            }
        }

        return flattenDirs.stream()
                .filter(d -> d.size <= 100000)
                .mapToInt(d -> d.size)
                .sum();
    }
}
