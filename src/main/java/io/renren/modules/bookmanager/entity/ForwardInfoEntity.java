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
 * @date 2022-03-04 16:10:07
 */
@Data
@TableName("forward_info")
public class ForwardInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 预约记录ID
	 */
	@TableId
	private Long forwardId;
	/**
	 * 预约记录编码
	 */
	private String forwardCode;
	/**
	 * 读者ID
	 */
	private Long userId;
	/**
	 * 图书馆ID
	 */
	private Long libraryId;
	/**
	 * 逻辑删除
	 */
	private Long deleted;
	/**
	 * 新增联系人
	 */
	private String insertName;
	/**
	 * 修改联系人
	 */
	private String updateName;
	/**
	 * 新增时间
	 */
	private Date insertTime;
	/**
	 * 预约时间
	 */
	private Date forwardTime;
	/**
	 * 修改时间
	 */
	private Date updateTime;

}
