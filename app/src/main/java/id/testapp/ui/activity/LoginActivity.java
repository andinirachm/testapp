package id.testapp.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import id.testapp.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editTextEmail, editTextPassword;
    private SharedPreferences loginPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginPref = getSharedPreferences("login", Context.MODE_PRIVATE);

        Button btnMasuk = findViewById(R.id.btn_masuk);
        editTextEmail = findViewById(R.id.edit_text_email);
        editTextPassword = findViewById(R.id.edit_text_password);

        btnMasuk.setOnClickListener(this);

        if (!loginPref.getString("email", "").equals("")) {
            finish();
            Intent i = new Intent(this, MainActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
        }
    }

    @Override
    public void onClick(View view) {
        initFirstLogin();
        Toast.makeText(this, "Hello " + editTextEmail.getText().toString(), Toast.LENGTH_SHORT).show();
        finish();
        Intent i = new Intent(this, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
    }

    private void initFirstLogin() {
        SharedPreferences.Editor editor = loginPref.edit();
        editor.putString("email", editTextEmail.getText().toString());
        editor.putString("password", editTextPassword.getText().toString());
        editor.putString("gender", "female");
        editor.putString("name", "Andini Rachmah");
        editor.putString("phone", "+628123456789");
        editor.apply();
    }
}
