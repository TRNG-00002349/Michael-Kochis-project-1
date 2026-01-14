package com.revature.services;

import com.revature.daos.TeamDao;
import com.revature.models.Team;

public class TeamService {
    public static TeamDao teamDao;

    public TeamService() {
        teamDao = new TeamDao();
    }

    public TeamService(TeamDao td) {
        teamDao = td;
    }

    public boolean deleteTeam(Long teamId) {
        return teamDao.deleteTeam(teamId);
    }

    public Team findTeamByID(Long teamId) {
        return teamDao.findTeamById(teamId);
    }

    public Team saveTeam(Team saveThis) {
        return teamDao.saveTeam(saveThis);
    }

    public boolean updateTeam(Team updateThis) {
        return teamDao.updateTeam(updateThis);
    }
}
