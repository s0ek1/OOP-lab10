import functions.Function;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testFunction {
    Function func;
    double EPS = 1e-9;
    @BeforeEach
    void setUp() {
        double a = 0;
        double b = Math.PI/3;
        int nSteps = 100_000_000;
        func = new Function(a, b, nSteps, x -> Math.cos(x));
    }
    @Test
    void calculateTest() {
        double expected = 0.8660254014;
        assertEquals(expected, func.calculate(), EPS);
    }
}