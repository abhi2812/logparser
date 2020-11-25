package com.example.logparser.models;


public class SortRecord implements Comparable<SortRecord> {
    int count;
    LogRecord record;

    public SortRecord(int count, LogRecord record) {
        this.count = count;
        this.record = record;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public LogRecord getRecord() {
        return record;
    }

    public void setRecord(LogRecord record) {
        this.record = record;
    }

    @Override
    public int compareTo(SortRecord rec) {
        return Integer.compare(count, rec.count);
    }
}
