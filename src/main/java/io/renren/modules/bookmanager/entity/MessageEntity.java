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
 * @date 2022-03-20 21:54:22
 */
@Data
@TableName("message")
public class MessageEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long messageId;
	/**
	 * 发送方ID
	 */
	private Long sendId;
	/**
	 * 接收方ID
	 */
	private Long receiveId;
	/**
	 * 消息内容
	 */
	private String messageInfo;
	/**
	 * 新建时间
	 */
	private Date insertTime;
	/**
	 * 逻辑删除
	 */
	private Integer deleted;
	/**
	 * 新增联系人
	 */
	private String insertName;

}
