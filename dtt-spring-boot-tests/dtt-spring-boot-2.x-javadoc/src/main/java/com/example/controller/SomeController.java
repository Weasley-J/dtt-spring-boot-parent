package com.example.controller;

import cn.alphahub.dtt.plus.entity.DttManualActEntity;
import cn.alphahub.dtt.plus.entity.DttManualActRequest;
import cn.alphahub.dtt.plus.framework.miscellaneous.DttDefaultConditionalService;
import cn.alphahub.dtt.plus.util.JacksonUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.domain.dtt.DttMember;
import com.example.page.PageHandler;
import com.example.page.PageParam;
import com.example.page.PageWrapper;
import com.example.service.DttMemberService;
import com.github.pagehelper.Page;
import com.github.pagehelper.page.PageMethod;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@RestController
@RequestMapping("/api/some/member")
public class SomeController {
    @Autowired(required = false)
    private DttMemberService memberService;
    @Autowired(required = false)
    private DttDefaultConditionalService defaultConditionalService;

    /**
     * Save a record
     */
    @PostMapping("/save")
    @Transactional(rollbackFor = {Exception.class})
    public ResponseEntity<Boolean> save(@RequestBody DttMember member) {
        boolean save = memberService.save(member);
        log.info("{}", JacksonUtil.toJson(member));
        return ResponseEntity.ok(save);
    }

    /**
     * Save a record directly without parameter
     */
    @PostMapping("/save/no/params")
    @Transactional(rollbackFor = {Exception.class})
    public ResponseEntity<Boolean> saveNoParams() {
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
        DttMember member = JacksonUtil.readValue(json, DttMember.class);
        member.setBirthday(LocalDateTime.now());
        member.setRegistrarDate(LocalDate.now());
        member.setUpdateTime(LocalDateTime.now());
        member.setAccelerateBeginTime(LocalTime.now());
        member.setAccelerateEndTime(LocalTime.now());
        DttMember dttMember = memberService.getOne(new QueryWrapper<DttMember>().select("MAX(member_id) memberId"));
        if (null != dttMember) {
            member.setMemberId(dttMember.getMemberId()+ 1);
        } else member.setMemberId(1L);
        boolean save = memberService.saveBatch(Arrays.asList(member));
        log.info("{}", JacksonUtil.toJson(member));
        return ResponseEntity.ok(save);
    }

    /**
     * Update a record
     */
    @PutMapping("/update")
    @Transactional(rollbackFor = {Exception.class})
    public ResponseEntity<Boolean> update(@RequestBody DttMember member) {
        boolean updated = memberService.updateById(member);
        log.info("{}", JacksonUtil.toJson(member));
        return ResponseEntity.ok(updated);
    }

    /**
     * Get a record
     */
    @GetMapping("/info/{id}")
    public ResponseEntity<DttMember> info(@PathVariable Long id) {
        DttMember dttMember = memberService.getById(id);
        log.info("{}", JacksonUtil.toJson(dttMember));
        return ResponseEntity.ok(dttMember);
    }

    /**
     * Get a record by Ids
     */
    @GetMapping("/list/{ids}")
    public ResponseEntity<List<DttMember>> listByIds(@PathVariable Long[] ids) {
        List<DttMember> list = memberService.listByIds(Arrays.asList(ids));
        log.info("{}", JacksonUtil.toJson(list));
        return ResponseEntity.ok(list);
    }

    /**
     * Get all record
     */
    @GetMapping("/list")
    public ResponseEntity<List<DttMember>> listAll() {
        List<DttMember> members = memberService.list();
        log.info("{}", JacksonUtil.toJson(members));
        return ResponseEntity.ok(members);
    }

    /**
     * Delete record by Ids
     */
    @DeleteMapping("/delete/{ids}")
    @Transactional(rollbackFor = {Exception.class})
    public ResponseEntity<Boolean> delete(@PathVariable Long[] ids) {
        boolean removed = memberService.removeByIds(Arrays.asList(ids));
        return ResponseEntity.ok(removed);
    }

    /**
     * List  record by page
     */
    @PostMapping("/pagehelper/list")
    public PageWrapper<DttMember> pages(@RequestBody PageParam pageParam) {
        Page<DttMember> page = PageMethod.startPage(pageParam.getPageNum(), pageParam.getPageSize());
        List<DttMember> list = memberService.list();
        PageWrapper<DttMember> render = PageHandler.render(page, list);
        log.info("{}", JacksonUtil.toJson(render));
        return render;
    }

    /**
     * Specify an entity class to create a table
     */
    @PostMapping("/manual/act")
    public List<DttManualActEntity> manualCreateTable(@RequestBody DttManualActRequest request) {
        return this.defaultConditionalService.manualCreate(request);
    }

}
