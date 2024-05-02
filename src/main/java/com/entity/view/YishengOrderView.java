package com.entity.view;

import com.entity.YishengOrderEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 医生挂号
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("yisheng_order")
public class YishengOrderView extends YishengOrderEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 时间段的值
		*/
		private String shijianduanValue;
		/**
		* 挂号状态的值
		*/
		private String yishengOrderValue;



		//级联表 yisheng
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
				* 科室的值
				*/
				private String yishengValue;
			/**
			* 职位
			*/
			private Integer zhiweiTypes;
				/**
				* 职位的值
				*/
				private String zhiweiValue;
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
				* 是否上架的值
				*/
				private String shangxiaValue;
			/**
			* 点击次数
			*/
			private Integer yishengClicknum;
			/**
			* 逻辑删除
			*/
			private Integer yishengDelete;

		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 用户手机号
			*/
			private String yonghuPhone;
			/**
			* 用户身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 用户头像
			*/
			private String yonghuPhoto;
			/**
			* 是否使用
			*/
			private Integer shiyongTypes;
				/**
				* 是否使用的值
				*/
				private String shiyongValue;
			/**
			* 电子邮箱
			*/
			private String yonghuEmail;

	public YishengOrderView() {

	}

	public YishengOrderView(YishengOrderEntity yishengOrderEntity) {
		try {
			BeanUtils.copyProperties(this, yishengOrderEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 时间段的值
			*/
			public String getShijianduanValue() {
				return shijianduanValue;
			}
			/**
			* 设置： 时间段的值
			*/
			public void setShijianduanValue(String shijianduanValue) {
				this.shijianduanValue = shijianduanValue;
			}
			/**
			* 获取： 挂号状态的值
			*/
			public String getYishengOrderValue() {
				return yishengOrderValue;
			}
			/**
			* 设置： 挂号状态的值
			*/
			public void setYishengOrderValue(String yishengOrderValue) {
				this.yishengOrderValue = yishengOrderValue;
			}










				//级联表的get和set yisheng
					/**
					* 获取： 医生编号
					*/
					public String getYishengUuidNumber() {
						return yishengUuidNumber;
					}
					/**
					* 设置： 医生编号
					*/
					public void setYishengUuidNumber(String yishengUuidNumber) {
						this.yishengUuidNumber = yishengUuidNumber;
					}
					/**
					* 获取： 医生名称
					*/
					public String getYishengName() {
						return yishengName;
					}
					/**
					* 设置： 医生名称
					*/
					public void setYishengName(String yishengName) {
						this.yishengName = yishengName;
					}
					/**
					* 获取： 医生照片
					*/
					public String getYishengPhoto() {
						return yishengPhoto;
					}
					/**
					* 设置： 医生照片
					*/
					public void setYishengPhoto(String yishengPhoto) {
						this.yishengPhoto = yishengPhoto;
					}
					/**
					* 获取： 科室
					*/
					public Integer getYishengTypes() {
						return yishengTypes;
					}
					/**
					* 设置： 科室
					*/
					public void setYishengTypes(Integer yishengTypes) {
						this.yishengTypes = yishengTypes;
					}


						/**
						* 获取： 科室的值
						*/
						public String getYishengValue() {
							return yishengValue;
						}
						/**
						* 设置： 科室的值
						*/
						public void setYishengValue(String yishengValue) {
							this.yishengValue = yishengValue;
						}
					/**
					* 获取： 职位
					*/
					public Integer getZhiweiTypes() {
						return zhiweiTypes;
					}
					/**
					* 设置： 职位
					*/
					public void setZhiweiTypes(Integer zhiweiTypes) {
						this.zhiweiTypes = zhiweiTypes;
					}


						/**
						* 获取： 职位的值
						*/
						public String getZhiweiValue() {
							return zhiweiValue;
						}
						/**
						* 设置： 职位的值
						*/
						public void setZhiweiValue(String zhiweiValue) {
							this.zhiweiValue = zhiweiValue;
						}
					/**
					* 获取： 擅长
					*/
					public String getYishengShanchang() {
						return yishengShanchang;
					}
					/**
					* 设置： 擅长
					*/
					public void setYishengShanchang(String yishengShanchang) {
						this.yishengShanchang = yishengShanchang;
					}
					/**
					* 获取： 医生介绍
					*/
					public String getYishengContent() {
						return yishengContent;
					}
					/**
					* 设置： 医生介绍
					*/
					public void setYishengContent(String yishengContent) {
						this.yishengContent = yishengContent;
					}
					/**
					* 获取： 是否上架
					*/
					public Integer getShangxiaTypes() {
						return shangxiaTypes;
					}
					/**
					* 设置： 是否上架
					*/
					public void setShangxiaTypes(Integer shangxiaTypes) {
						this.shangxiaTypes = shangxiaTypes;
					}


						/**
						* 获取： 是否上架的值
						*/
						public String getShangxiaValue() {
							return shangxiaValue;
						}
						/**
						* 设置： 是否上架的值
						*/
						public void setShangxiaValue(String shangxiaValue) {
							this.shangxiaValue = shangxiaValue;
						}
					/**
					* 获取： 点击次数
					*/
					public Integer getYishengClicknum() {
						return yishengClicknum;
					}
					/**
					* 设置： 点击次数
					*/
					public void setYishengClicknum(Integer yishengClicknum) {
						this.yishengClicknum = yishengClicknum;
					}
					/**
					* 获取： 逻辑删除
					*/
					public Integer getYishengDelete() {
						return yishengDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setYishengDelete(Integer yishengDelete) {
						this.yishengDelete = yishengDelete;
					}













				//级联表的get和set yonghu
					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}
					/**
					* 获取： 用户手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 用户手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}
					/**
					* 获取： 用户身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 用户身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}
					/**
					* 获取： 用户头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 用户头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}
					/**
					* 获取： 是否使用
					*/
					public Integer getShiyongTypes() {
						return shiyongTypes;
					}
					/**
					* 设置： 是否使用
					*/
					public void setShiyongTypes(Integer shiyongTypes) {
						this.shiyongTypes = shiyongTypes;
					}


						/**
						* 获取： 是否使用的值
						*/
						public String getShiyongValue() {
							return shiyongValue;
						}
						/**
						* 设置： 是否使用的值
						*/
						public void setShiyongValue(String shiyongValue) {
							this.shiyongValue = shiyongValue;
						}
					/**
					* 获取： 电子邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}



}
