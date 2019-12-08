package cn.cslg.controller;

import cn.cslg.service.BgmService;
import cn.cslg.utils.CslgJSONResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api(value = "背景音乐业务的接口",tags ={"背景音乐业务的controller"})
@RestController
@RequestMapping("/bgm")
public class BgmController {

    @Autowired
    private BgmService bgmService;
    @PostMapping("/list")
    public CslgJSONResult list() {

        return  CslgJSONResult.ok(bgmService.queryBgmList());
    }

}

