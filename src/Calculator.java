
import singleton.LoggerSingleton;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public final class Calculator implements Calculable {
    private ComplexNum result;
    private final Map<String, Strategy> strategyMap;

    public Calculator() {
        strategyMap = new HashMap<>();
    }

    @Override
    public void addStrategy(String operator, Strategy strategy) {
        strategyMap.put(operator, strategy);
    }

    @Override
    public ComplexNum execute(String operator, ComplexNum a, ComplexNum b) {
        Strategy strategy = strategyMap.get(operator);
        if (strategy != null) {
            strategy.setNumbers(a, b);
            Logger logger = LoggerSingleton.getInstance();
            logger.info("Calculating: " + a + " and " + b);
            result = strategy.calculate();
            //logger.info("Result: " + result);
        } else {
            throw new IllegalArgumentException("Invalid operator: " + operator);
        }
        return result;
    }

//    @Override
//    public ComplexNum calculate(ComplexNum a, ComplexNum b) {
//        return result;
//    }

//    @Override
//    public ComplexNum result() {
//        System.out.printf("Result: %s%n", result);
//        return result;
//    }

    @Override
    public void clear() {
        this.result = null;
    }
}


