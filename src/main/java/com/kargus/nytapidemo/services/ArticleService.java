package com.kargus.nytapidemo.services;

import com.kargus.nytapidemo.models.Article;
import com.kargus.nytapidemo.models.Media;
import com.kargus.nytapidemo.models.NytResponse;
import com.kargus.nytapidemo.models.Thumbnail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {

    @Value("${api_key}")
    private String apikey;

    @Value("${mostPopularUrl}")
    private String mostPopularUrl;

    @Autowired
    RestTemplate restTemplate;

    public List<Article> getMostPopular() {
        NytResponse response = restTemplate.getForObject(mostPopularUrl + "api-key=" + apikey, NytResponse.class);
        List<Article> results = new ArrayList<>();
        if (response != null && response.getStatus().equals("OK")) {
            for(Article a : response.getResults()) {
                for(Media m : a.getMedia()) {
                    for(Thumbnail t : m.getMediaMetadata()) {           //my logic for the imageUrl challenge, why .equals() always null??
                        if(t.getUrl() == null) {
                            response.getResults().remove(a);
                        } else {
                            a.setImageUrl(t.getUrl());
                        }
                    }
                }
            }
            return response.getResults();
        } else {
            return results;
        }
    }

//    public List<Doc> getSearchResults(String searchText) {
//        ResponseEntity<NytSearchResponse> response = restTemplate.getForEntity(mostPopularUrl + "api-key=" + apikey, NytSearchResponse.class);
//
//
//    }


}

