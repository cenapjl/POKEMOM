package com.Pokemon.Gabriel.services;

import com.Pokemon.Gabriel.domains.Pokemon;
import com.Pokemon.Gabriel.domains.dtos.PokemonDTO;
import com.Pokemon.Gabriel.repositories.PokemonRepository;
import com.Pokemon.Gabriel.services.exceptions.DataIntegrityViolationException;
import com.Pokemon.Gabriel.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokeRepo;


    public List<PokemonDTO> findAll(){
        return  pokeRepo.findAll().stream().map(obj -> new PokemonDTO(obj))
                .collect(Collectors.toList());
    }



    public Pokemon findbyId(Long id){
        Optional<Pokemon> obj = pokeRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Pokemon não encontrado Id:" + id));
    }


    public Pokemon findbyCpfPokemon(String cpfPokemon){
        Optional<Pokemon> obj = pokeRepo.findByCpfPokemon(cpfPokemon);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Pokemon não encontrado cpfPokemon:" + cpfPokemon));
    }


    public Pokemon create(PokemonDTO pokemonDTO){
        pokemonDTO.setId(null);
        validaCpf(pokemonDTO);
        Pokemon obj = new Pokemon(pokemonDTO);
        return pokeRepo.save(obj);
    }


    private void validaCpf(PokemonDTO pokemonDTO){
        Optional<Pokemon> obj = pokeRepo.findByCpfPokemon(pokemonDTO.getCpfPokemon());
        if(obj.isPresent() && obj.get().getId() != pokemonDTO.getId()){
            throw  new DataIntegrityViolationException("CpfPokemon ja cadastrado");
        }
    }



    public Pokemon update(Long id,  PokemonDTO objDto){
        objDto.setId(id);
        Pokemon oldObj = findbyId(id);
        validaCpf(objDto);
        oldObj = new Pokemon(objDto);
        return pokeRepo.save(oldObj);
    }


    public void deletePokemon (Long id){
        Pokemon obj = findbyId(id);
        pokeRepo.deleteById(id);
    }

}
