package co.alobaid.newsfeed.views.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import co.alobaid.newsfeed.R;
import co.alobaid.newsfeed.models.Article;
import co.alobaid.newsfeed.presenters.ArticleListPresenter;
import co.alobaid.newsfeed.views.interfaces.ArticleListInterface;

import static co.alobaid.newsfeed.helper.Constants.ARTICLE;

public class ArticleDetailsFragment extends BaseFragment<ArticleListPresenter> implements ArticleListInterface {

    private ArticleListPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_article_details, container, false);

        ImageView imageView = view.findViewById(R.id.imageView);
        TextView titleTextView = view.findViewById(R.id.titleTextView);
        TextView dateTextView = view.findViewById(R.id.dateTextView);
        TextView bylineTextView = view.findViewById(R.id.bylineTextView);
        TextView bodyTextView = view.findViewById(R.id.bodyTextView);
        FloatingActionButton shareButton = view.findViewById(R.id.shareButton);

        if (getArguments() != null && getArguments().getParcelable(ARTICLE) != null) {
            Article article = getArguments().getParcelable(ARTICLE);

            if (presenter.isValidMedia(article.getMedia()))
                Picasso.get().load(article.getMedia().get(0).getMetadata().get(0).getUrl()).into(imageView);
            else
                imageView.setVisibility(View.GONE);

            setTextView(titleTextView, article.getTitle());
            setTextView(dateTextView, article.getPublished_date());
            setTextView(bylineTextView, article.getByline());
            setTextView(bodyTextView, article.getBody());

            shareButton.setOnClickListener(v -> shareUrl(article));
        }

        return view;
    }

    private void setTextView(TextView textView, String s) {
        if (presenter.isValidString(s))
            textView.setText(s);
    }

    private void shareUrl(Article article) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, article.getUrl());
        startActivity(Intent.createChooser(intent, article.getTitle()));
    }

    @Override
    protected ArticleListPresenter getPresenter() {
        if (presenter == null)
            presenter = new ArticleListPresenter();
        return presenter;
    }

    @Override
    public void onArticlesListFetched(List<Article> articles) {}

}