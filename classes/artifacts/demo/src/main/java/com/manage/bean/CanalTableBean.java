package com.manage.bean;

import javax.xml.crypto.Data;

public class CanalTableBean {
    private Integer id;
    private Integer canalid;
    private String  canalDbName;
    private String  canalTableName;
    private String  clientDbName;
    private String  clientTableName;
    private Boolean isConsume;
    private Data inserttime;
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getCanalid() {
        return canalid;
    }
    
    public void setCanalid(Integer canalid) {
        this.canalid = canalid;
    }
    
    public String getCanalDbName() {
        return canalDbName;
    }
    
    public void setCanalDbName(String canalDbName) {
        this.canalDbName = canalDbName;
    }
    
    public String getCanalTableName() {
        return canalTableName;
    }
    
    public void setCanalTableName(String canalTableName) {
        this.canalTableName = canalTableName;
    }
    
    public String getClientDbName() {
        return clientDbName;
    }
    
    public void setClientDbName(String clientDbName) {
        this.clientDbName = clientDbName;
    }
    
    public String getClientTableName() {
        return clientTableName;
    }
    
    public void setClientTableName(String clientTableName) {
        this.clientTableName = clientTableName;
    }
    
    public Boolean getConsume() {
        return isConsume;
    }
    
    public void setConsume(Boolean consume) {
        isConsume = consume;
    }
    
    public Data getInserttime() {
        return inserttime;
    }
    
    public void setInserttime(Data inserttime) {
        this.inserttime = inserttime;
    }
    
    @Override
    public String toString() {
        return "CanalTableBean{" +
               "id=" + id +
               ", canalid=" + canalid +
               ", canalDbName='" + canalDbName + '\'' +
               ", canalTableName='" + canalTableName + '\'' +
               ", clientDbName='" + clientDbName + '\'' +
               ", clientTableName='" + clientTableName + '\'' +
               ", isConsume=" + isConsume +
               ", inserttime=" + inserttime +
               '}';
    }
}
