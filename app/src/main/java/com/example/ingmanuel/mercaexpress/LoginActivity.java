package com.example.ingmanuel.mercaexpress;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etNomUser, etPass;
    TextView tvCreateAccount, tvForgetPass;
    Button btnIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etNomUser = findViewById(R.id.editUserLogin);
        etPass = findViewById(R.id.editPassLogin);
        tvCreateAccount = findViewById(R.id.createAccount);
        tvForgetPass = findViewById(R.id.forgetPassword);
        btnIngresar = findViewById(R.id.btnIngresar);

        tvCreateAccount.setOnClickListener(this);
        tvForgetPass.setOnClickListener(this);
        btnIngresar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.createAccount:
                Toast.makeText(this, " "+ tvCreateAccount.getText().toString(), Toast.LENGTH_SHORT ).show();
                break;
            case R.id.forgetPassword:
                Toast.makeText(this, " "+ tvForgetPass.getText().toString(), Toast.LENGTH_SHORT ).show();
                break;
            case R.id.btnIngresar:
                break;
        }
    }
}
