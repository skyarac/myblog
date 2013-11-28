package com.wetuo.blog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="lh_link")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Link  implements java.io.Serializable {

	private static final long serialVersionUID = 597125038945877028L;
    private Long linkId;
    private String linkName;
    private String linkUrl;
    private String description;
    private String logo;
    private String linkStatus;
    private String remarks;
    @Id
    @GeneratedValue
    @Column(name="link_id", unique=true, nullable=false)
    public Long getLinkId() {
        return this.linkId;
    }
    public void setLinkId(Long linkId) {
        this.linkId = linkId;
    }
    @Column(name="link_name", length=30)
    public String getLinkName() {
        return this.linkName;
    }
    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }
    @Column(name="link_url", length=100)
    public String getLinkUrl() {
        return this.linkUrl;
    }
    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }
    @Column(name="description")
    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    @Column(name="logo")
    public String getLogo() {
        return this.logo;
    }
    public void setLogo(String logo) {
        this.logo = logo;
    }
    @Column(name="link_status" ,length = 20)
    public String getLinkStatus() {
        return this.linkStatus;
    }
    public void setLinkStatus(String linkStatus) {
        this.linkStatus = linkStatus;
    }
    @Column(name="remarks")
    public String getRemarks() {
        return this.remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}