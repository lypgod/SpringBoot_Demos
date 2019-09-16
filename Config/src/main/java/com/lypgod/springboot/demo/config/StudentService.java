package com.lypgod.springboot.demo.config;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author lypgod
 */
@Service
public class StudentService {
    public List likeName(String name) {
        if (name.equals("小明2")) return Arrays.asList(1, 2);
        if (name.equals("坏")) return Collections.emptyList();
        if (name.equals("莉莉")) return Arrays.asList(1, 2);
        return Collections.emptyList();
    }
}
