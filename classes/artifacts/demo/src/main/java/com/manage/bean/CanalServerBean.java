package com.manage.bean;

import java.util.Date;

public class CanalServerBean {
    private Integer id;
    private String ip;
    private Integer port;
    private String destination;
    private String username;
    private String password;
    private Boolean isConsume;
    private Date inserttime;
    
    public CanalServerBean(){
        super();
    }
    
    @Override
    public String toString() {
        return "CanalServerBean{" +
               "id=" + id +
               ", ip='" + ip + '\'' +
               ", port=" + port +
               ", destination='" + destination + '\'' +
               ", username='" + username + '\'' +
               ", password='" + password + '\'' +
               ", isConsume=" + isConsume +
               ", inserttime=" + inserttime +
               '}';
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getIp() {
        return ip;
    }
    
    public void setIp(String ip) {
        this.ip = ip;
    }
    
    public Integer getPort() {
        return port;
    }
    
    public void setPort(Integer port) {
        this.port = port;
    }
    
    public String getDestination() {
        return destination;
    }
    
    public void setDestination(String destination) {
        this.destination = destination;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public Boolean getConsume() {
        return isConsume;
    }
    
    public void setConsume(Boolean consume) {
        isConsume = consume;
    }
    
    public Date getInserttime() {
        return inserttime;
    }
    
    public void setInserttime(Date inserttime) {
        this.inserttime = inserttime;
    }
}
