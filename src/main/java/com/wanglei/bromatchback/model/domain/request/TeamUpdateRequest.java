package com.wanglei.bromatchback.model.domain.request;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class TeamUpdateRequest {

    /**
     * id
     */
    private Long id;

    /**
     * 队伍名
     */
    private String teamName;

    /**
     * 队伍描述
     */
    private String description;

    /**
     * 创建时间
     */
    private Date expireTime;


    /**
     * 密码
     */
    private String password;


    /**
     * 队伍状态
     */
    private Integer teamStatus;
}
