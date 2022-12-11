package com.example.page;

import com.github.pagehelper.Page;

import java.util.List;
import java.util.Objects;

/**
 * 分页工具
 * <p>
 * <b>分页示例</b>
 * <pre>
 * import cn.com.winning.common.basic.share.domain.ApiHisLog;
 * import cn.com.winning.common.basic.share.service.ApiHisLogService;
 * import cn.com.winning.common.entity.PageParam;
 * import cn.com.winning.common.page.PageHandler;
 * import cn.com.winning.common.page.PageWrapper;
 * import cn.hutool.json.JSONUtil;
 * import com.github.pagehelper.Page;
 * import com.github.pagehelper.page.PageMethod;
 * import lombok.extern.slf4j.Slf4j;
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.stereotype.Service;
 *
 * import java.util.List;
 *
 * {@code @Slf4j}
 * {@code @Service}
 * public class HisLogPageDemoService {
 *
 * {@code @Autowired}
 * private ApiHisLogService apiHisLogService;
 *
 * public PageWrapper{@code <ApiHisLog>} pages(PageParam pageParam) {
 *     log.info("分页入参 {}", JSONUtil.toJsonPrettyStr(pageParam));
 *     Page{@code <ApiHisLog>} page = PageMethod.startPage(pageParam.getPageNum(), pageParam.getPageSize());
 *     List{@code <ApiHisLog>} apiHisLogs = apiHisLogService.list();
 *     PageWrapper{@code <ApiHisLog>} render = PageHandler.render(page, apiHisLogs);
 *     log.info("分页数据 {}", JSONUtil.toJsonPrettyStr(render));
 *     return render;
 *   }
 * }
 *     </pre>
 * </p>
 */
public final class PageHandler {

    private PageHandler() {
    }

    public static <T> PageWrapper<T> render(Page<T> page, List<T> list) {
        PageWrapper<T> pageWrapper = new PageWrapper<>();
        if (null != page) {
            pageWrapper.setPageNum(page.getPageNum());
            pageWrapper.setPageSize(page.getPageSize());
            pageWrapper.setTotal(page.getTotal());
            pageWrapper.setPages(page.getPages());
            pageWrapper.setList(list);
        }
        return pageWrapper;
    }

    public static <T> PageWrapper<T> render(int pageNum, int pageSize, long total, List<T> list) {
        PageWrapper<T> pageWrapper = new PageWrapper<>();
        pageWrapper.setPageNum(pageNum);
        pageWrapper.setPageSize(pageSize);
        pageWrapper.setTotal(total);
        if (pageSize > 0) {
            pageWrapper.setPages((int) (total / (long) pageSize + (long) (total % (long) pageSize == 0L ? 0 : 1)));
        } else {
            pageWrapper.setPages(0);
        }

        pageWrapper.setList(list);
        return pageWrapper;
    }

    public static <R extends PageWrapper<T>, T> R render(Page<T> page, List<T> list, R result) {
        if (Objects.nonNull(page)) {
            result.setPageNum(page.getPageNum());
            result.setPageSize(page.getPageSize());
            result.setTotal(page.getTotal());
            result.setPages(page.getPages());
            result.setList(list);
        }
        return result;
    }
}
