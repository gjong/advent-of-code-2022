package day7;

public interface ListingElement {

    String name();
    long size();

    default boolean isFile() {
        return false;
    }

    default boolean isDirectory() {
        return false;
    }

}
