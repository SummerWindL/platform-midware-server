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
