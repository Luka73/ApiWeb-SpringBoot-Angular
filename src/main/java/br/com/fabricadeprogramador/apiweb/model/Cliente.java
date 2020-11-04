package br.com.fabricadeprogramador.apiweb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cliente {
    @Id
    @GeneratedValue
    private int id;
    private String nome;

    public Cliente() {
    }

    public Cliente(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString(){
        return "Id: " + id + ", Nome: " + nome;
    }
}
