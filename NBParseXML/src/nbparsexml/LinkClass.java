package nbparsexml;

public class LinkClass {

    private String titoloLink;
    private String link;

    public LinkClass() {
        this.titoloLink = "";
        this.link = "";
    }

    public LinkClass(String titoloLink, String titolo) {
        this.titoloLink = titoloLink;
        this.link = titolo;
    }

    public LinkClass(LinkClass stringLink) {
        this.titoloLink = stringLink.titoloLink;
        this.link = stringLink.link;
    }

    public String toString() {
        return "[" + titoloLink + "," + link + "]";
    }
    
    public String getTitoloLink() {
        return titoloLink;
    }

    public void setTitoloLink(String titoloLink) {
        this.titoloLink = titoloLink;
    }

    public String getTitolo() {
        return link;
    }

    public void setTitolo(String titolo) {
        this.link = titolo;
    }
}
