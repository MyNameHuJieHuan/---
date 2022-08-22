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
@TableName("debit_info")
public class DebitInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 借记卡ID
	 */
	@TableId
	private Long debitId;
	/**
	 * 借记卡编码
	 */
	private String debitCode;
	/**
	 * 借记卡有效期
	 */
	private Date debitValidity;
	/**
	 * 借记卡状态（0表示正常，1表示已经停用）
	 */
	private Long status;
	/**
	 * 借记卡级别
	 */
	private Integer debitLevel;
	/**
	 * 读者ID
	 */
	private Long userId;
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
	 * 修改时间
	 */
	private Date updateTime;
	/**
	 * 修改联系人
	 */
	private String updateName;

}
