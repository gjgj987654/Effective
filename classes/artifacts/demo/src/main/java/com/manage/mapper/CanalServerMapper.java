package com.manage.mapper;

import com.manage.bean.CanalServerBean;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface CanalServerMapper {
    // 查询全部信息
    @Select("select * from receive_canal_server ")
    public List<CanalServerBean> findAllCanalServer();
    //查询单条信息
    @Select("select * from receive_canal_server where id=#{id}")
    public CanalServerBean findOneCanalServer(int id);
    //修改单条信息
    @Update("update receive_canal_server set ip=#{ip},port=#{port},destination=#{destination},username=#{username},password=#{password},isConsume=#{isConsume},inserttime=#{inserttime} where id=#{id} ")
    public void updateCanalServer(CanalServerBean canalServerBean);
    //删除单条信息
    @Delete("delete from receive_canal_server where id=#{id}")
    public Integer deleteCanalServer(@Param("id") int id);
    //添加单条信息
    @Insert("insert into receive_canal_server (ip,port,destination,username,password,isConsume,inserttime) values(#{ip}，#{port}，#{destination}，#{username}，#{password}，#{isConsume}，#{inserttime})")
    public void insertCanalServer(CanalServerBean canalServerBean);
}
