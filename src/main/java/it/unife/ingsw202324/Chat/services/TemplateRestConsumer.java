package it.unife.ingsw202324.Chat.services;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestClient;


@SpringBootApplication
public class TemplateRestConsumer {

    static String uriBaseMockUsers = "http://localhost:3000/users";
    static String uriBaseMockEvents = "http://localhost:3000/events";

    public static String callREST(String resourceName, String uriBase) {
        RestClient restClient = RestClient.create();
        /*
            Creo uriBase per chiamare Mockoon se l'impostazione è useMock
        */
        if(uriBase.equals(uriBaseMockUsers)) uriBase = uriBaseMockUsers;
        else if(uriBase.equals(uriBaseMockEvents)) uriBase = uriBaseMockEvents;

        System.out.println(uriBase+resourceName);

        return restClient.get()
                .uri(uriBase + resourceName)
                .retrieve()
                .body(String.class);
    }
}