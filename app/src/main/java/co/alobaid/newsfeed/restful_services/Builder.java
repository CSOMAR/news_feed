package co.alobaid.newsfeed.restful_services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Builder {

    private static RestfulServices restfulServices;

    public Builder() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .excludeFieldsWithoutExposeAnnotation()
                .create();

        Retrofit retrofit2 = new Retrofit.Builder()
                .baseUrl("https://api.nytimes.com/svc/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        restfulServices = retrofit2.create(RestfulServices.class);
    }

    public RestfulServices getRestfulServices() {
        return restfulServices;
    }

}