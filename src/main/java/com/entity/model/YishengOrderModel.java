package com.entity.model;

import com.entity.YishengOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 医生挂号
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YishengOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 门诊号
     */
    private String yishengOrderUuidNumber;


    /**
     * 医生
     */
    private Integer yishengId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 挂号日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date guahaoTime;


    /**
     * 时间段
     */
    private Integer shijianduanTypes;


    /**
     * 挂号状态
     */
    private Integer yishengOrderTypes;


    /**
     * 备注
     */
    private String beizhuContent;


    /**
     * 挂号时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：门诊号
	 */
    public String getYishengOrderUuidNumber() {
        return yishengOrderUuidNumber;
    }


    /**
	 * 设置：门诊号
	 */
    public void setYishengOrderUuidNumber(String yishengOrderUuidNumber) {
        this.yishengOrderUuidNumber = yishengOrderUuidNumber;
    }
    /**
	 * 获取：医生
	 */
    public Integer getYishengId() {
        return yishengId;
    }


    /**
	 * 设置：医生
	 */
    public void setYishengId(Integer yishengId) {
        this.yishengId = yishengId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：挂号日期
	 */
    public Date getGuahaoTime() {
        return guahaoTime;
    }


    /**
	 * 设置：挂号日期
	 */
    public void setGuahaoTime(Date guahaoTime) {
        this.guahaoTime = guahaoTime;
    }
    /**
	 * 获取：时间段
	 */
    public Integer getShijianduanTypes() {
        return shijianduanTypes;
    }


    /**
	 * 设置：时间段
	 */
    public void setShijianduanTypes(Integer shijianduanTypes) {
        this.shijianduanTypes = shijianduanTypes;
    }
    /**
	 * 获取：挂号状态
	 */
    public Integer getYishengOrderTypes() {
        return yishengOrderTypes;
    }


    /**
	 * 设置：挂号状态
	 */
    public void setYishengOrderTypes(Integer yishengOrderTypes) {
        this.yishengOrderTypes = yishengOrderTypes;
    }
    /**
	 * 获取：备注
	 */
    public String getBeizhuContent() {
        return beizhuContent;
    }


    /**
	 * 设置：备注
	 */
    public void setBeizhuContent(String beizhuContent) {
        this.beizhuContent = beizhuContent;
    }
    /**
	 * 获取：挂号时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：挂号时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间 show3
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
