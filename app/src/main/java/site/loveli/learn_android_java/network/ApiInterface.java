package site.loveli.learn_android_java.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import site.loveli.learn_android_java.models.Article;

public interface ApiInterface {
    @GET("api/subject/{subject}/topics")
    Call<List<Article>> getArticles(@Path("subject") String subject);
}
