package com.example.logparser.models;

public class EndpointGroup {
    HttpMethod method;
    String url;
    int minTime;

    public EndpointGroup(HttpMethod method, String url, int minTime, int maxTime, int averageTime) {
        this.method = method;
        this.url = url;
        this.minTime = minTime;
        this.maxTime = maxTime;
        this.averageTime = averageTime;
    }

    public HttpMethod getMethod() {
        return method;
    }

    public void setMethod(HttpMethod method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getMinTime() {
        return minTime;
    }

    public void setMinTime(int minTime) {
        this.minTime = minTime;
    }

    public int getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(int maxTime) {
        this.maxTime = maxTime;
    }

    public int getAverageTime() {
        return averageTime;
    }

    public void setAverageTime(int averageTime) {
        this.averageTime = averageTime;
    }

    int maxTime;
    int averageTime;
}
