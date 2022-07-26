# mydtt-plus-spring-boot-starter

Domain Driven Table [![Maven Central](https://img.shields.io/maven-central/v/io.github.weasley-j/mydtt-plus-spring-boot-starter)](https://search.maven.org/artifact/io.github.weasley-j/mydtt-plus-spring-boot-starter) 

> - What is DTT?
>
> It's means  `Domain-to-Table`,  Aims to make it easy for you to automatically create DB tables based on your Java model.
>
> - What can DTT do?
>
> Its can easily convert Java domain to SQL create table statement and auto create them(`enable lombok  for your IDE`)，for different country java developer those who is none native English speaker, i.e.
>
> - Chinese  developer
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
> 2. Table statements
>
> ```mysql
> DROP TABLE IF EXISTS `db_demo`.`dtt_member`;
> CREATE TABLE IF NOT EXISTS `db_demo`.`dtt_member`
> (
>     `id`                    bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
>     `status`                int                                                                                                                               DEFAULT 3 COMMENT '用户状态；0 正常(默认)，1 已冻结，2 账号已封，3 账号异常',
>     `deleted`               int                                                                                                                               DEFAULT 0 COMMENT '账户注销状态；0 未注销（默认），1 已销户',
>     `open_id`               varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci                                                                      DEFAULT NULL COMMENT '用户openId',
>     `balance`               decimal                                                                                                                           DEFAULT 0.00 COMMENT '用户积分余额, 默认：0.00',
>     `accelerate_begin_time` time                                                                                                                              DEFAULT NULL COMMENT '会员加速开始时间, 格式：HH:mm:ss',
>     `nickname`              varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci                                                                      DEFAULT NULL COMMENT '用户昵称',
>     `birthday`              datetime                                                                                                                          DEFAULT NULL COMMENT '出生日期，格式：yyyy-MM-dd HH:mm:ss',
>     `member_type`           enum ('ORDINARY','STUDENT','GUNMETAL','SILVER','GOLD','DIAMOND','SPORTS','PLUS') CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT 'ORDINARY' COMMENT '会员类型，默认：ORDINARY',
>     `is_enable`             tinyint                                                                                                                           DEFAULT true COMMENT '是否启用, 默认：1',
>     `registrar_date`        date                                                                                                                              DEFAULT NULL COMMENT '注册时间，格式: yyyy-MM-dd',
>     `accelerate_end_time`   time                                                                                                                              DEFAULT NULL COMMENT '会员加速结束时间, 格式：HH:mm:ss',
>     `update_time`           datetime                                                                                                                          DEFAULT NULL COMMENT '修改时间',
>     PRIMARY KEY (`id`)
> ) ENGINE = InnoDB
>   DEFAULT CHARSET = utf8mb4
>   COLLATE = utf8mb4_general_ci COMMENT ='用户信息';
> ```
>
> 3.  As you can see，In your DB:
>
> ![image-20220713190051773](https://alphahub-test-bucket.oss-cn-shanghai.aliyuncs.com/image/image-20220713190051773.png)
>
> 
>
> - Korean developer
>
> 1. Java domain
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
>  * 사용자 정보
>  */
> @Data
> @Builder
> @AllArgsConstructor
> @NoArgsConstructor
> @Accessors(chain = true)
> public class DttMember implements Serializable {
>     private static final long serialVersionUID = 1L;
>     /**
>      * 기본 키 ID
>      */
>     private Long id;
>     /**
>      * 사용자 openId
>      */
>     private String openId;
>     /**
>      * 사용자 닉네임 사용자 닉네임
>      */
>     private String nickname;
>     /**
>      * 활성화 여부, 기본값: 1
>      */
>     private Boolean isEnable = true;
>     /**
>      * 사용자 신용 잔액, 기본값: 0.00
>      */
>     private BigDecimal balance = BigDecimal.valueOf(0L, 2);
>     /**
>      * 생년월일, 형식: yyyy-MM-dd HH:mm:ss
>      */
>     private LocalDateTime birthday;
>     /**
>      * 회원 유형, 기본값: ORDINARY
>      */
>     private MemberType memberType = MemberType.ORDINARY;
>     /**
>      * 사용자 상태: 0 정상(기본값), 1 동결, 2 계정 차단, 3 계정 비정상
>      */
>     private Integer status = 3;
>     /**
>      * 계정 취소 상태, 0은 취소되지 않음(기본값), 1은 취소됨
>      */
>     private Integer deleted = 0;
>     /**
>      * 등록 시간, 형식: yyyy-MM-dd
>      */
>     private LocalDate registrarDate;
>     /**
>      * 회원 가속 시작 시간, 형식: HH:mm:ss
>      */
>     private LocalTime accelerateBeginTime;
>     /**
>      * 회원 가속 종료 시간, 형식: HH:mm:ss
>      */
>     private LocalTime accelerateEndTime;
>     /**
>      * 시간 변경
>      */
>     private LocalDateTime updateTime;
> }
> ```
>
> 2. DB table
>
> ```mysql
> DROP TABLE IF EXISTS `db_demo`.`dtt_member`;
> CREATE TABLE IF NOT EXISTS `db_demo`.`dtt_member`
> (
>     `id`  bigint NOT NULL AUTO_INCREMENT COMMENT '기본 키 ID',
>     `status`  int                                                  DEFAULT 3 COMMENT '사용자 상태: 0 정상(기본값), 1 동결, 2 계정 차단, 3 계정 비정상',
>     `is_enable`  tinyint                                                  DEFAULT true COMMENT '활성화 여부, 기본값: 1',
>     `nickname`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '사용자 닉네임 사용자 닉네임',
>     `birthday`  datetime                                                  DEFAULT NULL COMMENT '생년월일, 형식: yyyy-MM-dd HH:mm:ss',
>     `member_type`  enum('ORDINARY','STUDENT','GUNMETAL','SILVER','GOLD','DIAMOND','SPORTS','PLUS') CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT 'ORDINARY' COMMENT '회원 유형, 기본값: ORDINARY',
>     `registrar_date`  date                                                  DEFAULT NULL COMMENT '등록 시간, 형식: yyyy-MM-dd',
>     `accelerate_begin_time`  time                                                  DEFAULT NULL COMMENT '회원 가속 시작 시간, 형식: HH:mm:ss',
>     `accelerate_end_time`  time                                                  DEFAULT NULL COMMENT '회원 가속 종료 시간, 형식: HH:mm:ss',
>     `update_time`  datetime                                                  DEFAULT NULL COMMENT '시간 변경',
>     `deleted`  int                                                  DEFAULT 0 COMMENT '계정 취소 상태, 0은 취소되지 않음(기본값), 1은 취소됨',
>     `open_id`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '사용자 openId',
>     `balance`  decimal                                                  DEFAULT 0.00 COMMENT '사용자 신용 잔액, 기본값: 0.00',
> PRIMARY KEY (`id`)
> ) ENGINE = InnoDB
> DEFAULT CHARSET = utf8mb4
> COLLATE = utf8mb4_general_ci COMMENT ='사용자 정보';
> ```
>
> 
>
> You can easily use DTT integrate with spring's ecosystem(mybatis-plus, mybatis, ... ) and enhance them，For [mybatis-plus](https://github.com/baomidou/mybatis-plus) you integrate with `0-Code` ，Support the implements for `MySQL` ，`ORACLE`, `DB2`, `SQLSERVER`, `MARIADB`, `POSTGRESQL`，Thanks for you star, .
>
> 

## Quick Start

- Add maven dependencies to your `pom.xml`

```xml
<properties>
  <mydtt-plus.version>1.0.6</therapi-runtime-javadoc.version>
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
        <mydtt-plus.version>1.0.6</therapi-runtime-javadoc.version>
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

- Config your projects datasource in `application.yml`, like this:

```yaml
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://your_ip:3306/your_db?serverTimezone=Asia/Shanghai&useSSL=false&allowPublicKeyRetrieval=true&autoReconnect=true&allowMultiQueries=true
    username: your_username
    password: your_password
```

- Using JAVA annotation `@EnableDtt` to enable DTT to your projects main function class, As follow:

```java
import cn.alphahub.dtt.plus.enums.ParserType;
import cn.alphahub.dtt.plus.framework.annotations.EnableDtt;
import com.example.domain.dtt.DttMember;
import com.example.domain.dtt.DttPerson;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * MyDtt-Plus Testing  Application
 */
@SpringBootApplication
@EnableDtt(
        scanBasePackages = {
                "com.example.i18n.korean",
                "com.example.domain.dtt",
                "com.example.domain.oms", "com.example.domain.order", "com.example.domain.payment",
                "com.example.domain.promotion", "com.example.domain.shop", "com.example.domain.user",
        },
        parserType = ParserType.JAVA_DOC,
        dropTableBeforeCreate = true,
        scanBaseClasses = {
                DttPerson.class,
                DttMember.class,
        }
)
@MapperScan(basePackages = {"com.example.mapper"})
public class MydttPlusTestsApplication {
    public static void main(String[] args) {
        SpringApplication.run(MydttPlusTestsApplication.class, args);
    }
}
```

You can enable the required functions as needed. When your application started. You'll be see like this console log in your IDE:



```

2022-07-17 22:15:13.894  INFO 12961 --- [           main] c.a.dtt.plus.framework.InitDttHandler    : Auto created '1' tables for '0' seconds. detail: {"dttStartTime":"2022-07-17 22:15:13","dttEndTime":"2022-07-17 22:15:13"}, location: /Users/weasley/Development/IdeaProjects/mydtt-plus-spring-boot-parent/ALL_IN_ONE.SQL

```



### Annotation Metadata

- `EnableDtt`

To enable DTT support your application，annotate on you main class.

| property                | type         | desc                                        | remark                                                       |
| :---------------------- | ------------ | ------------------------------------------- | ------------------------------------------------------------ |
| `scanBasePackages`      | `String[]`   | The model classes be given                  | The package permissions are as small as possible. If the scope is too large, DTT will scan all classes in subpackages. |
| `scanBaseClasses`       | `Class<?>[]` | base classes to scan，optional              | You want to specify which model class files generate database tables |
| `ParserType`            | `ParserType` | Enum，`JAVA_DOC`,`ANNOTATION`               | Which parser you want to choose to parse model, default is set to:`ParserType.JAVA_DOC`, Particularly，if your application is run with type of `jar`,`war`,`JAVA_DOC` will do nothing for this opt. Java doc has advantage of `0-Code` injection for your project src. |
| `dropTableBeforeCreate` | `boolean`    | Drop oraginal table before create new table | If true, the table created will be drop from database        |

- `@Dtt`

Which can annotate on you Java modle class or property of modle，Usually used in combination with `ParserType=ParserType.ANNOTATION`.

| property       | type    | desc                                                         | remark |
| -------------- | ------- | ------------------------------------------------------------ | ------ |
| `value`        | String  | when annotated on model class, can be as the commen of table, annotated on model property，can be as the comment of table column |        |
| `isPrimaryKey` | boolean | Mark whether the current column is the primary key, the default is `false` |        |
| `dbDataType`   | String  | DB data type, i.e（MySQL）: `varchar(64)`                    |        |
| `defaultValue` | String  | default value of current property，mapping to table column   |        |



### Yaml file configuration

You can easily  use in prefix of `alphahub.tt` in your porject，Here the  fully yaml property with default maybe you can reference it.  you can override in you `application.yml` if you don't need one of them. i.e:

[Or refere to source code](https://github.com/Weasley-J/mydtt-plus-spring-boot-starter/blob/main/mydtt-plus-spring-boot-starter/src/main/resources/META-INF/ddt-data-type-mapping.yml)

Particularly. when `all-in-one-table` set enbled,  DTT'll export a file with `all-in-one` type table DDL statements to the destination you set in your `application.yml` file.



## Develop Environment

### 1. Requirments

| items      | requirments                           | remark |
| ---------- | ------------------------------------- | ------ |
| JDK        | JDK1.8 or latest                      |        |
| SpringBoot | 2.2.0.RELEASE  <= version <= 3.0.0-M3 |        |
| IDE        | IDEA、Eclipse...                      |        |
| Maven      | v3.6.5 or latest                      |        |











## Features of DTT





## Database adaptation

| database     | version             | adaptation |
| ------------ | ------------------- | ---------- |
| `mysql`      | `5.7+` or latest    | ✅          |
| `oracle`     | `11.2.x`  or latest | ✅          |
| `db2`        | `11.x`  or latest   | ✅          |
| `sqlserver`  | `14.x` or latest    | ✅          |
| `mariadb`    | `10.x `or latest    | ✅          |
| `postgresql` | `v9.x` or latest    | ✅          |







## `UML` architecture diagram

![image-20220716190138301](https://alphahub-test-bucket.oss-cn-shanghai.aliyuncs.com/image/image-20220716190138301.png)





## Contribute your code

todo





## Question&Answer

todo





## Source code analysis of Sonarqube

![image-20220726180041339](https://alphahub-test-bucket.oss-cn-shanghai.aliyuncs.com/image/image-20220726180041339.png)

![image-20220726180112087](https://alphahub-test-bucket.oss-cn-shanghai.aliyuncs.com/image/image-20220726180112087.png)



## Credits

todo
