package com.example.i18n.korean;

import com.example.enums.MemberType;
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
 * 사용자 정보
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class DttMember implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 기본 키 ID
     */
    private Long id;
    /**
     * 사용자 openId
     */
    private String openId;
    /**
     * 사용자 닉네임 사용자 닉네임
     */
    private String nickname;
    /**
     * 활성화 여부, 기본값: 1
     */
    private Boolean isEnable = true;
    /**
     * 사용자 신용 잔액, 기본값: 0.00
     */
    private BigDecimal balance = BigDecimal.valueOf(0L, 2);
    /**
     * 생년월일, 형식: yyyy-MM-dd HH:mm:ss
     */
    private LocalDateTime birthday;
    /**
     * 회원 유형, 기본값: ORDINARY
     */
    private MemberType memberType = MemberType.ORDINARY;
    /**
     * 사용자 상태: 0 정상(기본값), 1 동결, 2 계정 차단, 3 계정 비정상
     */
    private Integer status = 3;
    /**
     * 계정 취소 상태, 0은 취소되지 않음(기본값), 1은 취소됨
     */
    private Integer deleted = 0;
    /**
     * 등록 시간, 형식: yyyy-MM-dd
     */
    private LocalDate registrarDate;
    /**
     * 회원 가속 시작 시간, 형식: HH:mm:ss
     */
    private LocalTime accelerateBeginTime;
    /**
     * 회원 가속 종료 시간, 형식: HH:mm:ss
     */
    private LocalTime accelerateEndTime;
    /**
     * 시간 변경
     */
    private LocalDateTime updateTime;
}
