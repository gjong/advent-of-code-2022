package day7;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Directory implements ListingElement {

    private final Directory parent;
    private final String name;

    private final Set<ListingElement> contents;

    public Directory(String name) {
        this.parent = null;
        this.name = name;
        contents = new HashSet<>();
    }

    public Directory(Directory parent, String name) {
        this.parent = parent;
        this.name = name;
        contents = new HashSet<>();
    }

    public Set<ListingElement> contents() {
        return contents;
    }

    public Set<Directory> directories() {
        return Stream.concat(Stream.of(this),
                contents.stream()
                        .filter(ListingElement::isDirectory)
                        .map(Directory.class::cast)
                        .flatMap(d -> d.directories().stream())
        ).collect(Collectors.toSet());
    }

    public Directory parent() {
        return parent;
    }

    public void add(ListingElement child) {
        contents.add(child);
    }

    @Override
    public boolean isDirectory() {
        return true;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public long size() {
        return this.contents.stream()
                .mapToLong(ListingElement::size)
                .sum();
    }
}
