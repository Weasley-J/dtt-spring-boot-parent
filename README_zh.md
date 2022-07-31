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

### 6 自动推断数据表的列的默认值

支持`枚举`和`Java基础包装类型`

### 7 `0代码`集成多款`mybatis`生态插件

1. `mybatis`: https://github.com/mybatis/spring-boot-starter
2. `mybatis-plus`: https://github.com/baomidou/mybatis-plus
3. `tk.mybatis`: https://search.maven.org/artifact/tk.mybatis/mapper-spring-boot-starter
4. `pagehelper`: https://search.maven.org/artifact/com.github.pagehelper/pagehelper

注解驱动开启功能，开箱即用，无需任何`SPI`继承、实现操作, 更低的学习和使用成本。

### 8 内置`mybatis-plus`代码生成器

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

# 受支持的RDB

| 数据库       | 版本                | 适配情况 |
| ------------ | ------------------- | -------- |
| `mysql`      | `5.7+` or latest    | ✅        |
| `oracle`     | `11.2.x`  or latest | ✅        |
| `db2`        | `11.x`  or latest   | ✅        |
| `sqlserver`  | `14.x` or latest    | ✅        |
| `mariadb`    | `10.x `or latest    | ✅        |
| `postgresql` | `v9.x` or latest    | ✅        |

# 快问快答



