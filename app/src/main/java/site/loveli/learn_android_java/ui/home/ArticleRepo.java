package site.loveli.learn_android_java.ui.home;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

import kotlin.reflect.KCallable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import site.loveli.learn_android_java.commons.AppApplication;
import site.loveli.learn_android_java.models.Article;
import site.loveli.learn_android_java.models.NetResponse;
import site.loveli.learn_android_java.models.PageData;
import site.loveli.learn_android_java.network.ApiInterface;

public class ArticleRepo {
    private static final String TAG = "ArticleRepo";

    public MutableLiveData<List<Article>> requestArticles(String subjectId) {
        final MutableLiveData<List<Article>> mutableLiveData = new MutableLiveData<>();
        ApiInterface apiService = AppApplication.getRetrofitClient().create(ApiInterface.class);

        apiService.getArticles(subjectId, 10, 1).enqueue(new Callback<NetResponse<PageData<Article>>>() {
            @Override
            public void onResponse(Call<NetResponse<PageData<Article>>> call, Response<NetResponse<PageData<Article>>> response) {
                NetResponse<PageData<Article>> body = response.body();
                if (response.isSuccessful()) {
                    mutableLiveData.setValue(body.getData().getItems());
                }
            }

            @Override
            public void onFailure(Call<NetResponse<PageData<Article>>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + call.toString());
            }
        });

        return mutableLiveData;
    }
}
