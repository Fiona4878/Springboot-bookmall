package com.example.bookmall.mapper;

import com.example.bookmall.entity.Orders;
import com.example.bookmall.entity.OrdersExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OrdersMapper {
    @Select("select orders.*,u.username ,b.Title,b.Price from orders,user u,books b where bookid=b.ID and userid=u.id;")
    List<Map> quarryAll();

    @Select("select orders.*,u.username ,b.Title,b.Price from orders,user u,books b where bookid=b.ID and userid=u.id and userid=#{id};")
    List<Map> queryAllByUid(Integer id);
    @Select("select orders.*,u.username ,b.Title,b.Price from orders,user u,books b where bookid=b.ID and userid=u.id and (u.username=#{name} or b.Title=#{name});")
    public List<Map> queryAllByUname(String name);

    long countByExample(OrdersExample example);

    int deleteByExample(OrdersExample example);

    int deleteByPrimaryKey(Integer orderid);

    int insert(Orders record);

    int insertSelective(Orders record);

    List<Orders> selectByExample(OrdersExample example);

    Orders selectByPrimaryKey(Integer orderid);

    int updateByExampleSelective(@Param("record") Orders record, @Param("example") OrdersExample example);

    int updateByExample(@Param("record") Orders record, @Param("example") OrdersExample example);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);
}