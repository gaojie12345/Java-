package com.spring.bean;

import java.util.*;

//普通属性的注入
public class Bean1 {
    private int intValue;
    private String strValue;
    private String[] arrayValue;
    private List listValue;
    private Set setValue;
    private Map mapValue;
    private Date dateValue;

    public Date getDateValue() {
        return dateValue;
    }

    public void setDateValue (Date date) {
        this.dateValue = dateValue;
    }

    public Bean1() {
    }

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }

    /**
     * 属性值的注入，主要通过setter方法
     *
     * @return
     */

    public String getStrValue() {
        return strValue;
    }

    public void setStrValue(String strValue) {
        this.strValue = strValue;
    }

    public String[] getArrayValue() {
        return arrayValue;
    }

    public void setArrayValue(String[] arrayValue) {
        this.arrayValue = arrayValue;
    }

    public List getListValue() {
        return listValue;
    }

    public void setListValue(List listValue) {
        this.listValue = listValue;
    }

    public Set getSetValue() {
        return setValue;
    }

    public void setSetValue(Set setValue) {
        this.setValue = setValue;
    }

    public Map getMapValue() {
        return mapValue;
    }

    public void setMapValue(Map mapValue) {
        this.mapValue = mapValue;
    }

    @Override
    public String toString() {
        return "Bean1{" +
                "strValue='" + strValue + '\'' +
                ", arrayValue=" + Arrays.toString(arrayValue) +
                ", listValue=" + listValue +
                ", setValue=" + setValue +
                ", mapValue=" + mapValue +
                '}';
    }

    public void setDateValue(String dateValue) {
    }
}
