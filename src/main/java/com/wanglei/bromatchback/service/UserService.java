package com.wanglei.bromatchback.service;

import com.wanglei.bromatchback.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

/**
 * 用户服务
* @author muqiu
*/
public interface UserService extends IService<User>  {


    /**
     * 用户注册
     * @param userAccount 账号
     * @param userPassword 密码
     * @param checkPassword 验证密码
     * @return 用户id
     */
    long UserRegister(String userAccount, String userPassword,String checkPassword,String acptCode);

    /**
     *用户登录
     * @param userAccount 账号
     * @param userPassword 密码
     * @return 脱敏后的用户信息
     */
    User doLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 用户脱敏
     * @param user
     * @return
     */

    User getSafetUser(User user);

    /**
     * 用户注销
     * @param request
     * @return
     */
    int userLogout(HttpServletRequest request);

    /**
     * 根据标签搜索用户
     * @param list
     * @return
     */
    List<User> searchUserByTags(List<String> list);
}
