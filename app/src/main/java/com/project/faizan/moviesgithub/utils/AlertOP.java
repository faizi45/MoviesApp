package com.project.faizan.moviesgithub.utils;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.project.faizan.moviesgithub.R;
import com.project.faizan.moviesgithub.utils.dialog.AlertDialogFragment;
import com.project.faizan.moviesgithub.utils.dialog.ConfirmOrCancelDialogListener;
import com.project.faizan.moviesgithub.utils.dialog.CreatePlaylistDialogFragment;
import com.project.faizan.moviesgithub.utils.dialog.GeneralDialogListener;
import com.project.faizan.moviesgithub.utils.dialog.SubscriptionDialogFragment;
import com.project.faizan.moviesgithub.utils.dialog.SubscriptionDialogListener;


/**
 * Created by Hamza Mehmood on 4/2/2018.
 */

public class AlertOP {


    public static void showResponseAlertOK(Context context, String title, String content) {
        try {
            if ((title != null && !title.isEmpty()) || (content != null && !content.isEmpty())) {
                AppCompatActivity activity = ((AppCompatActivity) context);
                int btnColor = ContextCompat.getColor(activity, R.color.textcolorLogin);

                AlertDialogFragment alertDialogFragment = AlertDialogFragment.newInstance(title,
                        content, context.getString(R.string.ok), null, btnColor, null, new GeneralDialogListener() {
                            @Override
                            public void onPositiveButtonPressed() {
                                // On Skip btn click
                            }

                            @Override
                            public void onNegativeButtonPressed() {
                                //on Cancel btn key
                            }
                        });
                alertDialogFragment.show(activity.getSupportFragmentManager(), "");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void showUnhandledExceptionMessage(Context context) {
        try {
            AppCompatActivity activity = ((AppCompatActivity) context);
            int btnColor = ContextCompat.getColor(activity, R.color.textcolorLogin);

            AlertDialogFragment alertDialogFragment = AlertDialogFragment.newInstance(context.getString(R.string.app_name),
                    context.getString(R.string.error_uncaught), context.getString(R.string.ok), null, btnColor, null, new GeneralDialogListener() {
                        @Override
                        public void onPositiveButtonPressed() {
                            // On Skip btn click
                        }

                        @Override
                        public void onNegativeButtonPressed() {
                            //on Cancel btn key
                        }
                    });
            alertDialogFragment.show(activity.getSupportFragmentManager(), "");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    // Show Ok and cancel Alert
    public static void showResponseAlertOKAndCancel(Context context, String title, String content,
                                                    String okBtnText, String cancelBtnText, final GeneralDialogListener listener) {
        try {

            if ((title != null && !title.isEmpty()) || (content != null && !content.isEmpty())) {
                AppCompatActivity activity = ((AppCompatActivity) context);
                int btnColor = ContextCompat.getColor(activity, R.color.textcolorLogin);

                AlertDialogFragment alertDialogFragment = AlertDialogFragment.newInstance(title,
                        content, okBtnText, cancelBtnText, btnColor, null, new GeneralDialogListener() {
                            @Override
                            public void onPositiveButtonPressed() {
                                // On Skip btn click
                                if (listener != null) listener.onPositiveButtonPressed();
                            }

                            @Override
                            public void onNegativeButtonPressed() {
                                //on Cancel btn key
                                if (listener != null) listener.onNegativeButtonPressed();
                            }
                        });
                alertDialogFragment.show(activity.getSupportFragmentManager(), "");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void showLoginDialog(final Context context) {
        AlertOP.showResponseAlertOKAndCancel(context, context.getString(R.string.app_name),
                context.getString(R.string.guest_user_text), context.getString(R.string.login),
                context.getString(R.string.cancel), new GeneralDialogListener() {


                    @Override
                    public void onPositiveButtonPressed() {


//                        PreferenceManager.getDefaultSharedPreferences(JazzMusicApp.getAppContext()).edit().clear().apply();

//                        ActivityUtil.launchActivityAndClearAll((Activity) context, UserRegisterActivity.class);
//                        ((Activity) context).finish();

                    }

                    @Override
                    public void onNegativeButtonPressed() {

//                        if (context instanceof DashboardActivity)
//                            ((DashboardActivity) context).hidePin();

                    }
                });
    }

    public static void showNumberConfirmAlert(Context context, String title, String mainContent, String content,
                                              String okBtnText, String cancelBtnText, final GeneralDialogListener listener) {
        try {
            if ((title != null && !title.isEmpty()) || (content != null && !content.isEmpty()) || (mainContent != null && !mainContent.isEmpty())) {
                AppCompatActivity activity = ((AppCompatActivity) context);
                int btnColor = ContextCompat.getColor(activity, R.color.textcolorLogin);

                AlertDialogFragment alertDialogFragment = AlertDialogFragment.newInstance(title,
                        content, okBtnText, cancelBtnText, btnColor, mainContent, new GeneralDialogListener() {
                            @Override
                            public void onPositiveButtonPressed() {
                                // On Skip btn click
                                if (listener != null) listener.onPositiveButtonPressed();
                            }

                            @Override
                            public void onNegativeButtonPressed() {
                                //on Cancel btn key
                                if (listener != null) listener.onNegativeButtonPressed();
                            }
                        });
                alertDialogFragment.show(activity.getSupportFragmentManager(), "");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void showInternetAlert(final Context context, final ConfirmOrCancelDialogListener listener) {

        try {

            final AppCompatActivity activity = ((AppCompatActivity) context);

            /*InternetDialogFragment internetDialogFragment = InternetDialogFragment.newInstance(context, new ConfirmOrCancelDialogListener() {
                @Override
                public void onPositiveButtonPressed() {

                    if (listener != null) listener.onPositiveButtonPressed();
                }
            });

            internetDialogFragment.show(activity.getSupportFragmentManager(), "internetDialogFragment");
*/
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }


    public static void showSubscriptionAlert(final Context context, final SubscriptionDialogListener listener) {
      /*  if (ProfileSharedPref.isSubscribed()) {
            AppOP.getUserDetails(context, ProfileSharedPref.getUserDetails().getMsisdn().toString());

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (listener != null) {
                        listener.onPositiveButtonPressed(context.getString(R.string.user_verified_success), true);


                    }
                }
            }, 1000);
            return;
        }
*/

        try {

            AppCompatActivity activity = ((AppCompatActivity) context);


            SubscriptionDialogFragment alertDialogFragment = SubscriptionDialogFragment.newInstance(new SubscriptionDialogListener() {
                @Override
                public void onPositiveButtonPressed(String successMsg, boolean isSubscribed) {
                    // On Skip btn click

                    if (listener != null) {
                        listener.onPositiveButtonPressed(successMsg, isSubscribed);
                        if (!isSubscribed) {

                            listener.onNegativeButtonPressed();
                        }
                    }
                }

                @Override
                public void onNegativeButtonPressed() {
                    //on Cancel btn key

                    if (listener != null)
                        listener.onNegativeButtonPressed();
                }
            });
            alertDialogFragment.show(activity.getSupportFragmentManager(), "");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public static void showSubscriptionAlertService(final Context context, final SubscriptionDialogListener listener) {
        /*if (ProfileSharedPref.isSubscribed()) {
            AppOP.getUserDetails(context, ProfileSharedPref.getUserDetails().getMsisdn().toString());

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (listener != null) {
                        listener.onPositiveButtonPressed(context.getString(R.string.user_verified_success), true);


                    }
                }
            }, 1000);
            return;
        }*/
        try {

            final AppCompatActivity activity = ((AppCompatActivity) context);


            final SubscriptionDialogFragment alertDialogFragment = SubscriptionDialogFragment.newInstance(new SubscriptionDialogListener() {
                @Override
                public void onPositiveButtonPressed(String successMsg, boolean isSubscribed) {
                    // On Skip btn click

                    if (listener != null) {
                        listener.onPositiveButtonPressed(successMsg, isSubscribed);
                        if (!isSubscribed) {
                            listener.onNegativeButtonPressed();
                        }
                    }
                }

                @Override
                public void onNegativeButtonPressed() {
                    //on Cancel btn key
                    if (listener != null)
                        listener.onNegativeButtonPressed();
                }
            });

            alertDialogFragment.show(activity.getSupportFragmentManager(), "");


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public static void showCreateNewPlaylistDialog(final Context context, CreatePlaylistDialogFragment.onDismissListener listener) {

        final AppCompatActivity activity = ((AppCompatActivity) context);

        CreatePlaylistDialogFragment dialogFragment = CreatePlaylistDialogFragment.newInstance(context);
        dialogFragment.setOnDismissListener(listener);
        dialogFragment.show(activity.getSupportFragmentManager(), "createPlaylistDialogFragment");
    }


}
