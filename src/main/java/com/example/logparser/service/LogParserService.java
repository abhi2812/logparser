package com.example.logparser.service;

import com.example.logparser.models.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class LogParserService implements LogParser {

    private final String filepath;

    HashMap<LogRecord, Integer> map;

    public LogParserService(String filePath) throws IOException {
        this.filepath = filePath;
        this.map = new HashMap<>();
        this.parseInputCsv();
    }


    @Override
    public List<TopRecords> getTopElements(int numberOfElements) {
        List<SortRecord> list = new ArrayList<>();
        for(Map.Entry<LogRecord, Integer> entry: map.entrySet()) {
            list.add(new SortRecord(entry.getValue(), entry.getKey()));
        }
        List<TopRecords> topRecords = new ArrayList<>();
        Collections.sort(list, Collections.reverseOrder());
        int i = 0;
        for(SortRecord rec: list) {
            i++;
            TopRecords topRecords1 = new TopRecords(rec.getCount(), rec.getRecord().getUrl(),
                    rec.getRecord().getMethod());
            topRecords.add(topRecords1);
            if(i == numberOfElements) break;
        }
        return topRecords;
    }

    @Override
    public List<EndpointGroup> getGroupedData() {
        return null;
    }

    public Boolean parseInputCsv() throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(this.filepath));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
        int i = 0;
        for (CSVRecord csvRecord : csvParser) {
            if(i++ == 0) continue;
            try {
                System.out.println(csvRecord.get(0));
                Long timeStamp = Long.parseLong(csvRecord.get(0));
                String url = parseUrl(csvRecord.get(1));
                HttpMethod method = HttpMethod.valueOf(csvRecord.get(2));
                Integer responseTime = Integer.parseInt(csvRecord.get(3));
                Integer responseCode = Integer.parseInt(csvRecord.get(4));
                LogRecord logRecord = new LogRecord(timeStamp, url, method, responseTime, responseCode);
                if(map.get(logRecord) == null) {
                    map.put(logRecord, 1);
                } else {
                    int val = map.get(logRecord);
                    map.put(logRecord, val + 1);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                continue;
            }
        }
        return null;
    }

    private String parseUrl(String url) {
        return url.replaceAll("[0-9]", "{id}");
    }
}
