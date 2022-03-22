package com.kargus.nytapidemo.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Byline {

    @JsonProperty("original")
    private String author;
}
