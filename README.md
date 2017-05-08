# 尴尬的事
　　腾讯暂时关闭了TGP查找看战绩的功能，何时恢复不知道，现在查战绩那些是用不了了，真的尴尬。刚写完没几天，就GG了。
# 写在前面
　　该项目基于`Spring Boot`开发，因为其它原因，`TGP`上的每个接口，我没有写的很细，只是实现了部分比较重要的功能，比如以下的基本功能：获取英雄、技能、皮肤、装备数据等。稍微高级点的就是查询玩家基本信息、战绩以及对局详情的信息。太细的接口我没有实现，因为我要准备找实习了，需要看些java基础的东西准备各种笔试面试了。
  
---

# 基本环境
- JDK： **1.8.0_111**
- 数据库： **[MySQL 5.7](https://www.mysql.com/)**
- 构建工具： **[Apache Maven 3.3.9](http://maven.apache.org/)**
- SpringBoot： **[1.5.3.RELEASE](http://projects.spring.io/spring-boot/)**

---

# 如何运行
1. `clone`项目到本地。

	``` bash
    git clone https://github.com/IT-HowieLi/lol-api
    ```

2. `Mysql`数据库执行`/src/main/resources/init.sql`。
3. 修改`/src/main/resources/application.yml`中的数据库账户密码，修改为本地数据库账户密码。
4. 进入项目，启动项目。

	``` bash
    mvn spring-boot:run
    ```

5. 启动成功后，访问`http://localhost:8080/lol/admin`，默认账户：admin 密码:123456。
6. 登录成功后，点击三个更新按钮，分别更新英雄数据，装备数据，技能数据。

---

# 接口介绍
　　在包`/src/main/java/cn/howieli/lol/controller/`下以`API`开头的`Controller`都有介绍。如果有时间，再一个一个列举出来。

---

# 尚未解决的难点
　　众所周知，要获取战绩信息，都是需要获取`Cookie`数据的，经过分析，只要有`puin`以及`pkey`就可以获取到战绩，可是，这两个值只有从`TGP`登录才可以获取到。所以，我抓`TGP`的登录包，`UDP`协议的包，什么`0836`发送包，又是什么接收包，最后无果，这完全不是我擅长的地方，当时解第二个包的时候，貌似还需要逆向分析去找客户端里的一个`KEY`来解密。所以我放弃了再做这件事，太浪费时间。所以，有这方面的大牛，还望多指点一二。  
　　目前，该项目是有`Cookie`的，不过我认为是一种不适合公开的获取方式，所以我封装到了我另一个在线的项目中，供该项目获取`Cookie`，不对外公开，还请各位谅解。

---

# 关注我
　　个人博客:[https://www.howieli.cn](https://www.howieli.cn) 和个人CSDN博客: [http://blog.csdn.net/howieli_1995](http://blog.csdn.net/howieli_1995)。  
　　也可以关注我的知乎:[https://www.zhihu.com/people/IT-HowieLi](https://www.zhihu.com/people/IT-HowieLi)