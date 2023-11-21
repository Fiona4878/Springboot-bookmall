package com.example.bookmall.service.impl;

import com.example.bookmall.entity.Author;
import com.example.bookmall.entity.AuthorExample;
import com.example.bookmall.mapper.AuthorMapper;
import com.example.bookmall.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorMapper authorMapper;

    @CachePut(cacheNames = "author",key = "#result.id")
    @Override
    public void addAuthor(Author author) {
        authorMapper.insert(author);
    }

    @CacheEvict(cacheNames = "author")
    @Override
    public void removeAuthor(int id) {
        authorMapper.deleteByPrimaryKey(id);
    }
//    mybatis通过逆向工程来生成example类，example用于添加条件，这就相当于where条件后面的
//
//    xxxExample example=new XXXExample();
//
//    Criteria criteria=new Example().createrCriteria();

    @CachePut(cacheNames = "author",key = "#result.id")
    @Override
    public void modifyAuthor(Author author) {
        authorMapper.updateByPrimaryKeySelective(author);
    }

    @Override
    public List<Author> queryAll() {
        List<Author> authors = authorMapper.selectAll();
        return authors;
    }

    @Cacheable(cacheNames = "author",unless = "#result==null")
    @Override
    public List<Author> selectByKey(String name) {
        AuthorExample example=new AuthorExample();
        AuthorExample.Criteria criteria=example.createCriteria();
        example.setOrderByClause("ID asc");
        criteria.andAuthorLike("%"+name+"%");
        List<Author> authors = authorMapper.selectByExample(example);
        return authors;
    }

    @Cacheable(cacheNames = "author",unless = "#result==null")
    @Override
    public List<Author> selectByPage(int pageIndex) {
        return null;
    }

    @Cacheable(cacheNames = "author",unless = "#result==null")
    @Override
    public List<Author> getAllAuthor() {
        List<Author> allAuthor = authorMapper.selectAll();
        return allAuthor;
    }
}
