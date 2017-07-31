package com.metarhia.metacom.activities.files;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;

import com.metarhia.metacom.R;
import com.metarhia.metacom.interfaces.DownloadFileByCodeListener;

import butterknife.ButterKnife;


/**
 * @author MariaKokshaikina
 */
public class DownloadFileDialog extends DialogFragment {

    public final static String DownloadFileDialogTag = "DownloadFileDialogTag";

    private DownloadFileByCodeListener mListener = null;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        LayoutInflater layoutInflater = getActivity().getLayoutInflater();

        final View view = layoutInflater.inflate(R.layout.fragment_download_code_dialog, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setView(view)
                .setPositiveButton(getResources().getString(R.string.ok),
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                TextInputEditText code = ButterKnife.findById(view, R.id.file_code);
                                String fileCode = code.getText().toString();
                                mListener.downloadByCode(fileCode);
                            }
                        }
                )
                .setNegativeButton(getResources().getString(R.string.cancel),
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                dialog.dismiss();
                            }
                        }
                );

        return builder.create();
    }

    public void setDownloadFileByCodeListener(DownloadFileByCodeListener listener) {
        mListener = listener;
    }

}
