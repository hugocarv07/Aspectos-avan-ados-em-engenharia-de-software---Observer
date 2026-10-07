package padroesprojeto.observer.hospital;

public class Plantao extends Notificavel {

    private Integer ano;
    private String turno;
    private String setor;
    private String equipe;

    public Plantao(Integer ano, String turno, String setor, String equipe) {
        this.ano = ano;
        this.turno = turno;
        this.setor = setor;
        this.equipe = equipe;
    }

    public void registrarOcorrencia() {
        setAlterado();
        notificarObservadores();
    }

    @Override
    public String toString() {
        return "Plantao{" +
                "ano=" + ano +
                ", turno='" + turno + '\'' +
                ", setor='" + setor + '\'' +
                ", equipe='" + equipe + '\'' +
                '}';
    }
}
