package com.example.bookmall.service.impl;

import com.example.bookmall.entity.Press;
import com.example.bookmall.mapper.PressMapper;
import com.example.bookmall.service.PressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PressServiceImpl implements PressService {
    @Autowired
    private PressMapper pressMapper;
    @Override
    public List<Press> getAllpress() {
        List<Press> all = pressMapper.getAll();
        return all;
    }
}
