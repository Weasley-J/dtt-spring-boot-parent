package cn.alphahub.dtt.plus.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Banner properties
 *
 * @author weasley
 * @since 1.0.8
 */
@Getter
@AllArgsConstructor
public enum BannerMode {
    /**
     * Will be show the banner when application start
     */
    ON,

    /**
     * Don't show the banner when application start
     */
    OFF,
}
