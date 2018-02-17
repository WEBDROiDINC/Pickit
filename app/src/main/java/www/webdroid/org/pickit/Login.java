package www.webdroid.org.pickit;

import android.content.Intent;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;

public class Login extends AppCompatActivity {

    private Button SignUp;
    private LoginButton loginButton;
    public static CallbackManager callbackManager;
    private static final String EMAIL = "email";
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        //  callbackManager to handle login responses
        callbackManager = CallbackManager.Factory.create();




        loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions(Arrays.asList(EMAIL));
        // If you are using in a fragment, call loginButton.setFragment(this);

        // Callback registration
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {


                Log.d("MyActivity" , "Facebook Success!");
                handleFacebookAccessToken(loginResult.getAccessToken());
            }

            @Override
            public void onCancel() {
                Toast.makeText(Login.this, "Cancel !", Toast.LENGTH_SHORT).show();
                Log.d("MyActivity" , "connection canceled!");
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
                Toast.makeText(Login.this, "Error happened !", Toast.LENGTH_SHORT).show();
                Log.d("MyActivity" , "Facebook failed error!");
            }
        });
        SignUp = (Button)findViewById(R.id.buttonSignUpLogin);

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gto = new Intent(Login.this,signUp.class);
                startActivity(gto);
            }
        });
    }

    private void handleFacebookAccessToken(AccessToken token) {
        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        String message;
                        if (task.isSuccessful()) {
                            Log.d("Myactivity", "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                          /*  message = "success firebaseAuthWithFacebook";
                            Toast.makeText(Login.this,message,Toast.LENGTH_SHORT).show();
                            Intent i = new Intent( Login.this, Main2Activity.class);
                            startActivity(i);*/


                        } else {
                            message = "fail firebaseAuthWithFacebook";
                            Toast.makeText(Login.this,message,Toast.LENGTH_SHORT).show();
                        }

                    }
                });
    }
}
