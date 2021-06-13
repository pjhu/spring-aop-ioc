package com.pjhu.aopioc.aop;

import org.springframework.stereotype.Service;

@Service
public class MyCalculateService {

    public Integer add(Integer i, Integer j) {
        return i+j;
    }
}
