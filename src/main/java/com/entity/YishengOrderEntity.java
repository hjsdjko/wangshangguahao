package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 医生挂号
 *
 * @author 
 * @email
 */
@TableName("yisheng_order")
public class YishengOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YishengOrderEntity() {

	}

	public YishengOrderEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 门诊号
     */
    @TableField(value = "yisheng_order_uuid_number")

    private String yishengOrderUuidNumber;


    /**
     * 医生
     */
    @TableField(value = "yisheng_id")

    private Integer yishengId;


    /**
     * 用户
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 挂号日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "guahao_time")

    private Date guahaoTime;


    /**
     * 时间段
     */
    @TableField(value = "shijianduan_types")

    private Integer shijianduanTypes;


    /**
     * 挂号状态
     */
    @TableField(value = "yisheng_order_types")

    private Integer yishengOrderTypes;


    /**
     * 备注
     */
    @TableField(value = "beizhu_content")

    private String beizhuContent;


    /**
     * 挂号时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：门诊号
	 */
    public String getYishengOrderUuidNumber() {
        return yishengOrderUuidNumber;
    }


    /**
	 * 获取：门诊号
	 */

    public void setYishengOrderUuidNumber(String yishengOrderUuidNumber) {
        this.yishengOrderUuidNumber = yishengOrderUuidNumber;
    }
    /**
	 * 设置：医生
	 */
    public Integer getYishengId() {
        return yishengId;
    }


    /**
	 * 获取：医生
	 */

    public void setYishengId(Integer yishengId) {
        this.yishengId = yishengId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：挂号日期
	 */
    public Date getGuahaoTime() {
        return guahaoTime;
    }


    /**
	 * 获取：挂号日期
	 */

    public void setGuahaoTime(Date guahaoTime) {
        this.guahaoTime = guahaoTime;
    }
    /**
	 * 设置：时间段
	 */
    public Integer getShijianduanTypes() {
        return shijianduanTypes;
    }


    /**
	 * 获取：时间段
	 */

    public void setShijianduanTypes(Integer shijianduanTypes) {
        this.shijianduanTypes = shijianduanTypes;
    }
    /**
	 * 设置：挂号状态
	 */
    public Integer getYishengOrderTypes() {
        return yishengOrderTypes;
    }


    /**
	 * 获取：挂号状态
	 */

    public void setYishengOrderTypes(Integer yishengOrderTypes) {
        this.yishengOrderTypes = yishengOrderTypes;
    }
    /**
	 * 设置：备注
	 */
    public String getBeizhuContent() {
        return beizhuContent;
    }


    /**
	 * 获取：备注
	 */

    public void setBeizhuContent(String beizhuContent) {
        this.beizhuContent = beizhuContent;
    }
    /**
	 * 设置：挂号时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：挂号时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "YishengOrder{" +
            "id=" + id +
            ", yishengOrderUuidNumber=" + yishengOrderUuidNumber +
            ", yishengId=" + yishengId +
            ", yonghuId=" + yonghuId +
            ", guahaoTime=" + guahaoTime +
            ", shijianduanTypes=" + shijianduanTypes +
            ", yishengOrderTypes=" + yishengOrderTypes +
            ", beizhuContent=" + beizhuContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
