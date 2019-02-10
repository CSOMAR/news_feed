package co.alobaid.newsfeed.views.adapters;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import co.alobaid.newsfeed.R;
import co.alobaid.newsfeed.models.Article;
import co.alobaid.newsfeed.presenters.ArticleListPresenter;
import co.alobaid.newsfeed.views.fragments.ArticleDetailsFragment;
import co.alobaid.newsfeed.views.fragments.BaseFragment;

import static co.alobaid.newsfeed.helper.Constants.ARTICLE;

public class ArticlesListAdapter extends RecyclerView.Adapter<ArticlesListAdapter.ViewHolder> {

    private List<Article> articles;
    private BaseFragment.FragmentInterface fragmentInterface;
    private ArticleListPresenter presenter;

    public ArticlesListAdapter(List<Article> articles, BaseFragment.FragmentInterface fragmentInterface, ArticleListPresenter presenter) {
        this.articles = articles;
        this.fragmentInterface = fragmentInterface;
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_article, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Article article = articles.get(i);

        viewHolder.linearLayout.setOnClickListener(view -> {
            Bundle bundle = new Bundle();
            bundle.putParcelable(ARTICLE, article);

            ArticleDetailsFragment fragment = new ArticleDetailsFragment();
            fragment.setArguments(bundle);

            fragmentInterface.changeFragment(fragment);
        });

        if (presenter.isValidMedia(article.getMedia()))
            Picasso.get().load(article.getMedia().get(0).getMetadata().get(0).getUrl()).into(viewHolder.imageView);
        else
            viewHolder.imageView.setVisibility(View.GONE);

        setTextView(viewHolder.titleTextView, article.getTitle());
        setTextView(viewHolder.dateTextView, article.getPublished_date());
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    private void setTextView(TextView textView, String s) {
        if (presenter.isValidString(s))
            textView.setText(s);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout linearLayout;
        private ImageView imageView;
        private TextView titleTextView;
        private TextView dateTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.linearLayout);
            imageView = itemView.findViewById(R.id.imageView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            dateTextView = itemView.findViewById(R.id.dateTextView);
        }

    }

}