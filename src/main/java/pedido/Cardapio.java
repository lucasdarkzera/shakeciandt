package pedido;

import ingredientes.Ingrediente;

import java.util.TreeMap;

public class Cardapio {
    private TreeMap<Ingrediente, Double> precos;

    public Cardapio(){
        this.precos = new TreeMap<>();
    }

    public TreeMap<Ingrediente, Double> getPrecos(){
        return this.precos;
    }

    public void adicionarIngrediente(Ingrediente ingrediente,Double preco){

        if (!this.isPriceValid(preco)){
            throw new IllegalArgumentException("Preco invalido.");
        }
        if (!this.getPrecos().containsKey(ingrediente)) // necessario?
            this.getPrecos().put(ingrediente, preco);
    }

    public boolean atualizarIngrediente(Ingrediente ingrediente,Double preco){
        if (!isPriceValid(preco)){
           throw new IllegalArgumentException("Preco invalido.");
        }
        if (!this.getPrecos().containsKey(ingrediente)){
            throw new IllegalArgumentException("Ingrediente nao existe no cardapio.");
        }

        // TODO melhorar
        this.precos.replace(ingrediente, preco);
        return true;
    }

    public boolean removerIngrediente(Ingrediente ingrediente){
        if (this.getPrecos().containsKey(ingrediente)){
            this.precos.remove(ingrediente);
            return true;
        }
        throw new IllegalArgumentException("Ingrediente nao existe no cardapio.");
    }

    public Double buscarPreco(Ingrediente ingrediente){
        if (this.precos.containsKey(ingrediente)) {
            return this.precos.get(ingrediente);
        }
        throw new IllegalArgumentException("Ingrediente nao existe no cardapio.");
    }

    @Override
    public String toString() {
        return this.precos.toString();
    }

    private boolean isPriceValid(Double price){

        return (price > 0) ? true : false;

    }


}
