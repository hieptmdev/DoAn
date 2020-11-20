package com.datn.app.dto;

import com.datn.app.entity.Category;

public class CategoryDto extends BaseDto{
    private String name;
    private Long categoryParentId;
    private String url;
    private String description;
    private String icon;
    private Boolean haveChildren;

    public CategoryDto() { }

    @Override
    public Category convertToEnt() {
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCategoryParentId() {
        return categoryParentId;
    }

    public void setCategoryParentId(Long categoryParentId) {
        this.categoryParentId = categoryParentId;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Boolean getHaveChildren() {
        return haveChildren;
    }

    public void setHaveChildren(Boolean haveChildren) {
        this.haveChildren = haveChildren;
    }
}
