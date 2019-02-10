package co.alobaid.newsfeed;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.runner.AndroidJUnit4;

import com.android21buttons.fragmenttestrule.FragmentTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import co.alobaid.newsfeed.views.activities.MainActivityTest;
import co.alobaid.newsfeed.views.fragments.ArticleDetailsFragment;

import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class ArticleDetailsTest {

    @Rule
    public FragmentTestRule<MainActivityTest, ArticleDetailsFragment> fragmentTestRule = new FragmentTestRule<>(MainActivityTest.class, ArticleDetailsFragment.class);

    @Test
    public void checkShareButton() {
        Espresso.onView(withId(R.id.shareButton)).perform(ViewActions.click());
    }

}