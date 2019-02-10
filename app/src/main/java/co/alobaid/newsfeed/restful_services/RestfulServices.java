package co.alobaid.newsfeed.restful_web_services;

import co.alobaid.newsfeed.models.MostPopularArticlesResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RestfulServices {

    String API_KEY = "MVAUkkTEfJXdRqakoqpMOEVIJ3Qz5dAz";

    @GET("mostpopular/v2/viewed/1.json?api-key=" + API_KEY)
    Call<MostPopularArticlesResponse> getMostPopularArticlesToday();

    @GET("mostpopular/v2/viewed/7.json?api-key=" + API_KEY)
    Call<MostPopularArticlesResponse> getMostPopularArticlesLastWeek();

}