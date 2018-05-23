import java.util.Iterator;
import java.util.LinkedList;

public class ListaOvelhas {

    private LinkedList<Ovelha> ovelhas;
    private LinkedList<Ovelha> ovelhasVendidas;

    public ListaOvelhas(){
        ovelhas = new LinkedList<Ovelha>();
    }

    void addOvelha(Ovelha ovelha){
        ovelhas.add(ovelha);
    }

    void removeOvelha(Ovelha ovelha) {
        ovelhas.remove(ovelha);
    }

    
    //lista todos os animais do rebanho
    public LinkedList<Ovelha> listaOvelhas(){
        return ovelhas;
    }

    //lista apenas os machos
    public LinkedList<MachoAdulto> listaMachos(){
        Iterator<Ovelha> i = ovelhas.iterator();
        LinkedList<MachoAdulto> aux = new LinkedList<MachoAdulto>();
        Ovelha o;

        while (i.hasNext()) {
            o = (Ovelha) i.next();
            if(o instanceof MachoAdulto) {
                MachoAdulto m = (MachoAdulto) o;
                aux.add(m);
            }
        }
        return aux;
    }

    //lista de machos reprodutores
    public LinkedList<MachoAdulto> listaReprodutor(){
        Iterator<Ovelha> i = ovelhas.iterator();
        LinkedList<MachoAdulto> aux = new LinkedList<MachoAdulto>();
        Ovelha o;

        while (i.hasNext()) {
            o = (Ovelha) i.next();
            if(o instanceof MachoAdulto && (((MachoAdulto) o).getCategoria() == CategoriaMacho.reprodutor)) {
                MachoAdulto m = (MachoAdulto) o;
                aux.add(m);
            }
        }
        return aux;
    }

    //lista de machos de corte
    public LinkedList<MachoAdulto> listaCorte(){
        Iterator<Ovelha> i = ovelhas.iterator();
        LinkedList<MachoAdulto> aux = new LinkedList<MachoAdulto>();
        Ovelha o;

        while (i.hasNext()) {
            o = (Ovelha) i.next();
            if(o instanceof MachoAdulto && (((MachoAdulto) o).getCategoria() == CategoriaMacho.corte)) {
                MachoAdulto m = (MachoAdulto) o;
                aux.add(m);
            }
        }
        return aux;
    }

    //lista apenas de femeas
    public LinkedList<FemeaAdulta> listaFemeas(){
        Iterator<Ovelha> i = ovelhas.iterator();
        LinkedList<FemeaAdulta> aux = new LinkedList<FemeaAdulta>();
        Ovelha o;

        while (i.hasNext()) {
            o = (Ovelha) i.next();
            if(o instanceof FemeaAdulta) {
                FemeaAdulta m = (FemeaAdulta) o;
                aux.add(m);
            }
        }
        return aux;
    }

    //lista apenas de borregos
    public LinkedList<Borrego> listaBorregos(){
        Iterator<Ovelha> i = ovelhas.iterator();
        LinkedList<Borrego> aux = new LinkedList<Borrego>();
        Ovelha o;

        while (i.hasNext()) {
            o = (Ovelha) i.next();
            if(o instanceof Borrego) {
                Borrego m = (Borrego) o;
                aux.add(m);
            }
        }
        return aux;
    }

    //Retorna ovelha pelo ID
    public Ovelha buscaPorId(int id){
        Iterator<Ovelha> i = ovelhas.iterator();
        Ovelha o;

        while (i.hasNext()) {
            o = (Ovelha) i.next();
            if(id == o.getIdOvelha()){
                return o;
            }
        }
        return null;
    }

    //Passa uma ovelha para a lista de vendidos e retira da lista de ovelhas
    public void venderOvelha(int id) {
        Iterator<Ovelha> i = ovelhas.iterator();
        Ovelha o;

        while (i.hasNext()) {
            o = (Ovelha) i.next();
            if(id == o.getIdOvelha()){
                ovelhasVendidas.add(o);
                removeOvelha(o);
            }
        }
    }
    
}
