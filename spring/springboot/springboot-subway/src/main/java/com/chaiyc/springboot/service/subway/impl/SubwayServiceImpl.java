package com.chaiyc.springboot.service.subway.impl;

import com.chaiyc.springboot.entities.subway.Subway;
import com.chaiyc.springboot.mapper.subway.SubwayMapper;
import com.chaiyc.springboot.service.subway.SubwayService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubwayServiceImpl implements SubwayService {

    @Autowired
    SubwayMapper subwayMapper;


    @Override
    public PageInfo<Subway> getPageSubway(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        return new PageInfo<Subway>(subwayMapper.getPageSubway());
    }
}
