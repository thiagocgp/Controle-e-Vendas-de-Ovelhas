import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public class FemeaAdulta extends Ovelha {
	
	private LinkedList<String> filhos;

    public FemeaAdulta(int id, String nome, Sexo sexo, String raca, Date nascimento, double peso) {
        super(id, nome, Sexo.femea, raca, nascimento, peso);
        filhos = new LinkedList<String>();
    }
   
    //mostra os dados do animal
    public String mostraDados(){
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return  ("\tNome: " + getNome() + "\n\tSexo: " + getSexo() + "\n\tRaca: " + getRaca() +
                "\n\tData de Nascimento: " + sdf.format(getNascimento()) + "\n\tPeso: " + getPeso() + "Kg" + "\n");
    }

    //adiciona o nome de um novo filho
    public void addFilho(String nomeFilho) {
        filhos.add(nomeFilho);
    }

    //retorna lista de filhos
    public LinkedList<String> listaFilhos() {
        return this.filhos;
    }

}
