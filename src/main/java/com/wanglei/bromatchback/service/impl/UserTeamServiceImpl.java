package com.wanglei.bromatchback.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wanglei.bromatchback.mapper.UserTeamMapper ;
import com.wanglei.bromatchback.model.domain.UserTeam;
import com.wanglei.bromatchback.service.UserTeamService ;
import org.springframework.stereotype.Service;

/**
* @author admin
* @description 针对表【user_team(用户-队伍)】的数据库操作Service实现
* @createDate 2024-03-13 10:44:25
*/
@Service
public class UserTeamServiceImpl extends ServiceImpl<UserTeamMapper, UserTeam>
    implements UserTeamService{

}




