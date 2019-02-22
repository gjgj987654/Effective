package com.manage.service;

import com.manage.bean.CanalServerBean;
import com.manage.mapper.CanalServerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CanalServerService {
    @Autowired
    private CanalServerMapper canalServerMapper;
    
    public List<CanalServerBean> findAllCanalServer(){
        List<CanalServerBean> list = canalServerMapper.findAllCanalServer();
        return list;
    }
    
    public CanalServerBean findOneCanalServer(int id){
        CanalServerBean canalServerBean=canalServerMapper.findOneCanalServer(id);
        return canalServerBean;
    }
    
    public void InsertCanalServer(CanalServerBean canalServerBean){
        canalServerMapper.insertCanalServer(canalServerBean);
    }
    
    public void UpdateCanalServer(CanalServerBean canalServerBean){
        canalServerMapper.updateCanalServer(canalServerBean);
    } 
    
    public void DeleteCanalServer(int id){
        canalServerMapper.deleteCanalServer(id);
    }
}
