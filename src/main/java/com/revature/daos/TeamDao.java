package com.revature.daos;

import com.revature.models.Team;
import com.revature.repositories.TeamRepository;

public class TeamDao {
    private static TeamRepository tr;

    public TeamDao() {
        tr = new TeamRepository();
    }

    public TeamDao(TeamRepository neo) {
        tr = neo;
    }

    public boolean deleteTeam(Long target) {
        return tr.deleteTeam(target);
    }

    public Team findTeamById(Long target) {
        return tr.findTeamById(target);
    }

    public Team saveTeam(Team saveThis) {
        return tr.saveTeam(saveThis);
    }

    public boolean updateTeam(Team updateThis) {
        return tr.updateTeam(updateThis);
    }

}
