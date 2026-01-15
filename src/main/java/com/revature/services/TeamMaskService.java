package com.revature.services;

import com.revature.daos.TeamMaskDao;
import com.revature.models.TeamMask;

import java.util.List;

public class TeamMaskService {
    private static TeamMaskDao tmd;

    public TeamMaskService() {
        tmd = new TeamMaskDao();
    }

    public TeamMaskService(TeamMaskDao neo) {
        tmd = neo;
    }

    public List<TeamMask> findTeamMaskByTeam(Long teamId) {
        return tmd.findTeamMaskByTeam(teamId);
    }

    public List<TeamMask> findTeamsByMask(Long maskId) {
        return tmd.findTeamsByMask(maskId);
    }

    public boolean deleteTeamMask(TeamMask deleteMe) {
        return tmd.deleteTeamMask(deleteMe);
    }

    public TeamMask saveTeamMask(TeamMask saveMe) {
        return tmd.saveTeamMask(saveMe);
    }

    public boolean updateTeamMask(TeamMask updateMe) {
        return tmd.updateTeamMask(updateMe);
    }


}
