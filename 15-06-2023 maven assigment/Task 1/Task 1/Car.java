package com.dal.setter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Car {
    @Value("Hyundai")
    private String name;
    @Value("XYZ")
    private String model;
    @Value("420KD")
    private String carNumber;

    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

    public String getModel() {
        return model;
    }

//    public void setModel(String model) {
//        this.model = model;
//    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    @Override
    public String toString() {
        return "Car [name=" + name + ", model=" + model + ", carNumber=" + carNumber + "]";
    }
}
