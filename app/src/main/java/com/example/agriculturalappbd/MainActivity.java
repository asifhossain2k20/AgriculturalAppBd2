package com.example.agriculturalappbd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
  TextView ivLogo,ivSubtitle,ivBtn;
  ImageView ivSplash;
  Animation smalltobig,fleft,fhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        smalltobig= AnimationUtils.loadAnimation(this,R.anim.smalltobig);
        fleft= AnimationUtils.loadAnimation(this,R.anim.fleft);
        fhelper= AnimationUtils.loadAnimation(this,R.anim.fhelper);

         Typeface logox =Typeface.createFromAsset(getAssets(),"fonts/Fredoka.ttf");
         Typeface mlight =Typeface.createFromAsset(getAssets(),"fonts/MontserratLight.ttf");
         Typeface mmedium =Typeface.createFromAsset(getAssets(),"fonts/MontserratMedium.ttf");
         Typeface mregular =Typeface.createFromAsset(getAssets(),"fonts/MontserratRegular.ttf");

        ivLogo = findViewById(R.id.ivLogo);
        ivSubtitle = findViewById(R.id.ivsubTitle);
        ivBtn = findViewById(R.id.ivBtn);
        ivSplash=findViewById(R.id.ivSplash);

        ivLogo.setTypeface(logox);
        ivSubtitle.setTypeface(mlight);
        ivBtn.setTypeface(mmedium);

        ivSplash.startAnimation(smalltobig);

        ivLogo.setTranslationX(400);
        ivSubtitle.setTranslationX(400);
        ivBtn.setTranslationX(400);

        ivLogo.setAlpha(0);
        ivSubtitle.setAlpha(0);
        ivBtn.setAlpha(0);

        ivLogo.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        ivSubtitle.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();
        ivBtn.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(900).start();

      ivBtn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent ax =new Intent(MainActivity.this,HomeActivity.class);
              startActivity(ax);
              overridePendingTransition(R.anim.fleft,R.anim.fhelper);
          }
      });
    }
}