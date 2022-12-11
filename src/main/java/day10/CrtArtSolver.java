package day10;

import common.Solution;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.lang.Integer.parseInt;

public class CrtArtSolver implements Solution<Scanner, String> {

    private static final int CYCLES_PER_ROW = 40;
    private static final String ADD_INST = "addx ";

    @Override
    public String solve(Scanner input) {
        var currentCycle = 0;
        var x = 1;

        var lastInstruction = "";
        var readNextLine = true;
        var screen = new char[6][40];
        while (currentCycle <= 240 && input.hasNextLine()) {
            var row = currentCycle / CYCLES_PER_ROW;
            if (readNextLine) {
                lastInstruction = input.nextLine();
            }

            var drawPosition = currentCycle % CYCLES_PER_ROW;
            var drawSymbol = '.';
            if ((x - 1) <= drawPosition && (x + 1) >= drawPosition) {
                drawSymbol = '#';
            }
            screen[row][drawPosition] = drawSymbol;

            if (lastInstruction.startsWith(ADD_INST)) {
                if (!readNextLine) {
                    x += parseInt(lastInstruction.substring(ADD_INST.length()));
                }

                readNextLine = !readNextLine;
            }

            currentCycle++;
        }

        var response = new StringBuilder(System.lineSeparator());
        for (var row : screen) {
            Arrays.asList(row)
                    .forEach(response::append);
            response.append(System.lineSeparator());
        }

        return response.toString();
    }
}
