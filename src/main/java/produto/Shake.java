package produto;

import ingredientes.Adicional;
import ingredientes.Base;
import ingredientes.Fruta;
import ingredientes.Topping;

import java.util.TreeSet;
import java.util.Collection;

public class Shake {
    private Base base;
    private Fruta fruta;
    private Topping topping;
    private TreeSet<Adicional> adicionais;
    private TipoTamanho  tipoTamanho;

    public Shake(Base base,
                 Fruta fruta,
                 Topping topping,
                 Collection<Adicional> adicionais,
                 TipoTamanho tipoTamanho) {
        this.base = base;
        this.fruta = fruta;
        this.topping = topping;
        this.adicionais = new TreeSet<>(adicionais);
        this.tipoTamanho = tipoTamanho;
    }

    public Shake(Base base, Fruta fruta, Topping topping, TipoTamanho tipoTamanho) {
        this.base = base;
        this.fruta = fruta;
        this.topping = topping;
        this.adicionais = new TreeSet<>();
        this.tipoTamanho = tipoTamanho;
    }

    public Base getBase() {
        return base;
    }

    public Fruta getFruta() {
        return fruta;
    }

    public Topping getTopping() {
        return topping;
    }

    public TreeSet<Adicional> getAdicionais() {
        return adicionais;
    }

    public TipoTamanho getTipoTamanho() {
        return tipoTamanho;
    }

    @Override
    public String toString() {
        return this.base.getTipoBase().toString() + " / " + this.fruta.getTipoFruta().toString() + " / " + this.topping.getTipoTopping().toString() + " / " + this.adicionais + " / " + this.tipoTamanho.toString();
    }
}
