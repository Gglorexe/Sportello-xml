/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmltocsv;

/**
 *
 * @author spinelli_loris
 */
public class StrutturaProf {
    String[] nome;
    String[] giorno;
    String[] ora;
    
    public StrutturaProf(){
        nome = new String[2];
        giorno = new String[2];
        ora = new String[2];
    }
    
    public StrutturaProf(String[] nome, String[] giorno, String[] ora){
        this.nome = nome;
        this.giorno = giorno;
        this.ora = ora;
    }
    
    public String toString(){
        String s = "";
        s = nome + giorno[0].toString() + "-" + ora[0].toString() + ","
                + giorno[1].toString() + ora[0].toString();
        return s;
    }
    public String[] getNome() {
        return nome;
    }

    public void setNome(String[] nome) {
        this.nome = nome;
    }

    public String[] getGiorno() {
        return giorno;
    }

    public void setGiorno(String[] giorno) {
        this.giorno = giorno;
    }

    public String[] getOra() {
        return ora;
    }

    public void setOra(String[] ora) {
        this.ora = ora;
    }
}
