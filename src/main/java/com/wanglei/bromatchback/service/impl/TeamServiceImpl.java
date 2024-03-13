package com.wanglei.bromatchback.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wanglei.bromatchback.commmon.ErrorCode;
import com.wanglei.bromatchback.exception.BusinessException;
import com.wanglei.bromatchback.model.domain.Team;
import com.wanglei.bromatchback.mapper.TeamMapper;
import com.wanglei.bromatchback.model.domain.User;
import com.wanglei.bromatchback.model.domain.UserTeam;
import com.wanglei.bromatchback.model.domain.enums.TeamStatus;
import com.wanglei.bromatchback.service.TeamService;
import com.wanglei.bromatchback.service.UserTeamService;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.crypto.Data;
import java.beans.Transient;
import java.util.Date;
import java.util.Optional;

/**
 * @author admin
 * @description 针对表【team(队伍)】的数据库操作Service实现
 * @createDate 2024-03-13 10:42:45
 */
@Service
public class TeamServiceImpl extends ServiceImpl<TeamMapper, Team>
        implements TeamService {

    @Resource
    private UserTeamService userTeamService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public long addTeam(Team team, User loginUser) {
        if (team == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        if (loginUser == null) {
            throw new BusinessException(ErrorCode.NO_LOGIN);
        }

        if (team.getMaxNum() < 1 || team.getMaxNum() > 20) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "队伍人数不满足要求");
        }

        String name = team.getTeamName();
        if (StringUtils.isNotBlank(name) || name.length() > 20) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "队伍名称不满足要求");
        }

        String description = team.getDescription();
        if (StringUtils.isNotBlank(description) && description.length() > 512) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "描述过长");
        }

        int status = Optional.ofNullable(team.getTeamStatus()).orElse(0);
        TeamStatus teamStatus = TeamStatus.getTeamStatusByValue(status);
        if (teamStatus == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "状态不满足要求");
        }
        String password = team.getPassword();
        if (TeamStatus.SECRET.equals(teamStatus) && (StringUtils.isNotBlank(password) || password.length() >= 32)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "密码设置不正确");
        }
        Date expireTime = team.getExpireTime();
        if (new Date().after(expireTime)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "超时时间>当前时间");
        }

        Long userId = loginUser.getId();
        QueryWrapper<Team> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userId", userId);
        long hasTeamCount = this.count(queryWrapper);
        if (hasTeamCount >= 5){
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "最多创建5个队伍");
        }
        team.setId(null);
        team.setUserId(userId);
        boolean result = this.save(team);
        if(!result){
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"创建队伍失败");
        }
        UserTeam userTeam = new UserTeam();
        userTeam.setUserId(userId);
        userTeam.setTeamId(team.getId());
        userTeam.setJoinTime(new Date());


        result =userTeamService.save(userTeam);
        if(!result){
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"创建队伍失败");
        }

        return team.getId();
    }
}




