package co.com.nelsNio.rest;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class PokemonRes {

    @Value("${resource.pokemons}")
    private String resource;

    @Value("${resource.pokemons}")
    private String idResource;

    private final static Logger LOGGER = Logger.getLogger("co.com.nelsNio.rest.PokemonRes");

    // this method is based on gson (see below) and is used to parse Strings to json objects
    public static JsonParser jsonParser = new JsonParser();

    @Autowired
    private RestTemplate restTemplate;

    /**
     *
     * @return List of pokemons
     * @throws UnirestException
     */
    public Object findAll() throws UnirestException {
        LOGGER.log(Level.INFO,resource);
        LOGGER.log(Level.INFO,"co.com.nelsNio.rest.PokemonRes.findAll");
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.get(resource).asString();

        return response.getBody();
    }

    /**
     *
     * @param id
     * @return A pokemon by id
     * @throws UnirestException
     */
    public Object findById(String id) throws UnirestException {
        LOGGER.log(Level.INFO,"Url :"+idResource);
        LOGGER.log(Level.INFO,"co.com.nelsNio.rest.PokemonRes.findById");
        Unirest.setTimeouts(0, 0);

        HttpResponse<String> response = Unirest.get(idResource+String.valueOf(id)+"/").asString();


        return response.getBody();

    }

}
