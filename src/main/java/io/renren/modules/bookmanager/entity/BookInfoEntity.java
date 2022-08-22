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
 * @date 2022-03-07 20:28:24
 */
@Data
@TableName("book_info")
public class BookInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 书籍ID
	 */
	@TableId
	private Long bookId;
	/**
	 * 图书编码
	 */
	private String bookCode;
	/**
	 * 图书名称
	 */
	private String bookName;
	/**
	 * 图书出版社
	 */
	private String bookPress;
	/**
	 * 图书分类编码
	 */
	private Long categoryCode;
	/**
	 * 图书馆ID
	 */
	private Long libraryId;
	/**
	 * 书籍馆存地址
	 */
	private Long addressId;
	/**
	 * 书籍照片存储地址
	 */
	private String bookImageurl;
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
	/**
	 * 书籍作者
	 */
	private String author;
	/**
	 * 图书定价
	 */
	private String pricing;
	/**
	 * 出版时间
	 */
	private Date pressTime;
	/**
	 * 正文语种
	 */
	private String language;
	/**
	 * 图书txt文件地址
	 */
	private String bookTxtUrl;

}
