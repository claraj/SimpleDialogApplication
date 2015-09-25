package com.example.we4954cp.simpledialogapplication;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

public class SimpleDialog extends DialogFragment {

    //Declare the interface. Inner interface of SimpleDialog to logically keep the two together.
    //Refer to this as SimpleDialog.SimpleDialogListener
    //Any class that wants to know what button was clicked, must implement this interface
    interface SimpleDialogListener {
        void userClickedOK();
        void userClickedCancel();
    }

    SimpleDialogListener mListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        //Set the activity to be the listener
        try {
            mListener = (SimpleDialogListener) activity;
        } catch (ClassCastException cce) {
            throw new ClassCastException("Dialog host must implement SimpleDialogListener");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        String dialogMessage;
        String defaultMessage = "OK-Cancel Dialog";
        Bundle args = getArguments();
        if (args != null) {
            dialogMessage = args.getString("Message", defaultMessage);  //TODO replace key with constant
        } else {
            dialogMessage = defaultMessage;
        }

        //Use getActivity() to get a reference to the Activity which created this Dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        AlertDialog dialog = builder.setTitle("OK-Cancel Dialog")
                .setMessage(dialogMessage)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //This will call the method in our listener
                        //In this case, an instance of ShowSimpleDialogActivity
                        //But could be any component which implements the required
                        //interface and required methods
                        mListener.userClickedOK();
                    }
                })

                .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Again, call method in listener
                        mListener.userClickedCancel();
                    }
                })
                .create();

        return dialog;
    }

}
