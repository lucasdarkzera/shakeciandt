package produto;


import java.util.Arrays;
import java.util.Objects;

public enum TipoTamanho {
    //IMPLEMENTE A LOGICA DO ENUM
    //TODO
    P(1L, 0),
    M(2L, 0.3),
    G(3L, 0.5);



    private Long id;
    private final double multiplicador;

    TipoTamanho(Long id, double multiplicador){
        this.id = id;
        this.multiplicador = multiplicador;
    }

    public static double obterMultiplicador(TipoTamanho tipoTamanho){
        return Arrays.stream(TipoTamanho.values())
                .filter(values -> Objects.equals(values.getId(), tipoTamanho.getId()))
                .mapToDouble(TipoTamanho::getMultiplicador)
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }

    double getMultiplicador(){
        return this.multiplicador;
    }

    public Long getId() {
        return id;
    }


}
