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
@Table(name = "Question")
public class Question implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
    
    @NotNull
    @Column(name = "Name")
    private String name;
    
    @NotNull
    @Column(name = "Answer_a")
    private String answera;
    
    @NotNull
    @Column(name = "Answer_b")
    private String answerb;
    
    @NotNull
    @Column(name = "Answer_c")
    private String answerc;
    
    @NotNull
    @Column(name = "Answer_d")
    private String answerd;
    
    @NotNull
    @Column(name = "AnswerCorrect")
    private String answerCorrect;
    
    @Column(name = "Image")
    private String image;
    
    @NotNull
    @Column(name = "CreatedDate")
    private Date createdDate;
    
    @Column(name = "UpdatedDate")
    private Date updatedDate;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
    private Collection<HistoryTestDetail> historyTestDetailCollection;
    @JoinColumn(name = "CategoryExamId", referencedColumnName = "Id")
    @ManyToOne
    private CategoryExam categoryExamId;

    public Question() {
    }

    public Question(Integer id) {
        this.id = id;
    }

    public Question(Integer id, String name, String answera, String answerb, String answerc, String answerd, String answerCorrect, Date createdDate) {
        this.id = id;
        this.name = name;
        this.answera = answera;
        this.answerb = answerb;
        this.answerc = answerc;
        this.answerd = answerd;
        this.answerCorrect = answerCorrect;
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnswera() {
        return answera;
    }

    public void setAnswera(String answera) {
        this.answera = answera;
    }

    public String getAnswerb() {
        return answerb;
    }

    public void setAnswerb(String answerb) {
        this.answerb = answerb;
    }

    public String getAnswerc() {
        return answerc;
    }

    public void setAnswerc(String answerc) {
        this.answerc = answerc;
    }

    public String getAnswerd() {
        return answerd;
    }

    public void setAnswerd(String answerd) {
        this.answerd = answerd;
    }

    public String getAnswerCorrect() {
        return answerCorrect;
    }

    public void setAnswerCorrect(String answerCorrect) {
        this.answerCorrect = answerCorrect;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    @XmlTransient
    public Collection<HistoryTestDetail> getHistoryTestDetailCollection() {
        return historyTestDetailCollection;
    }

    public void setHistoryTestDetailCollection(Collection<HistoryTestDetail> historyTestDetailCollection) {
        this.historyTestDetailCollection = historyTestDetailCollection;
    }

    public CategoryExam getCategoryExamId() {
        return categoryExamId;
    }

    public void setCategoryExamId(CategoryExam categoryExamId) {
        this.categoryExamId = categoryExamId;
    }   
}
