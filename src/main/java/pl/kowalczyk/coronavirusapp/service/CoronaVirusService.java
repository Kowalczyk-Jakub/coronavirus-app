package pl.kowalczyk.coronavirusapp.service;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import pl.kowalczyk.coronavirusapp.model.DataRecord;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class CoronaVirusService {

    private String url = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
    private List<DataRecord> al;

    //I might have used "Scheduled" annotation but I didn't (:
    public List<DataRecord> getData() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        al = new ArrayList<>();

        StringReader in = new StringReader(httpResponse.body());
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
        for (CSVRecord record : records) {
            DataRecord dataRecord = new DataRecord();
            dataRecord.setState(record.get("Province/State"));
            dataRecord.setRegion(record.get("Country/Region"));
            dataRecord.setInfected(Integer.parseInt(record.get(record.size()-1)));
            al.add(dataRecord);
        }
        return al;
    }

}
