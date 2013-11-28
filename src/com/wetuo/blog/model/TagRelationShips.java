package com.wetuo.blog.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="lh_tag_relationships")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class TagRelationShips  implements java.io.Serializable {

	private static final long serialVersionUID = 266028799651656751L;
	private TagRelationShipsId id;
    private Tag tag;
    private Blog blog;
    @EmbeddedId
    @AttributeOverrides( {
        @AttributeOverride(name="blogId", column=@Column(name="blog_id", nullable=false) ), 
        @AttributeOverride(name="tagId", column=@Column(name="tag_id", nullable=false) ) } )
    public TagRelationShipsId getId() {
        return this.id;
    }
    public void setId(TagRelationShipsId id) {
        this.id = id;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="tag_id", nullable=false, insertable=false, updatable=false)
    public Tag getTag() {
        return this.tag;
    }
    public void setTag(Tag tag) {
        this.tag = tag;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="blog_id", nullable=false, insertable=false, updatable=false)

    public Blog getBlog() {
        return this.blog;
    }
    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}