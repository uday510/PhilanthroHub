package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import okhttp3.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DataLoadingScript {

    private static final String BASE_URL = "http://localhost:8080";
    private static final OkHttpClient CLIENT = new OkHttpClient();
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    // Map to store Nonprofit IDs by legal name
    private static final Map<String, Integer> nonprofitIds = new HashMap<>();

    public static void main(String[] args) {
        try {
            // Load and parse Nonprofits data
            loadAndParseNonprofits("/Users/uday/Downloads/Temelio/nonprofit_data.csv");

            // Load and parse Submissions data
            loadAndParseSubmissions("/Users/uday/Downloads/Temelio/nonprofit_submission_data.csv");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to load and parse Nonprofits data from CSV
    private static void loadAndParseNonprofits(String csvFilePath) throws IOException, CsvException {
        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            List<String[]> rows = reader.readAll();

            // Skip first row containing column names
            for (int i = 1; i < rows.size(); ++i) {
                String[] row = rows.get(i);

                // Create Nonprofit object from CSV row
                Nonprofit nonprofit = createNonprofitFromRow(row);

                // Send POST request to create Nonprofit and get its ID
                String id = sendPostRequest("/nonprofits", convertToJson(nonprofit));
                nonprofitIds.put(nonprofit.getLegalName(), Integer.parseInt(id));
            }
        }
    }

    // Method to create Nonprofit object from CSV row
    private static Nonprofit createNonprofitFromRow(String[] row) {
        Nonprofit nonprofit = new Nonprofit();
        nonprofit.setLegalName(row[0]);
        nonprofit.setEin(row[2]);
        nonprofit.setMission(row[5]);

        Address address = new Address();
        address.setStreet(row[13]);
        address.setCity(row[25]);
        address.setState(row[26]);
        address.setZip(row[27]);

        nonprofit.setAddress(address);
        return nonprofit;
    }

    // Method to load and parse Submissions data from CSV
    private static void loadAndParseSubmissions(String csvFilePath) throws IOException, CsvException {
        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            List<String[]> rows = reader.readAll();

            for (int i = 1; i < rows.size(); ++i) {
                String[] row = rows.get(i);

                // Create GrantSubmission object from CSV row
                GrantSubmission submission = createSubmissionFromRow(row);

                // Send POST request to create Submission
                sendPostRequest("/nonprofits/" + submission.getNonprofitId() + "/submissions", convertToJson(submission));
            }
        }
    }

    // Method to create GrantSubmission object from CSV row
    private static GrantSubmission createSubmissionFromRow(String[] row) {
        GrantSubmission submission = new GrantSubmission();
        String nonProfit = row[0];
        String grantName = row[1];
        assert nonProfit != null;

        // Retrieve Nonprofit ID from the map
        int nonprofitId = nonprofitIds.get(nonProfit);

        submission.setNonprofitId(nonprofitId);
        submission.setGrantName(grantName);
        submission.setAwardedAmount(row[5]);
        submission.setGrantType(GrantType.valueOf(row[6]));
        submission.setTags(Collections.singletonList(row[7]));

        Duration duration = new Duration();
        duration.setGrantStart(row[8]);
        duration.setGrantEnd(row[9]);

        submission.setDuration(duration);
        return submission;
    }

    // Method to convert an object to JSON string
    private static String convertToJson(Object obj) {
        try {
            return OBJECT_MAPPER.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException("Failed to convert object to JSON", e);
        }
    }

    // Method to send a POST request and return the server response
    private static String sendPostRequest(String endpoint, String jsonBody) throws IOException {
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(jsonBody, JSON);
        Request request = new Request.Builder()
                .url(BASE_URL + endpoint)
                .post(body)
                .build();

        try (Response response = CLIENT.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            } else {
                String responseBody = Objects.requireNonNull(response.body()).string();
                System.out.println("Server response: " + responseBody);
                return responseBody;
            }
        }
    }
}
