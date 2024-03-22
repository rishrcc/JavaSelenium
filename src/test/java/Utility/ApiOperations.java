package Utility;

import TestData.OpenBankingApiData;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ApiOperations {
    public static Map<String, String> params = new HashMap<>();

    // Send POST request
    public static void main(String[] args) {
        {
            try {
                ApiOperations api = new ApiOperations();
                String accessTok = api.sendPostRequestForAzureToken();
                System.out.println(accessTok);
                String createContext = api.sendPostRequestToCreateContext(accessTok);
                System.out.print(createContext);
            } catch (IOException | URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public String sendPostRequestForAzureToken() throws IOException, URISyntaxException {

        String apiUrl = OpenBankingApiData.AzureToken.AZURE_TOKEN_URL.getValue();
        URI url = new URI(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.toURL().openConnection();

        connection.setRequestMethod("POST");

        params.put("Content-Type", "application/json");//application/x-www-form-urlencoded
        params.put("client_id", OpenBankingApiData.AzureToken.AZURE_TOKEN_CLIENT_ID.getValue());
        params.put("client_secret", OpenBankingApiData.AzureToken.AZURE_TOKEN_CLIENT_SECRET.getValue());
        params.put("scope", OpenBankingApiData.AzureToken.AZURE_TOKEN_SCOPE.getValue());
        params.put("grant_type", OpenBankingApiData.AzureToken.AZURE_TOKEN_GRANT_TYPE.getValue());
        params.put("resource", OpenBankingApiData.AzureToken.AZURE_TOKEN_RESOURCE.getValue());

        connection.setDoOutput(true);
        connection.setDoInput(true);

        handleRequestBody(connection);
        return getAccessToken(connection);
    }

    public String sendPostRequestToCreateContext(String Authorization) throws IOException, URISyntaxException {

        long uniqueNumber = generateUniqueNumber();

        // Convert the long to a string
        String external_ref = String.valueOf(uniqueNumber);

        String apiUrl = OpenBankingApiData.CreateContext.CREATE_CONTEXT_URL.getValue();
        URI url = new URI(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.toURL().openConnection();

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Authorization", "Bearer " + Authorization);
        connection.setDoOutput(true);

        try (DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream())) {
            outputStream.writeBytes(OpenBankingApiData.RequestBodyContext.JSON_BODY.getJsonBody(external_ref));
            outputStream.flush();
        }

        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        return getWidgetUrl(connection);
    }

    public void handleRequestBody(HttpURLConnection connection) {

        // Construct the request body with form-urlencoded parameters
        StringBuilder requestBody = new StringBuilder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (!requestBody.isEmpty()) {
                requestBody.append("&");
            }
            requestBody.append(entry.getKey()).append("=").append(entry.getValue());
        }

        // Write the request body to the output stream
        try (DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream())) {
            outputStream.writeBytes(requestBody.toString());
            outputStream.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getAccessToken(HttpURLConnection connection) throws IOException {


        StringBuilder response = getResponseFromServer(connection);
        String responseString = response.toString();

        ObjectMapper mapper = new ObjectMapper();

        JsonNode rootNode = mapper.readTree(responseString);

        String accessToken = rootNode.get("access_token").asText();
        connection.disconnect();
        return accessToken;
    }

    public String getWidgetUrl(HttpURLConnection connection) throws IOException{
        StringBuilder response = getResponseFromServer(connection);
        String responseString = response.toString();

        ObjectMapper mapper = new ObjectMapper();

        JsonNode rootNode = mapper.readTree(responseString);

        String widgetUrl = rootNode.get("widgetUrl").asText();
        connection.disconnect();
        return widgetUrl;
    }

    public StringBuilder getResponseFromServer(HttpURLConnection connection){
        // Get the response from the server
        StringBuilder response = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return response;
    }

    public long generateUniqueNumber() {
        Random random = new Random();
        return (long) (Math.pow(10, 9) + random.nextDouble() * Math.pow(10, 9));
    }

}
