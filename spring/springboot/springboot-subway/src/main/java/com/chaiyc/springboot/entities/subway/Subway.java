package com.chaiyc.springboot.entities.subway;

/**
 * 地铁站检测数据信息实体类
 */

public class Subway {

    private Integer dataId;             //主键

    private String checkName;           //检查人姓名
    private String checkPhone;          //检查人电话
    private String checkStation;        //检查站点
    private String remark;              //备注
    private String createTime;          //创建时间

    public Integer getDataId() {
        return dataId;
    }

    public void setDataId(Integer dataId) {
        this.dataId = dataId;
    }

    public String getCheckName() {
        return checkName;
    }

    public void setCheckName(String checkName) {
        this.checkName = checkName;
    }

    public String getCheckPhone() {
        return checkPhone;
    }

    public void setCheckPhone(String checkPhone) {
        this.checkPhone = checkPhone;
    }

    public String getCheckStation() {
        return checkStation;
    }

    public void setCheckStation(String checkStation) {
        this.checkStation = checkStation;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
