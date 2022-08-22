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
@TableName("offical_book")
public class OfficalBookEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String isbn;
	/**
	 * 
	 */
	private String bookName;
	/**
	 * 
	 */
	private String bookPress;
	/**
	 * 
	 */
	private String author;
	/**
	 * 
	 */
	private Date pressTime;
	/**
	 * 
	 */
	private String pricing;
	/**
	 * 
	 */
	private String category;
	/**
	 * 
	 */
	private String language;
	/**
	 * 
	 */
	private String imageUrl;
	/**
	 * 
	 */
	private String booktxtUrl;

}
