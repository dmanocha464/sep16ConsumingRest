package com.example.sep16ConsumingRest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Products(Integer id, String title, Double price, String description, String category,
                       String image, Rating rating){ }
