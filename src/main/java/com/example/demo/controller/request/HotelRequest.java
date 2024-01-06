package com.example.demo.Controller.Request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class HotelRequest {
    private String name;
    private String restaurant;
}
