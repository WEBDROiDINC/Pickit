package www.webdroid.org.pickit;
/*
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
*/


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signUp extends AppCompatActivity {

    private EditText Username_EditText_SignUp;

    private EditText Password_EditText_SignUp;

    private EditText RePassword_EditText_Signup;

    private Button Login;


    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Username_EditText_SignUp =(EditText) findViewById(R.id.editTextUserNameSignup);
        Password_EditText_SignUp = (EditText)  findViewById(R.id.editTextPasswordSignup);
        RePassword_EditText_Signup = (EditText) findViewById(R.id.editTextConPasswordSignup);
        Login = (Button)findViewById(R.id.buttonLoginSignUp);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gto = new Intent(signUp.this,Login.class);
                startActivity(gto);
            }
        });

        mAuth = FirebaseAuth.getInstance();

    }

    public void Signout()
    {

    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }
    public void Signin(View view) {

        String Username = Username_EditText_SignUp.getText().toString();

        String Password = Password_EditText_SignUp.getText().toString();

        if (!ValidateLogin(Username, Password)) {
            return;
        }

        mAuth.signInWithEmailAndPassword(Username, Password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                    // update UI with the signed-in user's information
                                    FirebaseUser user = mAuth.getCurrentUser();
                                 //   updateUI(user);
                                } else {

                                    Toast.makeText(signUp.this, "Authentication failed!", Toast.LENGTH_SHORT).show();
                                  //  updateUI(null);
                                }
                            }
                        }
                );
    }

    public void Signup(View view)
    {
        //Getting Username and Password after validation to signup in database
        String Username = Username_EditText_SignUp.getText().toString();

        String Password = Password_EditText_SignUp.getText().toString();

        String Repassword = RePassword_EditText_Signup.getText().toString();

        if (!ValidateForm(Username, Password , Repassword )) {
            return;
        }

        mAuth.createUserWithEmailAndPassword(Username, Password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                           Toast.makeText(signUp.this , "SignUp Successful",Toast.LENGTH_SHORT);

                            // update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();

                            Intent i = new Intent( signUp.this, Main2Activity.class);
                            startActivity(i);

                        } else {

                            Toast.makeText(signUp.this, "Authentication failed!", Toast.LENGTH_SHORT).show();
                           // updateUI(null);
                        }
                    }
                });

    }

    public boolean ValidateForm(String Username, String Password , String Repassword)
    {
        //Validating the emptiness of the fields with TextUtil Tool
        //---------------------------------------\\
        if (TextUtils.isEmpty(Username)) {
            Toast.makeText(signUp.this, R.string.enter_username, Toast.LENGTH_SHORT).show();
            return false;
        }

        if (TextUtils.isEmpty(Password)) {
            Toast.makeText(signUp.this, R.string.enter_password, Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(Repassword)) {
            Toast.makeText(signUp.this, R.string.enter_Repassword, Toast.LENGTH_SHORT).show();
            return false;
        }

        //-----------------------------------\\

        //validating the length of the password
        if (Password.length() < 6) {
            Toast.makeText(signUp.this, R.string.password_too_short, Toast.LENGTH_LONG).show();
            return false;
        }

       /* //vaidating the confirmation password
        if(!Password.equals(Repassword))
        {
            Toast.makeText(signUp.this , R.string.passwords_dont_match,Toast.LENGTH_SHORT).show();
            return false;
        }*/
        return true;


    }

    public boolean ValidateLogin(String Username , String Password)
    {

        if (TextUtils.isEmpty(Username)) {
            Toast.makeText(signUp.this, R.string.enter_username, Toast.LENGTH_SHORT).show();
            return false;
        }

        if (TextUtils.isEmpty(Password)) {
            Toast.makeText(signUp.this, R.string.enter_password, Toast.LENGTH_SHORT).show();
            return false;
    }

        return true;

    }
}
