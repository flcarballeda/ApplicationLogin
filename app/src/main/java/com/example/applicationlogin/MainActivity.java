package com.example.applicationlogin;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private             UserPreferences up;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        up = new UserPreferences( this);
        if( null != up.getUserName()) {
            Intent intent = new Intent( this, MenuActivity.class);
            startActivity( intent);
        }
    }
    private void hazLogin(View v) {
        EditText username = findViewById( R.id.idUsername);
        EditText password = findViewById( R.id.idPassword);
        if( username.getText().toString().isEmpty() ||
             password.getText().toString().isEmpty()) {
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setTitle(R.string.alert_login_title);
            alertDialog.setMessage( getResources().getString( R.string.alert_login_message));
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, getResources().getString( android.R.string.ok),
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        } else {
            up.register( username.getText().toString(), password.getText().toString());
        }
    }
}
