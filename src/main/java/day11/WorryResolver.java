package day11;

import java.util.function.Function;

public interface WorryResolver extends Function<Long, Long> {

    static WorryResolver DIV3() {
        return b -> (long) Math.floor(b / 3.0);
    }

    static WorryResolver noop() {
        return b -> b;
    }

}
