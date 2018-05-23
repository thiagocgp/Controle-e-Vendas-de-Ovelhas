import java.util.Date;

public class Ovelha{

    private int idOvelha;
    private String nome, raca;
    private Sexo sexo;
    private Date nascimento;
    private double peso;

    public Ovelha(int idOvelha, String nome, Sexo sexo, String raca, Date nascimento, double peso) {
        this.idOvelha = idOvelha;
        this.nome = nome;
        this.raca = raca;
        this.sexo = sexo;
        this.nascimento = nascimento;
        this.peso = peso;
    }

    public int getIdOvelha() {
        return this.idOvelha;
    }

    public void setIdOvelha(int idOvelha) {
        this.idOvelha = idOvelha;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return this.raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Sexo getSexo() {
        return this.sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Date getNascimento() {
        return this.nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public void setPeso(double peso) {
    	this.peso = peso;
    }
    
    public double getPeso() {
    	return this.peso;
    }
    
    public String mostraDados(){
        return null;
    }
    
}
