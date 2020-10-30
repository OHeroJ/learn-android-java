package site.loveli.learn_android_java.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import site.loveli.learn_android_java.models.Article;
import site.loveli.learn_android_java.models.NetResponse;
import site.loveli.learn_android_java.models.PageData;

public interface ApiInterface {
    @GET("/api/subject/{subject}/topics")
    Call<NetResponse<PageData<Article>>> getArticles(@Path("subject") String subject, @Query("per") int per, @Query("page") int page);
}
