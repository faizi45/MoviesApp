package com.project.faizan.mynewsapp.utils.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.Window;
import androidx.databinding.DataBindingUtil;
import com.project.faizan.mynewsapp.R;
import com.project.faizan.mynewsapp.databinding.WaitDialogBinding;
import com.wang.avi.AVLoadingIndicatorView;

/**
 * Created by Hamza Mehmood on 3/27/2018.
 */

public class WaitDialog {
    private Context context;
    private Dialog dialog;
    private boolean isActive;
    private AVLoadingIndicatorView avi;

    public WaitDialog(Context context) {
        this.context = context;
    }

    public void showWaitDialog() {
        isActive = true;
        final WaitDialogBinding binding;
        if (dialog != null) dialog.dismiss();
        dialog = new Dialog(context);
        dialog.setCancelable(false);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.wait_dialog, null, false);
        dialog.setContentView(binding.getRoot());

        if (dialog != null)
            dialog.getWindow().setBackgroundDrawable(
                    new ColorDrawable(Color.TRANSPARENT));

        avi = binding.progressDialog;

        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {

                if (avi.isShown())
                    avi.smoothToHide();

                isActive = false;
            }
        });

        avi.smoothToShow();
        dialog.show();
    }

    public void dismissWaitDialog() {
        if (dialog != null && dialog.isShowing()) {
            avi.smoothToHide();
            dialog.cancel();
        }
    }

    public boolean isStillActive() {
        return isActive;
    }


}
