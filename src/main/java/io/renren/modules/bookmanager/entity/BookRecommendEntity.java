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
 * @date 2022-03-09 17:20:33
 */
@Data
@TableName("book_recommend")
public class BookRecommendEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 推荐表主键
	 */
	@TableId
	private Long recommendId;
	/**
	 * 书籍ID
	 */
	private Long bookId;
	/**
	 * 读者ID
	 */
	private Long userId;
	/**
	 * 读者对该书籍的相关强度
	 */
	private Long correlationintensity;
	/**
	 * 是否已经加入书架收藏（0表示未收藏，1表示已收藏）
	 */
	private Integer status;

}
