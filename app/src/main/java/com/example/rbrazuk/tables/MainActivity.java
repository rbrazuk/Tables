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
    private String bundesligaId;
    private String laLigaId;
    private String ligue1Id;
    private String serieAId;

    public static final String PREMIER_LEAGUE = "PREMIER LEAGUE";
    @Bind(R.id.premier_league_button) Button mPremierLeagueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @OnClick (R.id.premier_league_button)
    public void startPremierLeagueActivity(View view) {
        Intent intent = new Intent(this,TableActivity.class);
        intent.putExtra(TAG,premierLeagueId);
        startActivity(intent);
    }

    private void getTable(String leagueName) {

    }
}
