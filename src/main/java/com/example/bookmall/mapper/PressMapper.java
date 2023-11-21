package com.example.bookmall.mapper;

import com.example.bookmall.entity.Press;
import com.example.bookmall.entity.PressExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface PressMapper {
    @Select("select * from press")
    public List<Press> getAll() ;

    long countByExample(PressExample example);

    int deleteByExample(PressExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Press record);

    int insertSelective(Press record);

    List<Press> selectByExampleWithBLOBs(PressExample example);

    List<Press> selectByExample(PressExample example);

    Press selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Press record, @Param("example") PressExample example);

    int updateByExampleWithBLOBs(@Param("record") Press record, @Param("example") PressExample example);

    int updateByExample(@Param("record") Press record, @Param("example") PressExample example);

    int updateByPrimaryKeySelective(Press record);

    int updateByPrimaryKeyWithBLOBs(Press record);

    int updateByPrimaryKey(Press record);
}