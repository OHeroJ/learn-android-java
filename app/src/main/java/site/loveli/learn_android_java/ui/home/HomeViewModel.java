package site.loveli.learn_android_java.ui.home;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import site.loveli.learn_android_java.models.Article;

public class HomeViewModel extends ViewModel {

    private ArticleRepo articleRepo;
    private MutableLiveData<List<Article>> articles;

    public HomeViewModel() {
        articleRepo = new ArticleRepo();
    }

    public MutableLiveData<List<Article>> getArticles() {
        if (articles == null) {
            articles = articleRepo.requestArticles("null");
        }
        return articles;
    }

}