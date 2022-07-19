package pedido;

import produto.Shake;

import java.util.Objects;

public class ItemPedido {
    private Shake shake;
    private int quantidade;

    public ItemPedido(Shake shake, int quantidade) {
        this.shake = shake;
        this.quantidade = quantidade;
    }

    public Shake getShake() {
        return shake;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ItemPedido itemPedido = (ItemPedido) o;
        Shake shake = itemPedido.getShake();

         /* TODO
            fix
          */
        return (Objects.hash(this.shake.getBase().obterTipo().toString(),
                this.shake.getFruta().obterTipo().toString(),
                this.shake.getTopping().obterTipo().toString(),
                this.shake.getAdicionais(),
                this.shake.getTipoTamanho().toString())
                == (Objects.hash(shake.getBase().obterTipo().toString(),
                shake.getFruta().obterTipo().toString(),
                shake.getTopping().obterTipo().toString(),
                shake.getAdicionais(),
                shake.getTipoTamanho().toString())));
    }

    @Override
    public int hashCode() {
        return Objects.hash(shake, quantidade);
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void removeShake(){
        if (this.quantidade > 0) {
            this.quantidade--;
        }
    }

    public void adicionaShake(){
        this.quantidade++;
    }

    public void adicionaShake(int quantidade){
        this.quantidade += quantidade;
    }

    public double calcValor(Cardapio cardapio){
        return -1;
    }

    @Override
    public String toString() {
        return this.shake + " / x" + this.quantidade;
    }
}
