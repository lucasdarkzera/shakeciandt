package produto;

public enum TipoTamanho {
    //IMPLEMENTE A LOGICA DO ENUM
    //TODO
    P(1L, 1),
    M(2L, 30),
    G(3L, 50);

    private Long id;
    private final double multiplicador;

    TipoTamanho(Long id, double multiplicador){
        this.id = id;
        this.multiplicador = multiplicador;
    }



}
