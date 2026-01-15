package com.revature.daos;

import com.revature.models.TeamMask;
import com.revature.repositories.TeamMaskRepository;

import java.util.List;

public class TeamMaskDao {
    private static TeamMaskRepository teamMaskRepository;

    public TeamMaskDao() {
        teamMaskRepository = new TeamMaskRepository();
    }

    public TeamMaskDao(TeamMaskRepository tmr) {
        teamMaskRepository = tmr;
    }

    public List<TeamMask> findTeamMaskByTeam(Long teamId) {
        return teamMaskRepository.findTeamMaskByTeam(teamId);
    }

    public List<TeamMask> findTeamsByMask(Long maskId) {
        return teamMaskRepository.findTeamsByMask(maskId);
    }

    public boolean deleteTeamMask(TeamMask deleteMe) {
        return teamMaskRepository.deleteTeamMask(deleteMe);
    }

    public TeamMask saveTeamMask(TeamMask saveMe) {
        return teamMaskRepository.saveTeamMask(saveMe);
    }

    public boolean updateTeamMask(TeamMask updateMe) {
        return teamMaskRepository.updateTeamMask(updateMe);
    }
}
