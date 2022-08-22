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
 * @date 2022-04-08 20:24:18
 */
@Data
@TableName("subject")
public class SubjectEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer subjectId;
	/**
	 * 题目名称
	 */
	private String sujectName;
	/**
	 * 题目选项
	 */
	private String subjectOption;
	/**
	 * 逻辑删除
	 */
	private Integer deleted;
	/**
	 * 新增联系人
	 */
	private String insertName;
	/**
	 * 新增时间
	 */
	private Date insertTime;

}
