package com.chaiyc.springboot.service.subway;

import com.chaiyc.springboot.entities.subway.Subway;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface SubwayService {

    /**
     * 分页查询
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageInfo<Subway> getPageSubway(int pageNo, int pageSize);

    /**
     * 导入excel数据到数据库
     * @param subway
     */
    void importSubway(Subway subway);

    /**
     * 查询数据
     * @return
     */
    List<Subway> getQuerySubway(Subway subway);

    /**
     * 添加
     * @param subway
     */
    void saveSubway(Subway subway);

    /**
     * 修改
     * @param subway
     */
    void updateUser(Subway subway);

    /**
     * 通过id 查找
     * @param dataId
     * @return
     */
    Subway getSubwayById(String dataId);

    void deleteSubwayById(String dataId);

    /**
     * 分页 条件查询
     * @param pageNo
     * @param pageSize
     * @param subway
     * @return
     */
    PageInfo<Subway> getQueryPageSubway(int pageNo, int pageSize, Subway subway);
}
