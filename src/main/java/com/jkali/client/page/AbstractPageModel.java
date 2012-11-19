package com.jkali.client.page;

import com.google.common.collect.Lists;
import com.jkali.client.entity.AuditableEntity;
import com.jkali.client.entity.Filter;
import com.jkali.client.entity.IPage;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import org.jrebirth.core.ui.AbstractModel;
import org.jrebirth.core.wave.Wave;

/**
 * The class <strong>AbstractSlideModel</strong>.
 *
 * @author Sébastien Bordes
 *
 * @param <M> the SlideModel class
 * @param <V> the SlideView class
 * @param <S> the SlideStep to use
 */
public abstract class AbstractPageModel<M extends AbstractPageModel<M, V, T>, V extends AbstractPageView<?, ?, ?>, T extends AuditableEntity> extends AbstractModel<M, V> implements IPage<T> {
    // -- 分页参数 --//
    // protected int pageNo = 1;
    // protected int pageSize = 1;

    protected String orderBy = null;
    protected String order = null;
    protected boolean autoCount = true;
    // -- 返回结果 --//
    // protected List<T> result = Collections.emptyList();
    // protected long totalCount = -1;
    // jqGrid json// -- 返回结果 --//
    protected int page = 1; // like pageNo
    protected int total = 1; // total page
    protected int pageSize = 1;// like pageSize
    protected long records = -1; // like totalCount
    protected List<T> rows = Lists.newArrayList();

    protected Filter filter;
    // -- 访问查询参数函数 --//
    /**
     * 获得当前页的页号,序号从1开始,默认为1.
     */
    @Override
    public int getPage() {
        return page;
    }

    /**
     * 设置当前页的页号,序号从1开始,低于1时自动调整为1.
     */
    @Override
    public void setPage(int page) {
        this.page = page;

        if (page < 1) {
            this.page = 1;
        }
    }

    @Override
    public int getTotal() {
        return total;
    }

    @Override
    public void setTotal(int total) {
        if (total < 0) {
            this.total = -1;
        }

        long count = this.records / pageSize;
        if (this.records % pageSize > 0) {
            count++;
        }
        this.total = (int) count;
    }

    /**
     * 取得总记录数, 默认值为-1.
     */
    @Override
    public long getRecords() {
        return records;
    }

    @Override
    public void setRecords(long records) {
        this.records = records;
        setTotal(1);

    }

    // -- 构造函数 --//
    public AbstractPageModel() {
    }

    public AbstractPageModel(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public IPage<T> pageNo(final int thePageNo) {
        setPage(thePageNo);
        return this;
    }

    /**
     * 获得每页的记录数量,默认为1.
     */
    @Override
    public int getPageSize() {
        return pageSize;
    }

    /**
     * 设置每页的记录数量,低于1时自动调整为1.
     */
    @Override
    public void setPageSize(final int pageSize) {
        this.pageSize = pageSize;

        if (pageSize < 1) {
            this.pageSize = 1;
        }

    }

    @Override
    public IPage<T> pageSize(final int thePageSize) {
        setPageSize(thePageSize);
        return this;
    }

    /**
     * 根据pageNo和pageSize计算当前页第一条记录在总结果集中的位置,序号从1开始.
     */
    @Override
    public int getFirst() {
        return ((page - 1) * pageSize) + 1;
    }

    /**
     * 获得排序字段,无默认值.多个排序字段时用','分隔.
     */
    @Override
    public String getOrderBy() {
        return orderBy;
    }

    /**
     * 设置排序字段,多个排序字段时用','分隔.
     */
    @Override
    public void setOrderBy(final String orderBy) {
        this.orderBy = orderBy;
    }

    @Override
    public IPage<T> orderBy(final String theOrderBy) {
        setOrderBy(theOrderBy);
        return this;
    }

    /**
     * 获得排序方向.
     */
    @Override
    public String getOrder() {
        return order;
    }

    /**
     * 设置排序方式向.
     *
     * @param order 可选值为desc或asc,多个排序字段时用','分隔.
     */
    @Override
    public void setOrder(final String order) {
        // 检查order字符串的合法值
        String[] orders = StringUtils.split(StringUtils.lowerCase(order), ',');
        for (String orderStr : orders) {
            if (!StringUtils.equals(DESC, orderStr) && !StringUtils.equals(ASC, orderStr)) {
                throw new IllegalArgumentException("排序方向" + orderStr + "不是合法值");
            }
        }

        this.order = StringUtils.lowerCase(order);
    }

    @Override
    public IPage<T> order(final String theOrder) {
        setOrder(theOrder);
        return this;
    }

    /**
     * 是否已设置排序字段,无默认值.
     */
    @Override
    public boolean isOrderBySetted() {
        return (StringUtils.isNotBlank(orderBy) && StringUtils.isNotBlank(order));
    }

    /**
     * 查询对象时是否自动另外执行count查询获取总记录数, 默认为false.
     */
    @Override
    public boolean isAutoCount() {
        return autoCount;
    }

    /**
     * 查询对象时是否自动另外执行count查询获取总记录数.
     */
    @Override
    public void setAutoCount(final boolean autoCount) {
        this.autoCount = autoCount;
    }

    @Override
    public IPage<T> autoCount(final boolean theAutoCount) {
        setAutoCount(theAutoCount);
        return this;
    }

    // -- 访问查询结果函数 --//
    /**
     * 取得页内的记录列表.
     */
    @Override
    public List<T> getRows() {
        return rows;
    }

    /**
     * 设置页内的记录列表.
     */
    @Override
    public void setRows(final List<T> rows) {
        this.rows = rows;
    }

    /**
     * 是否还有下一页.
     */
    @Override
    public boolean isHasNext() {
        return (page + 1 <= getTotal());
    }

    /**
     * 取得下页的页号, 序号从1开始. 当前页为尾页时仍返回尾页序号.
     */
    @Override
    public int getNextPage() {
        System.out.println("getNextPage method invoker.");
        if (isHasNext()) {
            return page + 1;
        } else {
            return page;
        }
    }

    /**
     * 是否还有上一页.
     */
    @Override
    public boolean isHasPre() {
        return (page - 1 >= 1);
    }

    /**
     * 取得上页的页号, 序号从1开始. 当前页为首页时返回首页序号.
     */
    @Override
    public int getPrePage() {
        if (isHasPre()) {
            return page - 1;
        } else {
            return page;
        }
    }
}
