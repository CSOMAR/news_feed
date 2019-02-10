package co.alobaid.newsfeed.views.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import java.util.List;
import java.util.Objects;

import co.alobaid.newsfeed.R;
import co.alobaid.newsfeed.models.Article;
import co.alobaid.newsfeed.presenters.ArticleListPresenter;
import co.alobaid.newsfeed.views.adapters.ArticleListAdapter;
import co.alobaid.newsfeed.views.interfaces.ArticleListInterface;

public class ArticleListFragment extends BaseFragment<ArticleListPresenter> implements ArticleListInterface {

    private RecyclerView recyclerView;

    private ArticleListPresenter presenter;

    private ArticleFilterType filterType;

    private Dialog dialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        filterType = ArticleFilterType.TODAY;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (filterType == ArticleFilterType.TODAY)
            Objects.requireNonNull(getActivity()).setTitle(getString(R.string.most_popular_articles_today));
        else if (filterType == ArticleFilterType.LAST_WEEK)
            Objects.requireNonNull(getActivity()).setTitle(getString(R.string.most_popular_articles_last_week));

        View view = inflater.inflate(R.layout.fragment_articles_list, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        FloatingActionButton filterButton = view.findViewById(R.id.filterButton);

        filterButton.setOnClickListener(v -> showFilterDialog());

        return view;
    }

    private void showFilterDialog() {
        dialog = new AlertDialog.Builder(getContext())
                .setView(getFilterDialogView())
                .create();
        dialog.show();
    }

    private View getFilterDialogView() {
        View view = LinearLayout.inflate(getContext(), R.layout.dialog_article_filter, null);

        RadioButton todayRadioButton = view.findViewById(R.id.todayRadioButton);
        RadioButton lastWeekRadioButton = view.findViewById(R.id.lastWeekRadioButton);

        if (filterType == ArticleFilterType.TODAY)
            todayRadioButton.setChecked(true);
        else if (filterType == ArticleFilterType.LAST_WEEK)
            lastWeekRadioButton.setChecked(true);

        todayRadioButton.setOnClickListener(v -> {
            filterType = ArticleFilterType.TODAY;
            Objects.requireNonNull(getActivity()).setTitle(getString(R.string.most_popular_articles_today));
            dialog.dismiss();
            presenter.getMostPopularArticlesToday();
        });

        lastWeekRadioButton.setOnClickListener(v -> {
            filterType = ArticleFilterType.LAST_WEEK;
            Objects.requireNonNull(getActivity()).setTitle(getString(R.string.most_popular_articles_last_week));
            dialog.dismiss();
            presenter.getMostPopularArticlesLastWeek();
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (filterType == ArticleFilterType.TODAY)
            presenter.getMostPopularArticlesToday();
        else if (filterType == ArticleFilterType.LAST_WEEK)
            presenter.getMostPopularArticlesLastWeek();
    }

    @Override
    public void onArticlesListFetched(List<Article> articles) {
        recyclerView.setAdapter(new ArticleListAdapter(articles, fragmentInterface, presenter));
    }

    @Override
    protected ArticleListPresenter getPresenter() {
        if (presenter == null)
            presenter = new ArticleListPresenter();
        return presenter;
    }

    private enum ArticleFilterType {TODAY, LAST_WEEK}

}