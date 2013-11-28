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
@Table(name="lh_tag")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Tag  implements java.io.Serializable {
	private static final long serialVersionUID = 3265194518804649705L;
    private Long tagId;
    private String name;
    private String remarks;
    private Set<TagRelationShips> tagRelationShipses = new HashSet<TagRelationShips>(0);

    @Id
    @GeneratedValue
    @Column(name="tag_id", unique=true, nullable=false)
    public Long getTagId() {
        return this.tagId;
    }
    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }
    @Column(name="name", length=60)
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Column(name="remarks")
    public String getRemarks() {
        return this.remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="tag")
    public Set<TagRelationShips> getTagRelationShipses() {
        return this.tagRelationShipses;
    }
    
    public void setTagRelationShipses(Set<TagRelationShips> tagRelationShipses) {
        this.tagRelationShipses = tagRelationShipses;
    }
}