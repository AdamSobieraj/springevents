package com.example.beanlifecycle2.domain;

import com.example.beanlifecycle2.enumerator.MathOperation;

public class OperationDto {

    private Integer operand1;
    private Integer operand2;
    private MathOperation mathOperation;

    public OperationDto(Integer operand1, Integer operand2, MathOperation mathOperation) {
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
