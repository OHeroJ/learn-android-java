package site.loveli.learn_android_java.ui.home;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import site.loveli.learn_android_java.models.Article;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<List<Article>> articles;

    public HomeViewModel() {
        articles = new MutableLiveData<>();
    }

    public MutableLiveData<List<Article>> getArticles() {
        return articles;
    }

    public void fetchArticles() {}

}