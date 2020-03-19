package com.chaiyc.springboot.mapper;

import com.chaiyc.springboot.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentMapper {

    @Select("select * FROM student")
    List<Student> findAll();
}
