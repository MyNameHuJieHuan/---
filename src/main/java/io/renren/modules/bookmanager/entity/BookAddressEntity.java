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
 * @date 2022-03-07 23:00:10
 */
@Data
@TableName("book_address")
public class BookAddressEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 书籍存放地址ID
	 */
	@TableId
	private Long addressId;
	/**
	 * 图书馆ID
	 */
	private Long libraryId;
	/**
	 * 门号
	 */
	private String door;
	/**
	 * 书架号
	 */
	private String pressmark;
	/**
	 * 书架行号
	 */
	private String bookRow;
	/**
	 * 书架列号
	 */
	private String bookLine;
	/**
	 * 是否存在书籍（0:存在，1：不存在）
	 */
	private Integer status;
	/**
	 * 图书混合类别编码
	 */
	private Long categoryId;
	/**
	 * 图书类别编码
	 */
	private Long addressCode;
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
