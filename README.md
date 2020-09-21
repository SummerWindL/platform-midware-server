# platform-midware-server
中间件服务 用户模块间解耦 数据库通知

## 部分依赖采用自建依赖 需要同步下载其他几个项目 执行mvn install命令
>1. activemq-platform
>2. platform-base
>3. platform-repo-pg
>4. platform-websocket
```pom
<!-- 自建依赖 -->
<dependency>
    <groupId>com.lemon</groupId>
    <artifactId>platform-common-util</artifactId>
    <version>0.1</version>
</dependency>
<dependency>
    <groupId>com.platform.repo.pg</groupId>
    <artifactId>platform-repo-pg</artifactId>
    <version>0.1-SNAPSHOT</version>
</dependency>
<dependency>
    <groupId>com.cluster.activemq</groupId>
    <artifactId>activemq-platform</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
<dependency>
    <groupId>com.platform.websocket</groupId>
    <artifactId>platform-websocket</artifactId>
    <version>0.1-SNAPSHOT</version>
</dependency>

```
### f_pg_notification_model 函数负责postgre数据库通知模块，详见具体SQL文件
f_pg_notification_model 函数 第一个参数是调用该模块的函数名称 。
第二个参数 为Java监听地址，可自行定义。
第三个参数 为实际需要从数据库发送的参数，Java方接收。

### 调用说明

```postgresql
select * from f_pg_notification_model('test_function','test_notification','{"notifyno":"cmd_4060001", "notifytype" :"insert","notifyparam":{"ssid":"123","hospcode":"123"}}');
``` 
