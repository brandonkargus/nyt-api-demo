package com.kargus.nytapidemo.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Doc {

    private List<Multimedia> multimedia;
    private Headline headLine;
    private Byline byline;

    private String imageUrl;



}
