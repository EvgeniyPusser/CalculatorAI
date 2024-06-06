

public class DivisionStrategy implements Strategy {
    private ComplexNum a;
    private ComplexNum b;

    @Override
    public void setNumbers(ComplexNum a, ComplexNum b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public ComplexNum calculate() {
        double denominator = b.getRealPart() * b.getRealPart() + b.getImaginaryPart() * b.getImaginaryPart();
        double realPart = (a.getRealPart() * b.getRealPart() + a.getImaginaryPart() * b.getImaginaryPart()) / denominator;
        double imaginaryPart = (a.getImaginaryPart() * b.getRealPart() - a.getRealPart() * b.getImaginaryPart()) / denominator;
        return new ComplexNum (realPart, imaginaryPart);
    }
}

