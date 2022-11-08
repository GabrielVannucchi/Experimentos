package com.mycompany.inventario;

import com.mycompany.inventario.itens.Consumivel;
import com.mycompany.inventario.itens.Item;
import java.util.ArrayList;
import java.util.List;

public class Inventario {

    private List<Item> listaItens;
    private List<Item> itens;
    private List<Integer> quantidade;

    public void organizarInventario() {
        List<Item> nItens = new ArrayList<>();
        List<Integer> nQtd = new ArrayList<>();
        Integer ultimoId = 0;
        Integer maiorId = itens.get(0).getId();

        for (int i = 0; i < itens.size(); i++) {
            if (itens.get(i).getId() > maiorId) {
                maiorId = itens.get(i).getId();
            }
        }
        //
        while (ultimoId <= maiorId) {
            for (int i = 0; i < itens.size(); i++) {
                if (itens.get(i).getId() == ultimoId) {
                    nItens.add(itens.get(i));
                    nQtd.add(quantidade.get(i));
                }
            }
            ultimoId++;
        }

        itens = nItens;
        quantidade = nQtd;

    }

    public void usarItem(Integer id) {
        for (int i = 0; i < itens.size(); i++) {
            if (itens.get(i).getId().equals(id)) {
                quantidade.set(i, quantidade.get(i) - 1);
                itens.get(i).usar();
                if (quantidade.get(i) <= 0) {
                    itens.remove(i);
                    quantidade.remove(i);
                }
            }
        }
    }

    public void usarItem(Integer id, Integer qtd) {
        for (int i = 0; i < itens.size(); i++) {
            if (itens.get(i).getId().equals(id)) {
                if (quantidade.get(i) - qtd >= 0) {
                    for (int j = 0; j < qtd; j++) {
                        quantidade.set(i, quantidade.get(i) - 1);
                        itens.get(i).usar();
                    }
                    if (quantidade.get(i) <= 0) {
                        itens.remove(i);
                        quantidade.remove(i);
                    }
                }
            }
        }
    }

    public void adicionar(Integer id) {
        Boolean newItem = true;
        for (int i = 0; i < itens.size(); i++) {
            if (itens.get(i).getId().equals(id)) {
                quantidade.set(i, quantidade.get(i) + 1);
                newItem = false;
            }
        }
        if (newItem == true) {
            itens.add(getItem(id));
            quantidade.add(1);
            organizarInventario();
        }

    }

    public void adicionar(Integer id, Integer qtd) {
        Boolean newItem = true;
        for (int i = 0; i < itens.size(); i++) {
            if (itens.get(i).getId().equals(id)) {
                quantidade.set(i, quantidade.get(i) + qtd);
                newItem = false;
            }
        }
        if (newItem == true) {
            itens.add(getItem(id));
            quantidade.add(qtd);
            organizarInventario();
        }

    }

    public void listarInventario() {
        for (int i = 0; i < itens.size(); i++) {
            System.out.println("Nome: (" + itens.get(i).getId() + ")" + itens.get(i).getNome() + "; qtd: " + quantidade.get(i));
        }
    }

    public void listarTodosItens() {
        for (int i = 0; i < listaItens.size(); i++) {
            System.out.println("Id: " + listaItens.get(i).getId() + "; " + listaItens.get(i).getNome());
        }
    }

    public Item getItem(Integer id) {
        for (int i = 0; i < listaItens.size(); i++) {
            if (listaItens.get(i).getId().equals(id)) {
                return listaItens.get(i);
            }
        }
        return null;
    }

    public Integer itemAutoIncrement() {
        return listaItens.size() + 1;
    }

    //////////////////
    public void criarItens() {
        listaItens.add(new Consumivel(itemAutoIncrement(), "Poção de Vida","aaaaa"));
        listaItens.add(new Item(itemAutoIncrement(), "Poção de Mana"));
        listaItens.add(new Item(itemAutoIncrement(), "Poção da Invisibilidade"));

        listaItens.add(new Item(itemAutoIncrement(), "Espada Enferrujada"));
        listaItens.add(new Item(itemAutoIncrement(), "Capa da Invisibilidade"));
        listaItens.add(new Item(itemAutoIncrement(), "Escudo da Bravura"));
        listaItens.add(new Item(itemAutoIncrement(), "Botas da Rapidez"));

    }

    ///////////////////
    public Inventario() {
        this.itens = new ArrayList<>();
        this.quantidade = new ArrayList<>();

        this.listaItens = new ArrayList<>();
        criarItens();
    }

    public List<Item> getItens() {
        return itens;
    }

    public List<Integer> getQuantidade() {
        return quantidade;
    }

}
