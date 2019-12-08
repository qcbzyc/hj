package cn.cslg.service;

import cn.cslg.pojo.Bgm;
import cn.cslg.pojo.Videos;
import cn.cslg.utils.PagedResult;

import java.util.List;

public interface VideoService {

    /**
     * 保存视频
     * @param video
     * @return
     */
    public String saveVideo(Videos video);

    /**
     * 修改视频的封面
     * @param videoId
     * @param coverPath
     * @return
     */
    public void updateVideo(String videoId,String coverPath);

    /**
     * 分页查询列表
     * @param page
     * @param pageSize
     * @return
     */
    public PagedResult getAllVideos(Videos video, Integer isSaveRecord,Integer page,Integer pageSize);

    /**
     * 获取热搜词列表
     * @return
     */
    public List<String> getHotwords();


}
