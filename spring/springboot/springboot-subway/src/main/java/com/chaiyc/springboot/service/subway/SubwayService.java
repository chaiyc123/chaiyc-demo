package com.chaiyc.springboot.service.subway;

import com.chaiyc.springboot.entities.subway.Subway;
import com.github.pagehelper.PageInfo;

public interface SubwayService {

    /**
     * 分页查询
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageInfo<Subway> getPageSubway(int pageNo, int pageSize);
}
