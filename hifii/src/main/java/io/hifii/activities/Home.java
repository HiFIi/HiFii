package io.hifii.activities;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import io.hifii.HiFii;
import io.hifii.R;

/**
 * Created by kyler on 10/26/15.
 */
public class Home extends HiFii {
    private static final float PHOTO_ASPECT_RATIO = 1.7777777f;
    private static final float DRAWEE_PHOTO_ASPECT_RATIO = 1.33f;
    private static Uri mDraweeUri;
    private SimpleDraweeView draweeView;

    @Override
    protected int getSelfNavDrawerItem() {
        return NAVDRAWER_ITEM_HOME;
    }

    @Override
    protected Context getContext() {
        return Home.this;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_HiFii_Home);
        super.onCreate(savedInstanceState);
        Fresco.initialize(getApplicationContext());
        setContentView(R.layout.home);
        mToolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_drawer));
        super.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        // I should perhaps do some research to see whether or not
        // setting the SupportActionBars title to an empty string is
        // more efficient than *.setTitle(null);

        getSupportActionBar().setTitle(null);
        mToolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_drawer_white));

        mDraweeUri = Uri.parse("http://i.imgur.com/YpVhcll.jpg");

        draweeView = (SimpleDraweeView) findViewById(R.id.session_photo);
        draweeView.setImageURI(mDraweeUri);
        draweeView.setAspectRatio(DRAWEE_PHOTO_ASPECT_RATIO);
    }
}
