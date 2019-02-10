package co.alobaid.newsfeed.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Article implements Parcelable {

    @Expose
    private Long id;

    @Expose
    private String url;

    @Expose
    private String adx_keywords;

    @Expose
    private String section;

    @Expose
    private String byline;

    @Expose
    private String title;

    @Expose
    @SerializedName("abstract")
    private String body;

    @Expose
    private String published_date;

    @Expose
    private List<Media> media;

    public Article() {}

    protected Article(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readLong();
        }
        url = in.readString();
        adx_keywords = in.readString();
        section = in.readString();
        byline = in.readString();
        title = in.readString();
        body = in.readString();
        published_date = in.readString();
    }

    public static final Creator<Article> CREATOR = new Creator<Article>() {
        @Override
        public Article createFromParcel(Parcel in) {
            return new Article(in);
        }

        @Override
        public Article[] newArray(int size) {
            return new Article[size];
        }
    };

    public Long getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAdx_keywords() {
        return adx_keywords;
    }

    public String getSection() {
        return section;
    }

    public String getByline() {
        return byline;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public String getPublished_date() {
        return published_date;
    }

    public List<Media> getMedia() {
        return media;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(id);
        }
        dest.writeString(url);
        dest.writeString(adx_keywords);
        dest.writeString(section);
        dest.writeString(byline);
        dest.writeString(title);
        dest.writeString(body);
        dest.writeString(published_date);
    }

}