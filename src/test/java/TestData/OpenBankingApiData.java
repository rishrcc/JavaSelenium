package TestData;

public class OpenBankingApiData {

    public enum AzureToken{

        AZURE_TOKEN_URL("https://login.microsoftonline.com/1cbcfc5b-bfc4-46cf-9dd1-b61140309b99/oauth2/token"),
        AZURE_TOKEN_CLIENT_ID("40eee0d9-cbcd-47ad-9339-335f787f5b9c"),
        AZURE_TOKEN_CLIENT_SECRET("qPn8Q~IbLSh4hg-w6JqaRPs56r8aeZvzuvvx5bbX"),
        AZURE_TOKEN_SCOPE("https://graph.microsoft.com/.default"),
        AZURE_TOKEN_GRANT_TYPE("client_credentials"),
        AZURE_TOKEN_RESOURCE("https://no-prod.common.openbanking.bank.oney.com");

        private final String value;

        AzureToken(String value){
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

    public enum CreateContext{

        CREATE_CONTEXT_URL("https://pprd-api.onbadi.com/open-banking/context");

        private final String value;

        CreateContext(String value){
            this.value = value;
        }
        public String getValue() {
            return value;
        }

    }

    public enum RequestBodyContext{
        JSON_BODY("""
        {
            "open_banking_context": {
                "external_reference_code": "proposal_case_uuid",
                "external_reference": "%s"
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
        """);

        private final String jsonBody;

        RequestBodyContext(String jsonBody) {
            this.jsonBody = jsonBody;
        }

        public String getJsonBody(String externalReference) {
            return String.format(jsonBody, externalReference);
        }
    }

}
