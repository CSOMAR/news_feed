package co.alobaid.newsfeed.helper;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;

import co.alobaid.newsfeed.R;

public class ProgressDialog {

    private Dialog dialog;

    @SuppressLint("InflateParams")
    public ProgressDialog(Context context) {
        dialog = new Dialog(context, R.style.ProgressDialog);
        dialog.setCancelable(false);
        dialog.setContentView(LayoutInflater.from(context).inflate(R.layout.progress_dialog, null));
    }

    public void showDialog() {
        if (dialog != null)
            dialog.show();
    }

    public void dismissDialog() {
        if (dialog != null)
            dialog.dismiss();
    }

}