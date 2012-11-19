/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jkali.client.entity;

import java.util.List;
import org.jrebirth.core.ui.Model;

/**
 *
 * @author Paul
 */
public interface IPage<T extends AuditableEntity> extends Model{
    public static final String ASC = "asc";
    public static final String DESC = "desc";

    IPage<T> autoCount(final boolean theAutoCount);

    /**
     * 根据pageNo和pageSize计算当前页第一条记录在总结果集中的位置,序号从1开始.
     */
    int getFirst();

    /**
     * 取得下页的页号, 序号从1开始. 当前页为尾页时仍返回尾页序号.
     */
    int getNextPage();

    /**
     * 获得排序方向.
     */
    String getOrder();

    /**
     * 获得排序字段,无默认值.多个排序字段时用','分隔.
     */
    String getOrderBy();

    // -- 访问查询参数函数 --//
    /**
     * 获得当前页的页号,序号从1开始,默认为1.
     */
    int getPage();

    /**
     * 获得每页的记录数量,默认为1.
     */
    int getPageSize();

    /**
     * 取得上页的页号, 序号从1开始. 当前页为首页时返回首页序号.
     */
    int getPrePage();

    /**
     * 取得总记录数, 默认值为-1.
     */
    long getRecords();

    // -- 访问查询结果函数 --//
    /**
     * 取得页内的记录列表.
     */
    List<T> getRows();

    int getTotal();

    /**
     * 查询对象时是否自动另外执行count查询获取总记录数, 默认为false.
     */
    boolean isAutoCount();

    /**
     * 是否还有下一页.
     */
    boolean isHasNext();

    /**
     * 是否还有上一页.
     */
    boolean isHasPre();

    /**
     * 是否已设置排序字段,无默认值.
     */
    boolean isOrderBySetted();

    IPage<T> order(final String theOrder);

    IPage<T> orderBy(final String theOrderBy);

    IPage<T> pageNo(final int thePageNo);

    IPage<T> pageSize(final int thePageSize);

    /**
     * 查询对象时是否自动另外执行count查询获取总记录数.
     */
    void setAutoCount(final boolean autoCount);

    /**
     * 设置排序方式向.
     *
     * @param order
     *            可选值为desc或asc,多个排序字段时用','分隔.
     */
    void setOrder(final String order);

    /**
     * 设置排序字段,多个排序字段时用','分隔.
     */
    void setOrderBy(final String orderBy);

    /**
     * 设置当前页的页号,序号从1开始,低于1时自动调整为1.
     */
    void setPage(int page);

    /**
     * 设置每页的记录数量,低于1时自动调整为1.
     */
    void setPageSize(final int pageSize);

    void setRecords(long records);

    /**
     * 设置页内的记录列表.
     */
    void setRows(final List<T> rows);

    void setTotal(int total);
    
}
