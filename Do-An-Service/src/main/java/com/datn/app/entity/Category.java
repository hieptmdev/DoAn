package com.datn.app.entity;

import com.datn.app.dto.CategoryDto;
import com.datn.app.util.AppUtil;

import javax.persistence.*;

@Entity
@Table
public class Category extends BaseEnt{
    @Column(nullable = false)
    private String name;
    @ManyToOne
    private Category categoryParent;
    private String url;
    private String description;

    public Category() { }

    @Override
    public CategoryDto convertToDto() {
        return AppUtil.mapToDtoAndEnt(this, CategoryDto.class);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategoryParent() {
        return categoryParent;
    }

    public void setCategoryParent(Category categoryParent) {
        this.categoryParent = categoryParent;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
