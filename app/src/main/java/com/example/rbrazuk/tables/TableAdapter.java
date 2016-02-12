package com.example.rbrazuk.tables;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by rossbrazuk1 on 2/12/16.
 */
public class TableAdapter extends RecyclerView.Adapter<TableAdapter.TeamViewHolder>{

    private Team[] mTeams;
    private Context mContext;

    public TableAdapter(Context context,Team[] teams) {

        mContext = context;
        mTeams = teams;
    }



    @Override
    public TeamViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.team_list_item,parent, false);
        TeamViewHolder viewHolder = new TeamViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TeamViewHolder holder, int position) {
        holder.bindTeam(mTeams[position]);
    }

    @Override
    public int getItemCount() {
        return mTeams.length;
    }

    public class TeamViewHolder extends RecyclerView.ViewHolder {
        public TextView mPositionView;
        public TextView mTeamNameView;
        public TextView mGoalDifferenceView;
        public TextView mPointsView;

        public TeamViewHolder(View itemView) {
            super(itemView);

            mPositionView = (TextView) itemView.findViewById(R.id.positionTextView);
            mTeamNameView = (TextView) itemView.findViewById(R.id.teamNameTextView);
            mGoalDifferenceView = (TextView) itemView.findViewById(R.id.goalDifferenceTextView);
            mPointsView = (TextView) itemView.findViewById(R.id.pointsTextView);


        }

        public void bindTeam(Team team) {
            mPositionView.setText(team.getPosition() + "");
            mTeamNameView.setText(team.getTeamName());
            mGoalDifferenceView.setText(team.getGoalDifference() + "");
            mPointsView.setText(team.getPoints() + "");
        }
    }
}
