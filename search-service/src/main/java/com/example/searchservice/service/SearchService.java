package com.example.searchservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.elasticsearch.index.query.QueryBuilders;
import java.util.List;

@Service
public class SearchService {

    private final ElasticsearchRestTemplate elasticsearchTemplate;

    @Autowired
    public SearchService(ElasticsearchRestTemplate elasticsearchTemplate) {
        this.elasticsearchTemplate = elasticsearchTemplate;
    }

    public List<String> searchProducts(String query) {
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.matchQuery("name", query))
                .build();
        return elasticsearchTemplate.queryForList(searchQuery, String.class);
    }
}