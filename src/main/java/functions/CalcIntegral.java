package functions;

import java.util.function.DoubleUnaryOperator;

public class CalcIntegral implements Runnable {
    private CalcProcessor main;
    private Function calc;
    public CalcIntegral(double start, double end, int nSteps, DoubleUnaryOperator f, CalcProcessor main) {
        calc = new Function(start, end, nSteps, f);
        this.main = main;
    }
    @Override
    public void run() {
        double v = calc.calculate();
        main.send(v);
    }
}