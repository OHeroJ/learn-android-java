package site.loveli.learn_android_java.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import site.loveli.learn_android_java.R;
import site.loveli.learn_android_java.commons.AppApplication;
import site.loveli.learn_android_java.models.Article;

public class HomeFragment extends Fragment {

    private ProgressBar progressBar;
    private ArticleAdapter articleAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        setupUI(root);

        if (AppApplication.getInstance().isNetworkAvailable()) {
            homeViewModel.getArticles().observe(getViewLifecycleOwner(), new Observer<List<Article>>() {
                @Override
                public void onChanged(List<Article> articles) {
                    progressBar.setVisibility(View.GONE);
                    articleAdapter.addArticles(articles);
                }
            });
        } else {
            Toast.makeText(getContext(), "no network avaliable", Toast.LENGTH_SHORT).show();
        }
        return root;
    }

    void setupUI(View root) {
        RecyclerView recyclerView = root.findViewById(R.id.rvCurrencyList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        articleAdapter = new ArticleAdapter();
        recyclerView.setAdapter(articleAdapter);
        progressBar = root.findViewById(R.id.progressBar);
    }
}