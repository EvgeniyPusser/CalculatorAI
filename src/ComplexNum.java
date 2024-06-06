

public class ComplexNum {
    private double realPart;
    private double imaginaryPart;

    public ComplexNum(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    public double getRealPart() {
        return realPart;
    }

    public double getImaginaryPart() {
        return imaginaryPart;
    }

    @Override
    public String toString() {
        return realPart + " + " + "i * " + imaginaryPart;
    }
}
