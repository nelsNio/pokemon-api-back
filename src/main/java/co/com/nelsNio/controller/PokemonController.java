package co.com.nelsNio.controller;


import co.com.nelsNio.rest.PokemonRes;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.io.IOException;


@Controller
@RequestMapping("/pokemons/")
public class PokemonController {
    @Autowired
    private PokemonRes  pokemonRes;

    @Autowired
    private  ObjectMapper mapper;


    /**
     *
     * @param model
     * @return
     * @throws UnirestException
     */
    @ResponseBody
    @GetMapping( produces= MediaType.APPLICATION_JSON_VALUE)
    public String findAll(Model model) throws UnirestException {
        return  pokemonRes.findAll().toString();
    }

    /**
     *
     * @param id
     * @return
     * @throws UnirestException
     */
    @GetMapping(value = "/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String findById(@PathVariable(required = false)  String id) throws  UnirestException {
        return  pokemonRes.findById(id).toString();
    }

    /**
     * Mapeo de controlador de excepciones
     * @param ex
     * @param model
     * @return
     * @throws IOException
     * @throws UnirestException
     */
    @ExceptionHandler(HttpClientErrorException.class)
    public String handleClientError(HttpClientErrorException ex, Model model) throws IOException, UnirestException {
        MessageDTO dto = mapper.readValue(ex.getResponseBodyAsByteArray(), MessageDTO.class);
        model.addAttribute("error", dto.getMessage());
        return findAll(model);
    }

}
