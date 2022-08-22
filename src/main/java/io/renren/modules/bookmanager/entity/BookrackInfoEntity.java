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
 * @date 2022-04-14 17:56:38
 */
@Data
@TableName("bookrack_info")
public class BookrackInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * app书架id
	 */
	@TableId
	private Long bookrackId;
	/**
	 * 用户id
	 */
	private Long userId;
	/**
	 * 书籍id
	 */
	private Long bookId;
	/**
	 * 逻辑删除
	 */
	private Integer deleted;
	/**
	 * 新增时间
	 */
	private Date insertTime;
	/**
	 * 修改时间
	 */
	private Date updateTime;

}
