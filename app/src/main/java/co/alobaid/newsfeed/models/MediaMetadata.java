package co.alobaid.newsfeed.models;

import com.google.gson.annotations.Expose;

public class MediaMetadata {

    @Expose
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}