/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author vungk
 */
@Entity
@Table(name = "HistoryTest")
public class HistoryTest implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "CorectMark")
    private Integer corectMark;

    @Column(name = "TotalMark")
    private Integer totalMark;

    @NotNull
    @Column(name = "Status")
    private boolean status;

    @NotNull
    @Column(name = "CreatedDate")
    private Date createdDate;

    @Column(name = "UpdatedDate")
    private Date updatedDate;

    @JoinColumn(name = "CategoryExamId", referencedColumnName = "Id")
    @ManyToOne
    private CategoryExam categoryExamId;

    @JoinColumn(name = "UserId", referencedColumnName = "Id")
    @ManyToOne
    private Account userId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "historyTest")
    private Collection<HistoryTestDetail> historyTestDetailCollection;

    public HistoryTest() {
    }

    public HistoryTest(Integer id) {
        this.id = id;
    }

    public HistoryTest(Integer id, boolean status, Date createdDate) {
        this.id = id;
        this.status = status;
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCorectMark() {
        return corectMark;
    }

    public void setCorectMark(Integer corectMark) {
        this.corectMark = corectMark;
    }

    public Integer getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(Integer totalMark) {
        this.totalMark = totalMark;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public CategoryExam getCategoryExamId() {
        return categoryExamId;
    }

    public void setCategoryExamId(CategoryExam categoryExamId) {
        this.categoryExamId = categoryExamId;
    }

    public Account getUserId() {
        return userId;
    }

    public void setUserId(Account userId) {
        this.userId = userId;
    }

    @XmlTransient
    public Collection<HistoryTestDetail> getHistoryTestDetailCollection() {
        return historyTestDetailCollection;
    }

    public void setHistoryTestDetailCollection(Collection<HistoryTestDetail> historyTestDetailCollection) {
        this.historyTestDetailCollection = historyTestDetailCollection;
    }

}
