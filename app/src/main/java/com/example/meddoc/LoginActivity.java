package com.example.meddoc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize views
        Button forgotPasswordButton = findViewById(R.id.forgotPasswordButton);
        // Set onClick listener for forgotPasswordButton
        forgotPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to ForgotPasswordActivity
                startActivity(new Intent(LoginActivity.this, ForgotPassword.class));
            }
        });


        // Initialize views
        TextView createAccountTextView = findViewById(R.id.createAccountTextView);
        // Set onClick listener for createAccountTextView
        createAccountTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to MainActivity (assuming it's the create account page)
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
        });
    }

    // Handle back button press
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // Navigate back to MainActivity (Create Account page)
        startActivity(new Intent(this, MainActivity.class));
        // Finish LoginActivity so it's not in the back stack
        finish();
    }
}
