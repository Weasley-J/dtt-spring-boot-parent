package com.example.util;

import cn.alphahub.dtt.plus.util.JacksonUtil;
import com.example.domain.dtt.DttMember;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassUtil Test
 *
 * @author weasley
 * @version 1.0
 * @date 2022/7/17
 */
class JacksonUtilTest {

    @Test
    void contextLoads() {
        String json = "{\n" +
                "  \"openId\": \"fawezOE5sT\",\n" +
                "  \"nickname\": \"蒋震南\",\n" +
                "  \"isEnable\": true,\n" +
                "  \"balance\": 865,\n" +
                "  \"birthday\": \"2022-08-19 22:18:51\",\n" +
                "  \"memberType\": \"STUDENT\",\n" +
                "  \"status\": 0,\n" +
                "  \"deleted\": 1\n" +
                "}";
        List<DttMember> members = new ArrayList<>();
        for (int i = 1; i <= 50000; i++) {
            DttMember member = JacksonUtil.readValue(json, DttMember.class);
            member.setRegistrarDate(LocalDate.now());
            member.setAccelerateBeginTime(LocalTime.now());
            member.setAccelerateEndTime(LocalTime.now());
            member.setUpdateTime(LocalDateTime.now());
            member.setId((long) i);
            members.add(member);
        }

        System.out.println("\n\n");

        members.parallelStream().forEach(member -> {
            String toJson = JacksonUtil.toJson(member);
            System.out.println(Thread.currentThread().getName() + " " + toJson);
            new Thread(() -> {
                DttMember _member = JacksonUtil.readValue(toJson, new TypeReference<DttMember>() {
                });
                System.err.println(Thread.currentThread().getName() + " " + JacksonUtil.toJson(_member));
            }).start();
        });
    }
}


