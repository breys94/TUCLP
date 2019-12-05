package com.bastou.tuclp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bastou.tuclp.model.Amiibo;
import com.bastou.tuclp.view.ListReleaseAdapter;

public class DisplayActivity  extends AppCompatActivity {

    public static final String KEY_ID = "id";

    private Amiibo amiibo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.amiibo_display_layout);

        int id = this.getIntent().getIntExtra(KEY_ID, 0);
        this.amiibo = Amiibo.getList().get(id);

        ImageView img = findViewById(R.id.img_amiibo);
        TextView name = findViewById(R.id.name_amiibo);
        TextView game = findViewById(R.id.serie_amiibo);
        TextView series = findViewById(R.id.game_amiibo);
        Button back = findViewById(R.id.back_button);

        img.setImageBitmap(amiibo.getImage());
        name.setText(amiibo.getName());
        game.setText(amiibo.getGameSeries().toString());
        series.setText(amiibo.getGameSeries().toString());

        RecyclerView list = findViewById(R.id.listview_release);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        list.setLayoutManager(mLayoutManager);
        list.setAdapter(new ListReleaseAdapter(amiibo.getReleases()));

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }


}
