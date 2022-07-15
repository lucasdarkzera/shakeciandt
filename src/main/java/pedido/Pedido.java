package pedido;

import ingredientes.Ingrediente;
import java.util.ArrayList;

public class Pedido{

    private int id;
    private  ArrayList<ItemPedido> itens;
    private Cliente cliente;

    public Pedido(int id, ArrayList<ItemPedido> itens,Cliente cliente){
        this.id = id;
        this.itens=itens;
        this.cliente=cliente;
    }

    public ArrayList<ItemPedido> getItens() {
        return itens;
    }

    public int getId(){
        return this.id;
    }

    public Cliente getCliente(){
        return this.cliente;
    }

    public double calcularTotal(Cardapio cardapio){
        double total = 0;
/*
        O preço de um Shake é calculado com o valor da Base de acordo com o TipoTamanho, somado com o custo dos adicionais
        P: preco da Base original no Cardapio
        M: preco da Base acrescentado de 30%
        G: preco da Base acrescentado de 50%
        Regra 3: O custo de um Pedido é o somatório do custo de todos os Shake presentes nos ItemPedido desse Pedido
            (dica: ItemPedido possui um atributo quantidade)
*/
        return total;
    }


    public void adicionarItemPedido(ItemPedido itemPedidoAdicionado){
        this.itens.stream()
                .filter(item -> item.equals(itemPedidoAdicionado)).findAny()
                .ifPresentOrElse(
                        (ItemPedido itemPresente) -> {
                            int qtdPresente = itemPresente.getQuantidade();
                            itemPresente.setQuantidade(qtdPresente + itemPedidoAdicionado.getQuantidade());
                        },
                        () -> {
                            this.itens.add(itemPedidoAdicionado);
                        }
                );
    }
    private void define(ItemPedido itemPedidoAdicionado){
    }

    public void removeItemPedido(ItemPedido itemPedidoRemovido) {
        ItemPedido itemPedido = this.itens.stream().filter(itemPedidoRemovido::equals)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Item nao existe no pedido."));
        this.removeShake(itemPedido);
    }

    public void removeShake(ItemPedido itemPedido){
       itemPedido.removeShake();
       if (itemPedido.getQuantidade() == 0)
           this.itens.remove(itemPedido);
    }

    @Override
    public String toString() {
        return this.itens + " - " + this.cliente;
    }
}
