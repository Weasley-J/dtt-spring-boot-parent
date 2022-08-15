# mydtt-plus-spring-boot-starter

## [![Maven Central](https://img.shields.io/maven-central/v/io.github.weasley-j/mydtt-plus-spring-boot-starter)](https://search.maven.org/artifact/io.github.weasley-j/mydtt-plus-spring-boot-starter)

> `DTT`是一个面向对象的`Java`开发框架，领域驱动表是`DTT`的核心理念,
> 它强调开发者在开发过程中应该更多关注领域而不是数据表，`DTT`可以根据你的域对象推断并创建数据库表,
> 并保留元数据所有备注，这是`JPA`不具备的，这大概也是`JPA`在非英语母国家不被广泛使用的原因之一，`DTT`支持 `0代码`
> 集成`mybatis`生态的`ORM`框架, 将你从表设计工具中解放出来使你真正面向对象开发.

# 快速开始

[See also](https://github.com/Weasley-J/mydtt-plus-spring-boot-starter/blob/ae8a7327db01b5c31bd7a2ccd2bf0be62942c9d2/README.md#L245)

# 开发环境

# DTT功能

### 1 `RDB`数据迁移的好搭档

你可以在受`DTT`支持的关系型数据库中不改变原项目代码的前提下很容易地进行数据迁移，`DTT`可以你在不改变任何代码的前提下20秒左右的时间帮你创建好上百张数据表

### 2 支持`0代码`入侵的方式建表

DTT支持如下两种解析器类型：

```java
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 解析模型私有属性注释的方式
 *
 * @author weasley
 * @version 1.0
 * @date 2022/7/10
 */
@Getter
@AllArgsConstructor
public enum ParserType {
    /**
     * java doc
     */
    JAVA_DOC,
    /**
     * 使用{@code @Dtt}注解
     *
     * @see Dtt
     */
    ANNOTATION,
    ;
}
```

其中Java注释解析建表是我比较推荐的，因为它不会修改你的任何源码。

### 3 保留所有数据表的列的元注释

让你很轻松的就能知道每表里面每一列含义

### 4 将表的DDL语句导出为本地文件

你可以通过配置文件进行配置，示例：

```yaml
alphahub:
  dtt:
    all-in-one-table:
      enable: true
      filename: AllInOne.sql
      filepath: /Users/weasley/Downloads
```

### 5 自定义字符串类型的列的长度

示例:

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

解释：

如果你的数据库是`mysql`，数据表里面如果列名包含：`phone`,`_tel`等字段时该列会被定义为`varchar(16)`,
DTT会有一切默认长度的自动推断，你可以想示例里面的例子一样在你的`yaml`文件中覆盖它.

[完整的配置文件](https://github.com/Weasley-J/mydtt-plus-spring-boot-starter/blob/main/mydtt-plus-spring-boot-starter/src/main/resources/META-INF/ddt-data-mapper.yml#L130)

### 6 配置高精度数据类型的精度

[完整的配置文件](https://github.com/Weasley-J/mydtt-plus-spring-boot-starter/blob/main/mydtt-plus-spring-boot-starter/src/main/resources/META-INF/ddt-data-mapper.yml#L248)

- 以下是DTT内置的默认配置示例:

```yaml
alphahub:
  dtt:
    high-precision-data-mapper:
      high-precision-data-type: BigDecimal #Java的高精度数据类型
      default-integer-length: 10 #整数部分的默认长度
      default-decimal-length: 6 #小数部分的默认长度
      precision-configs:
        - text: price,amount #需要推断推断的可能包含的字段，多个用","隔开, 不区分大小写
          integer-length: 10 #该字段的整数部分的长度
          decimal-length: 2 #小该数部分的长度
```

- 推断说明，以`h2`数据库为例：

当你的`Java`对象的私有属性所映射的数据库表的字段包含`price`,`amount`
字段时（不区分大小写），该列的数据类型会被定义为: `NUMERIC(10,2)`, 如果未配置`alphahub.dtt.precision-configs`
列表，该列的数据类型会被定义为: `NUMERIC(10,6)`;

一般会使用高精度的数据类型来定义货币的数据类型，DTT的`alphahub.dtt.precision-configs`的默认配置包含`price`,`amount`
字段的配置仅适用于`CNY`的货币数据精度,
如果开发者使用的是其他国家的货币单位，我强烈建议开发者在自己的应用中配置符合业务类型的数据精度来覆盖`DTT`默认的数据精度配置。

### 7 自动推断数据表的列的默认值

支持`枚举`和`Java基础包装类型`

### 8 `0代码`集成多款`mybatis`生态插件

1. `mybatis`: https://github.com/mybatis/spring-boot-starter
2. `mybatis-plus`: https://github.com/baomidou/mybatis-plus
3. `tk.mybatis`: https://search.maven.org/artifact/tk.mybatis/mapper-spring-boot-starter
4. `pagehelper`: https://search.maven.org/artifact/com.github.pagehelper/pagehelper

注解驱动开启功能，开箱即用，无需任何`SPI`继承、实现操作, 更低的学习和使用成本。

### 9 内置`mybatis-plus`代码生成器

默认关闭，需要通过配置开始

配置示例:

```yaml
alphahub:
  dtt:
    code-generator:
      is-enable: on
      show-code: false
      override-exists: false
      module-name: dtt
      module-package: com.example
      module-path: /Users/weasley/Development/IdeaProjects/mydtt-plus-spring-boot-parent/mydtt-plus-spring-boot-starter-tests/mydtt-plus-spring-boot-3-x
      base-package: com.example.domain.dtt
      base-classes: ""
```

提示：

`alphahub.dtt.code-generator.base-classes`属性支持生成单个域对象映射的表，`alphahub.dtt.code-generator.base-package`
的范围要尽可能精准，如果配置范围过大，所有的子包将会被`DTT`类扫描器扫描,

[代码生成器配置元数据解释参考这里](https://github.com/Weasley-J/mydtt-plus-spring-boot-starter/blob/main/mydtt-plus-spring-boot-starter/src/main/java/cn/alphahub/dtt/plus/config/DttProperties.java#L122-L121)

简单业务甚至你只用写个`Controller`就能完成业务功能

### 10 支持`mybatis`自动创建数据库表

提示:

1. 该功能需用注解驱动开启，在你的启动类上添加`@EnableDtt`（如果你只是想开启`mybatis`
   自动创建表），更多细节见源码[`@EnableDtt`](https://github.com/Weasley-J/mydtt-plus-spring-boot-starter/blob/main/mydtt-plus-spring-boot-starter/src/main/java/cn/alphahub/dtt/plus/framework/annotations/EnableDtt.java#L51)
   ，可以通过`yaml`配置在各个应用环境中禁用和启用状态（默认启用状态）
2. 禁用的`yaml`配置示例：

```yaml
alphahub:
  dtt:
    mybatis-orm-support:
      is-enable: false #禁用DTT在mybatis的执行SQL生命周期内创建表
```

3.
生产环境建议使用[`@Dtt`](https://github.com/Weasley-J/mydtt-plus-spring-boot-starter/blob/main/mydtt-plus-spring-boot-starter/src/main/java/cn/alphahub/dtt/plus/annotations/Dtt.java#L23)
注解标注你的域模型，域模型缺失[`@Dtt`](https://github.com/Weasley-J/mydtt-plus-spring-boot-starter/blob/main/mydtt-plus-spring-boot-starter/src/main/java/cn/alphahub/dtt/plus/annotations/Dtt.java#L23)
注解会导致创建的表没有元数据注释, 和`Hibernate`
创建的一样没有comment，如果你的英语很好，知道每个元数据的含义，不添加也行。下面是一个使用使用`@Dtt`的域对象示例：

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

开发环境下可以通过解析`Java document`获取数据表的备注说明，`Jar`，`war`包环境下不支持解析`Java`
注释，因此创建的表的注释会缺失。如果你是希望把开发环境的表结构通过`DTT`
创建好的表结构同步到生产环境，那么你可以忽略使用`@Dtt`注解注释你的域对象，你可以使用数据库工具。

4. **该功能仅适用于受支持的`RDB`**

### 11 支持调用API创建表

`API`: [cn.alphahub.dtt.plus.framework.miscellaneous.DttDefaultConditionalService#manualCreate](https://github.com/Weasley-J/mydtt-plus-spring-boot-starter/mydtt-plus-spring-boot-starter/src/main/java/cn/alphahub/dtt/plus/framework/miscellaneous/DttDefaultConditionalService.java#L57)

1. 在你的`spring-boot`应用的启动类上添加注解`@EnableDtt`，示例：

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

# 受支持的RDB

| 数据库       | 版本                | 适配情况 |
| ------------ | ------------------- | -------- |
| `mysql`      | `5.7+` or latest    | ✅        |
| `oracle`     | `11.2.x`  or latest | ✅        |
| `db2`        | `11.x`  or latest   | ✅        |
| `sqlserver`  | `14.x` or latest    | ✅        |
| `mariadb`    | `10.x `or latest    | ✅        |
| `postgresql` | `v9.x` or latest    | ✅        |
| `h2`         | 所有版本            | ✅        |
| `hsql`       |                     | 规划中   |
| `derby`      |                     | 规划中   |

# 快问快答



