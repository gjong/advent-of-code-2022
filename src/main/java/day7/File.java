package day7;

public class File implements ListingElement {
    private final String name;
    private final long size;

    public File(String name, long size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public boolean isFile() {
        return true;
    }

    @Override
    public long size() {
        return size;
    }

    @Override
    public String name() {
        return name;
    }
}
