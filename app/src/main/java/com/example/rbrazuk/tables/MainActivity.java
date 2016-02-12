package com.example.rbrazuk.tables;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    public static final String TAG = MainActivity.class.getSimpleName();

    private String premierLeagueId = "398";
    private String bundesligaId = "394";
    private String laLigaId = "399";
    private String ligue1Id = "396";
    private String serieAId = "401";

    public static final String PREMIER_LEAGUE = "PREMIER LEAGUE";
    @Bind(R.id.premier_league_button) Button mPremierLeagueButton;
    @Bind(R.id.bundesliga_button) Button mBundesligaButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @OnClick (R.id.premier_league_button)
    public void startPremierLeagueActivity(View view) {
        Intent intent = new Intent(this,TableActivity.class);
        intent.putExtra(TAG, premierLeagueId);
        startActivity(intent);
    }

    @OnClick (R.id.bundesliga_button)
    public void startBundesligaActivity(View view) {
        Intent intent = new Intent(this,TableActivity.class);
        intent.putExtra(TAG, bundesligaId);
        startActivity(intent);
    }
    @OnClick (R.id.bundesliga_button)
    public void startLaLigaActivity(View view) {
        Intent intent = new Intent(this,TableActivity.class);
        intent.putExtra(TAG, laLigaId);
        startActivity(intent);
    }
    @OnClick (R.id.bundesliga_button)
    public void startLigue1Activity(View view) {
        Intent intent = new Intent(this,TableActivity.class);
        intent.putExtra(TAG, ligue1Id);
        startActivity(intent);
    }
    @OnClick (R.id.bundesliga_button)
    public void startSerieAActivity(View view) {
        Intent intent = new Intent(this,TableActivity.class);
        intent.putExtra(TAG, serieAId);
        startActivity(intent);
    }

    private void getTable(String leagueName) {

    }
}
