package com.project.faizan.moviesgithub.utils.dialog;

public interface SubscriptionDialogListener {

    void onPositiveButtonPressed(String successMsg, boolean isSubscribed);

    void onNegativeButtonPressed();

}
