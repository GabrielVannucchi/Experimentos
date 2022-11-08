
package com.mycompany.inventario;


public class App {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        

        inventario.listarTodosItens();
        System.out.println(";;;;;;;");
        
        inventario.adicionar(5);
        inventario.adicionar(1,4);
        inventario.adicionar(2,6);
        inventario.adicionar(3,6);
        inventario.adicionar(7,2);
        inventario.adicionar(4);
        inventario.listarInventario();
        System.out.println(";;;;;;;");
        System.out.println(";;;;;;;");
        inventario.usarItem(2);
        inventario.listarInventario();
        
        
        
    }
}
