package com.example.user.aplikasilogin;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {
    private EditText edtUserName, edtUserEmail, edtUserPassword;
    private Button btnRegistrasi;
    private TextView tvinfoRegistrasi;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        setupUIViews();

        firebaseAuth = FirebaseAuth.getInstance();

        btnRegistrasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()){
                    //upload data to the database
                    String user_email = edtUserEmail.getText().toString().trim();
                    String user_password = edtUserPassword.getText().toString().trim();

                    firebaseAuth.createUserWithEmailAndPassword(user_email, user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(RegistrationActivity.this,"Registrasi Sukses", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
                            }else {
                                Toast.makeText(RegistrationActivity.this,"Registrasi Gagal", Toast.LENGTH_SHORT).show();
                            }


                        }
                    });
                }
            }
        });

        tvinfoRegistrasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
            }
        });
    }

    private void setupUIViews(){
        edtUserName = (EditText)findViewById(R.id.edt_user_name);
        edtUserEmail = (EditText)findViewById(R.id.edt_user_email);
        edtUserPassword = (EditText)findViewById(R.id.edt_password);
        btnRegistrasi = (Button)findViewById(R.id.btn_registrasi);
        tvinfoRegistrasi = (TextView)findViewById(R.id.tv_info_registrasi);
    }

    private Boolean validate(){
        Boolean result = false;

        String username = edtUserName.getText().toString();
        String useremail = edtUserEmail.getText().toString();
        String userpassword = edtUserPassword.getText().toString();

        if (username.isEmpty() && useremail.isEmpty() && userpassword.isEmpty()){
            Toast.makeText(this, "Mohon Isi Semua Data", Toast.LENGTH_SHORT).show();
        }else {
            result = true;
        }
        return result;
    }
}
