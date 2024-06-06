

public class AdditionalStrategy implements Strategy {
    private ComplexNum a;
    private ComplexNum b;

    @Override
    public void setNumbers(ComplexNum a, ComplexNum b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public ComplexNum calculate() {
        double realPart = a.getRealPart() + b.getRealPart();
        double imaginaryPart = a.getImaginaryPart() + b.getImaginaryPart();
        return new ComplexNum(realPart, imaginaryPart);
    }
}

