package co.alobaid.newsfeed.restful_services;

import co.alobaid.newsfeed.models.MostPopularArticlesResponse;
import retrofit2.Call;
import retrofit2.http.GET;

import static co.alobaid.newsfeed.helper.Constants.API_KEY;

public interface RestfulServices {

    @GET("mostpopular/v2/viewed/1.json?api-key=" + API_KEY)
    Call<MostPopularArticlesResponse> getMostPopularArticlesToday();

    @GET("mostpopular/v2/viewed/7.json?api-key=" + API_KEY)
    Call<MostPopularArticlesResponse> getMostPopularArticlesLastWeek();

}