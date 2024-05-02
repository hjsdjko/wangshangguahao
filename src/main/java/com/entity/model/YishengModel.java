package com.entity.model;

import com.entity.YishengEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 医生
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YishengModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 医生编号
     */
    private String yishengUuidNumber;


    /**
     * 医生名称
     */
    private String yishengName;


    /**
     * 医生照片
     */
    private String yishengPhoto;


    /**
     * 科室
     */
    private Integer yishengTypes;


    /**
     * 职位
     */
    private Integer zhiweiTypes;


    /**
     * 擅长
     */
    private String yishengShanchang;


    /**
     * 医生介绍
     */
    private String yishengContent;


    /**
     * 是否上架
     */
    private Integer shangxiaTypes;


    /**
     * 点击次数
     */
    private Integer yishengClicknum;


    /**
     * 逻辑删除
     */
    private Integer yishengDelete;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：医生编号
	 */
    public String getYishengUuidNumber() {
        return yishengUuidNumber;
    }


    /**
	 * 设置：医生编号
	 */
    public void setYishengUuidNumber(String yishengUuidNumber) {
        this.yishengUuidNumber = yishengUuidNumber;
    }
    /**
	 * 获取：医生名称
	 */
    public String getYishengName() {
        return yishengName;
    }


    /**
	 * 设置：医生名称
	 */
    public void setYishengName(String yishengName) {
        this.yishengName = yishengName;
    }
    /**
	 * 获取：医生照片
	 */
    public String getYishengPhoto() {
        return yishengPhoto;
    }


    /**
	 * 设置：医生照片
	 */
    public void setYishengPhoto(String yishengPhoto) {
        this.yishengPhoto = yishengPhoto;
    }
    /**
	 * 获取：科室
	 */
    public Integer getYishengTypes() {
        return yishengTypes;
    }


    /**
	 * 设置：科室
	 */
    public void setYishengTypes(Integer yishengTypes) {
        this.yishengTypes = yishengTypes;
    }
    /**
	 * 获取：职位
	 */
    public Integer getZhiweiTypes() {
        return zhiweiTypes;
    }


    /**
	 * 设置：职位
	 */
    public void setZhiweiTypes(Integer zhiweiTypes) {
        this.zhiweiTypes = zhiweiTypes;
    }
    /**
	 * 获取：擅长
	 */
    public String getYishengShanchang() {
        return yishengShanchang;
    }


    /**
	 * 设置：擅长
	 */
    public void setYishengShanchang(String yishengShanchang) {
        this.yishengShanchang = yishengShanchang;
    }
    /**
	 * 获取：医生介绍
	 */
    public String getYishengContent() {
        return yishengContent;
    }


    /**
	 * 设置：医生介绍
	 */
    public void setYishengContent(String yishengContent) {
        this.yishengContent = yishengContent;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 设置：是否上架
	 */
    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：点击次数
	 */
    public Integer getYishengClicknum() {
        return yishengClicknum;
    }


    /**
	 * 设置：点击次数
	 */
    public void setYishengClicknum(Integer yishengClicknum) {
        this.yishengClicknum = yishengClicknum;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getYishengDelete() {
        return yishengDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setYishengDelete(Integer yishengDelete) {
        this.yishengDelete = yishengDelete;
    }
    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
