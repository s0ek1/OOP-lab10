package functions;

import result.Result;

public interface ICalc {
    Result calcIntegral(int intervals, int threads);
}