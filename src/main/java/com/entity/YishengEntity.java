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
 * 医生
 *
 * @author 
 * @email
 */
@TableName("yisheng")
public class YishengEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YishengEntity() {

	}

	public YishengEntity(T t) {
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
     * 医生编号
     */
    @TableField(value = "yisheng_uuid_number")

    private String yishengUuidNumber;


    /**
     * 医生名称
     */
    @TableField(value = "yisheng_name")

    private String yishengName;


    /**
     * 医生照片
     */
    @TableField(value = "yisheng_photo")

    private String yishengPhoto;


    /**
     * 科室
     */
    @TableField(value = "yisheng_types")

    private Integer yishengTypes;


    /**
     * 职位
     */
    @TableField(value = "zhiwei_types")

    private Integer zhiweiTypes;


    /**
     * 擅长
     */
    @TableField(value = "yisheng_shanchang")

    private String yishengShanchang;


    /**
     * 医生介绍
     */
    @TableField(value = "yisheng_content")

    private String yishengContent;


    /**
     * 是否上架
     */
    @TableField(value = "shangxia_types")

    private Integer shangxiaTypes;


    /**
     * 点击次数
     */
    @TableField(value = "yisheng_clicknum")

    private Integer yishengClicknum;


    /**
     * 逻辑删除
     */
    @TableField(value = "yisheng_delete")

    private Integer yishengDelete;


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
	 * 设置：医生编号
	 */
    public String getYishengUuidNumber() {
        return yishengUuidNumber;
    }


    /**
	 * 获取：医生编号
	 */

    public void setYishengUuidNumber(String yishengUuidNumber) {
        this.yishengUuidNumber = yishengUuidNumber;
    }
    /**
	 * 设置：医生名称
	 */
    public String getYishengName() {
        return yishengName;
    }


    /**
	 * 获取：医生名称
	 */

    public void setYishengName(String yishengName) {
        this.yishengName = yishengName;
    }
    /**
	 * 设置：医生照片
	 */
    public String getYishengPhoto() {
        return yishengPhoto;
    }


    /**
	 * 获取：医生照片
	 */

    public void setYishengPhoto(String yishengPhoto) {
        this.yishengPhoto = yishengPhoto;
    }
    /**
	 * 设置：科室
	 */
    public Integer getYishengTypes() {
        return yishengTypes;
    }


    /**
	 * 获取：科室
	 */

    public void setYishengTypes(Integer yishengTypes) {
        this.yishengTypes = yishengTypes;
    }
    /**
	 * 设置：职位
	 */
    public Integer getZhiweiTypes() {
        return zhiweiTypes;
    }


    /**
	 * 获取：职位
	 */

    public void setZhiweiTypes(Integer zhiweiTypes) {
        this.zhiweiTypes = zhiweiTypes;
    }
    /**
	 * 设置：擅长
	 */
    public String getYishengShanchang() {
        return yishengShanchang;
    }


    /**
	 * 获取：擅长
	 */

    public void setYishengShanchang(String yishengShanchang) {
        this.yishengShanchang = yishengShanchang;
    }
    /**
	 * 设置：医生介绍
	 */
    public String getYishengContent() {
        return yishengContent;
    }


    /**
	 * 获取：医生介绍
	 */

    public void setYishengContent(String yishengContent) {
        this.yishengContent = yishengContent;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 设置：点击次数
	 */
    public Integer getYishengClicknum() {
        return yishengClicknum;
    }


    /**
	 * 获取：点击次数
	 */

    public void setYishengClicknum(Integer yishengClicknum) {
        this.yishengClicknum = yishengClicknum;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getYishengDelete() {
        return yishengDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setYishengDelete(Integer yishengDelete) {
        this.yishengDelete = yishengDelete;
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
        return "Yisheng{" +
            "id=" + id +
            ", yishengUuidNumber=" + yishengUuidNumber +
            ", yishengName=" + yishengName +
            ", yishengPhoto=" + yishengPhoto +
            ", yishengTypes=" + yishengTypes +
            ", zhiweiTypes=" + zhiweiTypes +
            ", yishengShanchang=" + yishengShanchang +
            ", yishengContent=" + yishengContent +
            ", shangxiaTypes=" + shangxiaTypes +
            ", yishengClicknum=" + yishengClicknum +
            ", yishengDelete=" + yishengDelete +
            ", createTime=" + createTime +
        "}";
    }
}
