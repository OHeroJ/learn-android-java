package site.loveli.learn_android_java.ui.home;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import site.loveli.learn_android_java.commons.AppApplication;
import site.loveli.learn_android_java.models.Article;
import site.loveli.learn_android_java.network.ApiInterface;

public class ArticleRepo {
    private static final String TAG = "ArticleRepo";

    public MutableLiveData<List<Article>> requestArticles() {
        final MutableLiveData<List<Article>> mutableLiveData = new MutableLiveData<>();
        ApiInterface apiService = AppApplication.getRetrofitClient().create(ApiInterface.class);

        apiService.getArticles(null).enqueue(new Callback<List<Article>>() {
            @Override
            public void onResponse(Call<List<Article>> call, Response<List<Article>> response) {
                Log.e(TAG, "onResponse: " + response);
                if (response.isSuccessful() && response.body() != null) {
                    Log.e(TAG, "onResponse: " + response.body().size());
                    mutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Article>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + call.toString());
            }
        });
        return mutableLiveData;
    }
}
