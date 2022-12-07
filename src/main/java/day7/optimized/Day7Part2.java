package day7.optimized;

import common.Solution;
import day7.Directory;

import java.util.*;

import static java.lang.Integer.parseInt;

public class Day7Part2 implements Solution<Scanner, Integer> {

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

        var clearSpace = 30_000_000 - (70_000_000 - rootDir.size);
        return flattenDirs.stream()
                .filter(d -> d.size >= clearSpace)
                .mapToInt(d -> d.size)
                .min()
                .getAsInt();
    }
}
