####spring cloud
###### 本文将是对以往的学习的总结。以一个工程，多模块的形式开发模式，为了避免jar 包版本冲突问题，统一采用
######spring boot 1.5.3.RELEASE  <spring-cloud.version>Dalston.SR1</spring-cloud.version>,配置文件采用yml形式。

1.创建一个maven 工程[引入基本相关的jar包,子模块依赖父模块的pom文件，以后不再赘言]
  	<parent>
    		<groupId>com.yidiandian</groupId>
    		<artifactId>back-stage</artifactId>
    		<version>1.0-SNAPSHOT</version>
    		<relativePath>../pom.xml</relativePath>
    	</parent>
2.创建eureka server 服务注册中心
    1.引入eureka server 依赖
    2.启动类加上注解：@EnableEurekaServer 开启服务注册与发现
    3.浏览器访问[http://127.0.0.1:8761/]
3.创建服务提供者Provider[user-server]
    1.引入父项目的依赖
    2.引入eureka依赖
    3.启动类加上注解：@EnableEurekaClient 开启服务注册功能
    4.加controller
    5.依次启动eureka-server user-server
    6.浏览器访问[http://127.0.0.1:8762/hi?name=jie]
    7.引入spring-data-jpa
    8.引入mysql
    9.引入swagger
    10.引入lombok
    11.在实体类上直接加validate校验
    11.postman测试：依次启动eureka-server user-server
    12.http://localhost:8762/save-user
      {
          "id": 1,
          "username": "张杰",
          "password": "123456789",
          "idNumber": "411421199308236037",
          "nickname": "1fafd",
          "birthday": null,
          "address": "河南省沈丘县城",
          "deleteFlag": true,
          "createTime": null,
          "updateTime": null
      }
    13.引入定时任务依赖pom.xml,定时任务配置文件，在启动类上引入定时任务文件
        [MySQL 先执行tables_mysql_infodb.sql]
    14.编写task job
    15.依次启动eureka-server user-server,查看效果
    16.加入redis
    17.编写：EncodingMysqlConfig ，解决jpa 创建表中文编码问题(MySQL) 
       
    