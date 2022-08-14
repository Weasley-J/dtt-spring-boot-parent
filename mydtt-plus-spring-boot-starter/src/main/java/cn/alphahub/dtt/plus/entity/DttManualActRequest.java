package cn.alphahub.dtt.plus.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * The request data for dtt manual automatically create database tables
 *
 * @author weasley
 * @version 1.3.1
 */
@Data
@Builder
@NoArgsConstructor
@Accessors(chain = true)
public class DttManualActRequest implements Serializable {
    /**
     * The list of fully qualified class names
     */
    private List<String> fullyQualifiedClassNames;

    public DttManualActRequest(List<String> fullyQualifiedClassNames) {
        this.fullyQualifiedClassNames = fullyQualifiedClassNames;
    }
}
