package com.wanglei.bromatchback.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wanglei.bromatchback.model.domain.Team ;
import com.wanglei.bromatchback.model.domain.User;

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


}
