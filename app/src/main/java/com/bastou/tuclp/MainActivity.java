package com.bastou.tuclp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.bastou.tuclp.controller.IOnLoadEnd;
import com.bastou.tuclp.controller.ListFragment;
import com.bastou.tuclp.controller.LoaderFragment;

public class MainActivity extends AppCompatActivity implements IOnLoadEnd {

    final String REALM_PARAM = "YourAppName";

    private LoaderFragment loaderFragment;
    private ListFragment listFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loaderFragment = (LoaderFragment) getFragmentManager().findFragmentById(R.id.load_fragment);
        loaderFragment.setOnLoadEnd(this);
        listFragment = (ListFragment) getFragmentManager().findFragmentById(R.id.list_fragment);
    }

    @Override
    public void onLoadEnd() {
        loaderFragment.getView().setVisibility(View.INVISIBLE);
        listFragment.updateList();
    }
}
