package com.wanglei.bromatchback.service;

import com.wanglei.bromatchback.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wanglei.bromatchback.model.domain.request.UserUpdateRequest;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

import static com.wanglei.bromatchback.constant.UserConstant.ADMIN_ROLE;
import static com.wanglei.bromatchback.constant.UserConstant.USER_LOGIN_STATE;

/**
 * 用户服务
 *
 * @author muqiu
 */
public interface UserService extends IService<User> {


    /**
     * 用户注册
     *
     * @param userAccount   账号
     * @param userPassword  密码
     * @param checkPassword 验证密码
     * @return 用户id
     */
    long UserRegister(String userAccount, String userPassword, String checkPassword);

    /**
     * 用户登录
     *
     * @param userAccount  账号
     * @param userPassword 密码
     * @return 脱敏后的用户信息
     */
    User doLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 用户脱敏
     *
     * @param user
     * @return
     */

    User getSafetUser(User user);

    /**
     * 用户注销
     *
     * @param request
     * @return
     */
    int userLogout(HttpServletRequest request);

    /**
     * 根据标签搜索用户
     *
     * @param list
     * @return
     */
    List<User> searchUserByTags(List<String> list);

    /**
     * 用户信息修改
     *
     * @param userUpdateRequest
     * @return
     */
    Integer updateUser(UserUpdateRequest userUpdateRequest, User loginUser);


    /**
     * 获取登录用户信息
     */
    User getLoginUser(HttpServletRequest request);

    /**
     * 判断是否为管理员
     */
    boolean isAdmin(HttpServletRequest request);

    boolean isAdmin(User loginUser);

    /**
     * 匹配用户
     * @param num
     * @param loginUser
     * @return
     */
    List<User> matchUsers(long num, User loginUser);
}




