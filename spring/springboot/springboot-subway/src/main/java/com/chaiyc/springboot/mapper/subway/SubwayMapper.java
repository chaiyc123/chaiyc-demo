package com.chaiyc.springboot.mapper.subway;

import com.chaiyc.springboot.entities.subway.Subway;

import java.util.List;

public interface SubwayMapper {

    /**
     * 分页查询
     * @return
     */
    List<Subway> getPageSubway();
}
