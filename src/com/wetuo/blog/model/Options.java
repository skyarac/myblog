package com.wetuo.blog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="lh_options")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Options  implements java.io.Serializable {
	private static final long serialVersionUID = 4104184536308852473L;
    private Long optionId;
    private String optionName;
    private String optionValue;
    private String remarks;
    @Id
    @GeneratedValue
    @Column(name="option_id", unique=true, nullable=false)
    public Long getOptionId() {
        return this.optionId;
    }
    public void setOptionId(Long optionId) {
        this.optionId = optionId;
    }
    @Column(name="option_name")
    public String getOptionName() {
        return this.optionName;
    }
    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }
    @Column(name="option_value")
    public String getOptionValue() {
        return this.optionValue;
    }
    public void setOptionValue(String optionValue) {
        this.optionValue = optionValue;
    }
    @Column(name="remarks")
    public String getRemarks() {
        return this.remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}