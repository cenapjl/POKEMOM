package com.Pokemon.Gabriel.resources;

import com.Pokemon.Gabriel.domains.Pokemon;
import com.Pokemon.Gabriel.domains.dtos.PokemonDTO;
import com.Pokemon.Gabriel.services.PokemonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/pokemon")
public class PokemonResource {

    @Autowired
    private PokemonService pokeService;



    @GetMapping
    public ResponseEntity<List<PokemonDTO>> findAll(){
        return  ResponseEntity.ok().body(pokeService.findAll());
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<PokemonDTO> findbyId(@PathVariable Long id){
        Pokemon obj = this.pokeService.findbyId(id);
        return ResponseEntity.ok().body(new PokemonDTO(obj));
    }

    @GetMapping(value = "/cpfPokemon/{cpfPokemon}")
    public ResponseEntity<PokemonDTO> findById(@PathVariable String cpfPokemon){
        Pokemon obj = this.pokeService.findbyCpfPokemon(cpfPokemon);
        return ResponseEntity.ok().body(new PokemonDTO(obj));
    }


    @PostMapping
    public ResponseEntity<PokemonDTO> create(@Valid  @RequestBody PokemonDTO pokemonDTO){
        Pokemon pokemon = pokeService.create(pokemonDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(pokemon.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PokemonDTO> update(@PathVariable Long id, @Valid @RequestBody PokemonDTO objDTO){
        Pokemon Obj = pokeService.update(id, objDTO);
        return  ResponseEntity.ok().body(new PokemonDTO(Obj));
    }


    @DeleteMapping(value =  "/{id}")
    public ResponseEntity<PokemonDTO> delete(@PathVariable Long id){
        pokeService.deletePokemon(id);
        return ResponseEntity.noContent().build();
    }


}

