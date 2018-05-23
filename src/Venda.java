import java.util.Date;

public class Venda {

    private int idOvelha;
    private double preco;
    private Date dataVenda;

    public Venda(int idOvelha, double preco, Date dataVenda) {
        this.idOvelha = idOvelha;
        this.preco = preco;
        this.dataVenda = dataVenda;
    }

    public int getId() {
        return idOvelha;
    }

    public void setId(int id) {
        this.idOvelha = id;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }
}
