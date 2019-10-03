package cn.cslg.service;

import cn.cslg.pojo.User;

public interface UserService {

    /**
     * 判断用户名是否存在
     * @param username
     * @return
     */
    public boolean queryUsernameIsExist(String username);

    /**
     * 注册用户
     * @param user
     */
    public void saveUser(User user);

    /**
     * 登录
     * @param username
     * @param md5Str
     * @return
     */
    public User querUserForLogin(String username, String md5Str);
}
