package com.example.beanlifecycle2.event;

import com.example.beanlifecycle2.enumerator.MathOperation;
import org.springframework.context.ApplicationEvent;

public class CalculatorRegisterEvent extends ApplicationEvent {

    private Integer operand1;
    private Integer operand2;
    private MathOperation mathOperation;

    public CalculatorRegisterEvent(Object source, Integer operand1, Integer operand2, MathOperation mathOperation) {
        super(source);
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.mathOperation = mathOperation;
    }

    public Integer getOperand1() {
        return operand1;
    }

    public Integer getOperand2() {
        return operand2;
    }

    public MathOperation getMathOperation() {
        return mathOperation;
    }

}
