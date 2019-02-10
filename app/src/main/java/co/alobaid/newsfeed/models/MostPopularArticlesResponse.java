package co.alobaid.newsfeed.models;

import com.google.gson.annotations.Expose;

import java.util.List;

public class MostPopularArticlesResponse {

    @Expose
    private String status;

    @Expose
    private Long num_results;

    @Expose
    private List<Article> results;

    public String getStatus() {
        return status;
    }

    public Long getNum_results() {
        return num_results;
    }

    public List<Article> getResults() {
        return results;
    }

}