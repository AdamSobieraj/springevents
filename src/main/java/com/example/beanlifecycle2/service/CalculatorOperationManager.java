package com.example.beanlifecycle2.service;

import com.example.beanlifecycle2.event.CalculatorRegisterEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class CalculatorOperationManager implements ApplicationListener<CalculatorRegisterEvent> {

    private static final Logger LOG = LogManager.getLogger(CalculatorRegisterEvent.class);
    @Override
    public void onApplicationEvent(CalculatorRegisterEvent event) {
        LOG.info("operastion " + event.getMathOperation() + " on " + event.getOperand1() + " and " + event.getOperand2());
    }
}
