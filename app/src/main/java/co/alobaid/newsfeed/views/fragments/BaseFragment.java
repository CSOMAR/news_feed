package co.alobaid.newsfeed.views.fragments;

import android.support.v4.app.Fragment;

import co.alobaid.newsfeed.helper.ProgressDialog;
import co.alobaid.newsfeed.presenters.BasePresenter;
import co.alobaid.newsfeed.views.interfaces.BaseFragmentInterface;

public abstract class BaseFragment<Presenter extends BasePresenter> extends Fragment implements BaseFragmentInterface {

    protected FragmentInterface fragmentInterface;

    private ProgressDialog progressDialog;
    boolean isProgressDialogRunning = false;

    public interface FragmentInterface {
        void changeFragment(Fragment fragment);
    }

}