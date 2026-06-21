package org.zhaoxu.springstudy.common.util;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.zhaoxu.springstudy.common.vo.PageResultVO;

public class PageUtil {

    /**
     * 将 MyBatis-Plus IPage 转为 自定义分页VO
     * 自动去掉 pages，自动把 records → list
     */
    public static <T> PageResultVO<T> convert(IPage<T> page) {
        PageResultVO<T> vo = new PageResultVO<>();
        vo.setList(page.getRecords());
        vo.setTotal(page.getTotal());
        vo.setSize(page.getSize());
        vo.setCurrent(page.getCurrent());
        return vo;
    }
}