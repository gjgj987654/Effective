package com.manage.mapper;

import com.manage.bean.CanalServerBean;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface CanalTableMapper {
    // 查询全部信息
    @Select("select * from receive_canal_table ")
    public List<CanalServerBean> findAllCanalTable();
    //查询单条信息
    @Select("select * from receive_canal_table where id=#{id}")
    public CanalServerBean findOneCanalTable(int id);
    //修改单条信息
    @Update("update receive_canal_table set canalid=#{canalid},canalDbName=#{canalDbName},canalTableName=#{canalTableName},clientDbName=#{clientDbName},clientTableName=#{clientTableName},isConsume=#{isConsume},inserttime=#{inserttime} where id=#{id} ")
    public void updateCanalTable(CanalServerBean canalServerBean);
    //删除单条信息
    @Delete("delete from receive_canal_table where id=#{id}")
    public Integer deleteCanalTable(@Param("id") int id);
    //添加单条信息
    @Insert("insert into receive_canal_table (canalid,canalDbName,canalTableName,clientDbName,clientTableName,isConsume,inserttime) values(#{canalid}，#{canalDbName}，#{canalTableName}，#{clientDbName}，#{clientTableName}，#{isConsume}，#{inserttime})")
    public void insertCanalTable(CanalServerBean canalServerBean);
    
}
