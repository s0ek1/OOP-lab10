package functions;

import result.Result;

public class CalcProcessor implements ICalc {

    public Result calcIntegral(int intervals, int threads) {
        double a = 0;
        double b = Math.PI/3;

        double delta = (b - a) / threads;
        totalResult = 0;
        finished = 0;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < threads; i++) {
            CalcIntegral calculator = new CalcIntegral(
                    a + i * delta,
                    a + i * delta + delta,
                    intervals / threads, t -> Math.cos(4*t)*Math.cos(2*t),
                    this);
            new Thread(calculator).start();
        }
        try {
            synchronized (this) {
                while (finished < threads) {
                    wait();
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupted");
        }
        long finishTime = System.currentTimeMillis();
        return new Result(totalResult, finishTime - startTime);
    }
    private double totalResult;
    private int finished;
    public synchronized void send(double v) {
        totalResult += v;
        finished++;
        notify();
    }
}