package com.wetuo.blog.dao;

import java.io.Serializable;
import java.util.List;

import org.wetuo.util.PageBean;



/**
 * <p>DAO层基础接口<p>
 * @author LH
 * 
 */
public interface BaseDAO<T> {
	/**
	 * 
	 * 根据ID查找对象
	 * @param entityid 实体ID
	 * @return T   
	 * 
	 */
	public abstract T get(Serializable entityid);
	
	/**
	 * 
	 * 获取全部对象
	 * @return List<T>   
	 * 
	 */
	public abstract List<T> getAll();
	
	/**
	 * 
	 * 获取全部对象,带排序字段与升降序参数
	 * @param orderBy 排序字段名
	 * @param isAsc boolean型
	 * @return List<T>   
	 * 
	 */
	public abstract List<T> getAll(String orderBy,boolean isAsc);
	
	/**
	 * 
	 * 保存实体.
	 * @param  entity  实体对象
	 * 
	 */
	public abstract void save(T entity);
	
	/**
	 * 
	 * 更新实体.
	 * @param  entity 实体对象
	 * 
	 */
	public abstract void update(T entity);
	
	/**
	 * 
	 * 更新或保存实体.
	 * @param  entity  实体
	 * 
	 */
	public abstract void merge(T entity);
	
	/**
	 * 
	 * 保存实体.
	 * @param  entity  实体对象
	 * @return 返回保存实体对象，一般用在需要获取报错实体的ID
	 */
	public abstract T add(T entity);
	
	/**
	 * 
	 * 根据ID删除实体.
	 * @param entityid  序列化实体ID
	 * 
	 */
	public abstract void delete(Serializable entityid);
	
	/**
	 * 
	 * 查询总记录数,使用hql
	 * @param  sql  HQL语句
	 * @return int  总记录数 
	 * 
	 */
	public abstract int totalCount(String sql);
	
	/**
	 * 
	 * 分页查询记录，使用hql，复杂分页采用，如：涉及到多张表
	 * @param hql   HQL语句
	 * @param offset   起始位置
	 * @param length   最大长度
	 * @return List<T> 符合条件的对象列表
	 * 
	 */
	public abstract List<T> getPage(final String hql, final int offset,
			final int length);
	
	/**
	 * 
	 * 分页查询记录，使用hql，普通分页采用此方法
	 * @param hql   HQL语句
	 * @param pageSize   每页显示条数
	 * @param page  当前页数
	 * @return PageBean<T> 符合条件的PageBean对象
	 * 
	 */
	public abstract PageBean<T> pageQuery(String hql, int pageSize,int page);
	/**
	 * 
	 * 根据HQL语句查询记录.
	 * @param hql   HQL语句
	 * @return List<T> 符合条件的对象列表
	 * 
	 */
	public abstract List<T> getByHQL(String hql);
	/**
	 * 
	 * 根据属性名和属性值查询对象.
	 * @param propertyName 字段名
	 * @param value 值
	 * @return List<T> 符合条件的对象列表
	 * 
	 */
	public abstract List<T> getByProperty(String propertyName ,Object value);
	
	/**
	 * 
	 * 根据属性名和属性值查询对象,带排序参数.
	 * @param propertyName 条件字段名
	 * @param value 值
	 * @param orderBy 排序字段名
	 * @param isAsc boolean型
	 * @return List<T> 符合条件的对象列表
	 * 
	 */
	public abstract List<T> getByProperty(String propertyName ,Object value ,String orderBy,boolean isAsc);
	/**
	 * 
	 * 根据单个属性名和属性值查询单个对象.
	 * @param propertyName 字段名
	 * @param value 值
	 * @return T 实体 
	 * 
	 */
	public abstract T getUniqueByProperty(String propertyName ,Object value);
	/**
	 * 
	 * 根据多个属性名和属性值查询单个对象.
	 * @param propertyNames 字段名数组
	 * @param values 值数组
	 * @return T 实体 
	 * 
	 */
	public abstract T getUniqueByPropertys(String[] propertyNames ,Object[] values);
	/**
	 * 
	 * 根据多个属性名和属性值判断是否存在数据.
	 * @param propertyNames 字段名数组
	 * @param values 值数组
	 * 
	 */
	public abstract boolean existsByPropertys(String[] propertyNames ,Object[] values);
	/**
	 * 
	 * 根据单个属性名和属性值判断是否存在数据.
	 * @param propertyName  条件字段名
	 * @param value 值
	 * 
	 */
	public abstract boolean existsByProperty(String propertyName ,Object value);
	/**
	 * 
	 * 根据属性名和属性值数组查询对象.
	 * @param propertyNames 字段名数组
	 * @param values 值数组
	 * @return List<T> 符合条件的对象列表
	 * 
	 */
	public abstract List<T> getByPropertys(String[] propertyNames ,Object[] values);
	
	/**
	 * 
	 * 根据属性名和属性值模糊查询对象.
	 * @param propertyName 字段名
	 * @param value 值
	 * @return List<T> 符合条件的对象列表
	 * 
	 */
	public abstract List<T> fuzzyFindByProperty(String propertyName ,Object value);
	/**
	 * 
	 * 根据主键ID局部更新一条数据一个字段值.
	 * @param  entityid 序列号实体ID
	 * @param  propertyName 需要更新字段名
	 * @param  value 字段新值
	 * 
	 */
	public abstract boolean localUpdateOneField(Serializable entityid,String propertyName ,Object value);
	/**
	 * 
	 * 根据主键ID局部更新一条数据多个字段值.
	 * @param  entityid 序列号实体ID
	 * @param  propertyNames 需要更新字段名数组
	 * @param  value 字段新值数组
	 */
	public abstract boolean localUpdateOneFields(Serializable entityid,String[] propertyNames ,Object[] values);
	/**
	 * 
	 * 根据HQL语句批量更新.
	 * @param  queryString hql语句
	 * @param  values 值数组
	 * @return int 更新成功条数
	 */
	public abstract int bulkUpdate(String queryString, Object[] values);
	/**
	 * 根据关键字ID批量删除.
	 * @param  ids 关键字ID数组
	 */
	public abstract int bulkDelete(final Object[] ids);
	
	
}
