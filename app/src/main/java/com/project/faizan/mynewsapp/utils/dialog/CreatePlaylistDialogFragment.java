package com.project.faizan.mynewsapp.utils.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import com.project.faizan.mynewsapp.R;
import com.project.faizan.mynewsapp.utils.AlertOP;

/**
 * Created by Waqar on 5/4/2018.
 */

public class CreatePlaylistDialogFragment extends DialogFragment {

    private static Context mContext;
    private View view;
    private onDismissListener listener;


    public static CreatePlaylistDialogFragment newInstance(Context context) {

        CreatePlaylistDialogFragment fragment = new CreatePlaylistDialogFragment();
        mContext = context;
        return fragment;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        if (getDialog() == null) {
            setShowsDialog(false);
        }
        super.onActivityCreated(savedInstanceState);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        view = inflater.inflate(R.layout.layout_create_playlist_dialog, null);
        setCancelable(true);
        initViews();
        builder.setView(view);
        Dialog dialog = builder.create();

        if (dialog != null)
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        return dialog;
    }

    public void initViews() {

        final EditText etName = view.findViewById(R.id.etName);

        InputFilter filter = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end,
                                       Spanned dest, int dstart, int dend) {
                for (int i = start; i < end; i++) {
                    if (!Character.isLetterOrDigit(source.charAt(i)) &&
                            !Character.isSpaceChar(source.charAt(i))) {
                        return "";
                    }
                }
                return null;
            }
        };
        etName.setFilters(new InputFilter[]{new InputFilter.LengthFilter(30), filter});

        View iv_cross = view.findViewById(R.id.iv_cross);
        iv_cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        View tvCreatePlayList = view.findViewById(R.id.tvCreatePlayList);
        tvCreatePlayList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString();
                if (name.trim().equals("")) {
                    AlertOP.showResponseAlertOK(mContext, mContext.getString(R.string.app_name), getString(R.string.enter_playlist_name));
                } else {
                    createPlaylist(name);
                }
            }
        });

    }

    private void createPlaylist(final String name) {
//        String userId = ProfileSharedPref.readIdentity().getUserMSISDN();
        /*String userId = "", lang = Constants.Languages.ENGLISH;

        ConfigurationResponseDto configurationResponseDto = ConfigSharedPref.getConfiguration();
        RegisterDeviceDto userDetailsDto = ProfileSharedPref.getUserDetails();

        if (userDetailsDto != null)
            userId = userDetailsDto.getUserId();


        if (configurationResponseDto != null)
            lang = configurationResponseDto.getDefaultLang();

        new CreatePlaylistApi(mContext).createPlayList(userId, name, lang, new ICallBackListener() {
            @Override
            public void onSuccess(Object o) {

                CreatePlaylistResponse response = (CreatePlaylistResponse) o;

                if (response.getRespCode().equals(Constants.ApiResponseTypes.Success)) {

                    dismiss();
                } else {
                    AlertOP.showResponseAlertOK(mContext, mContext.getResources().getString(R.string.app_name), response.getMsg());
                }
            }

            @Override
            public void onFailure(ErrorDto t) {


                if (t.serverCode == 500 ||
                        t.serverCode == 502) {

                    AlertOP.showInternetAlert(mContext, new ConfirmOrCancelDialogListener() {
                        @Override
                        public void onPositiveButtonPressed() {
                            createPlaylist(name);
                        }
                    });
                }
            }
        });*/
    }

    public void setOnDismissListener(onDismissListener listener) {
        this.listener = listener;
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);

        if (listener != null) {
            listener.onDismiss(dialog);
        }
    }

    public interface onDismissListener {
        void onDismiss(DialogInterface dialog);
    }
}