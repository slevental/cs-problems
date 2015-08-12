package math;

/**
 * Created by Stas on 8/12/15.
 */
public class SqRoot {
    public static double sqrt(double num) {
        double precision = 0.00001;
        double x0 = num;
        double x1;
        for (; ; ) {
            x1 = .5 * (x0 + num / x0);
            if (Math.abs(x1 - x0) < precision) return x1;
            x0 = x1;
        }
    }
}
