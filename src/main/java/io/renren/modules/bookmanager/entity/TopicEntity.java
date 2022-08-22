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
 * @date 2022-04-26 19:18:59
 */
@Data
@TableName("topic")
public class TopicEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long topicId;
	/**
	 * 题目
	 */
	private String title;
	/**
	 * 选项A
	 */
	private String optiona;
	/**
	 * 选项B
	 */
	private String optionb;
	/**
	 * 选项C
	 */
	private String optionc;
	/**
	 * 选项D
	 */
	private String optiond;
	/**
	 * 逻辑删除
	 */
	private Integer deleted;
	/**
	 * 新增时间
	 */
	private Date insertTime;
	/**
	 * 新增联系人
	 */
	private String insertName;
	/**
	 * 修改时间
	 */
	private Date updateTime;
	/**
	 * 修改联系人
	 */
	private Date updateName;

}
