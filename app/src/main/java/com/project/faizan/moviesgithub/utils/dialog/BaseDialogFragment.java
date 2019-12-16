package com.project.faizan.moviesgithub.utils.dialog;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;

/**
 * Created by Hamza Mehmood on 3/27/2018.
 */

public abstract class BaseDialogFragment extends DialogFragment {

    private WaitDialog waitDialog;
    private boolean isActive;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getArguments();
        if (extras != null) {
            getExtras((ArrayList<Object>) extras.getSerializable("extras"));
        }
        if (waitDialog == null) waitDialog = new WaitDialog(getContext());
    }

    @Override
    public void onResume() {
        super.onResume();
        if (waitDialog == null) waitDialog = new WaitDialog(getContext());
        isActive = true;
    }

    @Override
    public void onPause() {
        isActive = false;
        super.onPause();
    }

    public abstract void getExtras(ArrayList<Object> extras);

    public BaseDialogFragment addExtras(ArrayList<Object> extras) {
        if (extras != null) {
            Bundle args = new Bundle();
            args.putSerializable("extras", extras);
            this.setArguments(args);
        }
        return this;
    }

    public void showWaitDialog() {
        waitDialog.showWaitDialog();
    }

    public void dismissWaitDialog() {
        try {
            if (waitDialog.isStillActive()) {
                waitDialog.dismissWaitDialog();
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }


    public boolean isThisFragmentActive() {
        return isActive;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();

        try {

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
