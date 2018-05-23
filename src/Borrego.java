import java.text.SimpleDateFormat;
import java.util.Date;

public class Borrego extends Ovelha {

    private String mae, pai;

    public Borrego(int id, String nome, Sexo sexo, String raca, Date nascimento, double peso, String mae, String pai) {
        super(id, nome, sexo, raca, nascimento, peso);
        this.mae = mae;
        this.pai = pai;
    }

    public String getMae() {
        return mae;
    }

    public void setMae(String mae) {
        this.mae = mae;
    }

    public String getPai() {
        return pai;
    }

    public void setPai(String pai) {
        this.pai = pai;
    }

    //mostra os dados do animal
    public String mostraDados(){
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return ("Nome: " + getNome() + " \nSexo: " + getSexo() + " \nRaca: " + getRaca() +
                " \nData de Nascimento: " + sdf.format(getNascimento()) + " \nPeso: " + getPeso() + "Kg" + "\nNome da mae: " + getMae() +
        		"\nNome do pai: " + getPai() + "\n");
    }
}
