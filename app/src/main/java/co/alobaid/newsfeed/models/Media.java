package co.alobaid.newsfeed.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Media {

    @Expose
    private String type;

    @Expose
    private String copyright;

    @Expose
    @SerializedName("media-metadata")
    private List<MediaMetadata> metadata;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCopyright() {
        return copyright;
    }

    public List<MediaMetadata> getMetadata() {
        return metadata;
    }

    public void setMetadata(List<MediaMetadata> metadata) {
        this.metadata = metadata;
    }

}