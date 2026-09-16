package compress;

import edu.game.compress.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    static Stream<Object[]> cases() {
        return Stream.of(
                new Object[]{List.of(), List.of()},
                new Object[]{List.of(1), List.of(1)},
                new Object[]{List.of(1, 1, 1, 1), List.of(1)},
                new Object[]{List.of(1, 1, 2, 2, 3), List.of(1, 2, 3)},
                new Object[]{List.of(0, 0, 1, 1, 0), List.of(0, 1, 0)},
                new Object[]{List.of(1, 2, 3), List.of(1, 2, 3)},
                new Object[]{List.of(1, 2, 1, 2), List.of(1, 2, 1, 2)},
                new Object[]{List.of(-1, -1, 0, 0, -1), List.of(-1, 0, -1)}
        );
    }


    @ParameterizedTest
    @MethodSource("cases")
    void testCompressNumbers(List<Integer> input, List<Integer> expected) {
        Assertions.assertEquals(expected, Solution.compressNumbers(input));
    }

    @Test
    void nullInputReturnsEmptyList() {
        assertEquals(List.of(), Solution.compressNumbers(null));
    }

    @Test
    void doesNotMutateInput() {
        List<Integer> input = new ArrayList<>(List.of(1, 1, 2, 2, 3));
        List<Integer> copy = new ArrayList<>(input);
        List<Integer> result = Solution.compressNumbers(input);

        assertEquals(List.of(1, 2, 3), result);
        assertEquals(copy, input);
    }

    @Test
    void returnsNewList() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 1, 2));
        List<Integer> result = Solution.compressNumbers(input);

        assertEquals(List.of(1, 2), result);
        assertNotSame(input, result);
    }
}