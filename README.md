# mydtt-plus-spring-boot-starter

> - What is DTT?
>
> It's means  `Domain-to-Table`，As we know，The Object of Java is `Domain`，Database's is `Table` yet.
>
> 
>
> - What can DTT do?
>
> Its can easily convert Java domain to SQL create table statement and auto create them，As follow:
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
>     private Integer status = 0;
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
>     `id`  bigint NOT NULL AUTO_INCREMENT COMMENT '',
>     `open_id`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '',
>     `nickname`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL  COMMENT '',
>     `is_enable`  tinyint                                                  DEFAULT true COMMENT '',
>     `balance`  decimal                                                  DEFAULT 0.00 COMMENT '',
>     `birthday`  datetime                                                  DEFAULT NULL COMMENT '',
>     `member_type`  enum('ORDINARY','STUDENT','GUNMETAL','SILVER','GOLD','DIAMOND','SPORTS','PLUS') CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT 'ORDINARY' COMMENT '',
>     `status`  int                                                  DEFAULT 0 COMMENT '',
>     `deleted`  int                                                  DEFAULT 0 COMMENT '',
>     `registrar_date`  date                                                  DEFAULT NULL COMMENT '',
>     `accelerate_begin_time`  time                                                  DEFAULT NULL COMMENT '',
>     `accelerate_end_time`  time                                                  DEFAULT NULL COMMENT '',
>     `update_time`  datetime                                                  DEFAULT NULL COMMENT '',
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
> **You can easily integrate with spring's ecosystem(mybatis-plus, mybatis, ... ) and enhance them， I first support for MySQL implements，ORACLE, DB2, SQLSERVER, MARIADB, POSTGRESQL wil be support in the future.  Thanks for you star.** 
>
> 







## 1 Quick Start

- Clone  this project into your dir.

```bash
git clone https://github.com/Weasley-J/mydtt-plus-spring-boot-starter.git
```



- CD to your work dir then you can run this maven command to install DTT and use it in you projects.

Tips: For this step, I mean your JDK and MAVEN environment are set correctly.

```shell
mvn clean install -pl :mydtt-plus-spring-boot-starter -am
```



- Add maven dependencies into your `pom.xml `(The pom's parent must be extends `org.springframework.boot:spring-boot-starter-parent`)

**Tips**: `domain` model must be in the same `src` folder with `pom.xml`

```xml
<properties>
        <therapi-runtime-javadoc.version>0.13.0</therapi-runtime-javadoc.version>
        <mydtt-plus.version>1.0.0</mydtt-plus.version>
</properties>

<dependencies>
        <!-- mydtt-plus-spring-boot-starter -->
        <dependency>
            <groupId>cn.alphahub</groupId>
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



Read more?

```java

import cn.alphahub.dtt.plus.config.DataSourceAutoConfig;
import cn.alphahub.dtt.plus.config.DefaultExtraPropertiesLoader;
import cn.alphahub.dtt.plus.config.DefaultExtraYamlSourceLoader;
import cn.alphahub.dtt.plus.config.InitDttClient;
import cn.alphahub.dtt.plus.config.InitDttHandler;
import cn.alphahub.dtt.plus.config.VelocityHandler;
import cn.alphahub.dtt.plus.enums.ParseType;
import cn.alphahub.dtt.plus.framework.core.*;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 启用 Dtt 处理程
 * <p>
 * <b>What is DTT?</b>
 *     <ul>
 *         <li>It's means  `Domain-to-Table`，As we know，The Object of Java is `Domain`，Database's is `Table` yet.</li>
 *         <li>You can easily use the '@EnableDtt' annotation to prevent JAVA objects from automatically creating data tables into your database with minimal configuration</li>
 *         <li>DTT can easily preserve comments on database from 'java doc' to database table comments</li>
 *     </ul>
 * </p>
 *
 * @author weasley
 * @version 1.0.0
 */
@Inherited
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({DataSourceAutoConfig.class, InitDttHandler.class, DefaultAnnotationParser.class,
        DefaultJavaDocParser.class, DefaultDb2TableHandler.class, DefaultMariadbTableHandler.class,
        DefaultMysqlTableHandler.class, DefaultOracleTableHandler.class, DefaultPostgresqlTableHandler.class,
        DefaultSqlserverTableHandler.class, VelocityHandler.class, DttRunner.class,
        DefaultExtraPropertiesLoader.class, DefaultExtraYamlSourceLoader.class, InitDttClient.class
})
public @interface EnableDtt {
    /**
     * Java域模型的基础包路径，全限定包路径
     *
     * @return Java域模型的基础包路径
     */
    String[] scanBasePackages() default {};

    /**
     * Type-safe alternative to {@link #scanBasePackages} for specifying the classes to
     * scan,each class specified will be scanned.
     * <p>
     * JAVA model classes to scan
     * <p>
     * <strong>Note:</strong> Applicable to incremental table creation, when {@link #scanBasePackages} is specified,
     * it will scan all classes in the package specified by {@link #scanBasePackages}
     *
     * @return base classes to scan
     * @since 1.0.0
     */
    Class<?>[] scanBaseClasses() default {};

    /**
     * 解析模型私有属性注释的方式
     *
     * @return 是否使用Comment注解解析表结构，有代码侵入性，默认使用Java Doc注释
     * @see ParseType
     */
    ParseType parseCommentType() default ParseType.JAVA_DOC;

    /**
     * 创建前删除表
     *
     * @return 创建前是否删除表
     */
    boolean dropTableBeforeCreate() default false;
}
```



You can enable the required functions as needed







## 2 `UML` architecture diagram

![image-20220713150846860](https://alphahub-test-bucket.oss-cn-shanghai.aliyuncs.com/image/image-20220713150846860.png)





## 3 Contribute your code



todo





## 4 A&Q

 todo



## 5 Credits

todo
