package com.example.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.example.domain.dtt.DttMember;
import com.example.service.DttMemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * 用户信息
 *
 * @author Weasley
 */
@Slf4j
@RestController
@RequestMapping("/api/dtt/member")
public class DttMemberController {

    @Autowired
    private DttMemberService dttMemberService;

    /**
     * 用户信息分页查询
     *
     * @param pageParam 分页参数: current(当前页码,默认1), size(每页显示条数，默认10)
     * @param dttMember     用户信息查询参数
     * @return 用户信息分页数据
     * @see <a href="https://mp.baomidou.com/guide/page.html">Mybatis Plus官方分页插件配置示例</a>
     */
    @GetMapping("/page")
    public Page<DttMember> page(@ModelAttribute("pageParam") PageDTO<DttMember> pageParam, @ModelAttribute("dttMember") DttMember dttMember) {
        Page<DttMember> params = new Page<>();
        params.setSize(pageParam.getSize());
        params.setCurrent(pageParam.getCurrent());
        return dttMemberService.page(params, Wrappers.lambdaQuery(dttMember));
    }

    /**
     * 获取用户信息详情
     *
     * @param memberId 用户信息主键id
     * @return 用户信息详细信息
     */
    @GetMapping("/info/{memberId}")
    public ResponseEntity<DttMember> info(@PathVariable("memberId") Long memberId){
        DttMember dttMember = dttMemberService.getById(memberId);
        return ResponseEntity.ok(dttMember);
    }

    /**
     * 新增用户信息
     *
     * @param dttMember 用户信息元数据
     * @return 成功返回true,失败返回false
     */
    @PostMapping("/save")
    @Transactional(rollbackFor = {Exception.class})
    public ResponseEntity<Boolean> save(@RequestBody @Validated DttMember dttMember) {
        boolean save = dttMemberService.save(dttMember);
        return ResponseEntity.ok(save);
    }

    /**
     * 修改用户信息
     *
     * @param dttMember 用户信息, 根据id选择性更新
     * @return 成功返回true,失败返回false
     */
    @PutMapping("/update")
    @Transactional(rollbackFor = {Exception.class})
    public ResponseEntity<Boolean> update(@RequestBody @Validated DttMember dttMember) {
        boolean update = dttMemberService.updateById(dttMember);
        return ResponseEntity.ok(update);
    }

    /**
     * 批量删除用户信息
     *
     * @param memberIds 用户信息id集合
     * @return 成功返回true, 失败返回false
     */
    @DeleteMapping("/delete/{memberIds}")
    @Transactional(rollbackFor = {Exception.class})
    public ResponseEntity<Boolean> delete(@PathVariable("memberIds") Long[] memberIds){
        boolean delete = dttMemberService.removeByIds(Arrays.asList(memberIds));
        return ResponseEntity.ok(delete);
    }
}
