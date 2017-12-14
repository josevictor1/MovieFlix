package com.dev.felipe.movieflix;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.view.View;

import com.dev.felipe.movieflix.UI.Discover;
import com.dev.felipe.movieflix.UI.Search;
import com.dev.felipe.movieflix.Utils.APIUtils;
import com.dev.felipe.movieflix.Utils.Common;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.SearchCard)
    CardView mSearchCard;
    @BindView(R.id.DiscoverCard)
    CardView mDiscoverCard;

    public static Map<String, Integer> mListOfGenres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mSearchCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Search.class);
                startActivity(intent);
            }
        });

        mDiscoverCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Discover.class);
                startActivity(intent);
            }
        });

        if (!Common.isNetworkConnected(MainActivity.this)) {
            AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Sem conexão com a Internet!")
                    .setMessage("Conecte-se à internet para utilizar o aplicativo")
                    .setPositiveButton("Ok", null);

            alert.show();
        }

        mListOfGenres = APIUtils.genreIdMap();
    }
}
