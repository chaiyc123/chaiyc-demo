package com.chaiyc.springboot.service.subway.impl;

import com.chaiyc.springboot.entities.subway.Subway;
import com.chaiyc.springboot.mapper.subway.SubwayMapper;
import com.chaiyc.springboot.service.subway.SubwayService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubwayServiceImpl implements SubwayService {

    @Autowired
    SubwayMapper subwayMapper;


    @Override
    public PageInfo<Subway> getPageSubway(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        return new PageInfo<Subway>(subwayMapper.getPageSubway());
    }

    @Override
    public void importSubway(Subway subway) {
        subwayMapper.saveSubway(subway);
    }

    @Override
    public List<Subway> getQuerySubway(Subway subway) {
        return subwayMapper.getQueryPageSubway(subway);
    }

    @Override
    public void saveSubway(Subway subway) {
        subwayMapper.saveSubway(subway);
    }

    @Override
    public void updateUser(Subway subway) {
        subwayMapper.updateUser(subway);
    }

    @Override
    public Subway getSubwayById(String dataId) {
        return subwayMapper.getSubwayById(dataId);
    }

    @Override
    public void deleteSubwayById(String dataId) {
        subwayMapper.deleteSubwayById(dataId);
    }

    @Override
    public PageInfo<Subway> getQueryPageSubway(int pageNo, int pageSize, Subway subway) {
        PageHelper.startPage(pageNo,pageSize);
        return new PageInfo<Subway>(subwayMapper.getQueryPageSubway(subway));
    }
}
