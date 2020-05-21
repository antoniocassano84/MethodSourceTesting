import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class AdderTest {

    @ParameterizedTest
    @MethodSource("sourceMethod")
    void addTest(IAdder add, int a, int b, int expected) {
        assertEquals(expected, add.add(a, b));
    }

    static Stream<Arguments> sourceMethod() {
        final SimpleAdder simpleAdder = new SimpleAdder();
        final AbsAdder absAdder = new AbsAdder();
        return Stream.of(
                Arguments.of(simpleAdder, 2, 3, 5),
                // add more test cases for SimpleAdder, e.g. 
                Arguments.of(simpleAdder, 2, 0, 2),
                Arguments.of(simpleAdder, 0, 4, 4),
                Arguments.of(absAdder, -2, -5, 7),
                // add more test cases for AbsAdder, e.g. 
                Arguments.of(absAdder, -2, 0, 2),
                Arguments.of(absAdder, 0, -9, 9)
        );
    }
}
