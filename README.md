# dtt-spring-boot-starter

## [![Maven Central](https://img.shields.io/maven-central/v/io.github.weasley-j/dtt-spring-boot-starter)](https://search.maven.org/artifact/io.github.weasley-j/dtt-spring-boot-starter)|[中文文档](https://github.com/Weasley-J/dtt-spring-boot-parent/blob/main/README_zh.md)

`DTT` is an object-oriented Java framework that enables developers to automatically create database tables based on domain models through annotation-driven development, increasing productivity for developers. The core concept of `DTT` is domain-driven table, which makes you focus more on domain objects rather than database tables.

> - What can DTT do?
>
> Tips: Read about DDT's features to learn more.
> 
>(a) Converts your Java domain object to `RDB` table `DDL` statements and auto create them.
> 
>(b) Supports the ability for `mybatis` to create table lazily on demand just like `hibernate` and `spring-data-jpa`  can do.
> 
>(c) Exports an `all-in-one` DDL statements for all tables as local file.
> 
>(d) Retains comments for columns of data tables for the Java developers who is non-native English speaker.
> 
>here is an example for the way of `0-code` injection to parse Java document to a table DDL statements.
> 
>- Chinese developer
> 
>1. Java domain
> 
>```java
> import com.example.enums.MemberType;
>import lombok.AllArgsConstructor;
> import lombok.Builder;
>import lombok.Data;
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
>CREATE TABLE IF NOT EXISTS `db_demo`.`dtt_member`
> (
>    `id`                    bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
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
>- Korean developer
> 
>1. Java domain
> 
>```java
> import com.example.enums.MemberType;
>import lombok.AllArgsConstructor;
> import lombok.Builder;
>import lombok.Data;
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
>CREATE TABLE IF NOT EXISTS `db_demo`.`dtt_member`
> (
>    `id`  bigint NOT NULL AUTO_INCREMENT COMMENT '기본 키 ID',
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
> It's easily to use DTT to integrate with Spring's ecosystem (mybatis-plus, mybatis, ... ) and enhance
> them，For [mybatis-plus](https://github.com/baomidou/mybatis-plus)  can be `0-Code` .
>
>

## Architecture

![DTT架构图](https://alphahub-test-bucket.oss-cn-shanghai.aliyuncs.com/image/DTT%E6%9E%B6%E6%9E%84%E5%9B%BE-1005672.png)

## Quick Start

- Add maven dependencies to your `pom.xml`

```xml

<dependencies>
  <!-- dtt-spring-boot-starter -->
  <dependency>
    <groupId>io.github.weasley-j</groupId>
    <artifactId>dtt-spring-boot-starter</artifactId>
    <version>1.4.0</version>
  </dependency>
  <!-- javadoc-scribe start  -->
  <dependency>
    <groupId>com.github.therapi</groupId>
    <artifactId>therapi-runtime-javadoc-scribe</artifactId>
    <version>0.15.0</version>
    <scope>provided</scope>
  </dependency>
  <!-- javadoc-scribe end  -->
</dependencies>
```



**OR**

- Clone this project into your dir.

```bash
git clone https://github.com/Weasley-J/dtt-spring-boot-parent.git
```

- `CD` to your work `DIR` then you can run this maven command to install DTT and use it in you projects.

Tips: For this step, I mean your `JDK` and `MAVEN` environment are set correctly.

```shell
mvn clean install -pl :dtt-spring-boot-starter -am
```

- Add maven dependencies into your `pom.xml `(The pom's parent must be
  extends `org.springframework.boot:spring-boot-starter-parent`)

**Tips**: `domain` model must be in the same `src` folder with `pom.xml`

```xml
<dependencies>
        <!-- dtt-spring-boot-starter -->
        <dependency>
            <groupId>io.github.weasley-j</groupId>
          <artifactId>dtt-spring-boot-starter</artifactId>
          <version>1.4.0</version>
        </dependency>
        <!-- javadoc-scribe start  -->
        <dependency>
            <groupId>com.github.therapi</groupId>
          <artifactId>therapi-runtime-javadoc-scribe</artifactId>
          <version>0.15.0</version>
          <scope>provided</scope>
        </dependency>
        <!-- javadoc-scribe end  -->
</dependencies>

```

- Configure your projects datasource in `application.yml`, e.g

```yaml
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://your_ip:3306/your_db?serverTimezone=Asia/Shanghai&useSSL=false&allowPublicKeyRetrieval=true&autoReconnect=true&allowMultiQueries=true
    username: your_username
    password: your_password
```

- Using Java annotation `@EnableDtt` to enable DTT to your projects Main class, As follow:

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

2022-07-17 22:15:13.894  INFO 12961 --- [           main] c.a.dtt.plus.framework.InitDttHandler    : Auto created '1' tables for '0' seconds. detail: {"dttStartTime":"2022-07-17 22:15:13","dttEndTime":"2022-07-17 22:15:13"}, location: /Users/weasley/Development/IdeaProjects/dtt-spring-boot-parent/ALL_IN_ONE.SQL

```

- Generate business source code with `DTT` through yaml configuration

Here is the example of `application.yml`:

```yaml
alphahub:
  dtt:
    code-generator:
      is-enable: off
      show-code: false
      override-exists: false
      module-name: dtt
      module-package: com.example
      module-path: /Users/weasley/Development/IdeaProjects/dtt-spring-boot-parent/dtt-spring-boot-tests/dtt-spring-boot-3-x
      base-package: com.example.domain.dtt
      base-classes: ""
```

[Full meta data for `code-generator` configuration](https://github.com/Weasley-J/dtt-spring-boot-parent/blob/main/dtt-spring-boot-starter/src/main/java/cn/alphahub/dtt/plus/config/DttProperties.java#L122-L121)
，the classes of `Service`,  `Mapper interface`, `Mapper.xml`, The directory structure is as follows:

![image-20220729171604994](https://alphahub-test-bucket.oss-cn-shanghai.aliyuncs.com/image/image-20220729171604994.png)

Next, you can use the generated code in some controller class，i.e:

```java
/**
 * Some controller
 */
@RestController
@RequestMapping("/api/member")
public class SomeController {
    @Autowired
    private DttMemberService memberService;

    @PostMapping("/save")
    @Transactional(rollbackFor = {Exception.class})
    public ResponseEntity<Boolean> save(@RequestBody DttMember member) {
        boolean save = memberService.save(member);
        return ResponseEntity.ok(save);
    }

    @PutMapping("/update")
    @Transactional(rollbackFor = {Exception.class})
    public ResponseEntity<Boolean> update(@RequestBody DttMember member) {
        boolean updated = memberService.updateById(member);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/info/{id}")
    public ResponseEntity<DttMember> info(@PathVariable Long id) {
        DttMember dttMember = memberService.getById(id);
        return ResponseEntity.ok(dttMember);
    }

    @GetMapping("/list/{ids}")
    public ResponseEntity<List<DttMember>> list(@PathVariable Long[] ids) {
        List<DttMember> list = memberService.listByIds(Arrays.asList(ids));
        return ResponseEntity.ok(list);
    }

    @DeleteMapping("/delete/{ids}")
    @Transactional(rollbackFor = {Exception.class})
    public ResponseEntity<Boolean> delete(@PathVariable Long[] ids) {
        boolean removed = memberService.removeByIds(Arrays.asList(ids));
        return ResponseEntity.ok(removed);
    }
}
```

That's the overview for `DTT` quick start.

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

### Yaml configuration

You can easily use in prefix of `alphahub.tt` in your porject，Here the fully yaml property with default maybe you can
reference it. you can override in you `application.yml` if you don't need one of them. i.e:

[Or refere to source code](https://github.com/Weasley-J/dtt-spring-boot-parent/blob/main/dtt-spring-boot-starter/src/main/resources/META-INF/ddt-data-mapper.yml#L1-L512)

Particularly. when `all-in-one-table` set enbled, DTT'll export a file with `all-in-one` type table DDL statements to
the destination you set in your `application.yml` file.



## Develop Environment

### 1. Requirments

| items      | requirments                           | remark |
| ---------- | ------------------------------------- | ------ |
| JDK        | JDK1.8 or latest                      |        |
| SpringBoot | 2.2.0.RELEASE  <= version <= 3.0.0-M3 |        |
| IDE        | IDEA、Eclipse...                      |        |
| Maven      | v3.6.5 or latest                      |        |

## Features of DTT

### 1 Good partner for RDB data migration

You can easily complete the creation of the target database in the RDB database that `DTT` has been adapted to without
modifying any source code, and can retain the remark information of each metadata of the old database. The whole process
takes about 20 seconds.

### 2 Create tables with the type of `0-code` injection

Which means DTT do nothing for your source code, you can specify `parserType = ParserType.JAVA_DOC` in `EnableDtt`
annotation. you can also make `parserType = ParserType.ANNOTATION` optional.

### 3 Export `SQL` for table's `DDL`  statement to local filesystem

`DTT` can Export `SQL` for table's `DDL`  statement to local file thorough yaml configuration optional that you can
modify those DLL statements.

### 4 Preserve all meta comments for database tables

DTT's parser support parsing the Java documentation also.

### 5 Specifies the character length of the metadata

You can configure for your configuration yaml like this, [Here is the link](https://github.com/Weasley-J/dtt-spring-boot-parent/blob/main/dtt-spring-boot-starter/src/main/resources/META-INF/ddt-data-mapper.yml#L130)

Example:

```yaml
alphahub:
  dtt:
    string-length-mapper:
      - database-type: MYSQL
        default-text-type: varchar
        default-text-length: 256
        length-configs:
          - text: phone,_tel,telephone,_user,_size
            length: 16
          - text: _id,_no,number,name,code,_code,_name
            length: 64
          - text: link,url,_url,_link
            length: 128
          - text: _msg,message,remark
            length: 512
          - text: request,response,body,text,content
            length: 768
```

Explanation：

Which means when your database is `MySQL`, A column contains filed of  `phone`, `_tel`, ... will be defined as type
of `varchar(16)`,if the `alphahub.dttstring-length-mapper.length-configs` list is not configured, the data type of the
column will be defined as: `varchar(256)`;

### 6 Infer default values automatically for database table columns

i.e:

- An enum type to illustrate DTT infer default values.

```java
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 会员类型枚举
 *
 * @author weasley
 * @version 1.0
 * @date 2022/7/9
 */
@Getter
@AllArgsConstructor
public enum MemberType {
    ORDINARY("普通会员"),
    STUDENT("学生会员"),
    GUNMETAL("青铜会员"),
    SILVER("白银会员"),
    GOLD("黄金会员"),
    DIAMOND("钻石会员"),
    SPORTS("体育会员"),
    PLUS("plus会员");

    /**
     * 会员描述
     */
    private final String desc;
}
```

- A domain class to infer diffrent table structure between `DTT` supported `RDB`

```java
/**
 * 用户信息-DttMember
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class DttMember implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键id
     */
    private Long id;
    /**
     * 用户openId
     */
    private String openId;
    /**
     * 用户昵称
     */
    private String nickname;
    /**
     * 是否启用, 默认：1
     */
    private Boolean isEnable = true;
    /**
     * 用户积分余额, 默认：0.00
     */
    private BigDecimal balance = BigDecimal.valueOf(0L, 2);
    /**
     * 出生日期，格式：yyyy-MM-dd HH:mm:ss
     */
    private LocalDateTime birthday;
    /**
     * 会员类型，默认：ORDINARY
     */
    private MemberType memberType = MemberType.ORDINARY;
    /**
     * 用户状态；0 正常(默认)，1 已冻结，2 账号已封，3 账号异常
     */
    private Integer status = 3;
    /**
     * 账户注销状态；0 未注销（默认），1 已销户
     */
    private Integer deleted = 0;
    /**
     * 注册时间，格式: yyyy-MM-dd
     */
    private LocalDate registrarDate;
    /**
     * 会员加速开始时间, 格式：HH:mm:ss
     */
    private LocalTime accelerateBeginTime;
    /**
     * 会员加速结束时间, 格式：HH:mm:ss
     */
    private LocalTime accelerateEndTime;
    /**
     * 修改时间
     */
    private LocalDateTime updateTime;
}
```

- For those properties which specified default value，`DTT` can infer the default value for different `RDB` which `DTT`
  has supported as follow:

```java
/**
 * 用户信息-DttMember
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class DttMember implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 是否启用, 默认：1
     */
    private Boolean isEnable = true;
    /**
     * 用户积分余额, 默认：0.00
     */
    private BigDecimal balance = BigDecimal.valueOf(0L, 2);
    /**
     * 会员类型，默认：ORDINARY
     */
    private MemberType memberType = MemberType.ORDINARY;
    /**
     * 用户状态；0 正常(默认)，1 已冻结，2 账号已封，3 账号异常
     */
    private Integer status = 3;
    /**
     * 账户注销状态；0 未注销（默认），1 已销户
     */
    private Integer deleted = 0;
}
```

**As you can see the default value specified by `DTT`  in the table DDL statement demonstrate the given 3 types RDB.**

#### (a) DB2

```sql
CREATE TABLE "TESTDB"."DTT_MEMBER"
(
    "ID"    BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
    "OPEN_ID"    VARCHAR(64) DEFAULT NULL,
    "NICKNAME"    VARCHAR(64) DEFAULT NULL,
    "IS_ENABLE"    BOOLEAN DEFAULT true,
    "BALANCE"    DECIMAL DEFAULT 0.00,
    "BIRTHDAY"    TIMESTAMP DEFAULT NULL,
    "MEMBER_TYPE"    VARCHAR(256) DEFAULT 'ORDINARY',
    "STATUS"    INTEGER DEFAULT 3,
    "DELETED"    INTEGER DEFAULT 0,
    "REGISTRAR_DATE"    DATE DEFAULT NULL,
    "ACCELERATE_BEGIN_TIME"    TIME DEFAULT NULL,
    "ACCELERATE_END_TIME"    TIME DEFAULT NULL,
    "UPDATE_TIME"    TIMESTAMP(6) DEFAULT CURRENT TIMESTAMP,
    PRIMARY KEY ("ID")
);
COMMENT ON TABLE "TESTDB"."DTT_MEMBER" IS '用户信息';
COMMENT ON COLUMN "TESTDB"."DTT_MEMBER"."ID" IS '主键id';
COMMENT ON COLUMN "TESTDB"."DTT_MEMBER"."OPEN_ID" IS '用户openId';
COMMENT ON COLUMN "TESTDB"."DTT_MEMBER"."NICKNAME" IS '用户昵称';
COMMENT ON COLUMN "TESTDB"."DTT_MEMBER"."IS_ENABLE" IS '是否启用, 默认：1';
COMMENT ON COLUMN "TESTDB"."DTT_MEMBER"."BALANCE" IS '用户积分余额, 默认：0.00';
COMMENT ON COLUMN "TESTDB"."DTT_MEMBER"."BIRTHDAY" IS '出生日期，格式：yyyy-MM-dd HH:mm:ss';
COMMENT ON COLUMN "TESTDB"."DTT_MEMBER"."MEMBER_TYPE" IS '会员类型，默认：ORDINARY, Enum type:ORDINARY,STUDENT,GUNMETAL,SILVER,GOLD,DIAMOND,SPORTS,PLUS';
COMMENT ON COLUMN "TESTDB"."DTT_MEMBER"."STATUS" IS '用户状态；0 正常(默认)，1 已冻结，2 账号已封，3 账号异常';
COMMENT ON COLUMN "TESTDB"."DTT_MEMBER"."DELETED" IS '账户注销状态；0 未注销（默认），1 已销户';
COMMENT ON COLUMN "TESTDB"."DTT_MEMBER"."REGISTRAR_DATE" IS '注册时间，格式: yyyy-MM-dd';
COMMENT ON COLUMN "TESTDB"."DTT_MEMBER"."ACCELERATE_BEGIN_TIME" IS '会员加速开始时间, 格式：HH:mm:ss';
COMMENT ON COLUMN "TESTDB"."DTT_MEMBER"."ACCELERATE_END_TIME" IS '会员加速结束时间, 格式：HH:mm:ss';
COMMENT ON COLUMN "TESTDB"."DTT_MEMBER"."UPDATE_TIME" IS '修改时间';
```

#### (b) SQL server

```sql
CREATE TABLE [dbo].[dtt_member]
(
    [id]    bigint PRIMARY KEY NOT NULL,
    [open_id]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [nickname]    varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT    NULL,
    [is_enable]    tinyint DEFAULT 1,
    [balance]    money DEFAULT 0.00,
    [birthday]    datetime2 DEFAULT NULL,
    [member_type]    varchar(256) DEFAULT 'ORDINARY',
    [status]    int DEFAULT 3,
    [deleted]    int DEFAULT 0,
    [registrar_date]    date DEFAULT NULL,
    [accelerate_begin_time]    time DEFAULT NULL,
    [accelerate_end_time]    time DEFAULT NULL,
    [update_time]    datetime2 DEFAULT NULL
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'用户信息',
    'SCHEMA', N'dbo',
    'TABLE', N'dtt_member'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'主键id',
    'SCHEMA', N'dbo',
    'TABLE', N'dtt_member',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'用户openId',
    'SCHEMA', N'dbo',
    'TABLE', N'dtt_member',
    'COLUMN', N'open_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'用户昵称',
    'SCHEMA', N'dbo',
    'TABLE', N'dtt_member',
    'COLUMN', N'nickname'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'是否启用, 默认：1',
    'SCHEMA', N'dbo',
    'TABLE', N'dtt_member',
    'COLUMN', N'is_enable'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'用户积分余额, 默认：0.00',
    'SCHEMA', N'dbo',
    'TABLE', N'dtt_member',
    'COLUMN', N'balance'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'出生日期，格式：yyyy-MM-dd HH:mm:ss',
    'SCHEMA', N'dbo',
    'TABLE', N'dtt_member',
    'COLUMN', N'birthday'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'会员类型，默认：ORDINARY, Enum type:ORDINARY,STUDENT,GUNMETAL,SILVER,GOLD,DIAMOND,SPORTS,PLUS',
    'SCHEMA', N'dbo',
    'TABLE', N'dtt_member',
    'COLUMN', N'member_type'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'用户状态；0 正常(默认)，1 已冻结，2 账号已封，3 账号异常',
    'SCHEMA', N'dbo',
    'TABLE', N'dtt_member',
    'COLUMN', N'status'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'账户注销状态；0 未注销（默认），1 已销户',
    'SCHEMA', N'dbo',
    'TABLE', N'dtt_member',
    'COLUMN', N'deleted'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'注册时间，格式: yyyy-MM-dd',
    'SCHEMA', N'dbo',
    'TABLE', N'dtt_member',
    'COLUMN', N'registrar_date'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'会员加速开始时间, 格式：HH:mm:ss',
    'SCHEMA', N'dbo',
    'TABLE', N'dtt_member',
    'COLUMN', N'accelerate_begin_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'会员加速结束时间, 格式：HH:mm:ss',
    'SCHEMA', N'dbo',
    'TABLE', N'dtt_member',
    'COLUMN', N'accelerate_end_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'修改时间',
    'SCHEMA', N'dbo',
    'TABLE', N'dtt_member',
    'COLUMN', N'update_time'
GO
```

#### (c) MySQL

```mysql
CREATE TABLE IF NOT EXISTS `db_demo`.`dtt_member`
(
  `id`                    bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `open_id`               varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci                                                                     DEFAULT NULL  COMMENT '用户openId',
  `nickname`              varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci                                                                     DEFAULT NULL  COMMENT '用户昵称',
  `is_enable`             tinyint                                                                                                                          DEFAULT true COMMENT '是否启用, 默认：1',
  `balance`               decimal                                                                                                                          DEFAULT 0.00 COMMENT '用户积分余额, 默认：0.00',
  `birthday`              datetime                                                                                                                         DEFAULT NULL COMMENT '出生日期，格式：yyyy-MM-dd HH:mm:ss',
  `member_type`           enum('ORDINARY','STUDENT','GUNMETAL','SILVER','GOLD','DIAMOND','SPORTS','PLUS') CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT 'ORDINARY' COMMENT '会员类型，默认：ORDINARY',
  `status`                int                                                                                                                              DEFAULT 3 COMMENT '用户状态；0 正常(默认)，1 已冻结，2 账号已封，3 账号异常',
  `deleted`               int                                                                                                                              DEFAULT 0 COMMENT '账户注销状态；0 未注销（默认），1 已销户',
  `registrar_date`        date                                                                                                                             DEFAULT NULL COMMENT '注册时间，格式: yyyy-MM-dd',
  `accelerate_begin_time` time                                                                                                                             DEFAULT NULL COMMENT '会员加速开始时间, 格式：HH:mm:ss',
  `accelerate_end_time`   time                                                                                                                             DEFAULT NULL COMMENT '会员加速结束时间, 格式：HH:mm:ss',
  `update_time`           datetime                                                                                                                         DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='用户信息-DttMember';
```

### 7 Configure precision for high precision data types

- [Here is the complete configurations](https://github.com/Weasley-J/dtt-spring-boot-parent/blob/main/dtt-spring-boot-starter/src/main/resources/META-INF/ddt-data-mapper.yml#L248)
- The following is an example of the default configuration built into DTT:

```yaml
alphahub:
  dtt:
    high-precision-data-mapper:
      high-precision-data-type: BigDecimal #The high precision data types of Java
      default-integer-length: 10 #The default length of the integer part
      default-decimal-length: 6 #The default length of fractional part
      precision-configs:
        - text: price,amount #The possible fields that need to be inferred, separated by ","(case insensitive)
          integer-length: 10 #The length of the integer part of the field
          decimal-length: 2 #The length of the fractional part
```

- Inference description, take the `h2` database as an example:

When the fields of the database table mapped by the private properties of your `Java` object contain `price`, `amount`
fields (case-insensitive), the data type of the column will be defined as: `NUMERIC(10,2 )`, if
the `alphahub.dtt.precision-configs` list is not configured, the data type of the column will be defined
as: `NUMERIC(10,6)`;

Generally, a high-precision data type is used to define the data type of currency. The default configuration of
DTT's `alphahub.dtt.precision-configs` includes `price`, `amount`, the fields is only applicable to the currency data
precision of `CNY` , If the developer is using the currency unit of other countries, I strongly recommend that the
developer configure the data precision that matches the business type in their own application to override the default
data precision configuration of `DTT` built in.

### 8 Integrate multi-mybatis framework with `0-Code`

1. `mybatis`: https://github.com/mybatis/spring-boot-starter
2. `mybatis-plus`: https://github.com/baomidou/mybatis-plus
3. `tk.mybatis`: https://search.maven.org/artifact/tk.mybatis/mapper-spring-boot-starter
4. `pagehelper`: https://search.maven.org/artifact/com.github.pagehelper/pagehelper

### 9 Built-in mybatis-plus code generator

`DTT` can help you build an enterprise development framework quickly, you can configure it in your project configuration
yaml file,

i.e:

```yaml
alphahub:
  dtt:
    code-generator:
      is-enable: on
      show-code: false
      override-exists: false
      module-name: dtt
      module-package: com.example
      module-path: /Users/weasley/Development/IdeaProjects/dtt-spring-boot-parent/dtt-spring-boot-tests/dtt-spring-boot-3-x
      base-package: com.example.domain.dtt
      base-classes: ""
```

[Here is the explaination for configuration meta-data](https://github.com/Weasley-J/dtt-spring-boot-parent/blob/main/dtt-spring-boot-starter/src/main/java/cn/alphahub/dtt/plus/config/DttProperties.java#L122-L121)

### 10 Support `mybatis` create table automatically

- **This feature only available for supported `RDB`**

- This feature depends on your `springboot` main class or configuration class annotated by `@EnableDtt`, you don't need
  to specify any properties of `@EnableDtt`, and you can set the `enabled` status to `disabled` through `yaml`
  configuration in different environment of your application（Default status is enabled）.
- Example of disabled `yaml` configuration

```yaml
alphahub:
  dtt:
    mybatis-orm-support:
      is-enable: false #Disable DTT to create table during execution SQL lifecycle of mybatis
```

- It is recommended to
  use [Dtt](https://github.com/Weasley-J/dtt-spring-boot-parent/blob/main/dtt-spring-boot-starter/src/main/java/cn/alphahub/dtt/plus/annotations/Dtt.java#L1-L64)
  annotation to annotate your domain model if your are none native English speaker, the domain model is
  missing [Dtt](https://github.com/Weasley-J/dtt-spring-boot-parent/blob/main/dtt-spring-boot-starter/src/main/java/cn/alphahub/dtt/plus/annotations/Dtt.java#L1-L64)
  annotation will cause the table to be created without column metadata comments like `Hibernate` created without
  comments. If your English is so well and you know the meaning of each metadata, it is fine not to add them.

  Here is an example of using a domain object using `@Dtt`:

```java
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 会员类型枚举
 *
 * @author weasley
 * @version 1.0
 * @date 2022/7/9
 */
@Getter
@AllArgsConstructor
public enum MemberType {
  ORDINARY("普通会员"),
  STUDENT("学生会员"),
  GUNMETAL("青铜会员"),
  PLUS("plus会员");

  /**
   * 会员描述
   */
  private final String desc;
}
```

```java
import cn.alphahub.dtt.plus.annotations.Dtt;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * 用户信息-DttPerson
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Dtt("用户信息")
public class DttMember implements Serializable {
  private static final long serialVersionUID = 1L;

  @Dtt(value = "主键id")
  private Long id;

  @Dtt(value = "用户openId")
  private String openId;

  @Dtt(value = "用户昵称")
  private String nickname;

  @Dtt(value = "是否启用, 默认：1")
  private Boolean isEnable = true;

  @Dtt(value = "用户积分余额, 默认：0.00")
  private BigDecimal balance = BigDecimal.valueOf(0L, 2);

  @Dtt(value = "出生日期，格式：yyyy-MM-dd HH:mm:ss")
  private LocalDateTime birthday;

  @Dtt(value = "会员类型，默认：ORDINARY")
  private MemberType memberType = MemberType.ORDINARY;

  @Dtt(value = "用户状态；0 正常(默认)，1 已冻结，2 账号已封，3 账号异常")
  private Integer status = 0;

  @Dtt(value = "账户注销状态；0 未注销（默认），1 已销户")
  private Integer deleted = 0;

  @Dtt(value = "注册时间，格式: yyyy-MM-dd")
  private LocalDate registrarDate;

  @Dtt(value = "会员加速开始时间, 格式：HH:mm:ss")
  private LocalTime accelerateBeginTime;

  @Dtt(value = "会员加速结束时间, 格式：HH:mm:ss")
  private LocalTime accelerateEndTime;

  @Dtt(value = "修改时间")
  private LocalDateTime updateTime;
}
```

End of this feature introduction, I want to note that in the development environment, the remarks of the data table can
be obtained by parsing `Java documentation`. In the environment of  `Jar`、 `war`，DTT doesn't support parsing `Java`
documents, so the comments for the created table are missing. If you want to synchronize the table structure
for `production environment` from `Dev environment` which created by `DTT`, then you can ignore to use`@Dtt`annotations
to annotate your domain objects，you can you some `RDB` tools.

### 11 Support calling API to create table

`API`: [cn.alphahub.dtt.plus.framework.miscellaneous.DttDefaultConditionalService#manualCreate](https://github.com/Weasley-J/dtt-spring-boot-parent/blob/main/dtt-spring-boot-starter/src/main/java/cn/alphahub/dtt/plus/framework/miscellaneous/DttDefaultConditionalService.java)

```java
/**
 * Manually specify a collection of fully qualified Class names to create database tables
 *
 * @param request The request data for dtt manual automatically create database tables
 * @return The list of 'DttManualActEntity'
 */
public List<DttManualActEntity> manualCreate(DttManualActRequest request){}
```

- Add the annotation `@EnableDtt` to the startup class of your `spring-boot` application, i.e:

```java
import cn.alphahub.dtt.plus.entity.DttManualActEntity;
import cn.alphahub.dtt.plus.entity.DttManualActRequest;
import cn.alphahub.dtt.plus.framework.annotations.EnableDtt;
import cn.alphahub.dtt.plus.framework.miscellaneous.DttDefaultConditionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Some Application
 */
@EnableDtt
@SpringBootApplication
public class SomeApplication {
  public static void main(String[] args) {
    SpringApplication.run(SomeApplication.class, args);
  }

  /**
   * Some controller
   */
  @RestController
  @RequestMapping("/api/member")
  public static class SomeController {
    @Autowired
    private DttDefaultConditionalService defaultConditionalService;

    @PostMapping("/manual/act")
    public List<DttManualActEntity> manualCreateTable(@RequestBody DttManualActRequest request) {
      return this.defaultConditionalService.manualCreate(request);
    }
  }
}
```

## Supported `RDB` type

| database     | version             | adaptation |
| ------------ | ------------------- | ---------- |
| `mysql`      | `5.7+` or latest    | ✅          |
| `oracle`     | `11.2.x`  or latest | ✅          |
| `db2`        | `11.x`  or latest   | ✅          |
| `sqlserver`  | `14.x` or latest    | ✅          |
| `mariadb`    | `10.x `or latest    | ✅          |
| `postgresql` | `v9.x` or latest    | ✅          |
| `h2`         | -                   | ✅          |
| `hsql`       | -                   | ✅          |
| `derby`      | -                   | ✅          |

## Performance

DTT support `either create table lazily on demand`（depends on mybatis framework） or` eagerly on startup`. this chapter
will explore the impact of enabling `DTT` on application performance from two
perspectives. [Here is the tests project](https://github.com/Weasley-J/dtt-spring-boot-parent/tree/main/dtt-spring-boot-tests/dtt-spring-boot-2-x)

### Test platform & environment

| item                        | value             | remark                                                       |
| --------------------------- | ----------------- | ------------------------------------------------------------ |
| Computer System             | Mac OS X          | MacBook Pro 14 (2021)                                        |
| Architecture                | aarch64           |                                                              |
| OS Version                  | 12.5.1            |                                                              |
| RAM                         | 32G               |                                                              |
| RDB                         | SQL Server        | version: 14.00.3451                                          |
| JDK                         | 1.8.0_342 (arm64) | ["Azul Systems, Inc." - "Zulu 8.64.0.15"](https://www.azul.com/downloads/?version=java-8-lts&os=macos&architecture=arm-64-bit&package=jdk) |
| Apache Maven                | 3.8.6             | https://maven.apache.org/download.cgi                        |
| DTT                         | 1.3.5             | https://search.maven.org/artifact/io.github.weasley-j/dtt-spring-boot-starter |
| spring-boot                 | 2.7.3             | https://search.maven.org/artifact/org.springframework.boot/spring-boot-starter-parent/2.7.3/pom |
| mybatis-plus-boot-starter   | 3.5.2             | https://search.maven.org/artifact/com.baomidou/mybatis-plus-boot-starter |
| mybatis-spring-boot-starter | 2.2.2             | https://search.maven.org/artifact/org.mybatis.spring.boot/mybatis-spring-boot-starter |
| pagehelper-spring-boot      | 1.4.3             | https://search.maven.org/artifact/com.github.pagehelper/pagehelper-spring-boot |
| mapper-spring-boot-starter  | 4.2.1             | https://search.maven.org/artifact/tk.mybatis/mapper-spring-boot-starter |

### **Create table eagerly on startup**

1. Enable DTT for your application

- [x] Main class of application

```java
import cn.alphahub.dtt.plus.enums.ParserType;
import cn.alphahub.dtt.plus.framework.annotations.EnableDtt;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDtt(
        scanBasePackages = {
                "com.example.domain.dtt", "com.example.domain.order"
        },
        scanBaseClasses = {},
        parserType = ParserType.JAVA_DOC,
        dropTableBeforeCreate = true
)
@SpringBootApplication
@MapperScan(basePackages = {"com.example.mapper"})
public class MydttPlus2xTestApp {
  public static void main(String[] args) {
    SpringApplication.run(MydttPlusTestApplication.class, args);
  }
}
```

```yaml
# The application.yml of sqlserver
spring:
  datasource:
    driver-class-name: com.microsoft.sqlserver.jdbc.SQLServerDriver
    url: jdbc:sqlserver://192.168.31.23:1433;databaseName=dtt_demo;integratedSecurity=false;encrypt=false;
    username: SA
    password: weasley@dtt123

mybatis-plus:
  mapper-locations: classpath:mapper/**/*Mapper.xml,mapper/**/*Dao.xml
  type-aliases-package: com.example.domain.dtt,com.example.domain.order
  configuration:
    map-underscore-to-camel-case: true
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl

alphahub:
  dtt:
    show-sql: false
    all-in-one-table:
      enable: true
      filename: AllInOne.sql
      filepath: /Users/weasley/Downloads
    code-generator:
      is-enable: on
      base-package: com.example.domain.order
      module-package: com.example
      module-name: order
      module-path: /Users/weasley/Development/IdeaProjects/dtt-spring-boot-parent/dtt-spring-boot-tests/dtt-spring-boot-2-x
```

Note: The property `scanBasePackages`'s value of `@EnableDtt` is the same as the value
of `mybatis-plus.type-aliases-package` or `mybatis.type-aliases-package` . Those classes are mapped to your database
table.

- [x] Start application with Enabling `DTT`

As we can see from the image:

![image-20220819170348473](https://alphahub-test-bucket.oss-cn-shanghai.aliyuncs.com/image/image-20220819170348473.png)

```log
2022-08-19 16:56:24.609  INFO 8331 --- [           main] com.example.MydttPlusTestApplication     : Started MydttPlusTestApplication in 2.132 seconds (JVM running for 2.598)

2022-08-19 16:56:26.845  INFO 8331 --- [           main] c.a.dtt.plus.framework.InitDttHandler    : Auto created tables for '2' seconds. detail: {"dttStartTime":"2022-08-19 16:56:24","dttEndTime":"2022-08-19 16:56:26"}, location: /Users/weasley/Downloads/AllInOne.sql
```

DTT has done two things in the logger:

(a) Generate `Service`, `Mapper`, `Mapper.xml` source code

![image-20220819171137271](https://alphahub-test-bucket.oss-cn-shanghai.aliyuncs.com/image/image-20220819171137271.png)

(b) created `63` tables based on your domain objects

![image-20220819171207065](https://alphahub-test-bucket.oss-cn-shanghai.aliyuncs.com/image/image-20220819171207065.png)

`DTT` takes `2` seconds to do what it's supposed to do, which means to use `DTT` based on your domain objects you just
need to write some `Controller` to satisfy your business interface, for
example: [SomeController](https://github.com/Weasley-J/dtt-spring-boot-parent/blob/main/dtt-spring-boot-tests/dtt-spring-boot-2-x/src/main/java/com/example/controller/SomeController.java)

2. Disable DTT for your application

- [x] Main class

```java
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan(basePackages = {"com.example.mapper"})
public class MydttPlus2xTestApp {
  public static void main(String[] args) {
    SpringApplication.run(MydttPlusTestApplication.class, args);
  }
}
```

![image-20220819172757581](https://alphahub-test-bucket.oss-cn-shanghai.aliyuncs.com/image/image-20220819172757581.png)

```log
2022-08-19 17:27:42.829  INFO 21286 --- [           main] MydttPlus2xTestApp     : Started MydttPlus2xTestApp in 2.122 seconds (JVM running for 2.381)
```

Started MydttPlusTestApplication in 2.122 seconds without `DTT`.

3. Compare

| APP                | Loading type       | DTT  | Time                 |
| ------------------ | ------------------ | ---- | -------------------- |
| MydttPlus2xTestApp | default            | NO   | 2.122s               |
| MydttPlus2xTestApp | eagerly on startup | YES  | 2.132s + 2s = 4.132s |

### Create table lazily on demand

`Create table lazily on demand` means that when mybatis executes `DDL` or `DQL` statements, if there is no corresponding
table in the database, DTT will be created, and the cache design is used here.

For this step, delete the test table from your SQL server database, clear your console of IDE,

`com.example.domain.dtt.DttMember` -> `dtt_member`

(1) Main class

```java
import cn.alphahub.dtt.plus.framework.annotations.EnableDtt;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDtt
@SpringBootApplication
@MapperScan(basePackages = {"com.example.mapper"})
public class MydttPlus2xTestApp {
  public static void main(String[] args) {
    SpringApplication.run(MydttPlus2xTestApp.class, args);
  }
}
```

(2) application.yml

```yaml
logging:
  level:
    org.springframework.jdbc.core.JdbcTemplate: debug
    jdbc.sqltiming: debug

spring:
  datasource:
    driver-class-name: com.microsoft.sqlserver.jdbc.SQLServerDriver
    url: jdbc:sqlserver://192.168.31.23:1433;databaseName=dtt_demo;integratedSecurity=false;encrypt=false;
    username: SA
    password: weasley@dtt123

mybatis-plus:
  mapper-locations: classpath:mapper/**/*Mapper.xml,mapper/**/*Dao.xml
  type-aliases-package: com.example.domain.dtt,com.example.domain.order
  configuration:
    map-underscore-to-camel-case: true
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl

alphahub:
  dtt:
    code-generator:
      is-enable: on
      base-classes:
        - com.example.domain.dtt.DttMember
      module-name: dtt
      module-package: com.example
      module-path: /Users/weasley/Development/IdeaProjects/dtt-spring-boot-parent/dtt-spring-boot-tests/dtt-spring-boot-2-x

```

- [x] Here is the console for step `(2)`.

![image-20220819175802755](https://alphahub-test-bucket.oss-cn-shanghai.aliyuncs.com/image/image-20220819175802755.png)

```log
2022-08-19 17:57:41.708  INFO 33463 --- [           main] com.example.DttPlus2xAnnotationTest           : Started MydttPlus2xTestApp in 1.873 seconds (JVM running for 2.129)
```

Access the same interface twice, simulating DTT to build tables on demand, Here is the API
url: http://localhost:8080/api/member/save/no/params

**(a) 1st logger:**

Create table if donest exists, The concrete DDL implementation delegates to the RDB implementation class.

```log
-08-19 18:10:12.339  INFO 38516 --- [           main] com.example.DttPlus2xAnnotationTest           : Started MydttPlus2xTestApp in 2.448 seconds (JVM running for 2.707)
2022-08-19 18:10:12.344  WARN 38516 --- [           main] c.a.dtt.plus.framework.InitDttHandler    : Data model is empty. DTT cannot parse.
2022-08-19 18:10:21.078  INFO 38516 --- [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2022-08-19 18:10:21.078  INFO 38516 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2022-08-19 18:10:21.079  INFO 38516 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 1 ms
Creating a new SqlSession
Registering transaction synchronization for SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@7ab15e2a]
JDBC Connection [HikariProxyConnection@1139253693 wrapping ConnectionID:2 ClientConnectionId: f2679647-4094-4f20-a812-ee941a778b4a] will be managed by Spring
2022-08-19 18:10:21.183  INFO 38516 --- [nio-8080-exec-1] c.a.d.p.f.i.DefaultDttMybatisInterceptor : Table of 'dtt_member' not exists, DTT will help you to create it automatically.
2022-08-19 18:10:21.183  INFO 38516 --- [nio-8080-exec-1] c.a.d.p.f.core.DefaultJavaDocParser      : Parse Java Doc comments for data table structure information，class 'com.example.domain.dtt.DttMember'
2022-08-19 18:10:21.215  INFO 38516 --- [nio-8080-exec-1] c.a.d.p.f.c.DefaultSqlserverTableHandler : 使用sqlserver默认建表实现 {"databaseName":"dtt_demo","modelName":"dtt_member","modelComment":"用户信息","details":[{"isPrimaryKey":true,"databaseDataType":"bigint","javaDataType":"Long","filedName":"id","filedComment":"主键id","initialValue":"NULL"},{"isPrimaryKey":false,"databaseDataType":"varchar(64)","javaDataType":"String","filedName":"open_id","filedComment":"用户openId","initialValue":"NULL"},{"isPrimaryKey":false,"databaseDataType":"varchar(64)","javaDataType":"String","filedName":"nickname","filedComment":"用户昵称","initialValue":"NULL"},{"isPrimaryKey":false,"databaseDataType":"tinyint","javaDataType":"Boolean","filedName":"is_enable","filedComment":"是否启用, 默认：1","initialValue":"true"},{"isPrimaryKey":false,"databaseDataType":"money","javaDataType":"BigDecimal","filedName":"balance","filedComment":"用户积分余额, 默认：0.00","initialValue":"0.00"},{"isPrimaryKey":false,"databaseDataType":"datetime2","javaDataType":"LocalDateTime","filedName":"birthday","filedComment":"出生日期，格式：yyyy-MM-dd HH:mm:ss","initialValue":"NULL"},{"isPrimaryKey":false,"databaseDataType":"varchar('ORDINARY','STUDENT','GUNMETAL','SILVER','GOLD','DIAMOND','SPORTS','PLUS')","javaDataType":"Enum","filedName":"member_type","filedComment":"会员类型，默认：ORDINARY","initialValue":"ORDINARY"},{"isPrimaryKey":false,"databaseDataType":"int","javaDataType":"Integer","filedName":"status","filedComment":"用户状态；0 正常(默认)，1 已冻结，2 账号已封，3 账号异常","initialValue":"3"},{"isPrimaryKey":false,"databaseDataType":"int","javaDataType":"Integer","filedName":"deleted","filedComment":"账户注销状态；0 未注销（默认），1 已销户","initialValue":"0"},{"isPrimaryKey":false,"databaseDataType":"date","javaDataType":"LocalDate","filedName":"registrar_date","filedComment":"注册时间，格式: yyyy-MM-dd","initialValue":"NULL"},{"isPrimaryKey":false,"databaseDataType":"time","javaDataType":"LocalTime","filedName":"accelerate_begin_time","filedComment":"会员加速开始时间, 格式：HH:mm:ss","initialValue":"NULL"},{"isPrimaryKey":false,"databaseDataType":"time","javaDataType":"LocalTime","filedName":"accelerate_end_time","filedComment":"会员加速结束时间, 格式：HH:mm:ss","initialValue":"NULL"},{"isPrimaryKey":false,"databaseDataType":"datetime2","javaDataType":"LocalDateTime","filedName":"update_time","filedComment":"修改时间","initialValue":"NULL"}]}
2022-08-19 18:10:21.229  INFO 38516 --- [nio-8080-exec-1] c.a.d.p.f.core.DefaultTemplateResolver   : 数据库建表语句: 
CREATE TABLE [dbo].[dtt_member]
(
    [id]    bigint PRIMARY KEY NOT NULL,
    [open_id]    varchar(64) COLLATE Chinese_PRC_CI_AS DEFAULT NULL,
    [nickname]    varchar(64) COLLATE Chinese_PRC_CI_AS DEFAULT NULL,
    [is_enable]    tinyint DEFAULT 1,
    [balance]    money DEFAULT 0.00,
    [birthday]    datetime2 DEFAULT NULL,
    [member_type]    varchar(256) DEFAULT 'ORDINARY',
    [status]    int DEFAULT 3,
    [deleted]    int DEFAULT 0,
    [registrar_date]    date DEFAULT NULL,
    [accelerate_begin_time]    time DEFAULT NULL,
    [accelerate_end_time]    time DEFAULT NULL,
    [update_time]    datetime2 DEFAULT NULL
)
GO
EXEC sp_addextendedproperty
    'MS_Description', N'用户信息',
    'SCHEMA', N'dbo',
    'TABLE', N'dtt_member'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'主键id',
    'SCHEMA', N'dbo',
    'TABLE', N'dtt_member',
    'COLUMN', N'id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'用户openId',
    'SCHEMA', N'dbo',
    'TABLE', N'dtt_member',
    'COLUMN', N'open_id'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'用户昵称',
    'SCHEMA', N'dbo',
    'TABLE', N'dtt_member',
    'COLUMN', N'nickname'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'是否启用, 默认：1',
    'SCHEMA', N'dbo',
    'TABLE', N'dtt_member',
    'COLUMN', N'is_enable'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'用户积分余额, 默认：0.00',
    'SCHEMA', N'dbo',
    'TABLE', N'dtt_member',
    'COLUMN', N'balance'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'出生日期，格式：yyyy-MM-dd HH:mm:ss',
    'SCHEMA', N'dbo',
    'TABLE', N'dtt_member',
    'COLUMN', N'birthday'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'会员类型，默认：ORDINARY, Enum type:ORDINARY,STUDENT,GUNMETAL,SILVER,GOLD,DIAMOND,SPORTS,PLUS',
    'SCHEMA', N'dbo',
    'TABLE', N'dtt_member',
    'COLUMN', N'member_type'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'用户状态；0 正常(默认)，1 已冻结，2 账号已封，3 账号异常',
    'SCHEMA', N'dbo',
    'TABLE', N'dtt_member',
    'COLUMN', N'status'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'账户注销状态；0 未注销（默认），1 已销户',
    'SCHEMA', N'dbo',
    'TABLE', N'dtt_member',
    'COLUMN', N'deleted'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'注册时间，格式: yyyy-MM-dd',
    'SCHEMA', N'dbo',
    'TABLE', N'dtt_member',
    'COLUMN', N'registrar_date'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'会员加速开始时间, 格式：HH:mm:ss',
    'SCHEMA', N'dbo',
    'TABLE', N'dtt_member',
    'COLUMN', N'accelerate_begin_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'会员加速结束时间, 格式：HH:mm:ss',
    'SCHEMA', N'dbo',
    'TABLE', N'dtt_member',
    'COLUMN', N'accelerate_end_time'
GO
EXEC sp_addextendedproperty
    'MS_Description', N'修改时间',
    'SCHEMA', N'dbo',
    'TABLE', N'dtt_member',
    'COLUMN', N'update_time'
GO

Transaction synchronization suspending SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@7ab15e2a]
2022-08-19 18:10:21.343 DEBUG 38516 --- [nio-8080-exec-1] o.s.jdbc.core.JdbcTemplate               : Executing SQL batch update of 15 statements
Transaction synchronization resuming SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@7ab15e2a]
==>  Preparing: SELECT MAX(ID) id FROM dtt_member
==> Parameters: 
<==    Columns: id
<==        Row: null
<==      Total: 1
Releasing transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@7ab15e2a]
JDBC Connection [HikariProxyConnection@1139253693 wrapping ConnectionID:2 ClientConnectionId: f2679647-4094-4f20-a812-ee941a778b4a] will be managed by Spring
==>  Preparing: INSERT INTO dtt_member ( id, open_id, nickname, is_enable, balance, birthday, member_type, status, deleted, registrar_date, accelerate_begin_time, accelerate_end_time, update_time ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )
==> Parameters: 1560569852266041346(Long), fawezOE5sT(String), 蒋震南(String), true(Boolean), 865(BigDecimal), 2022-08-19T18:10:21.135(LocalDateTime), STUDENT(String), 0(Integer), 1(Integer), 2022-08-19(LocalDate), 18:10:21.135(LocalTime), 18:10:21.135(LocalTime), 2022-08-19T18:10:21.135(LocalDateTime)
2022-08-19 18:10:21.449  INFO 38516 --- [nio-8080-exec-1] com.example.controller.SomeController    : {"id":1560569852266041346,"openId":"fawezOE5sT","nickname":"蒋震南","isEnable":true,"balance":865,"birthday":"2022-08-19 18:10:21","memberType":"STUDENT","status":0,"deleted":1,"registrarDate":"2022-08-19","accelerateBeginTime":"18:10:21","accelerateEndTime":"18:10:21","updateTime":"2022-08-19 18:10:21"}
Transaction synchronization committing SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@7ab15e2a]
Transaction synchronization deregistering SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@7ab15e2a]
Transaction synchronization closing SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@7ab15e2a]
```

**(b) 2nd logger**

Cause by table exists, DTT does nothing.

```log
2022-08-19 18:10:21.449  INFO 38516 --- [nio-8080-exec-1] com.example.controller.SomeController    : {"id":1560569852266041346,"openId":"fawezOE5sT","nickname":"蒋震南","isEnable":true,"balance":865,"birthday":"2022-08-19 18:10:21","memberType":"STUDENT","status":0,"deleted":1,"registrarDate":"2022-08-19","accelerateBeginTime":"18:10:21","accelerateEndTime":"18:10:21","updateTime":"2022-08-19 18:10:21"}
Transaction synchronization committing SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@7ab15e2a]
Transaction synchronization deregistering SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@7ab15e2a]
Transaction synchronization closing SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@7ab15e2a]
Creating a new SqlSession
Registering transaction synchronization for SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@5167ea53]
JDBC Connection [HikariProxyConnection@1537179939 wrapping ConnectionID:2 ClientConnectionId: f2679647-4094-4f20-a812-ee941a778b4a] will be managed by Spring
==>  Preparing: SELECT MAX(ID) id FROM dtt_member
==> Parameters: 
<==    Columns: id
<==        Row: 1560569852266041346
<==      Total: 1
Releasing transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@5167ea53]
JDBC Connection [HikariProxyConnection@1537179939 wrapping ConnectionID:2 ClientConnectionId: f2679647-4094-4f20-a812-ee941a778b4a] will be managed by Spring
==>  Preparing: INSERT INTO dtt_member ( id, open_id, nickname, is_enable, balance, birthday, member_type, status, deleted, registrar_date, accelerate_begin_time, accelerate_end_time, update_time ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )
==> Parameters: 1560569852266041347(Long), fawezOE5sT(String), 蒋震南(String), true(Boolean), 865(BigDecimal), 2022-08-19T18:13:45.066(LocalDateTime), STUDENT(String), 0(Integer), 1(Integer), 2022-08-19(LocalDate), 18:13:45.066(LocalTime), 18:13:45.066(LocalTime), 2022-08-19T18:13:45.066(LocalDateTime)
2022-08-19 18:13:45.082  INFO 38516 --- [nio-8080-exec-3] com.example.controller.SomeController    : {"id":1560569852266041347,"openId":"fawezOE5sT","nickname":"蒋震南","isEnable":true,"balance":865,"birthday":"2022-08-19 18:13:45","memberType":"STUDENT","status":0,"deleted":1,"registrarDate":"2022-08-19","accelerateBeginTime":"18:13:45","accelerateEndTime":"18:13:45","updateTime":"2022-08-19 18:13:45"}
Transaction synchronization committing SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@5167ea53]
Transaction synchronization deregistering SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@5167ea53]
Transaction synchronization closing SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@5167ea53]
```

- [x] Console of default（Without DTT）

![image-20220819175658344](https://alphahub-test-bucket.oss-cn-shanghai.aliyuncs.com/image/image-20220819175658344.png)

`2022-08-19 17:52:56.045  INFO 31535 --- [           main] com.example.DttPlus2xAnnotationTest           : Started MydttPlus2xTestApp in 1.293 seconds (JVM running for 1.55)`

(3) Compare

| APP                | Loading type     | DTT  | Time   |
| ------------------ | ---------------- | ---- | ------ |
| MydttPlus2xTestApp | default          | NO   | 1.293s |
| MydttPlus2xTestApp | lazily on demand | YES  | 1.873s |

From the data comparison in the above table, it is easy to see that lazily on demand has little effect on performance.

> The test is made under the circumstances where personal energy and time are limited. Please forgive me if there are
> some inadequacies.

## Contribute your code

todo

## Question&Answer

- Those `ORM` frameworks which can be integrated `DTT` with `0-Code`?

1. `mybatis`: https://github.com/mybatis/spring-boot-starter
2. `mybatis-plus`: https://github.com/baomidou/mybatis-plus
3. `tk.mybatis`: https://search.maven.org/artifact/tk.mybatis/mapper-spring-boot-starter
4. `pagehelper`: https://search.maven.org/artifact/com.github.pagehelper/pagehelper

## Source code quality

![image-20220819122523273](https://alphahub-test-bucket.oss-cn-shanghai.aliyuncs.com/image/image-20220819122523273.png)

![image-20220819122621908](https://alphahub-test-bucket.oss-cn-shanghai.aliyuncs.com/image/image-20220819122621908.png)

## Credits

- Java document analyse

[com.github.therapi:therapi-runtime-javadoc](https://github.com/dnault/therapi-runtime-javadoc)

- Template engine language

[org.apache.velocity:velocity-engine-core](https://search.maven.org/artifact/org.apache.velocity/velocity-engine-core/2.3/jar)

- jsqlparser

[com.github.jsqlparser:jsqlparser](https://search.maven.org/artifact/com.github.jsqlparser/jsqlparser)
