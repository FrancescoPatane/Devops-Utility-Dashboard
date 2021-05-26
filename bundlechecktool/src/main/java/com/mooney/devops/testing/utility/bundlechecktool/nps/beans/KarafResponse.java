package com.mooney.devops.testing.utility.bundlechecktool.nps.beans;

import java.util.List;

public class KarafResponse {
    private String status;
    private List<Integer> s;
    private List<Data> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Integer> getS() {
        return s;
    }

    public void setS(List<Integer> s) {
        this.s = s;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public KarafResponse() {
    }

    public KarafResponse(String status, List<Integer> s, List<Data> data) {
        this.status = status;
        this.s = s;
        this.data = data;
    }
}
