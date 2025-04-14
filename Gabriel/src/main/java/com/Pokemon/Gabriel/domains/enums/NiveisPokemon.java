package com.Pokemon.Gabriel.domains.enums;


public enum NiveisPokemon {


    INICIANTE(0,"INICIANTE"), INTERMEDIARIO(1,"INTERMEDIARIO"), AVANCADO(2,"AVANÇADO"), LENDARIO(3,"LENDARIO");

    private int id;
    private String niveisPokemon;




    NiveisPokemon(int id, String niveisPokemon) {
        this.id = id;
        this.niveisPokemon = niveisPokemon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNiveisPokemon() {
        return niveisPokemon;
    }

    public void setNiveisPokemon(String niveisPokemon) {
        this.niveisPokemon = niveisPokemon;
    }



    public static NiveisPokemon toEnum(Integer id){
        if(id == null) return null;
        for( NiveisPokemon x : NiveisPokemon.values()){
            if(id.equals(x.getId())){
                return x;
            }
        }
        throw new IllegalArgumentException("Nivél de pokemon inválido");

    }
}
