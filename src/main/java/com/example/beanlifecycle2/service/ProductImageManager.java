package com.example.beanlifecycle2.service;

import com.example.beanlifecycle2.event.ProductRegisteredEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ProductImageManager implements ApplicationListener<ProductRegisteredEvent> {

    @Override
    public void onApplicationEvent(ProductRegisteredEvent event) {
        System.out.println("Processing image of " + event.getProductName());
        System.out.println("The graphics is: " + event.getOtherData());
    }


}

