package com.shashank.ConnectThree;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

public class PlayerTwoWinDialogSingle extends AppCompatDialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.player2win, null);
        builder.setView(view);
        final AlertDialog twoWin =  builder.create();
        twoWin.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        Button noBtn = (Button) view.findViewById(R.id.no);
        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        Button yesBtn = (Button) view.findViewById(R.id.yes);
        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((singlePlayer)getActivity()).resetBoard();
                dismiss();
            }
        });
        return twoWin;
    }
}
