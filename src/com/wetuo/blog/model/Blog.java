package com.wetuo.blog.model;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.wetuo.util.CutHtml;
@Entity
@Table(name="lh_blog")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Blog  implements java.io.Serializable {
	private static final long serialVersionUID = 7380839157119819122L;
    private Long blogId;
    private User user;
    private Sort sort;
    private Date postDate;
    private String postContent;
    private String postTitle;
    private String postStatus;
    private String commentStatus;
    private Date postModified;
    private Long commentCount;
    private Long viewConut;
    private String isTop;
    private String remarks;
    private Set<Comment> comments = new HashSet<Comment>(0);
    private Set<TagRelationShips> tagRelationShipses = new HashSet<TagRelationShips>(0);

    @Id
    @GeneratedValue
    @Column(name="blog_id", unique=true, nullable=false)
    public Long getBlogId() {
        return this.blogId;
    }
    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="user_id")
    public User getUser() {
        return this.user;
    }
    public void setUser(User user) {
        this.user = user;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="sort_id")
    public Sort getSort() {
        return this.sort;
    }
    public void setSort(Sort sort) {
        this.sort = sort;
    }
    @Column(name="post_date", length=29)
    public Date getPostDate() {
        return this.postDate;
    }
    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }
    @Column(name="post_content")
    public String getPostContent() {
        return this.postContent;
    }
    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }
    @Column(name="post_title")
    public String getPostTitle() {
        return this.postTitle;
    }
    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }
    @Column(name="post_status", length=20)
    public String getPostStatus() {
        return this.postStatus;
    }
    public void setPostStatus(String postStatus) {
        this.postStatus = postStatus;
    }
    @Column(name="comment_status", length=20)
    public String getCommentStatus() {
        return this.commentStatus;
    }
    public void setCommentStatus(String commentStatus) {
        this.commentStatus = commentStatus;
    }
    @Column(name="post_modified", length=29)
    public Date getPostModified() {
        return this.postModified;
    }
    public void setPostModified(Date postModified) {
        this.postModified = postModified;
    }
    @Column(name="comment_count")
    public Long getCommentCount() {
        return this.commentCount;
    }
    public void setCommentCount(Long commentCount) {
        this.commentCount = commentCount;
    }
    @Column(name="view_conut")
    public Long getViewConut() {
        return this.viewConut;
    }
    public void setViewConut(Long viewConut) {
        this.viewConut = viewConut;
    }
    @Column(name="is_top", length=10)
    public String getIsTop() {
        return this.isTop;
    }
    public void setIsTop(String isTop) {
        this.isTop = isTop;
    }
    @Column(name="remarks")
    public String getRemarks() {
        return this.remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="blog")
    public Set<Comment> getComments() {
        return this.comments;
    }
    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="blog")
    public Set<TagRelationShips> getTagRelationShipses() {
        return this.tagRelationShipses;
    }
    public void setTagRelationShipses(Set<TagRelationShips> tagRelationShipses) {
        this.tagRelationShipses = tagRelationShipses;
    }
    //文章截取
    public String getSubContent(int len) {
        if ((len <= 0) || (len > this.postContent.length()))
          return this.postContent;
        return CutHtml.subStringHTML(this.postContent, len, "...");
      }
}