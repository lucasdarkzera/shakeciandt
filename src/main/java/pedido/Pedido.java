package pedido;

import ingredientes.Adicional;
import produto.TipoTamanho;

import java.util.ArrayList;
import java.util.Objects;

public class Pedido{

    private int id;
    private  ArrayList<ItemPedido> itens;
    private Cliente cliente;

    public Pedido(int id, ArrayList<ItemPedido> itens, Cliente cliente){
        this.id = id;
        this.itens = itens;
        this.cliente = cliente;
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
        total = this.itens.stream()
                .map(cadaPedido -> {
                    final var precoTamanho = TipoTamanho.obterMultiplicador(cadaPedido.getShake().getTipoTamanho());
                    final var precoBase = cardapio.buscarPreco(cadaPedido.getShake().getBase());
                    final var quantidade = cadaPedido.getQuantidade();
                    final var pFinal = precoBase + precoTamanho * precoBase;
                    final var precoAdicionais = cadaPedido.getShake().getAdicionais().stream().reduce(
                            0.0,
                            (Double p, Adicional adicional) -> (p + cardapio.buscarPreco(adicional)),
                            Double::sum);
                    return (pFinal + precoAdicionais) * quantidade;

                })
                .reduce(0.0, Double::sum);
        return total;
    }


    public void adicionarItemPedido(ItemPedido itemPedidoAdicionado){
        this.itens.stream()
                .filter(item -> item.equals(itemPedidoAdicionado)).findAny()
                .ifPresentOrElse(
                        (ItemPedido itemPresente) -> {
                            final int qtdPresente = itemPresente.getQuantidade();
                            itemPresente.setQuantidade(qtdPresente + itemPedidoAdicionado.getQuantidade());
                        },
                        () ->
                                this.itens.add(itemPedidoAdicionado)
                );
    }


    public Pedido removeItemPedido(ItemPedido itemPedidoRemovido) {
        final ItemPedido itemPedido = this.itens.stream()
                .filter(itemPedidoRemovido::equals)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Item nao existe no pedido."));
        this.removeShake(itemPedido);
        return this;
    }

    private void removeShake(ItemPedido itemPedido){
        if (Objects.nonNull(itemPedido)){
            itemPedido.removeShake();
            if (itemPedido.getQuantidade() <= 0)
                this.itens.remove(itemPedido);
        }
    }

    @Override
    public String toString() {
        return this.itens + " - " + this.cliente;
    }
}
