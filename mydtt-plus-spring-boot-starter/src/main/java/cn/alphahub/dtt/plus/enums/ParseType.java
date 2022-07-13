package cn.alphahub.dtt.plus.enums;

import cn.alphahub.dtt.plus.annotations.Dtt;
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
public enum ParseType {
    /**
     * java doc
     */
    JAVA_DOC,
    /**
     * 使用{@code @Dtt}注解
     *
     * @see Dtt
     */
    ANNO_TYPE,
    ;

    /**
     * @return 解析注释类型
     */
    public static Set<ParseType> getParseTypes() {
        return Arrays.stream(ParseType.values()).collect(Collectors.toSet());
    }
}
