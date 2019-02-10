package co.alobaid.newsfeed;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.android21buttons.fragmenttestrule.FragmentTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import co.alobaid.newsfeed.models.SyncObject;
import co.alobaid.newsfeed.views.activities.MainActivityTest;
import co.alobaid.newsfeed.views.fragments.ArticleDetailsFragment;

import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class ArticleListTest {

    @Rule
    public FragmentTestRule<MainActivityTest, ArticleDetailsFragment> fragmentTestRule = new FragmentTestRule<>(MainActivityTest.class, ArticleDetailsFragment.class);

    @Test
    public void articleListFilterByTodayTest() {
        Espresso.onView(withId(R.id.shareButton)).perform(ViewActions.click()).check();
    }


//    private void startArticleListFragment() {
//        SyncObject syncObject = ((MainActivityTest) activityTestRule.getActivity()).getSyncObject();
//
//        synchronized (syncObject) {
//            try {
//                syncObject.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

//        onView(withId(R.id.filterButton)).perform(ViewActions.click());
//        activityTestRule.getActivity().runOnUiThread(() -> {
//            Article article = new Article();
//            article.setUrl("https://www.google.com/");
//
//            Bundle bundle = new Bundle();
//            bundle.putParcelable(ARTICLE, article);
//
//            ArticleDetailsFragment fragment = new ArticleDetailsFragment();
//            fragment.setArguments(bundle);

//            ((MainActivityTest) activityTestRule.getActivity()).getSupportFragmentManager()
//                    .beginTransaction().add(R.id.fragmentContainer, fragment)
//                    .commit();


//        });
//    }

}
