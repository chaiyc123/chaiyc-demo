package com.chaiyc.springboot.service.subway.impl;

import com.chaiyc.springboot.mapper.subway.SubwayMapper;
import com.chaiyc.springboot.service.subway.SubwayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubwayServiceImpl implements SubwayService {

    @Autowired
    SubwayMapper subwayMapper;


}
