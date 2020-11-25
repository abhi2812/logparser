package com.example.logparser.models;

public class TopRecords {
    int frequency;
    String url;
    HttpMethod method;

    public TopRecords(int frequency, String url, HttpMethod method) {
        this.frequency = frequency;
        this.url = url;
        this.method = method;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public HttpMethod getMethod() {
        return method;
    }

    public void setMethod(HttpMethod method) {
        this.method = method;
    }
}
