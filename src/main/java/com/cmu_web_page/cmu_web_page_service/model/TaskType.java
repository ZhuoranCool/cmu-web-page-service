package com.cmu_web_page.cmu_web_page_service.model;

public enum TaskType {
    PRODUCT("product"),
    INFO("info");
    
    private final String value;
    
    TaskType(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
    
    @Override
    public String toString() {
        return value;
    }
}
