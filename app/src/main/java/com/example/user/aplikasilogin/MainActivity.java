package com.example.user.aplikasilogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtNama, edtPassword;
    private Button btnLogin;
    private TextView tvInfo;
    private int counter = 5;
    private TextView tvUserRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtNama = (EditText)findViewById(R.id.edt_nama);
        edtPassword = (EditText)findViewById(R.id.edt_password);
        btnLogin = (Button)findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);
        tvInfo = (TextView)findViewById(R.id.tv_info);
        tvUserRegister = (TextView)findViewById(R.id.tv_register);

        tvInfo.setText("Silahkan Login : 5");

        tvUserRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegistrationActivity.class));
            }
        });

    }


    @Override
    public void onClick(View v) {
        String userNameKey = edtNama.getText().toString();
        String userPwdKey = edtPassword.getText().toString();

        if (userNameKey.equals("Admin") && userPwdKey.equals("1234")){
            Toast.makeText(getApplicationContext(), "Login sukses Coy",
                    Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
        }
        else {
            counter--;
            tvInfo.setText("Jajal Dei Geh Coy : "+String.valueOf(counter));
             if (counter == 0){
                 btnLogin.setEnabled(false);
             }

        }

    }
}
