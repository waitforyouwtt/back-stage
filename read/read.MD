####spring cloud
###### 本文将是对以往的学习的总结。以一个工程，多模块的形式开发模式，为了避免jar 包版本冲突问题，统一采用
######spring boot 1.5.3.RELEASE  <spring-cloud.version>Dalston.SR1</spring-cloud.version>,配置文件采用yml形式。

###### http://www.cnblogs.com/cc11001100/p/7456145.html[banner.txt]

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
    17.编写：EncodingMysqlConfig[yml文件引用] ，解决jpa 创建表中文编码问题(MySQL) 
       jpa:
           hibernate:
             ddl-auto: update
           show-sql: true
           properties:
             hibernate:
               dialect: com.yidiandian.config.EncodingMysqlConfig  #配置类全路径
    18.创建服务提供者Provider[goods-server]
       引入父依赖，feign,Hystrix,dashboard
    19.查看效果：
       启动一个eureka server 端口8761
       启动两个user-server 端口8762 8763
       浏览器访问[http://localhost:8765/hi],轮询显示：
       1.在接口上加fallback 快速失败的处理类。该处理类是作为feign熔断器的逻辑处理类，必须实现被@FeignClient修改的接口。
       2.该类需要实现EurekaClientFeign接口.
       3.查看效果：
           1：启动一个eureka server 端口8761
              java -jar .\eureka-server-0.0.1-SNAPSHOT.jar --server.port=8761
           2：启动两个eureka client 端口8762 8763 
              java -jar .\user-server-0.0.1-SNAPSHOT.jar --server.port=8762
              java -jar .\user-server-0.0.1-SNAPSHOT.jar --server.port=8763
           3：启动goods-server
           4: http://127.0.0.1:8765/hi [依次轮询8762，8763 端口] 
           5: 结果显示feign client  有负载均衡的能力
           6:关闭eureka client[模拟服务异常] (执行快速失败)  
    20.引入网关：
         查看效果：
           1：启动一个eureka server 端口8761
              java -jar .\eureka-server-0.0.1-SNAPSHOT.jar --server.port=8761
           2：启动两个eureka client 端口8762 8763 
              java -jar .\user-server-0.0.1-SNAPSHOT.jar --server.port=8762
              java -jar .\user-server-0.0.1-SNAPSHOT.jar --server.port=8763
           3：启动网关服务
              java -jar .\zuul-server-0.0.1-SNAPSHOT.jar --server.port=5000
           4：浏览器访问[http://localhost:5000/v1/userapi/hi?name=jie&token=2345]
           
    21.配置中心：
         引入jar: 
                 <dependency>
                     <groupId>org.springframework.cloud</groupId>
                     <artifactId>spring-cloud-starter-config</artifactId>
                     <version>1.4.4.RELEASE</version>
                 </dependency>
         
                 <!--表示为web工程-->
                 <dependency>
                     <groupId>org.springframework.boot</groupId>
                     <artifactId>spring-boot-starter-web</artifactId>
                 </dependency>
         
                 <!--暴露各种指标  貌似是必须的  -->
                 <dependency>
                     <groupId>org.springframework.boot</groupId>
                     <artifactId>spring-boot-starter-actuator</artifactId>
                 </dependency>
                  <dependency>
                             <groupId>org.springframework.cloud</groupId>
                             <artifactId>spring-cloud-config-server</artifactId>
                             <version>1.4.4.RELEASE</version>
                  </dependency>
         application.yml:
                  server:
                    port: 8181
                  spring:
                    application:
                      name: config-server
                    cloud:
                      config:
                        server:
                          git:
                            uri: https://github.com/waitforyouwtt/back-stage.git
                            username: waitforyouwtt
                            password: wtt19940512577
         [注意：git.uri 指的是这个项目的git 地址]
         查看效果：[http://localhost:8181/service1/default] 或者[http://localhost:8181/service1/default/master]                                   
                  
                     
       
     ,