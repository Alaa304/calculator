package calculator;

public class calc {
    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }

    public double squareRoot(double a) {
        return Math.sqrt(a);
    }

    public double cubeRoot(double a) {
        return Math.cbrt(a);
    }

    public double power(double a, double b) {
        return Math.pow(a, b);
    }

    public double logarithm(double a) {
        return Math.log(a);
    }

    public double logBase10(double a) {
        return Math.log10(a);
    }

    public double exponential(double a) {
        return Math.exp(a);
    }

    public double sine(double a) {
        return Math.sin(a);
    }

    public double cosine(double a) {
        return Math.cos(a);
    }

    public double tangent(double a) {
        return Math.tan(a);
    }
}
