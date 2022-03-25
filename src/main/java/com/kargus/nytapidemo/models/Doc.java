package com.kargus.nytapidemo.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Doc {

    private List<Media> multimedia;


    private Headline headline;
    private Byline byline;

    private String imageUrl;

    @JsonProperty("web_url")
    private String webUrl;

    @JsonProperty("abstract")
    private String summary;


}
