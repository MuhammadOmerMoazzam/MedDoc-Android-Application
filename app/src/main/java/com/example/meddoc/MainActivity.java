package com.example.meddoc;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
//
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseAuthException;
//import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
//import com.google.firebase.auth.FirebaseAuthUserCollisionException;
//import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
//import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

//    private FirebaseAuth mAuth;
    private EditText emailEditText, passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize Firebase Auth
//        mAuth = FirebaseAuth.getInstance();

        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);

        TextView signInTextView = findViewById(R.id.signInTextView);
        signInTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to LoginActivity when signInTextView is clicked
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });
    }

    public void createAccount(View view) {
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEditText.setError("Please enter a valid email address");
            emailEditText.requestFocus();
            return;
        }

        if (password.isEmpty() || password.length() < 6) {
            passwordEditText.setError("Password must be at least 6 characters");
            passwordEditText.requestFocus();
            return;
        }

//        mAuth.createUserWithEmailAndPassword(email, password)
//                .addOnCompleteListener(this, task -> {
//                    if (task.isSuccessful()) {
//                        FirebaseUser user = mAuth.getCurrentUser();
//                        if (user != null) {
//                            startActivity(new Intent(MainActivity.this, HomeActivity.class));
//                            Toast.makeText(MainActivity.this, "Welcome to MedDoc. Account Created", Toast.LENGTH_SHORT).show();
//                            finish();
//                        }
//                    } else {
//                        try {
//                            throw task.getException();
//                        } catch (FirebaseAuthWeakPasswordException e) {
//                            passwordEditText.setError("Weak password. Please enter a stronger password.");
//                            passwordEditText.requestFocus();
//                        } catch (FirebaseAuthInvalidCredentialsException e) {
//                            emailEditText.setError("Invalid email. Please enter a valid email address.");
//                            emailEditText.requestFocus();
//                        } catch (FirebaseAuthUserCollisionException e) {
//                            emailEditText.setError("An account with this email already exists.");
//                            emailEditText.requestFocus();
//                        } catch (Exception e) {
//                            Toast.makeText(MainActivity.this, "Account creation failed: " + e.getMessage(), Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });

        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        Toast.makeText(MainActivity.this, "Welcome to MedDoc", Toast.LENGTH_SHORT).show();
        Log.d("general", "test createAccount");
    }

    // Handle back button press
    @Override
    public void onBackPressed() {
        // Exit the app
        super.onBackPressed();
        finishAffinity(); // This finishes all activities in the task associated with the application
    }

}
