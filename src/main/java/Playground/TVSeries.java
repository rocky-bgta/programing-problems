package Playground;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TVSeries {

    static class TVSeriesData {
        String name;
        String runtime_of_series;
        String certificate;
        String runtime_of_episodes;
        String genre;
        double imdb_rating;
        String overview;
        int no_of_votes;
        int id;

        public String getName() {
            return name;
        }

        public String getRuntime_of_series() {
            return runtime_of_series;
        }

        public int getStartYear() {
            // Extract start year from runtime_of_series
            return Integer.parseInt(runtime_of_series.substring(1, 5));
        }

        public int getEndYear() {
            // Extract end year from runtime_of_series
            int endIndex = runtime_of_series.indexOf('-');
            return endIndex == -1 ? -1 : Integer.parseInt(runtime_of_series.substring(endIndex + 1, endIndex + 5));
        }
    }

    public static List<String> showsInProduction(int startYear, int endYear) throws IOException {
        List<TVSeriesData> tvSeriesList = new ArrayList<>();
        int currentPage = 1;
        int totalPages = Integer.MAX_VALUE;

        // Retrieve all records by paginating through the API
        while (currentPage <= totalPages) {
            String apiUrl = "https://jsonmock.hackerrank.com/api/tvseries?page=" + currentPage;
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(new URL(apiUrl));

            // Extract relevant information from the API response
            totalPages = jsonNode.get("total_pages").asInt();
            JsonNode dataNode = jsonNode.get("data");

            for (JsonNode seriesNode : dataNode) {
                TVSeriesData tvSeriesData = objectMapper.treeToValue(seriesNode, TVSeriesData.class);
                tvSeriesList.add(tvSeriesData);
            }

            currentPage++;
        }

        // Filter and sort the TV series based on the provided startYear and endYear
        List<String> result = tvSeriesList.stream()
                .filter(series -> series.getStartYear() >= startYear &&
                        (endYear == -1 || series.getEndYear() <= endYear))
                .sorted(Comparator.comparing(TVSeriesData::getName))
                .map(TVSeriesData::getName)
                .collect(Collectors.toList());

        return result;
    }

    public static void main(String[] args) throws IOException {
        // Example with startYear = 2006 and endYear = 2011
        int startYear = 2006;
        int endYear = 2011;

        List<String> result = showsInProduction(startYear, endYear);

        // Print the result
        for (String show : result) {
            System.out.println(show);
        }
    }
}
/*
    SELECT
    participant_name AS winner,
    ROUND(bet + 0.3 * (SELECT SUM(bet) FROM event_details WHERE group_id
    = ed.group_id AND participant_id != ed.participant_id), 2) AS total_cash
FROM
    event_details ed
WHERE
    slice_count = (SELECT MAX(slice_count) FROM event_details WHERE group_id = ed.group_id)
ORDER BY
    winner;

 */