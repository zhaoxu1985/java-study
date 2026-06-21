package org.zhaoxu.springstudy.common.vo;

import lombok.Data;
import java.util.List;

/**
 * 通用分页返回对象
 * 自定义字段，自定义名称
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