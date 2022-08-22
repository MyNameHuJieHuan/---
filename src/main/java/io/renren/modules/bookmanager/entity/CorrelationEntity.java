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
 * @date 2022-04-08 20:24:17
 */
@Data
@TableName("correlation")
public class CorrelationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long correlationId;
	/**
	 * 关联用户ID
	 */
	private Long userid;
	/**
	 * 关联分类编码
	 */
	private String categoryCode;
	/**
	 * 与分类的相关强度
	 */
	private Double correlationStrength;

}
