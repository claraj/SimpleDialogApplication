package com.example.we4954cp.simpledialogapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShowSimpleDialogActivity extends AppCompatActivity
        implements SimpleDialog.SimpleDialogListener {

    TextView dialogResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_simple_dialog);

        dialogResult = (TextView) findViewById(R.id.dialog_result_text);

        Button showDialog = (Button) findViewById(R.id.show_dialog_button);
        showDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SimpleDialog dialog = new SimpleDialog();

                //Create a bundle
                Bundle dialogArgs = new Bundle();
                //Add any data you need. TODO use a constant for the key
                dialogArgs.putString("Message", "Custom Message - OK or Cancel?");
                //Give these arguments to your dialog
                dialog.setArguments(dialogArgs);

                //1st argument: now need fragmentManager to display Dialog
                //2nd argument: a string, used as a label for this fragment transaction
                //Can be useful to put the name of the Fragment class being created here
                //In a situation with more complex fragment transactions,
                //having a unique tag for each transaction is useful for managing and debugging
                //Although for this example, it doesn't matter
                dialog.show(getFragmentManager(), dialog.getClass().getName());

            }
        });

    }


    public void userClickedOK() {

        dialogResult.setText("You selected OK");

    }

    public void userClickedCancel() {

        dialogResult.setText("You selected Cancel");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_show_simple_dialog, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
