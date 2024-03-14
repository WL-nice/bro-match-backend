package com.wanglei.bromatchback.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wanglei.bromatchback.model.domain.Team ;
import com.wanglei.bromatchback.model.domain.User;
import com.wanglei.bromatchback.model.domain.dto.TeamQuery;
import com.wanglei.bromatchback.model.domain.request.TeamJoinRequest;
import com.wanglei.bromatchback.model.domain.request.TeamUpdateRequest;
import com.wanglei.bromatchback.model.domain.vo.TeamUserVo;

import java.util.List;

/**
* @author admin
* @description 针对表【team(队伍)】的数据库操作Service
* @createDate 2024-03-13 10:42:45
*/
public interface TeamService extends IService<Team> {

    /**
     * 创建队伍
     * @param team
     * @param loginUser
     * @return
     */
    long addTeam(Team team, User loginUser);


    /**
     * 搜索队伍
     * @param teamQuery
     * @return
     */
    List<TeamUserVo> listTeams(TeamQuery teamQuery,boolean isAdmin);

    /**
     * 修改队伍信息
     * @param teamUpdateRequest
     * @param loginUser
     * @return
     */
    boolean updateTeam(TeamUpdateRequest teamUpdateRequest,User loginUser);

    /**
     * 加入队伍
     * @param teamJoinRequest
     * @param loginUser
     * @return
     */
    boolean joinTeam(TeamJoinRequest teamJoinRequest, User loginUser);
}
