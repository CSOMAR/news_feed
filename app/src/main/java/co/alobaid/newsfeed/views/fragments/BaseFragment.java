package co.alobaid.newsfeed.views.fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import co.alobaid.newsfeed.helper.ProgressDialog;
import co.alobaid.newsfeed.presenters.BasePresenter;
import co.alobaid.newsfeed.views.interfaces.BaseFragmentInterface;

public abstract class BaseFragment<Presenter extends BasePresenter> extends Fragment implements BaseFragmentInterface {

    protected FragmentInterface fragmentInterface;

    private ProgressDialog progressDialog;
    boolean isProgressDialogRunning = false;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentInterface)
            fragmentInterface = (FragmentInterface) context;
        else
            throw new RuntimeException(context.toString() + " must implement FragmentInterface");

        if (getPresenter() != null)
            getPresenter().setFragmentInterface(this);
    }

    protected Presenter getPresenter() {
        return null;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        fragmentInterface = null;
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showLoading() {
        if (progressDialog == null)
            progressDialog = new ProgressDialog(getContext());
        if (!isProgressDialogRunning) {
            isProgressDialogRunning = true;
            progressDialog.showDialog();
        }
    }

    @Override
    public void dismissLoading() {
        if (progressDialog != null) {
            isProgressDialogRunning = false;
            progressDialog.dismissDialog();
        }
    }

    public interface FragmentInterface {
        void changeFragment(Fragment fragment);
    }

}