package org.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        String apiUrl = "https://pprd-api.onbadi.com/open-banking/context";
        String bearerToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6IlhSdmtvOFA3QTNVYVdTblU3Yk05blQwTWpoQSIsImtpZCI6IlhSdmtvOFA3QTNVYVdTblU3Yk05blQwTWpoQSJ9.eyJhdWQiOiJodHRwczovL25vLXByb2QuY29tbW9uLm9wZW5iYW5raW5nLmJhbmsub25leS5jb20iLCJpc3MiOiJodHRwczovL3N0cy53aW5kb3dzLm5ldC8xY2JjZmM1Yi1iZmM0LTQ2Y2YtOWRkMS1iNjExNDAzMDliOTkvIiwiaWF0IjoxNzExMTA5MTQ1LCJuYmYiOjE3MTExMDkxNDUsImV4cCI6MTcxMTExMzA0NSwiYWlvIjoiRTJOZ1lFaStmcGhYVFBPNjBCYlpkTUZkeFR3ekFBPT0iLCJhcHBpZCI6IjQwZWVlMGQ5LWNiY2QtNDdhZC05MzM5LTMzNWY3ODdmNWI5YyIsImFwcGlkYWNyIjoiMSIsImlkcCI6Imh0dHBzOi8vc3RzLndpbmRvd3MubmV0LzFjYmNmYzViLWJmYzQtNDZjZi05ZGQxLWI2MTE0MDMwOWI5OS8iLCJvaWQiOiJkMjNlYmNhZi03MWU3LTQ5ZGItODlhZi03MTI4MDNiNmQwMDMiLCJyaCI6IjAuQVJFQVdfeThITVNfejBhZDBiWVJRRENibVd4OVliZWYtTFJGajg0RXpTWjlLRjRSQUFBLiIsInN1YiI6ImQyM2ViY2FmLTcxZTctNDlkYi04OWFmLTcxMjgwM2I2ZDAwMyIsInRpZCI6IjFjYmNmYzViLWJmYzQtNDZjZi05ZGQxLWI2MTE0MDMwOWI5OSIsInV0aSI6Inh6WHEyeWwxTlVTMWQxZWUxcjBUQUEiLCJ2ZXIiOiIxLjAifQ.osR67UZRPRYUNVHwfewiQJbOXa7bpDM0o-ZCgmoGzx6fyPFRxQTkTz9lUjwAMkpVyFC6eaNDwtb3HeDCDPUmNeapkcdNu15bHyIVjRcxaRyAImh7u2JfCH5LBobIP_pX-f46pb-yz6yPZ8Y8aGC4cj3ymUYpCOp_UEIPI3vY2sMKydmwuN6CvJe0-8N5O-Cvd2ctwwOqG69JB8cSbv8VQi6Lv0cY6qnWL_XaFxw_l6rloH7r9dO923tO2VhQtGB9yhIfJ1yxSgWt2uRdAHmUzbINwvnK9iP6RFsrIrDYV6kUw_ladzhxgHVqtZSW9dAflrMvzLB-uR4V3DRoKmmSkw";

        String requestBody = """
                {
                    "open_banking_context": {
                        "external_reference_code": "proposal_case_uuid",
                        "external_reference": "7894561230"
                    },
                    "customer": {
                        "emails": [
                            {
                                "type_code": "PRS",
                                "address": "jauyeung@partner.oney.fr"
                            }
                        ],
                        "identity": {
                            "full_name": "Hubert Laurent",
                            "first_name": "Laurent",
                            "last_name": "Hubert",
                            "birth_date": ""
                        }
                    }
                }
                """;

        URL url = new URI(apiUrl).toURL();
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Authorization", "Bearer " + bearerToken);
        connection.setDoOutput(true);

        try (DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream())) {
            outputStream.writeBytes(requestBody);
            outputStream.flush();
        }

        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        StringBuilder responseBody = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                responseBody.append(line);
            }
        }

        System.out.println("Response Body: " + responseBody.toString());

        connection.disconnect();
    }
}
