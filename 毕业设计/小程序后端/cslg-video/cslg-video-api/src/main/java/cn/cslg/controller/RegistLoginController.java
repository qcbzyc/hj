package cn.cslg.controller;

import cn.cslg.pojo.User;
import cn.cslg.service.UserService;
import cn.cslg.utils.CslgJSONResult;
import cn.cslg.utils.MD5Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "用户注册登录的接口",tags={"注册和登录的controller"})
public class RegistLoginController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户登录",notes = "用户注册的接口")
    @PostMapping("/regist")
    public CslgJSONResult regist(@RequestBody User user) throws Exception {

        //1.判断用户名和密码必须非空
        if(StringUtils.isBlank(user.getUsername())||StringUtils.isBlank(user.getPassword())){
            return CslgJSONResult.errorMsg("用户名和密码不能为空");
        }
        //2.判断用户名是否存在
        boolean usernameIsExist = userService.queryUsernameIsExist(user.getUsername());
        //3.保存用户，注册信息
        if(!usernameIsExist){
            user.setNickname(user.getUsername());
            user.setPassword(MD5Utils.getMD5Str(user.getPassword()));
            user.setFansCounts(0);
            user.setReceiveLikeCounts(0);
            user.setFollowCounts(0);
            userService.saveUser(user);
        }else{
            return CslgJSONResult.errorMsg("用户名已经存在，请换一个再试");
        }
        //密码不返回前端
        user.setPassword("");
        return CslgJSONResult.ok(user);
    }

    @ApiOperation(value = "用户登录",notes = "用户登录的接口")
    @PostMapping("/login")
    public CslgJSONResult login(@RequestBody User user) throws Exception {

        String username = user.getUsername();
        String password = user.getPassword();
        //1.判断用户名和密码必须非空
        if(StringUtils.isBlank(user.getUsername())||StringUtils.isBlank(user.getPassword())){
            return CslgJSONResult.ok("用户名和密码不能为空...");
        }
        //2.判断用户名是否存在
        User userResult = userService.querUserForLogin(username,MD5Utils.getMD5Str(user.getPassword()));
        //3.返回信息
        if(userResult!=null){
            //密码不返回前端
            userResult.setPassword("");
            return CslgJSONResult.ok(userResult);
        }else{
            return CslgJSONResult.errorMsg("用户名和密码不正确，请重试...");
        }

    }
}
