package com.example.rbrazuk.tables;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TableActivity extends AppCompatActivity {

    private Team[] mTeams;
    public final static String TAG = TableActivity.class.getSimpleName();


    @Bind(R.id.table_recycler_view) RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);

        ButterKnife.bind(this);

        Intent intent = getIntent();

        System.out.println(intent.getStringExtra(MainActivity.TAG));
        String leagueId = intent.getStringExtra(MainActivity.TAG);

        String tableUrl = "http://api.football-data.org/v1/soccerseasons/" + leagueId + "/leagueTable";

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(tableUrl).addHeader("X-Auth-Token","95468454664049ca81f3fc478ede7ef2").build();

        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String jsonData = response.body().string();



                Log.v(TAG, jsonData);

                try {
                    if(response.isSuccessful()) {
                        mTeams = parseJsonTeam(jsonData);

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                TableAdapter adapter = new TableAdapter(getApplicationContext(),mTeams);
                                mRecyclerView.setAdapter(adapter);

                                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                                mRecyclerView.setLayoutManager(layoutManager);

                                mRecyclerView.setHasFixedSize(true);
                            }
                        });
                    }
                    else {
                        System.out.println("error");
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }




            }
        });


//        System.out.println(mTeams);
//
//        TableAdapter adapter = new TableAdapter(this,mTeams);
//        mRecyclerView.setAdapter(adapter);
//
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
//        mRecyclerView.setLayoutManager(layoutManager);
//
//        mRecyclerView.setHasFixedSize(true);


    }

    @Override
    protected void onPause() {
        super.onPause();
        mTeams = new Team[0];
    }

    private void getTable() {

    }

    private Team[] parseJsonTeam(String jsonData) throws JSONException {

        JSONObject table = new JSONObject(jsonData);
        JSONArray standing = table.getJSONArray("standing");

        System.out.println(standing.length());

        mTeams = new Team[standing.length()];

        for (int i = 0; i < standing.length(); i++) {
            JSONObject jsonTeam = standing.getJSONObject(i);
            Team team = new Team();

            team.setTeamName(jsonTeam.getString("teamName"));
            team.setPosition(jsonTeam.getInt("position"));
            team.setGoalDifference(jsonTeam.getInt("goalDifference"));
            team.setPoints(jsonTeam.getInt("points"));

            mTeams[i] = team;


        }

        return mTeams;
    }

}
