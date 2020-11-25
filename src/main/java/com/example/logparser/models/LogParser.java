package com.example.logparser.models;

import java.util.List;

public interface LogParser {
    List<TopRecords> getTopElements(int numberOfElements);
    List<EndpointGroup> getGroupedData();
}
