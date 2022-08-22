package io.renren.modules.bookmanager.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author hujh
 * @email 1942698741@qq.com
 * @date 2022-03-24 20:41:35
 */
@Data
@TableName("category")
public class CategoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 分类ID
	 */
	@TableId
	private Long categoryId;
	/**
	 * 分类编码
	 */
	private String categoryCode;
	/**
	 * 分类名
	 */
	private String categoryName;
	/**
	 * 逻辑删除
	 */
	private Long deleted;
	/**
	 * 新增联系人
	 */
	private String insertName;
	/**
	 * 新增时间
	 */
	private Date insertTime;
	/**
	 * 修改联系人
	 */
	private String updateName;
	/**
	 * 修改时间
	 */
	private Date updateTime;

}
