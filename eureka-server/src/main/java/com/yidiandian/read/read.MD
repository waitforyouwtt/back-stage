####项目访问地址： http://localhost:8761/ 
####开启服务注册与发现： @EnableEurekaServer

####发送心跳时间每30秒，剔除时间90秒，如果你真的需要更改，则在application.yml 加以下的配置：

eureka.instance.leaseRenewalIntervalInSeconds

eureka.instance.leaseExpirationDurationInSeconds

####默认情况下，eureka server 的自我模式是开启的，如果需要关闭，则在配置文件加以下代码：

eureka:

   server:

      enable-self-preservation:false

####高可用eureka server 集群： 原文件------------------------------- server: port: 8761

eureka: instance: hostname: localhost client: registerWithEureka: false fetchRegistry: false serviceUrl: defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/
配置文件中，定义了两个profile 文件，分别为peer1 和 peer2，它们的 hostname 分别为：peer1 和peer2. 在实际开发中，可能是具体的服务器Ip 地址。 在本地搭建eureka server 集群，需要修改本地的host 。windows 系统在C:\Windows\System32\drivers\etc\hosts 修改：

127.0.0.1 peer1 127.0.0.1 peer2