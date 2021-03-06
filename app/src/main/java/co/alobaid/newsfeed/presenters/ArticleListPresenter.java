package co.alobaid.newsfeed.presenters;

import java.util.List;

import co.alobaid.newsfeed.models.Media;
import co.alobaid.newsfeed.models.MostPopularArticlesResponse;
import co.alobaid.newsfeed.restful_services.Builder;
import co.alobaid.newsfeed.views.interfaces.ArticleListInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleListPresenter extends BasePresenter<ArticleListInterface> implements Callback<MostPopularArticlesResponse> {

    private Builder builder;

    public ArticleListPresenter() {
        builder = new Builder();
    }

    public boolean isValidMedia(List<Media> media) {
        if (media == null)
            return false;
        else if (media.isEmpty())
            return false;
        else if (!media.get(0).getType().equals("image"))
            return false;
        else if (media.get(0).getMetadata() == null)
            return false;
        else if (media.get(0).getMetadata().isEmpty())
            return false;
        else if (media.get(0).getMetadata().get(0) == null)
            return false;
        else if (media.get(0).getMetadata().get(0).getUrl() == null)
            return false;
        else if (media.get(0).getMetadata().get(0).getUrl().isEmpty())
            return false;
        return true;
    }

    public boolean isValidString(String s) {
        return s != null && !s.isEmpty();
    }

    public void getMostPopularArticlesToday() {
        getFragmentInterface().showLoading();
        builder.getRestfulServices().getMostPopularArticlesToday().enqueue(this);
    }

    public void getMostPopularArticlesLastWeek() {
        getFragmentInterface().showLoading();
        builder.getRestfulServices().getMostPopularArticlesLastWeek().enqueue(this);
    }

    @Override
    public void onResponse(Call<MostPopularArticlesResponse> call, Response<MostPopularArticlesResponse> response) {
        getFragmentInterface().dismissLoading();
        if (response.body() != null)
            getFragmentInterface().onArticlesListFetched(response.body().getResults());
    }

    @Override
    public void onFailure(Call<MostPopularArticlesResponse> call, Throwable t) {
        getFragmentInterface().dismissLoading();
        getFragmentInterface().showMessage(t.getMessage());
    }

}