
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class View {
    private final Calculator calculator;
    private final List<String> validOperators;

    public View(Calculator calculator) {
        this.calculator = calculator;
        this.validOperators = Arrays.stream(Operators.values())
                .map(Operators::operator)
                .collect(Collectors.toList());

        // Register strategies
        calculator.addStrategy("+", new AdditionalStrategy());
        calculator.addStrategy("-", new SubstractionStrategy());
        calculator.addStrategy("*", new MultiplicationStrategy());
        calculator.addStrategy("/", new DivisionStrategy());
    }

    public void run() {
        while (true) {
            prepare();
            String action = prompt();
            if (!action.equalsIgnoreCase("y")) {
                System.exit(0);
            }
        }
    }

    private void prepare() {
        double real1 = promptDouble("Enter the real part of the first number: ");
        double imag1 = promptDouble("Enter the imaginary part of the first number: ");
        ComplexNum  a = new ComplexNum (real1, imag1);

        String operator = getOperator();

        double real2 = promptDouble("Enter the real part of the second number: ");
        double imag2 = promptDouble("Enter the imaginary part of the second number: ");
        ComplexNum  b = new ComplexNum (real2, imag2);

        ComplexNum  result = calculator.execute(operator, a, b);
        System.out.println("Result: " + result);
        calculator.clear();
    }

    private String prompt() {
        Scanner in = new Scanner(System.in);
        System.err.println("Continue?... (y/n)");
        return in.nextLine();
    }

    private String getOperator() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the math operation (*, +, /, -) : ");
        String operator = in.nextLine();
        while (true) {
            if (isInvalidOperator(operator)) {
                System.err.println("Entered invalid math operator. Enter the math operation (*, +, /, -) : ");
                operator = in.nextLine();
            } else return operator;
        }
    }

    private boolean isInvalidOperator(String operator) {
        return !validOperators.contains(operator);
    }

    private double promptDouble(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        double result = -1;
        try {
            result = Double.parseDouble(in.nextLine());
        } catch (NumberFormatException e) {
            System.err.println("Not a valid number. Please enter a valid number.");
            result = promptDouble(message);
        }
        return result;
    }
}
