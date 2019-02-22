package com.manage.service;

import com.manage.bean.CanalServerBean;
import com.manage.mapper.CanalTableMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CanalTableService {
    @Autowired
    private CanalTableMapper canalTableMapper;
    
    public List<CanalServerBean> findAllCanalTable(){
        List<CanalServerBean> list = canalTableMapper.findAllCanalTable();
        return list;
    }
    
    public CanalServerBean findOneCanalTable(int id){
        CanalServerBean canalServerBean=canalTableMapper.findOneCanalTable(id);
        return canalServerBean;
    }
    
    public void InsertCanalTable(CanalServerBean canalServerBean){
        canalTableMapper.insertCanalTable(canalServerBean);
    }
    
    public void UpdateCanalTable(CanalServerBean canalServerBean){
        canalTableMapper.updateCanalTable(canalServerBean);
    }
    
    public void DeleteCanalTable(int id){
        canalTableMapper.deleteCanalTable(id);
    }
}
