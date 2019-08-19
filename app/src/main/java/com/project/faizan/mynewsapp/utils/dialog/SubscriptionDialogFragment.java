package com.project.faizan.mynewsapp.utils.dialog;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.project.faizan.mynewsapp.R;

import java.util.ArrayList;

public class SubscriptionDialogFragment extends BaseDialogFragment {

    private static SubscriptionDialogListener mListener;
    private View view;
    private Dialog dialog;
    private String successMsg;
    private int btnColor = Color.BLACK;
    private TextView tvNb, tvPb, tvPackageName, tvPackageDesc;
    private LinearLayout llPackage;
    private ProgressBar pbPackages;
    private CheckBox cbPackge;
    private String TAG = this.getClass().getSimpleName();

    public static SubscriptionDialogFragment newInstance(SubscriptionDialogListener listener) {

        SubscriptionDialogFragment fragment = new SubscriptionDialogFragment();

        mListener = listener;

        return fragment;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        if (getDialog() == null) {  // Returns mDialog
            // Tells DialogFragment to not use the fragment as a dialog, and so won't try to use mDialog
            setShowsDialog(false);
        }
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        view = inflater.inflate(R.layout.layout_subscription_dialog, null);
        setCancelable(false);

        initViews();

        builder.setView(view);
        dialog = builder.create();

        if (dialog != null)
            dialog.getWindow().setBackgroundDrawable(
                    new ColorDrawable(Color.TRANSPARENT));

        return dialog;
    }//onCreateDialog

    public void initViews() {

        tvNb = (TextView) view.findViewById(R.id.tv_nb); // negative button
        tvPb = (TextView) view.findViewById(R.id.tv_pb); // positive button
        pbPackages = (ProgressBar) view.findViewById(R.id.pbPackages);
        tvPackageName = (TextView) view.findViewById(R.id.tvPackageName);
        tvPackageDesc = (TextView) view.findViewById(R.id.tvPackageDesc);
        llPackage = (LinearLayout) view.findViewById(R.id.llPackage);
        cbPackge = (CheckBox) view.findViewById(R.id.cbPackge);

        setValues();

        tvPb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (cbPackge.isChecked()) {

                        subscribeUserApi();


                    }

                } catch (IllegalStateException ex) {
                    ex.printStackTrace();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        });

        tvNb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    if (mListener != null)
                        mListener.onNegativeButtonPressed();
                } catch (IllegalStateException ex) {
                    ex.printStackTrace();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                dismiss();
            }
        });
    }

    public void setValues() {

       /* try {
            pbPackages.setVisibility(View.VISIBLE);

            ConfigurationResponseDto configurationResponseDto = ConfigSharedPref.getConfiguration();

            String lang = Constants.Languages.ENGLISH;
            int countryId = 1;

            if (configurationResponseDto != null) {
                countryId = configurationResponseDto.getCountryId();
                lang = configurationResponseDto.getDefaultLang();
            }

            new GetPackagesApi(getActivity()).getPackages(lang, countryId, new ICallBackListener() {
                @Override
                public void onSuccess(Object o) {

                    PackagesResponseDto responseDto = (PackagesResponseDto) o;

                    if (responseDto.getRespCode().equals(Constants.ApiResponseTypes.Success)) {

                        successMsg = responseDto.getRespData().get(0).getSuccessSms();

                        pbPackages.setVisibility(View.GONE);

                        tvPackageName.setText(responseDto.getRespData().get(0).getName());
                        tvPackageDesc.setText(responseDto.getRespData().get(0).getDescription());
                        cbPackge.setTag(responseDto.getRespData().get(0).getPackageId());

                        llPackage.setVisibility(View.VISIBLE);


                    } else {
                        AlertOP.showResponseAlertOK(getActivity(), getString(R.string.app_name), responseDto.getMsg());
                    }
                }

                @Override
                public void onFailure(ErrorDto t) {

                    pbPackages.setVisibility(View.GONE);
                }
            });

        } catch (Exception ex) {
            ex.printStackTrace();
        }*/
    }

    private void subscribeUserApi() {
        /*showWaitDialog();
        int packageID = (int) cbPackge.getTag();
        String uuid = DeviceIdentity.getDeviceID(getActivity());

        String userId = "", msisdn = "";
        RegisterDeviceDto userDetailsDto = ProfileSharedPref.getUserDetails();
        ConfigurationResponseDto configurationResponseDto = ConfigSharedPref.getConfiguration();

        String lang = Constants.Languages.ENGLISH;
        int countryId = 1;

        if (configurationResponseDto != null) {
            countryId = configurationResponseDto.getCountryId();
            lang = configurationResponseDto.getDefaultLang();
        }

        if (userDetailsDto != null) {
            userId = userDetailsDto.getUserId();
            msisdn = userDetailsDto.getMsisdn().toString();
        }
//        String msisdn = ProfileSharedPref.readIdentity().getUserMSISDN();

        new SubscribeUserApi(getActivity()).subscribeUser(packageID, msisdn, userId, uuid, lang,
                new ICallBackListener() {
                    @Override
                    public void onSuccess(Object o) {
                        dismissWaitDialog();
                        SubscribeUserDto responseDto = (SubscribeUserDto) o;

                        if (responseDto.getRespCode().equals(Constants.ApiResponseTypes.Success) ||
                                responseDto.getRespCode().equals(Constants.ApiResponseTypes.ALREADY_SUBSCRIBED)) {

                            ProfileSharedPref.setIsLoggedIn(true);
                            ProfileSharedPref.setIsHeaderEnrichment(false);
                            ProfileSharedPref.saveUserDetails(responseDto.getRespData());

                            AppOP.getUserSubscriptionStatus(getContext());

                            if (mListener != null)
                                mListener.onPositiveButtonPressed(responseDto.getMsg(), true);


                        } else {
                            if (mListener != null)
                                mListener.onPositiveButtonPressed(responseDto.getMsg(), false);

                        }

                        dismiss();
                    }

                    @Override
                    public void onFailure(ErrorDto t) {
                        dismissWaitDialog();
                    }
                });*/
    }


    @Override
    public void getExtras(ArrayList<Object> extras) {

    }
}//main