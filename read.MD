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
3.创建服务提供者    