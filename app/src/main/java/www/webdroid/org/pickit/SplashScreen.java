package www.webdroid.org.pickit;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 2000;
    Animation fade;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        textView = (TextView)findViewById(R.id.textViewSplash);

        fade = AnimationUtils.loadAnimation(this,R.anim.fade);

        textView.setAnimation(fade);

        TextView myTextView = (TextView) findViewById(R.id.textViewSplash);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Shrikhand-Regular.ttf");
        myTextView.setTypeface(typeface);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent gto = new Intent(SplashScreen.this,StartActivity.class);
                startActivity(gto);

                finish();
            }
        },SPLASH_TIME_OUT);

    }
}
