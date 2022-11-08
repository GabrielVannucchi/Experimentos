package com.mycompany.inventario.itens;

public class Consumivel extends Item{
    private String texto;
    public Consumivel(Integer id, String nome, String texto) {
        super(id, nome);
        this.texto = texto;
    }
    
    @Override
    public void usar(){
        System.out.println("aaaaaaaaaaaaa");
    }
    
}
