**项目说明** 
- 智能图书管理与推荐系统是结合传统的图书管理业务与现代的数字化阅读相结合的一个系统

- 系统有前端和后端以及移动端的支持，包括对数据库的一个持久化操作等等

- 系统有三个角色，分别是超级管理员，图书管理员以及读者，每个角色有着自己的菜单和功能权限

- 系统的核心是基于模型的推荐算法，通过中图法分类对每一个图书的分类编码和用户的id进行关联，形成一张相关强度表，系统根据用户的一些搜索行为，实现相关强度的增加等等。

  

  <br> 

**项目结构** 
```
wangshangbook
├─db  项目SQL语句
│
├─common 公共模块
│  ├─aspect 系统日志
│  ├─exception 异常处理
│  ├─validator 后台校验
│  └─xss XSS过滤
│ 
├─config 配置信息
│ 
├─modules 功能模块
│  ├─app API接口模块(APP调用)
│  ├─job 定时任务模块
│  ├─oss 文件服务模块
│  └─sys 权限模块
│ 
├─RenrenApplication 项目启动类
│  
├──resources 
│  ├─mapper SQL对应的XML文件
│  └─static 静态资源

```
<br>  


**技术选型：** 
- 核心框架：Spring Boot 2.1
- 安全框架：Apache Shiro 1.4
- 视图框架：Spring MVC 5.0
- 持久层框架：MyBatis 3.3
- 移动端框架：Uniapp
- 定时器：Quartz 2.3
- 数据库连接池：Druid 1.0
- 日志管理：SLF4J 1.7、Log4j
- 页面交互：Vue2.x 
<br> 


 **后端部署**
- 通过git下载源码
- idea、eclipse需安装lombok插件，不然会提示找不到entity的get set方法
- 创建数据库library，数据库编码为UTF-8
- 执行db/mysql.sql文件，初始化数据
- 修改application-dev.yml，更新MySQL账号和密码
- Eclipse、IDEA运行RenrenApplication.java，则可启动项目

<br> 

 **前端部署**
 - 本项目是前后端分离的，还需要部署前端，才能运行起来
 - 前端下载地址：https://gitee.com/renrenio/renren-fast-vue
 - 前端部署完毕，就可以访问项目了，账号：admin，密码：admin

 <br>

 **项目演示**
- 演示地址：http://localhost:8001
- 账号密码：admin/admin
<br> 

**接口文档效果图：**
![image-20220822164941664](C:\Users\adol\AppData\Roaming\Typora\typora-user-images\image-20220822164941664.png)

<br> <br> <br> 

**效果图：**

web端：

![image-20220822161740053](C:\Users\adol\AppData\Roaming\Typora\typora-user-images\image-20220822161740053.png)


![image-20220822161842213](C:\Users\adol\AppData\Roaming\Typora\typora-user-images\image-20220822161842213.png)

<br>

移动端：

​	![image-20220822163209751](C:\Users\adol\AppData\Roaming\Typora\typora-user-images\image-20220822163209751.png)

![image-20220822164316580](C:\Users\adol\AppData\Roaming\Typora\typora-user-images\image-20220822164316580.png)