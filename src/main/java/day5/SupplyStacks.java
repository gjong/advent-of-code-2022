package day5;

import common.Solution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class SupplyStacks implements Solution<Scanner, String> {
    private Pattern moveExtractor = Pattern.compile("move\\s(?<count>\\d+)\\sfrom\\s(?<from>\\d+)\\sto\\s(?<to>\\d+)");

    private final List<Stack<String>> columns = new ArrayList<>();

    @Override
    public String solve(Scanner input) {
        boolean processing = false;
        while (input.hasNextLine()) {
            var line = input.nextLine();

            if (line.isBlank()) {
                // blank line means the moves start on the next line
                processing = true;
                continue;
            }

            if (processing) {
                processMove(line);
            } else {
                processStackLine(line);
            }
        }

        return columns.stream()
                .map(Stack::pop)
                .collect(Collectors.joining());
    }

    private void processMove(String line) {
        var matcher = moveExtractor.matcher(line);
        if (matcher.find()) {
            var moveBoxes = parseInt(matcher.group("count"));
            var fromColumn = parseInt(matcher.group("from"));
            var toColumn = parseInt(matcher.group("to"));

            for (var move = 0; move < moveBoxes; move++) {
                var boxName = columns.get(fromColumn - 1).pop();
                columns.get(toColumn - 1).add(boxName);
            }
        }
    }

    private void processStackLine(String line) {
        var columnIdx = 0;
        var remainder = line;
        while (!remainder.isEmpty()) {
            if (columns.size() < (columnIdx + 1)) {
                columns.add(new Stack<>());
            }

            var column = remainder.substring(0, Math.min(4, remainder.length()));
            remainder = remainder.substring(column.length());
            if (column.contains("[")) {
                columns.get(columnIdx)
                        .insertElementAt(column.substring(1,2), 0);
            }

            columnIdx++;
        }
    }
}
