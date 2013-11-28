package com.wetuo.blog.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TagRelationShipsId  implements java.io.Serializable {
	private static final long serialVersionUID = 7189019752177501819L;
	private Long blogId;
    private Long tagId;
    @Column(name="blog_id", nullable=false)
    public Long getBlogId() {
        return this.blogId;
    }
    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }
    @Column(name="tag_id", nullable=false)

    public Long getTagId() {
        return this.tagId;
    }
    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }
    public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof TagRelationShipsId) ) return false;
		 TagRelationShipsId castOther = ( TagRelationShipsId ) other; 
         
		 return ( (this.getBlogId()==castOther.getBlogId()) || ( this.getBlogId()!=null && castOther.getBlogId()!=null && this.getBlogId().equals(castOther.getBlogId()) ) )
		 && ( (this.getTagId()==castOther.getTagId()) || ( this.getTagId()!=null && castOther.getTagId()!=null && this.getTagId().equals(castOther.getTagId()) ) );
    }
    public int hashCode() {
         int result = 17;
         result = 37 * result + ( getBlogId() == null ? 0 : this.getBlogId().hashCode() );
         result = 37 * result + ( getTagId() == null ? 0 : this.getTagId().hashCode() );
         return result;
    }   
}