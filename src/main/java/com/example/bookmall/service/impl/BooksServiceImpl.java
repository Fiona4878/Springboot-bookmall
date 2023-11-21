package com.example.bookmall.service.impl;

import com.example.bookmall.entity.Books;
import com.example.bookmall.entity.BooksExample;
import com.example.bookmall.mapper.BooksMapper;
import com.example.bookmall.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksServiceImpl implements BooksService {
    @Autowired
    private BooksMapper booksMapper;

    @Override
    public List getAllType() {
        List allType = booksMapper.getAllType();
        return allType;
    }

    @CachePut(cacheNames = "books", key = "#result.id")
    @Override
    public void addBooks(Books books) {
        booksMapper.insert(books);
        System.out.println("入库一本书");
    }

    @CacheEvict(cacheNames = "books")
    @Override
    public void removeBooks(int id) {
        booksMapper.deleteBook(id);
    }

    @CachePut(cacheNames = "books", key = "#result.id")
    @Override
    public void modifyBooks(Books emp) {
        booksMapper.insertBooks(emp);
    }

    @CachePut(cacheNames = "books", unless = "#result==null")
    @Override
    public void modifyBooksPrice(String price, Integer id) {
        System.out.println(id + " " + price);
        booksMapper.updateByPrice(price, id);
    }

    @Cacheable(cacheNames = "books", unless = "#result==null")
    @Override
    public List<Books> selectById(Integer id) {
        BooksExample booksExample = new BooksExample();
        BooksExample.Criteria criteria = booksExample.createCriteria();
        criteria.andIdEqualTo(id);
        List<Books> books = booksMapper.selectByExample(booksExample);
        return books;
    }

    @Override
    public List<Books> queryAll() {
        List<Books> books = booksMapper.selectAll();
        return books;
    }

    @Cacheable(cacheNames = "books", unless = "#result==null")
    @Override
    public List<Books> selectByKey(String name) {
        BooksExample booksExample = new BooksExample();
        BooksExample.Criteria criteria = booksExample.createCriteria();
        criteria.andTitleLike("%" + name + "%");
        List<Books> books = booksMapper.selectByExample(booksExample);
        return books;
    }

    @Override
    public List<Books> selectByType(String name) {
        BooksExample booksExample = new BooksExample();
        BooksExample.Criteria criteria = booksExample.createCriteria();
        criteria.andTypeEqualTo(name);
        List<Books> books = booksMapper.selectByExample(booksExample);
        return books;
    }

    @Override
    public List<Books> selectByAuthorId(Integer id) {
        BooksExample booksExample = new BooksExample();
        BooksExample.Criteria criteria = booksExample.createCriteria();
        criteria.andAuthoridEqualTo(id);
        List<Books> books = booksMapper.selectByExample(booksExample);
        return books;
    }

    @Override
    public List<Books> selectByPressId(Integer id) {
        BooksExample booksExample = new BooksExample();
        BooksExample.Criteria criteria = booksExample.createCriteria();
        criteria.andPressidEqualTo(id);
        List<Books> books = booksMapper.selectByExample(booksExample);
        return books;
    }

    @Cacheable(cacheNames = "books", unless = "#result==null")
    @Override
    public List<Books> selectByTB(String text) {
        BooksExample booksExample = new BooksExample();
        BooksExample.Criteria criteria = booksExample.createCriteria();
        criteria.andTitleLike("%" + text + "%");
        List<Books> books = booksMapper.selectByExample(booksExample);
        return books;
    }

    @Cacheable(cacheNames = "books", unless = "#result==null")
    @Override
    public Books selectByDetails(Integer id) {
        Books details = booksMapper.Booksdetails(id);
        return details;
    }

    @Override
    public List<Books> selectByPage(int pageIndex) {
        return null;
    }
}
