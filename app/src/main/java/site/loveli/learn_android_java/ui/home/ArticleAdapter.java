package site.loveli.learn_android_java.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import site.loveli.learn_android_java.R;
import site.loveli.learn_android_java.models.Article;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {
    private List<Article> articles;

    public ArticleAdapter() {
        articles = new ArrayList<>();
    }

    public void addArticles(List<Article> articles) {
        this.articles = articles;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return articles != null ? articles.size() : 0;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_article, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Article article = articles.get(position);
        holder.tvTitle.setText(article.getTitle());
    }

    public static class ViewHolder extends  RecyclerView.ViewHolder {
        private TextView tvTitle;
        public ViewHolder(View convertView) {
            super(convertView);
            tvTitle = convertView.findViewById(R.id.tv_title);
        }
    }
}
