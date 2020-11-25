package com.example.logparser.models;

import java.util.Objects;

public final class LogRecord {


    public LogRecord(long timeStamp, String url, HttpMethod method, int responseTime, int responseCode) {
        this.timeStamp = timeStamp;
        this.url = url;
        this.method = method;
        this.responseTime = responseTime;
        this.responseCode = responseCode;

    }

    long timeStamp;
    String url;
    int responseTime;

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(int responseTime) {
        this.responseTime = responseTime;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public HttpMethod getMethod() {
        return method;
    }

    public void setMethod(HttpMethod method) {
        this.method = method;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogRecord logRecord = (LogRecord) o;
        return url.equals(logRecord.url) &&
                method == logRecord.method;
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, method);
    }

    int responseCode;
    HttpMethod method;
}
