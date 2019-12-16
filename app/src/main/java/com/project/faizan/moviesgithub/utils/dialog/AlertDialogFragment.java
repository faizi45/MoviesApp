package com.project.faizan.moviesgithub.utils.dialog;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.project.faizan.moviesgithub.R;

/**
 * Created by Hamza Mehmood on 4/2/2018.
 */

public class AlertDialogFragment extends DialogFragment {

    private static String ARG_PARAM1 = "header";
    private static String ARG_PARAM2 = "content";
    private static String ARG_PARAM3 = "pbMsg";
    private static String ARG_PARAM4 = "nbMsg";
    private static String ARG_PARAM5 = "btnColor";
    private static String ARG_PARAM6 = "mainContent";
    private static GeneralDialogListener mListener;
    private View view;
    private Dialog dialog;
    private String header, content, pbMsg, nbMsg, mainContent;
    private int btnColor = Color.BLACK;
    private TextView tvHeader, tv_maincontent, tvContent, tvNb, tvPb;
    private String TAG = this.getClass().getSimpleName();

    public static AlertDialogFragment newInstance(String header, String content,
                                                  String pbMsg, String nbMsg,
                                                  int btnColor, String mainContent, GeneralDialogListener listener) {
        AlertDialogFragment fragment = new AlertDialogFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, header);
        args.putString(ARG_PARAM2, content);
        args.putString(ARG_PARAM3, pbMsg);
        args.putString(ARG_PARAM4, nbMsg);
        args.putInt(ARG_PARAM5, btnColor);
        args.putString(ARG_PARAM6, mainContent);
        mListener = listener;
//        args.putParcelable(ARG_PARAM6, listener);
        fragment.setArguments(args);
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

        if (getArguments() != null) {
            header = getArguments().getString(ARG_PARAM1);
            content = getArguments().getString(ARG_PARAM2);
            pbMsg = getArguments().getString(ARG_PARAM3);
            nbMsg = getArguments().getString(ARG_PARAM4);
            btnColor = getArguments().getInt(ARG_PARAM5);
            mainContent = getArguments().getString(ARG_PARAM6);
//            mListener = (ConfirmOrCancelDialogListener) getArguments().getParcelable(ARG_PARAM6);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        view = inflater.inflate(R.layout.general_dialog_layout, null);
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
        tvHeader = (TextView) view.findViewById(R.id.tv_header);
        tvContent = (TextView) view.findViewById(R.id.tv_content);
        tv_maincontent = (TextView) view.findViewById(R.id.tv_maincontent);
        tvNb = (TextView) view.findViewById(R.id.tv_nb); // negative button
        tvPb = (TextView) view.findViewById(R.id.tv_pb); // positive button

        setValues();

        tvPb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (mListener != null)
                        mListener.onPositiveButtonPressed();
                } catch (IllegalStateException ex) {
                    ex.printStackTrace();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                dismiss();
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
        try {
            if (header != null && !header.isEmpty())
                tvHeader.setText(header);
            else
                tvHeader.setVisibility(View.GONE);

            if (mainContent != null)
                tv_maincontent.setText(mainContent);
            else
                tv_maincontent.setVisibility(View.GONE);

            if (content != null)
                tvContent.setText(content);
            else
                tvContent.setVisibility(View.GONE);

            if (pbMsg != null) {
                tvPb.setText(pbMsg);
                tvPb.setTextColor(btnColor);
            } else
                tvPb.setVisibility(View.GONE);

            if (nbMsg != null) {
                tvNb.setText(nbMsg);
                tvNb.setTextColor(btnColor);

            } else
                tvNb.setVisibility(View.GONE);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}//main