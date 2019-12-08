package cn.cslg.mapper;

import cn.cslg.pojo.Videos;
import cn.cslg.pojo.vo.VideosVO;
import cn.cslg.utils.MyMapper;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideosMapperCustom extends MyMapper<Videos> {

    public List<VideosVO> queryAllVideos(@Param("videoDesc") String videoDesc);
}