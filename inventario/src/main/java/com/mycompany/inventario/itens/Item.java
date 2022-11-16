
package com.mycompany.inventario.itens;

public abstract class Item {
    private Integer id;
    private String nome;
    
    public abstract void usar();
    
    //
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Item(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}