package com.example.controller;

import cn.alphahub.dtt.plus.entity.DttManualActEntity;
import cn.alphahub.dtt.plus.entity.DttManualActRequest;
import cn.alphahub.dtt.plus.framework.miscellaneous.DttDefaultConditionalService;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.domain.dtt.DttMember;
import com.example.service.DttMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

/**
 * Some controller
 */
@RestController
@RequestMapping("/api/member")
public class SomeController {
    @Autowired
    private DttMemberService memberService;
    @Autowired
    private DttDefaultConditionalService defaultConditionalService;

    @PostMapping("/save")
    @Transactional(rollbackFor = {Exception.class})
    public ResponseEntity<Boolean> save(@RequestBody DttMember member) {
        boolean save = memberService.save(member);
        return ResponseEntity.ok(save);
    }

    @PostMapping("/save/no/params")
    @Transactional(rollbackFor = {Exception.class})
    public ResponseEntity<Boolean> saveNoParams() {
        String json = "{\n" +
                "  \"openId\": \"fawezOE5sT\",\n" +
                "  \"nickname\": \"蒋震南\",\n" +
                "  \"isEnable\": true,\n" +
                "  \"balance\": 865,\n" +
                "  \"memberType\": \"STUDENT\",\n" +
                "  \"status\": 0,\n" +
                "  \"deleted\": 1,\n" +
                "}";
        DttMember member = JSONUtil.toBean(json, DttMember.class);
        member.setBirthday(LocalDateTime.now());
        member.setRegistrarDate(LocalDate.now());
        member.setUpdateTime(LocalDateTime.now());
        member.setAccelerateBeginTime(LocalTime.now());
        member.setAccelerateEndTime(LocalTime.now());
        DttMember dttMember = memberService.getOne(new QueryWrapper<DttMember>().select("MAX(ID) id"));
        if (null != dttMember) {
            member.setId(dttMember.getId() + 1);
        } else {
            member.setId(1L);
        }
        boolean save = memberService.saveBatch(Arrays.asList(member));
        System.err.println(JSONUtil.toJsonStr(member));
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
    public ResponseEntity<List<DttMember>> listByIds(@PathVariable Long[] ids) {
        List<DttMember> list = memberService.listByIds(Arrays.asList(ids));
        return ResponseEntity.ok(list);
    }

    @GetMapping("/list")
    public ResponseEntity<List<DttMember>> listAll() {
        return ResponseEntity.ok(memberService.list());
    }

    @DeleteMapping("/delete/{ids}")
    @Transactional(rollbackFor = {Exception.class})
    public ResponseEntity<Boolean> delete(@PathVariable Long[] ids) {
        boolean removed = memberService.removeByIds(Arrays.asList(ids));
        return ResponseEntity.ok(removed);
    }

    @PostMapping("/manual/act")
    public List<DttManualActEntity> manualCreateTable(@RequestBody DttManualActRequest request) {
        return this.defaultConditionalService.manualCreate(request);
    }
}
