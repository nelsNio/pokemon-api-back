package co.com.nelsNio.controller;


import co.com.nelsNio.rest.PokemonRes;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.io.IOException;


@Controller
@RequestMapping("/")
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
    @RequestMapping(value = "/pokemons/list/",method = RequestMethod.GET)
    @ResponseBody
    public String findAll(Model model) throws UnirestException {
        System.out.println(pokemonRes.findAll().toString());
        return pokemonRes.findAll().toString();
    }

    /**
     *
     * @param id
     * @return
     * @throws UnirestException
     */
    @RequestMapping(value = "/pokemons",method = RequestMethod.GET)
    @ResponseBody
    public String findById(@RequestParam(required = false)  String id) throws  UnirestException {
        System.out.println(pokemonRes.findById(id));

        return pokemonRes.findById(id).toString();
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
