package services;

public class No {
    private int ID;
    private No ant;

    //retorna ID (valor) do nó
    public int getID() {
        return ID;
    }
    
    //define ID (valor) do nó
    public void setID(int ID) {
        this.ID = ID;
    }

    //retorna nó anterior
    public No getAnt() {
        return ant;
    }

    //define nó anterior
    public void setAnt(No ant) {
        this.ant = ant;
    }   
}
