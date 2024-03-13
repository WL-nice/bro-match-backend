package com.wanglei.bromatchback.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wanglei.bromatchback.model.domain.Team ;
import com.wanglei.bromatchback.mapper.TeamMapper ;
import com.wanglei.bromatchback.service.TeamService ;
import org.springframework.stereotype.Service;

/**
* @author admin
* @description 针对表【team(队伍)】的数据库操作Service实现
* @createDate 2024-03-13 10:42:45
*/
@Service
public class TeamServiceImpl extends ServiceImpl<TeamMapper, Team>
    implements TeamService{

}




