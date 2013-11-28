package com.wetuo.blog.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
@Entity
@Table(name="lh_sort")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Sort  implements java.io.Serializable {

	private static final long serialVersionUID = -7418252282782954716L;
    private Long sortId;
    private String name;
    private Long blogCount;
    private String remarks;
    private Set<Blog> blogs = new HashSet<Blog>(0);

    @Id
    @GeneratedValue
    @Column(name="sort_id", unique=true, nullable=false)
    public Long getSortId() {
        return this.sortId;
    }
    public void setSortId(Long sortId) {
        this.sortId = sortId;
    }
    @Column(name="name", length=200)
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Column(name="blog_count")
    public Long getBlogCount() {
        return this.blogCount;
    }
    public void setBlogCount(Long blogCount) {
        this.blogCount = blogCount;
    }
    @Column(name="remarks")
    public String getRemarks() {
        return this.remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="sort")
    public Set<Blog> getBlogs() {
        return this.blogs;
    }
    public void setBlogs(Set<Blog> blogs) {
        this.blogs = blogs;
    }
}