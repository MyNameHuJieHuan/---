package io.renren.modules.bookmanager.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-04 11:55:06
 */
@Data
@TableName("classify")
public class ClassifyEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 类别ID
	 */
	@TableId
	private Long classifyId;
	/**
	 * 类别名
	 */
	private String classifyName;
	/**
	 * 逻辑删除
	 */
	private Long deleted;
	/**
	 * 新增时间
	 */
	private Date insertTime;
	/**
	 * 新增联系人
	 */
	private String insertName;
	/**
	 * 修改联系人
	 */
	private String updateName;
	/**
	 * 修改时间
	 */
	private Date updateTime;

}
