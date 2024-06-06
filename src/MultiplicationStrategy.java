

public class MultiplicationStrategy implements Strategy {
    private ComplexNum a;
    private ComplexNum b;

    @Override
    public void setNumbers(ComplexNum a, ComplexNum b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public ComplexNum calculate() {
        double realPart = a.getRealPart() * b.getRealPart() - a.getImaginaryPart() * b.getImaginaryPart();
        double imaginaryPart = a.getRealPart() * b.getImaginaryPart() + a.getImaginaryPart() * b.getRealPart();
        return new ComplexNum (realPart, imaginaryPart);
    }
}

