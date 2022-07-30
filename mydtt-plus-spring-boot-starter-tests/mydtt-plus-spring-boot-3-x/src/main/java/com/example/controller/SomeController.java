package com.example.controller;

import cn.alphahub.dtt.plus.util.JacksonUtil;
import com.example.domain.dtt.DttMember;
import com.example.service.DttMemberService;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

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

    @PostMapping("/save/no/params")
    @Transactional(rollbackFor = {Exception.class})
    public ResponseEntity<Boolean> saveNoParams() {
        String json = "";
        Collection<DttMember> dttMembers = JacksonUtil.readValue(json, new TypeReference<>() {
        });
        System.out.println(JacksonUtil.toJson(dttMembers));
        boolean save = memberService.saveBatch(dttMembers);
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
