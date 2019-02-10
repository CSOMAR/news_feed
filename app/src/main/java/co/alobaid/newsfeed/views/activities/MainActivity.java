package co.alobaid.newsfeed.views.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Objects;

import co.alobaid.newsfeed.R;
import co.alobaid.newsfeed.views.fragments.ArticleListFragment;
import co.alobaid.newsfeed.views.fragments.BaseFragment;

public class MainActivity extends AppCompatActivity implements BaseFragment.FragmentInterface, FragmentManager.OnBackStackChangedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null)
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, new ArticleListFragment()).commit();

        getSupportFragmentManager().addOnBackStackChangedListener(this);
        shouldDisplayHomeUp();
    }

    @Override
    public void changeFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onBackStackChanged() {
        shouldDisplayHomeUp();
    }

    @Override
    public boolean onSupportNavigateUp() {
        getSupportFragmentManager().popBackStack();
        return true;
    }

    private void shouldDisplayHomeUp() {
        boolean canBack = getSupportFragmentManager().getBackStackEntryCount() > 0;
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(canBack);
    }

}