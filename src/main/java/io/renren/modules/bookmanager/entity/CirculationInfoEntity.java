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
@TableName("circulation_info")
public class CirculationInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 借还书记录ID
	 */
	@TableId
	private Long circulationId;
	/**
	 * 借书时间
	 */
	private Date borrowTime;
	/**
	 * 还书时间
	 */
	private Date returnTime;
	/**
	 * 0表示借书，1表示还书
	 */
	private Long status;
	/**
	 * 读者ID
	 */
	private Long userId;
	/**
	 * 书籍ID
	 */
	private Long bookId;
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
