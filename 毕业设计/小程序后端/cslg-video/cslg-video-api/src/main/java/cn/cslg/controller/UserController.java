package cn.cslg.controller;

import cn.cslg.pojo.User;
import cn.cslg.pojo.vo.UserVO;
import cn.cslg.service.UserService;
import cn.cslg.utils.CslgJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
@Api(value = "用户相关业务的接口",tags={"用户相关业务的controller"})
@RequestMapping("/user")
public class UserController extends BasicController{

    @Autowired
    private UserService userService;


    @ApiOperation(value = "用户上传头像",notes = "用户上传头像的接口")
    @ApiImplicitParam(name="userId",value = "用户id",required = true,dataType = "String",paramType = "query")
    @PostMapping("/uploadFace")
    public CslgJSONResult uploadFace
            (String userId,
             @RequestParam("file") MultipartFile[] files) throws Exception {
        if(StringUtils.isBlank(userId)){
            return CslgJSONResult.errorMsg("用户id不能为空...");
        }
        //文件保存的命名空间
        String fileSpace = "C:/cslg_video";
        //保存到数据库中的相对路径
        String uploadPathDB = "/" + userId + "/face";
        FileOutputStream fileOutputStream = null;
        try {
            if(files != null && files.length > 0){

                InputStream inputStream =null;
                //获取上传时文件名
                String fileName = files[0].getOriginalFilename();
                if(StringUtils.isNotBlank(fileName)){
                    //文件上次最终保存路径
                    String finalFacePath = fileSpace + uploadPathDB + "/" + fileName;
                    //设置数据库保存路径
                    uploadPathDB += ("/" + fileName);

                    File outFile = new File(finalFacePath);
                    //是否有父文件夹以及是否有自身文件夹
                    if(outFile.getParentFile()!=null||!outFile.getParentFile().isDirectory()){
                        //创建父文件夹
                        outFile.getParentFile().mkdirs();
                    }
                    fileOutputStream = new FileOutputStream(outFile);
                    inputStream = files[0].getInputStream();
                    IOUtils.copy(inputStream,fileOutputStream);
                }
            }else{
                return CslgJSONResult.errorMsg("上传出错...");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return CslgJSONResult.errorMsg("上传出错...");
        } finally {
            if(fileOutputStream !=null){
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        }
        //路径保存至数据库
        User user = new User();
        user.setId(userId);
        user.setFaceImage(uploadPathDB);
        userService.updateUserInfo(user);
        return CslgJSONResult.ok(uploadPathDB);
    }

    @ApiOperation(value = "查询用户信息",notes = "查询用户信息的接口")
    @ApiImplicitParam(name="userId",value = "用户id",required = true,dataType = "String",paramType = "query")
    @PostMapping("/query")
    public CslgJSONResult query(String userId) throws Exception {
        if(StringUtils.isBlank(userId)){
            return CslgJSONResult.errorMsg("用户id不能为空...");
        }
;
        User userInfo = userService.queryUserInfo(userId);
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userInfo,userVO);

        return CslgJSONResult.ok(userVO);
    }
}
