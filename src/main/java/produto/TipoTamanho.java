package produto;

public enum TipoTamanho {
    //IMPLEMENTE A LOGICA DO ENUM
    //TODO
    P(1L, 2),
    M(2L, 2),
    G(3L, 2);

    private Long id;
    private final double multiplicador;

    TipoTamanho(Long id, double multiplicador){
        this.id = id;
        this.multiplicador = multiplicador;
    }



}
