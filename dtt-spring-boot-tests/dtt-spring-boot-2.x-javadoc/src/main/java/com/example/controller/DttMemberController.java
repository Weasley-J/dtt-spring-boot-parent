package com.example.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.example.domain.dtt.DttMember;
import com.example.page.PageHandler;
import com.example.page.PageWrapper;
import com.example.service.DttMemberService;
import com.github.pagehelper.page.PageMethod;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

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
     * 用户信息分页查询(Pagehelper写法)
     *
     * @param dttMember 用户信息查询参数
     * @param pageNum   前页码, 默认: 1
     * @param pageSize  每页显示条数，默认: 10
     * @return 用户信息分页数据
     * @apiNote 请求示例: <a href="http://localhost:8080/api/dtt/member/page/pagehelper?pageNum=1&pageSize=2">请求示例</a>
     * @see <a href="https://github.com/pagehelper/pagehelper-spring-boot">多数据源分页推荐使用pagehelper</a>
     * @see <a href="https://github.com/pagehelper/Mybatis-PageHelper/blob/master/wikis/zh/HowToUse.md">pagehelper多数据源分页配置</a>
     * @see <a href="https://github.com/Weasley-J/lejing-mall/blob/main/lejing-common/lejing-common-base-service/src/main/java/cn/alphahub/mall/common/page/PageWrapper.java">PageWrapper类源码</a>
     * @see <a href="https://github.com/Weasley-J/lejing-mall/blob/main/lejing-common/lejing-common-base-service/src/main/java/cn/alphahub/mall/common/page/PageHandler.java">PageHandler类源码</a>
     */
    @GetMapping("/page/pagehelper")
    public ResponseEntity<PageWrapper<DttMember>> pageByPagehelper(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                                                                   @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
                                                                   @ModelAttribute(value = "dttMember", binding = true) DttMember dttMember) {
        com.github.pagehelper.Page<DttMember> page = PageMethod.startPage(pageNum, pageSize);
        List<DttMember> pageResults = dttMemberService.list(Wrappers.lambdaQuery(dttMember));
        return ResponseEntity.ok(PageHandler.render(page, pageResults));
    }

    /**
     * 用户信息分页查询(Mybatis-Plus写法)
     *
     * @param pageParam 分页参数: current(当前页码,默认1), size(每页显示条数，默认10)
     * @param dttMember 用户信息查询参数
     * @return 用户信息分页数据
     * @apiNote 请求示例: <a href="http://localhost:8080/api/dtt/member/page/mmp?current=1&size=3">请求示例</a>
     * @see <a href="https://mp.baomidou.com/guide/page.html">Mybatis Plus官方分页插件配置示例</a>
     * @see <a href="https://github.com/pagehelper/pagehelper-spring-boot">多数据源分页推荐使用pagehelper</a>
     */
    @GetMapping("/page/mmp")
    public ResponseEntity<Page<DttMember>> pageByMmp(@ModelAttribute("pageParam") PageDTO<DttMember> pageParam, @ModelAttribute("dttMember") DttMember dttMember) {
        Page<DttMember> params = new Page<>();
        params.setSize(pageParam.getSize());
        params.setCurrent(pageParam.getCurrent());
        Page<DttMember> page = dttMemberService.page(params, Wrappers.lambdaQuery(dttMember));
        return ResponseEntity.ok(page);
    }

    /**
     * 获取用户信息详情
     *
     * @param memberId 用户信息主键id
     * @return 用户信息详细信息
     */
    @GetMapping("/info/{memberId}")
    public ResponseEntity<DttMember> info(@PathVariable("memberId") Long memberId) {
        DttMember dttMember = dttMemberService.getById(memberId);
        return ResponseEntity.ok(dttMember);
    }

    /**
     * 新增用户信息
     *
     * @param dttMember 用户信息元数据
     * @return 成功返回true, 失败返回false
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
     * @return 成功返回true, 失败返回false
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
    public ResponseEntity<Boolean> delete(@PathVariable("memberIds") Long[] memberIds) {
        boolean delete = dttMemberService.removeByIds(Arrays.asList(memberIds));
        return ResponseEntity.ok(delete);
    }
}
