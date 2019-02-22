package com.manage.controller;

import com.manage.bean.CanalServerBean;
import com.manage.service.CanalServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CanalServerController {
    @Autowired
    CanalServerService canalServerService;
    
    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    public List<CanalServerBean> selectAllCanalServer(){
        List<CanalServerBean> list = canalServerService.findAllCanalServer();
        System.out.println(list);
        return list;
    }
    
}
