package padroesprojeto.observer.hospital;

public class Enfermeiro implements Observador {

    private String nome;
    private String ultimaNotificacao;

    public Enfermeiro(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void escalarNoPlantao(Plantao plantao) {
        plantao.addObservador(this);
    }

    public void atualizar(Object fonte, Object dado) {
        Plantao plantao = (Plantao) fonte;
        this.ultimaNotificacao = this.nome + ", ocorrência registrada no " + plantao.toString();
    }
}
