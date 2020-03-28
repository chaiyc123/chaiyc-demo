package com.chaiyc.springboot.mapper.subway;

import com.chaiyc.springboot.entities.subway.Subway;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SubwayMapper {

    /**
     * 分页查询
     * @return
     */
    List<Subway> getPageSubway();

    /**
     * 分页 条件 查询
     * @param subway
     * @return
     */
    List<Subway> getQueryPageSubway(Subway subway);

    /**
     *   添加 数据库
     * @param subway
     */
    void saveSubway(Subway subway);

    void updateUser(Subway subway);

    @Select(" select * from T_SUBWAY where dataId=#{dataId}")
    Subway getSubwayById(String dataId);

    /**
     * 通过Id 删除
     * @param dataId
     */
    @Delete("delete from T_SUBWAY where dataId=#{dataId}")
    void deleteSubwayById(String dataId);

}
