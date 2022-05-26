package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.socket.client.*;
import java.net.URI;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.List;

public class SocketMethods {

    private URI url = URI.create("http://192.168.1.27:3000");
    private final IO.Options options = IO.Options.builder().build();
    private Socket socket;
    private ObjectMapper mapper = new ObjectMapper();

    public SocketMethods() {
        this.mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

        this.socket = IO.socket(url, options);

        // Connect the socket
        this.socket.connect();
    }

    public void sendEvent(String name, String content) {
        JSONObject message = new JSONObject();
        try {
            message.put("name", name);
            message.put("message", content);

            socket.emit("message", message);
        } catch (JSONException ex) {
            System.out.println("Ocurrio un problema al crear el json");
            System.out.println(ex);
        }

    }

    public Socket listen(){
        return socket;
    }
    
    public <T> T convertToJson(String json, TypeReference<T> reference) {
        try {
            return this.mapper.readValue(json, reference);
        } catch (JsonProcessingException ex) {
            System.out.println("Error al convertir a un objeto Json");
            System.out.println(ex);
        }

        return null;
    }
}
