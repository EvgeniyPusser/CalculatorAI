
public interface Calculable {
        void addStrategy(String operator, Strategy strategy);
        ComplexNum execute(String operator, ComplexNum a, ComplexNum b);
       // ComplexNum calculate(ComplexNum a, ComplexNum b);
       // ComplexNum result();
        void clear();
    }



