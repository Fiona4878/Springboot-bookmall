package com.example.bookmall.mapper;

import com.example.bookmall.entity.Books;
import com.example.bookmall.entity.BooksExample;

import java.util.List;

import org.apache.ibatis.annotations.*;
import org.springframework.cache.annotation.Cacheable;

@Mapper
public interface BooksMapper {

    @Select("select books.* ,author.Nation,author.Author,press.Press from books,author,press where books.authorid=author.ID and books.pressid=press.ID")
    List<Books> selectAll();

    @Select("select distinct(Type) from books")
    public List<Books> getAllType();

    @Select("select books.* ,author.Nation,author.Author,press.Press from books,author,press where books.authorid=author.ID and books.pressid=press.ID and books.ID=#{id}")
    Books Booksdetails(Integer id);

    @Insert("insert into book(Type,Title,Pages,Brief,authorid,pressid)" +
            "values(#{type},#{title},#{pages},#{brief},#{authorid},#{pressid})")
    public void insertBooks(Books books);

    @Delete("delete  from books where id=#{id}")
    void deleteBook(Integer id);

    @Update("update books set Price=#{price} where ID=#{id}")
    void updateByPrice(String price, Integer id);

    long countByExample(BooksExample example);

    int deleteByExample(BooksExample example);

    int deleteByPrimaryKey(@Param("id") Integer id, @Param("title") String title);

    int insert(Books record);

    int insertSelective(Books record);

    List<Books> selectByExampleWithBLOBs(BooksExample example);

    List<Books> selectByExample(BooksExample example);

    Books selectByPrimaryKey(@Param("id") Integer id, @Param("title") String title);

    int updateByExampleSelective(@Param("record") Books record, @Param("example") BooksExample example);

    int updateByExampleWithBLOBs(@Param("record") Books record, @Param("example") BooksExample example);

    int updateByExample(@Param("record") Books record, @Param("example") BooksExample example);

    int updateByPrimaryKeySelective(Books record);

    int updateByPrimaryKeyWithBLOBs(Books record);

    int updateByPrimaryKey(Books record);
}