package co.alobaid.newsfeed.views.interfaces;

import java.util.List;

import co.alobaid.newsfeed.models.Article;

public interface ArticlesListInterface extends BaseFragmentInterface {
    void onArticlesListFetched(List<Article> articles);
}
