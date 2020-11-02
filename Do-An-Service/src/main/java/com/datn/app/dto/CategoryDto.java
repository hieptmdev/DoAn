package com.datn.app.dto;

import com.datn.app.entity.BaseEnt;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryDto extends BaseDto{
    private String name;
    private Long categoryParent;
    private String url;
    private String description;

    public CategoryDto() { }

    @Override
    public BaseEnt convertToEnt() {
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCategoryParent() {
        return categoryParent;
    }

    public void setCategoryParent(Long categoryParent) {
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
