package co.alobaid.newsfeed;

import org.junit.Test;

import java.util.ArrayList;

import co.alobaid.newsfeed.models.Article;
import co.alobaid.newsfeed.models.Media;
import co.alobaid.newsfeed.models.MediaMetadata;
import co.alobaid.newsfeed.presenters.ArticleListPresenter;

import static org.junit.Assert.assertTrue;

public class ArticleTest {

    @Test
    public void checkArticleTitle() {
        Article article = new Article();
        article.setTitle("Title");
        assertTrue(!article.getTitle().isEmpty());
    }

    @Test
    public void checkArticleUrl() {
        Article article = new Article();
        article.setUrl("https://www.google.com/");
        assertTrue(article.getUrl().contains("https"));
    }

    @Test
    public void checkMedia() {
        MediaMetadata mediaMetadata = new MediaMetadata();
        mediaMetadata.setUrl("https://www.google.com/google.png");

        ArrayList<MediaMetadata> mediaMetadataList = new ArrayList<>();
        mediaMetadataList.add(mediaMetadata);

        Media media = new Media();
        media.setType("image");
        media.setMetadata(mediaMetadataList);

        ArrayList<Media> mediaList = new ArrayList<>();
        mediaList.add(media);

        assertTrue(new ArticleListPresenter().isValidMedia(mediaList));
    }

}