package com.chaiyc.springboot.mapper.study;

import com.chaiyc.springboot.bean.study.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface StudentMapper {

    @Select("select * FROM student")
    List<Student> findAll();
}
