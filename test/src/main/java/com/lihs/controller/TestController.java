package com.lihs.controller;

import com.lihs.entity.TestEntity;
import com.lihs.service.TestService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author hsli
 * @Date 2018/6/21 8:30:34
 */
@RestController
public class TestController {

    @Resource
    private TestService testService;

    @GetMapping("get/{id}")
    @ResponseBody
    public TestEntity get(String id){
        TestEntity testEntity = new TestEntity();
        testEntity.setId(id);
        try {
            return testService.get(testEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @GetMapping("list/")
    @ResponseBody
    public Object list(){
        try {
            return testService.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    @DeleteMapping("delete/{id}")
    public int delete(String id){
        TestEntity testEntity = new TestEntity();
        testEntity.setId(id);
        try {
            return testService.delete(testEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @PutMapping("add/{id}/{name}/{age}")
    public int add(TestEntity testEntity){
        try {
            return testService.add(testEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }



}
