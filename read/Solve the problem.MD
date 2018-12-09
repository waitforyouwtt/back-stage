1.解决数据库连接乱码问题：
  jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC 
2.解决jpa 生成表中文乱码问题：
  public class EncodingMysqlConfig extends MySQL5InnoDBDialect {
      @Override
      public String getTableTypeString() {
          return " ENGINE=InnoDB DEFAULT CHARSET=utf8";
      }
  }
  加+yml 文件
3.解决打包失败问题[相对路径]以及maven 主工程[ <packaging>pom</packaging>]：
  	<parent>
  		<groupId>com.yidiandian</groupId>
  		<artifactId>back-stage</artifactId>
  		<version>1.0-SNAPSHOT</version>
  		<relativePath>../pom.xml</relativePath>
  	</parent>
4.解决quartz编译打包问题如下：  	 
java.lang.IllegalStateException: ApplicationEventMulticaster not initialized
 - call 'refresh' before multicasting events via the context: org.springframework.web.context.support.GenericWebApplicationContext@5aceec94:
  startup date [Sun Dec 09 12:20:56 CST 2018]; parent: org.springframework.context.annotation.AnnotationConfigApplicationContext@1e16c0aa
  
  启动类原 @ImportResource("quartz.xml") 换成这个：@ImportResource(locations = {"classpath:quartz.xml"})