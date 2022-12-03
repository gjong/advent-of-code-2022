package common;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Supplier;

public class InputSuppliers {

    private InputSuppliers() {}

    public static Supplier<String> stringSupplier(String inputFile) {
        return () -> String.join("\n", readInputData(inputFile));
    }

    public static Supplier<List<String>> listSupplier(String inputFile) {
        return () -> readInputData(inputFile);
    }


    private static List<String> readInputData(String file) {
        try {
            return Files.readAllLines(Path.of(InputSuppliers.class.getResource(file).toURI()));
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException("Could not open input file.", e);
        }
    }
}
