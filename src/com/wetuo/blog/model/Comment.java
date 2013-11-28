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

@Entity
@Table(name="lh_comment")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Comment  implements java.io.Serializable {

	private static final long serialVersionUID = -4455406057866516901L;
    private Long commentId;
    private Blog blog;
    private Comment comment;
    private Date commentDate;
    private String poster;
    private String content;
    private String mail;
    private String url;
    private String ip;
    private String hide;
    private String remarks;
    private Set<Comment> comments = new HashSet<Comment>(0);
    @Id
    @GeneratedValue
    @Column(name="comment_id", unique=true, nullable=false)
    public Long getCommentId() {
        return this.commentId;
    }
    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="blog_id", nullable=false)
    public Blog getBlog() {
        return this.blog;
    }
    public void setBlog(Blog blog) {
        this.blog = blog;
    }
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="parent_id")
	public Comment getComment() {
	    return this.comment;
	}
	
	public void setComment(Comment comment) {
	    this.comment = comment;
	}
    @Column(name="comment_date", length=29)
    public Date getCommentDate() {
        return this.commentDate;
    }
    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }
    @Column(name="poster", length=20)
    public String getPoster() {
        return this.poster;
    }
    public void setPoster(String poster) {
        this.poster = poster;
    }
    @Column(name="content")
    public String getContent() {
        return this.content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    @Column(name="mail", length=60)
    public String getMail() {
        return this.mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    @Column(name="url", length=75)
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    @Column(name="ip", length=128)
    public String getIp() {
        return this.ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }
    @Column(name="hide", length=10)
    public String getHide() {
        return this.hide;
    }
    public void setHide(String hide) {
        this.hide = hide;
    }
    @Column(name="remarks")
    public String getRemarks() {
        return this.remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="comment")
    public Set<Comment> getComments() {
        return this.comments;
    }
    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
}