package com.example.rbrazuk.tables;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    public static final String TAG = MainActivity.class.getSimpleName();

    private String premierLeagueId = "398";
    private String bundesligaId = "394";
    private String laLigaId = "399";
    private String ligue1Id = "396";
    private String serieAId = "401";

    private League[] leagues;

    public static final String PREMIER_LEAGUE = "PREMIER LEAGUE";

    @Bind(R.id.league_spinner) Spinner mSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);


        mSpinner.setSelected(false);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.leagues_array,android.R.layout.simple_spinner_item);


        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mSpinner.setAdapter(adapter);

        mSpinner.setOnItemSelectedListener(this);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        System.out.println(parent.getItemAtPosition(position));

        String selection = parent.getSelectedItem().toString();
        System.out.println(selection);


        Intent intent = new Intent(MainActivity.this,TableActivity.class);
        switch (position){
            case 0:
                break;

            case 1:
                intent.putExtra(TAG,premierLeagueId);
                startActivity(intent);
                break;
            case 2:
                intent.putExtra(TAG,bundesligaId);
                startActivity(intent);
                break;
            case 3:
                intent.putExtra(TAG,laLigaId);
                startActivity(intent);
                break;
            case 4:
                intent.putExtra(TAG,serieAId);
                startActivity(intent);
                break;
            case 5:
                intent.putExtra(TAG,ligue1Id);
                startActivity(intent);
                break;
        }




    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
