package cn.cslg.service;

import cn.cslg.pojo.Bgm;

import java.util.List;

public interface BgmService {

    /**
     * 查询bgm列表
     * @return
     */
    public List<Bgm> queryBgmList();

    /**
     * 根据Id查询bgm信息
     * @param bgmId
     * @return
     */
    public Bgm queryBgmById(String bgmId);
}
