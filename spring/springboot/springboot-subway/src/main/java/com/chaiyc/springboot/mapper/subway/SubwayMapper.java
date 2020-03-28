package com.chaiyc.springboot.mapper.subway;

import com.chaiyc.springboot.entities.subway.Subway;

import java.util.List;

public interface SubwayMapper {

    /**
     * 分页查询
     * @return
     */
    List<Subway> getPageSubway();

    /**
     * 导入 excel 数据到数据库
     * @param subway
     */
    void importSubway(Subway subway);

    /**
     * 查询数据
     * @return
     */
    List<Subway> getQuerySubway();
}
