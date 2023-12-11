package com.example.beanlifecycle2.controller;

import com.example.beanlifecycle2.domain.OperationDto;
import com.example.beanlifecycle2.domain.ProductDto;
import com.example.beanlifecycle2.event.CalculatorRegisterEvent;
import com.example.beanlifecycle2.event.ProductRegisteredEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/products")
public class ProductController implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher publisher;

    @PostMapping(path = "createProduct")
    public void createProduct(@RequestBody ProductDto productDto) {
        System.out.println("Register product: " + productDto.getProductName());
        publisher.publishEvent(
                new ProductRegisteredEvent(
                        this,
                        productDto.getProductName(),
                        productDto.getOtherData()));
    }

    @GetMapping("/add")
    public double add(@RequestBody OperationDto operationDto) {
        double result = operationDto.getOperand1() + operationDto.getOperand2();
                publisher.publishEvent(
                new CalculatorRegisterEvent(
                        this,
                        operationDto.getOperand1(),
                        operationDto.getOperand2(),
                        operationDto.getMathOperation()
                        ));
        return result;
    }

    @GetMapping("/subtract")
    public double subtract(@RequestBody OperationDto operationDto) {
        double result = operationDto.getOperand1() - operationDto.getOperand2();
                publisher.publishEvent(
                new CalculatorRegisterEvent(
                        this,
                        operationDto.getOperand1(),
                        operationDto.getOperand2(),
                        operationDto.getMathOperation()
                        ));
        return result;
    }

    @GetMapping("/multiply")
    public double multiply(@RequestBody OperationDto operationDto) {
        double result = operationDto.getOperand1() * operationDto.getOperand2();
                publisher.publishEvent(
                new CalculatorRegisterEvent(
                        this,
                        operationDto.getOperand1(),
                        operationDto.getOperand2(),
                        operationDto.getMathOperation()
                        ));
        return result;
    }

    @GetMapping("/divide")
    public double divide(@RequestBody OperationDto operationDto) {
        if (operationDto.getOperand2() == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        double result = (double) operationDto.getOperand1() / operationDto.getOperand2();
                publisher.publishEvent(
                new CalculatorRegisterEvent(
                        this,
                        operationDto.getOperand1(),
                        operationDto.getOperand2(),
                        operationDto.getMathOperation()
                        ));
        return result;
    }


    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

}
