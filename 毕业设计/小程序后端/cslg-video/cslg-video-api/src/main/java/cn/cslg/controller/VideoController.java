package cn.cslg.controller;

import cn.cslg.enums.VideoStatusEnum;
import cn.cslg.pojo.Bgm;
import cn.cslg.pojo.Videos;
import cn.cslg.service.BgmService;
import cn.cslg.service.VideoService;
import cn.cslg.utils.CslgJSONResult;
import cn.cslg.utils.FetchVideoCover;
import cn.cslg.utils.MergeVideoMp3;
import cn.cslg.utils.PagedResult;
import io.swagger.annotations.*;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static cn.cslg.controller.BasicController.FFMPEG_EXE;
import static cn.cslg.controller.BasicController.FILE_SPACE;
import static cn.cslg.controller.BasicController.PAGE_SIZE;

@Api(value = "视频相关业务的接口",tags ={"视频相关业务的controller"})
@RestController
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private BgmService bgmService;

    @Autowired
    private VideoService videoService;

    @ApiOperation(value = "上传视频",notes = "上传视频的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name="userId",value = "用户id",required = true,dataType = "String",paramType = "form"),
            @ApiImplicitParam(name="bgmId",value = "bgmid",required = false,dataType = "String",paramType = "form"),
            @ApiImplicitParam(name="videoSeconds",value = "视频时间",required = true,dataType = "double",paramType = "form"),
            @ApiImplicitParam(name="videoWidth",value = "视频宽度",required = true,dataType = "int",paramType = "form"),
            @ApiImplicitParam(name="videoHeight",value = "视频高度",required = true,dataType = "int",paramType = "form"),
            @ApiImplicitParam(name="desc",value = "视频描述",required = false,dataType = "String",paramType = "form")
    })
    @PostMapping(value = "/upload",headers = "content-type=multipart/form-data")
    public CslgJSONResult upload
            (String userId,String bgmId,double videoSeconds,int videoWidth,
             int videoHeight,String desc,
             @ApiParam(value = "短视频",required = true) MultipartFile file) throws Exception {
        if(StringUtils.isBlank(userId)){
            return CslgJSONResult.errorMsg("用户id不能为空...");
        }

        //保存到数据库中的相对路径
        String uploadPathDB = "/" + userId + "/video";
        String coverPathDB = "/" + userId + "/video";
        FileOutputStream fileOutputStream = null;

        //文件上次最终保存路径
        String finalVideoPath = "";
        try {
            if(file != null ){

                InputStream inputStream =null;
                //获取上传时文件名
                String fileName = file.getOriginalFilename();

                //封面图片名
                String fileNamePrefix = fileName.split("\\.")[2];

                if(StringUtils.isNotBlank(fileName)){
                    //文件上次最终保存路径
                    finalVideoPath = FILE_SPACE  + uploadPathDB + "/" + fileName;
                    //设置数据库保存路径
                    uploadPathDB += ("/" + fileName);

                    //封面图片保存路径
                    coverPathDB = coverPathDB + "/" + fileNamePrefix + ".jpg";

                    File outFile = new File(finalVideoPath);
                    //是否有父文件夹以及是否有自身文件夹
                    if(outFile.getParentFile()!=null||!outFile.getParentFile().isDirectory()){
                        //创建父文件夹
                        outFile.getParentFile().mkdirs();
                    }
                    fileOutputStream = new FileOutputStream(outFile);
                    inputStream = file.getInputStream();
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

        //判断bgmId是否为空，如果不空，那就查询选中的BGM，并合并产生新的视频
        if(StringUtils.isNotBlank(bgmId)){
            Bgm bgm = bgmService.queryBgmById(bgmId);
            String mp3InputPath = FILE_SPACE +bgm.getPath();

            MergeVideoMp3 tool = new MergeVideoMp3(FFMPEG_EXE);
            String videoInputPath = finalVideoPath;

            String videoOutputName = UUID.randomUUID().toString()+".mp4";
            //保存到数据库中的相对路径
            uploadPathDB = "/" + userId + "/video" + "/" + videoOutputName;
            finalVideoPath = FILE_SPACE + uploadPathDB;
            tool.convertor(videoInputPath,mp3InputPath,videoSeconds,finalVideoPath);
        }

        //对视频进行截图
        FetchVideoCover videoInfo = new FetchVideoCover(FFMPEG_EXE);
        videoInfo.getCover(finalVideoPath,FILE_SPACE + coverPathDB);


        //视频路径保存至数据库
        Videos video = new Videos();
        video.setAudioId(bgmId);
        video.setUserId(userId);
        video.setVideoSeconds((float)videoSeconds);
        video.setVideoHeight(videoHeight);
        video.setVideoWidth(videoWidth);
        video.setVideoDesc(desc);
        video.setVideoPath(uploadPathDB);
        video.setCoverPath(coverPathDB);
        video.setStatus(VideoStatusEnum.SUCCESS.value);
        video.setCreateTime(new Date());

        String videoId = videoService.saveVideo(video);

        return CslgJSONResult.ok( videoId );
    }


    @ApiOperation(value = "上传封面",notes = "上传封面的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name="userId",value = "用户id",required = true,dataType = "String",paramType = "form"),
            @ApiImplicitParam(name="videoId",value = "视频主键id",required = true,dataType = "String",paramType = "form")
    })
    @PostMapping(value = "/uploadCover",headers = "content-type=multipart/form-data")
    public CslgJSONResult upload
            (String userId,String videoId,
             @ApiParam(value = "视频封面",required = true) MultipartFile file) throws Exception {
        if(StringUtils.isBlank(userId)||StringUtils.isBlank(videoId)){
            return CslgJSONResult.errorMsg("用户id和视频主键id不能为空...");
        }

        //保存到数据库中的相对路径
        String uploadPathDB = "/" + userId + "/video";

        FileOutputStream fileOutputStream = null;

        //文件上次最终保存路径
        String finalCoverPath = "";
        try {
            if(file != null ){

                InputStream inputStream =null;
                //获取上传时文件名
                String fileName = file.getOriginalFilename();



                if(StringUtils.isNotBlank(fileName)){
                    //文件上次最终保存路径
                    finalCoverPath = FILE_SPACE  + uploadPathDB + "/" + fileName;
                    //设置数据库保存路径
                    uploadPathDB += ("/" + fileName);

                    File outFile = new File(finalCoverPath);
                    //是否有父文件夹以及是否有自身文件夹
                    if(outFile.getParentFile()!=null||!outFile.getParentFile().isDirectory()){
                        //创建父文件夹
                        outFile.getParentFile().mkdirs();
                    }
                    fileOutputStream = new FileOutputStream(outFile);
                    inputStream = file.getInputStream();
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

        videoService.updateVideo(videoId,uploadPathDB);

        return CslgJSONResult.ok();
    }

    /**
     * 分页和搜索查询列表
     * @param video
     * @param isSaveRecord：1 - 需要保存
     *                      2 - 不需要保存
     * @param page
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/showAll")
    public CslgJSONResult showAll(@RequestBody Videos video, Integer isSaveRecord,
                                  Integer page) throws Exception {

        if(page == null){
            page = 1;
        }

        PagedResult result = videoService.getAllVideos(video,isSaveRecord,page,PAGE_SIZE);
        return CslgJSONResult.ok(result);
    }

    /**
     * 返回热搜词
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/hot")
    public CslgJSONResult hot() throws Exception {
        List<String> result = videoService.getHotwords();
        return CslgJSONResult.ok(result);
    }
}

