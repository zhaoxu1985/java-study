package org.zhaoxu.springstudy.vo;

import lombok.Data;
import java.util.List;

/**
 * 全局统一分页出参
 * 替代 MP 原生 IPage，不暴露 pages 字段
 * @param <T> 分页列表泛型
 */
@Data
public class PageResultVO<T> {

    // 把 records 改成 list（你想改成 items 也行）
    private List<T> list;

    // 总条数
    private long total;

    // 每页条数
    private long size;

    // 当前页
    private long current;

    // 不写 pages → 就不会返回！
}