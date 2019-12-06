package com.bastou.tuclp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.Toast;

import com.bastou.tuclp.controller.IOnLoadEnd;
import com.bastou.tuclp.controller.ListFragment;
import com.bastou.tuclp.controller.LoaderFragment;
import com.bastou.tuclp.controller.PhotoFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements IOnLoadEnd {

    private static final int REQUEST_IMAGE_CAPTURE = 1;

    private LoaderFragment loaderFragment;
    private ListFragment listFragment;
    private PhotoFragment photoFragment;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loaderFragment = (LoaderFragment) getFragmentManager().findFragmentById(R.id.load_fragment);
        loaderFragment.setOnLoadEnd(this);
        listFragment = (ListFragment) getFragmentManager().findFragmentById(R.id.list_fragment);
        photoFragment = (PhotoFragment) getFragmentManager().findFragmentById(R.id.photo_fragment);
        displayFragment(-1);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setVisibility(View.INVISIBLE);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_search:
                        listFragment.updateSearchField();
                        displayFragment(0);
                        break;
                    case R.id.action_list:
                        displayFragment(0);
                        break;
                    case R.id.action_photo:
                        displayFragment(1);
                        dispatchTakePictureIntent();
                        break;
                }
                return true;
            }
        });
    }

    private void displayFragment(int id){
        listFragment.getView().setVisibility(id == 0 ? View.VISIBLE : View.INVISIBLE);
        photoFragment.getView().setVisibility(id == 1 ? View.VISIBLE : View.INVISIBLE);
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    public void onLoadEnd() {
        bottomNavigationView.post(new Runnable() {
            @Override
            public void run() {
                bottomNavigationView.setVisibility(View.VISIBLE);
                loaderFragment.getView().setVisibility(View.INVISIBLE);
            }
        });
        listFragment.updateList();
        displayFragment(0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            photoFragment.updatePhoto(imageBitmap);
        }
    }

}
