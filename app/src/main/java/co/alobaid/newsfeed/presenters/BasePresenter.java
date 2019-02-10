package co.alobaid.newsfeed.presenters;

import co.alobaid.newsfeed.views.interfaces.BaseFragmentInterface;

public abstract class BasePresenter<FragmentInterface extends BaseFragmentInterface> {

    private FragmentInterface fragmentInterface;

    FragmentInterface getFragmentInterface() {
        return fragmentInterface;
    }

    public void setFragmentInterface(FragmentInterface fragmentInterface) {
        this.fragmentInterface = fragmentInterface;
    }

}