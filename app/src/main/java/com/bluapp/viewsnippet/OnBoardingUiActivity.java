package com.bluapp.viewsnippet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import com.codemybrainsout.onboarder.AhoyOnboarderActivity;
import com.codemybrainsout.onboarder.AhoyOnboarderCard;

import java.util.ArrayList;
import java.util.List;

public class OnBoardingUiActivity extends AhoyOnboarderActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AhoyOnboarderCard onboarderCard1 = new AhoyOnboarderCard("Hello", "Hello World", R.drawable.interview_item_image);
        onboarderCard1.setBackgroundColor(R.color.bg_onboarding);
        AhoyOnboarderCard onboarderCard2 = new AhoyOnboarderCard("Hello2", "Hello World2", R.drawable.interview_item_image);
        onboarderCard2.setBackgroundColor(R.color.bg_onboarding);
        AhoyOnboarderCard onboarderCard3 = new AhoyOnboarderCard("Hello3", "Hello World3", R.drawable.interview_item_image);
        onboarderCard3.setBackgroundColor(R.color.bg_onboarding);
        AhoyOnboarderCard onboarderCard4 = new AhoyOnboarderCard("Hello4", "Hello World4", R.drawable.interview_item_image);
        onboarderCard4.setBackgroundColor(R.color.bg_onboarding);


        List<AhoyOnboarderCard> pages = new ArrayList<>();
        pages.add(onboarderCard1);
        pages.add(onboarderCard2);
        pages.add(onboarderCard3);
        pages.add(onboarderCard4);

        for (AhoyOnboarderCard page : pages) {
            page.setTitleColor(R.color.white);
            page.setDescriptionColor(R.color.white);
            page.setTitleTextSize(dpToPixels(10, this));
            page.setDescriptionTextSize(dpToPixels(8, this));
            page.setIconLayoutParams(100, 100, 10, 10, 10, 10);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            setFinishButtonDrawableStyle(ContextCompat.getDrawable(this, R.drawable.rounded_button));
        }


        setFinishButtonTitle("Finish");
        setImageBackground(R.drawable.on_boarding_bg);
        showNavigationControls(true);
        setOnboardPages(pages);
    }

    @Override
    public void onFinishButtonPressed() {
        Toast.makeText(this, "Button Pressed", Toast.LENGTH_LONG).show();
    }
}
