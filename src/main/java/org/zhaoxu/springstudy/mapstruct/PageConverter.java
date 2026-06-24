package org.zhaoxu.springstudy.mapstruct;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.mapstruct.Mapper;
import org.zhaoxu.springstudy.vo.PageResultVO;

import java.util.List;
import java.util.function.Consumer;

/**
 * 通用分页转换器
 * 所有分页接口都可以直接用
 */
@Mapper(componentModel = "spring")
public interface PageConverter {

    /**
     * IPage<E> → PageResultVO<V>
     * @param page MP 分页对象
     * @param voList 转换后的 VO 列表
     * @return 自定义分页结果
     */
     default <E, V> PageResultVO<V> toPageVO(IPage<E> page, List<V> voList) {
        PageResultVO<V> result = new PageResultVO<>();
        result.setList(voList);
        result.setTotal(page.getTotal());
        result.setSize(page.getSize());
        result.setCurrent(page.getCurrent());
        // pages 不设置，前端不会返回
        return result;
    }
}