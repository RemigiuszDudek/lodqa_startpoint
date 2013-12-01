package com.dudek.calculator;

import com.dudek.calculator.calculation.CircleFieldCalculationStrategy;
import com.dudek.calculator.calculation.FieldCalculationStrategy;
import com.dudek.calculator.calculation.RectangleFieldCalculationStrategy;
import com.dudek.calculator.figure.Figure;

import java.util.Arrays;
import java.util.List;

public class FieldCalculator {
    List<FieldCalculationStrategy> fieldCalculationStrategies;

    public FieldCalculator() {
        this(Arrays.asList(new CircleFieldCalculationStrategy(),
                new RectangleFieldCalculationStrategy()));
    }

    public FieldCalculator(List<FieldCalculationStrategy> fieldCalculationStrategies) {
        this.fieldCalculationStrategies = fieldCalculationStrategies;
    }

    public double calculateFieldOf(Figure figure) {
        for (FieldCalculationStrategy fieldCalculationStrategy : fieldCalculationStrategies) {
            if (fieldCalculationStrategy.apply(figure)) {
                return fieldCalculationStrategy.calculateFieldFor(figure);
            }
        }
        throw new RuntimeException("No strategy available for given figure");
    }
}
