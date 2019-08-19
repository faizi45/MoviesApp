package com.project.faizan.mynewsapp.utils.dialog;

public interface SubscriptionDialogListener {

    void onPositiveButtonPressed(String successMsg, boolean isSubscribed);

    void onNegativeButtonPressed();

}
