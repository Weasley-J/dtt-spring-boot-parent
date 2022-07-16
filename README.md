# mydtt-plus-spring-boot-starter

DTT has deploied to maven  central repo,  you can get latest version from [maven central repository](https://search.maven.org/search?q=mydtt-plus-spring-boot-starter).



> - What is DTT?
>
> It's means  `Domain-to-Table`,  As we know，The object of Java is `Domain`，Database's  is `Table` .
>
> - What can DTT do?
>
> Its can easily convert Java domain to SQL create table statement and auto create them，i.e.
>
> 1. Java domian
>
> ```java
> import com.example.enums.MemberType;
> import lombok.AllArgsConstructor;
> import lombok.Builder;
> import lombok.Data;
> import lombok.NoArgsConstructor;
> import lombok.experimental.Accessors;
> 
> import java.io.Serializable;
> import java.math.BigDecimal;
> import java.time.LocalDate;
> import java.time.LocalDateTime;
> import java.time.LocalTime;
> 
> /**
>  * 用户信息
>  */
> @Data
> @Builder
> @AllArgsConstructor
> @NoArgsConstructor
> @Accessors(chain = true)
> public class DttMember implements Serializable {
>     private static final long serialVersionUID = 1L;
>     /**
>      * 主键id
>      */
>     private Long id;
>     /**
>      * 用户openId
>      */
>     private String openId;
>     /**
>      * 用户昵称
>      */
>     private String nickname;
>     /**
>      * 是否启用, 默认：1
>      */
>     private Boolean isEnable = true;
>     /**
>      * 用户积分余额, 默认：0.00
>      */
>     private BigDecimal balance = BigDecimal.valueOf(0L, 2);
>     /**
>      * 出生日期，格式：yyyy-MM-dd HH:mm:ss
>      */
>     private LocalDateTime birthday;
>     /**
>      * 会员类型，默认：ORDINARY
>      */
>     private MemberType memberType = MemberType.ORDINARY;
>     /**
>      * 用户状态；0 正常(默认)，1 已冻结，2 账号已封，3 账号异常
>      */
>     private Integer status = 3;
>     /**
>      * 账户注销状态；0 未注销（默认），1 已销户
>      */
>     private Integer deleted = 0;
>     /**
>      * 注册时间，格式: yyyy-MM-dd
>      */
>     private LocalDate registrarDate;
>     /**
>      * 会员加速开始时间, 格式：HH:mm:ss
>      */
>     private LocalTime accelerateBeginTime;
>     /**
>      * 会员加速结束时间, 格式：HH:mm:ss
>      */
>     private LocalTime accelerateEndTime;
>     /**
>      * 修改时间
>      */
>     private LocalDateTime updateTime;
> }
> ```
>
> 2. Table statement
>
> ```mysql
> DROP TABLE IF EXISTS `dtt_member`;
> CREATE TABLE IF NOT EXISTS `dtt_member`
> (
>     `id`  bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
>     `open_id`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '用户openId',
>     `nickname`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '用户昵称',
>     `is_enable`  tinyint                                                  DEFAULT true COMMENT '是否启用, 默认：1',
>     `balance`  decimal                                                  DEFAULT 0.00 COMMENT '用户积分余额, 默认：0.00',
>     `birthday`  datetime                                                  DEFAULT NULL COMMENT '出生日期，格式：yyyy-MM-dd HH:mm:ss',
>     `member_type`  enum('ORDINARY','STUDENT','GUNMETAL','SILVER','GOLD','DIAMOND','SPORTS','PLUS') CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT 'ORDINARY' COMMENT '会员类型，默认：ORDINARY',
>     `status`  int                                                  DEFAULT 3 COMMENT '用户状态；0 正常(默认)，1 已冻结，2 账号已封，3 账号异常',
>     `deleted`  int                                                  DEFAULT 0 COMMENT '账户注销状态；0 未注销（默认），1 已销户',
>     `registrar_date`  date                                                  DEFAULT NULL COMMENT '注册时间，格式: yyyy-MM-dd',
>     `accelerate_begin_time`  time                                                  DEFAULT NULL COMMENT '会员加速开始时间, 格式：HH:mm:ss',
>     `accelerate_end_time`  time                                                  DEFAULT NULL COMMENT '会员加速结束时间, 格式：HH:mm:ss',
>     `update_time`  datetime                                                  DEFAULT NULL COMMENT '修改时间',
> PRIMARY KEY (`id`)
> ) ENGINE = InnoDB
> DEFAULT CHARSET = utf8mb4
> COLLATE = utf8mb4_general_ci COMMENT ='用户信息';
> ```
>
> 3. In your DB as you can see:
>
> ![image-20220713190051773](https://alphahub-test-bucket.oss-cn-shanghai.aliyuncs.com/image/image-20220713190051773.png)
>
> 
>
> You can easily use DTT integrate with spring's ecosystem(mybatis-plus, mybatis, ... ) and enhance them，For [mybatis-plus](https://github.com/baomidou/mybatis-plus) you integrate with **0** code ，I first support the implements for `MySQL` ，`ORACLE`, `DB2`, `SQLSERVER`, `MARIADB`, `POSTGRESQL` wil be support in the future. Thanks for you star, .
>
> 

## Quick Start

- Add maven dependencies to your `pom.xml`

```xml
<properties>
  <mydtt-plus.version>1.0.3</therapi-runtime-javadoc.version>
  <therapi-runtime-javadoc.version>0.13.0</therapi-runtime-javadoc.version>
</properties>

<dependencies>
        <!-- mydtt-plus-spring-boot-starter -->
        <dependency>
            <groupId>io.github.weasley-j</groupId>
            <artifactId>mydtt-plus-spring-boot-starter</artifactId>
            <version>${mydtt-plus.version}</version>
        </dependency>
        <!-- javadoc-scribe start  -->
        <dependency>
            <groupId>com.github.therapi</groupId>
            <artifactId>therapi-runtime-javadoc-scribe</artifactId>
            <version>${therapi-runtime-javadoc.version}</version>
            <scope>provided</scope>
        </dependency>
        <!-- javadoc-scribe end  -->
</dependencies>
```



**OR ELSE:**

- Clone this project into your dir.

```bash
git clone https://github.com/Weasley-J/mydtt-plus-spring-boot-starter.git
```

- CD to your work dir then you can run this maven command to install DTT and use it in you projects.

Tips: For this step, I mean your JDK and MAVEN environment are set correctly.

```shell
mvn clean install -pl :mydtt-plus-spring-boot-starter -am
```

- Add maven dependencies into your `pom.xml `(The pom's parent must be
  extends `org.springframework.boot:spring-boot-starter-parent`)

**Tips**: `domain` model must be in the same `src` folder with `pom.xml`

```xml
<properties>
        <therapi-runtime-javadoc.version>0.13.0</therapi-runtime-javadoc.version>
        <mydtt-plus.version>1.0.0</mydtt-plus.version>
</properties>

<dependencies>
        <!-- mydtt-plus-spring-boot-starter -->
        <dependency>
            <groupId>io.github.weasley-j</groupId>
            <artifactId>mydtt-plus-spring-boot-starter</artifactId>
            <version>${mydtt-plus.version}</version>
        </dependency>
        <!-- javadoc-scribe start  -->
        <!-- Annotation processor -->
        <dependency>
            <groupId>com.github.therapi</groupId>
            <artifactId>therapi-runtime-javadoc-scribe</artifactId>
            <version>${therapi-runtime-javadoc.version}</version>
            <scope>provided</scope>
        </dependency>
        <!-- Runtime library -->
        <dependency>
            <groupId>com.github.therapi</groupId>
            <artifactId>therapi-runtime-javadoc</artifactId>
            <version>${therapi-runtime-javadoc.version}</version>
        </dependency>
        <!-- javadoc-scribe end  -->
</dependencies>

```

- Config your projects datasource in `application.yml`, like this:

```yaml
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://your_ip:3306/your_db?serverTimezone=Asia/Shanghai&useSSL=false&allowPublicKeyRetrieval=true&autoReconnect=true&allowMultiQueries=true
    username: your_username
    password: your_password
```

- Using JAVA annotation `@EnableDtt` to enable DTT to your projects, As follow:

![image-20220713190839427](https://alphahub-test-bucket.oss-cn-shanghai.aliyuncs.com/image/image-20220713190839427.png)

You can enable the required functions as needed.



## Features of DTT







## `UML` architecture diagram

![image-20220716190138301](https://alphahub-test-bucket.oss-cn-shanghai.aliyuncs.com/image/image-20220716190138301.png)





## Contribute your code

todo





## Q&A

todo





## Credits

todo
