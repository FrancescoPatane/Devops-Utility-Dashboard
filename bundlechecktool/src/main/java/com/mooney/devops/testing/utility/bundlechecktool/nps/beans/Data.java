package com.mooney.devops.testing.utility.bundlechecktool.nps.beans;

public class Data {// implements Comparable< Data >{
    private Integer id;
    private String name;
    private boolean fragment;
    private int stateRaw;
    private String state;
    private String version;
    private String symbolicName;
    private String category;

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

    public boolean isFragment() {
        return fragment;
    }

    public void setFragment(boolean fragment) {
        this.fragment = fragment;
    }

    public int getStateRaw() {
        return stateRaw;
    }

    public void setStateRaw(int stateRaw) {
        this.stateRaw = stateRaw;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSymbolicName() {
        return symbolicName;
    }

    public void setSymbolicName(String symbolicName) {
        this.symbolicName = symbolicName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Data() {
    }

    public Data(Integer id, String name, boolean fragment, int stateRaw, String state, String version, String symbolicName, String category) {
        this.id = id;
        this.name = name;
        this.fragment = fragment;
        this.stateRaw = stateRaw;
        this.state = state;
        this.version = version;
        this.symbolicName = symbolicName;
        this.category = category;
    }
    
//    @Override
//    public int compareTo(Data o) {
//        return this.getId().compareTo(o.getId());
//    }
}
