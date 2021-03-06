package cn.cslg.controller;

import cn.cslg.utils.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

    @Autowired
    public RedisOperator redis;

    public static final  String USER_REDIS_SESSION = "user-redis-session";

    //文件保存的命名空间
    public static final String FILE_SPACE = "C:/cslg_video";

    //ffmpeg所在目录
    public static final String FFMPEG_EXE = "C:\\ffmpeg\\bin\\ffmpeg.exe";

    //分页每页显示条目数
    public static final Integer PAGE_SIZE = 5;
}
