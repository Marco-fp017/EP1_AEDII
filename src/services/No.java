package services;

public class No {
    private long ID;
    private No proximo;

    public No(long ID){
       this.ID = ID;
       this.proximo = null;
   }

    //retorna ID (valor) do nó
    public long getID() {
        return ID;
    }
    
    //define ID (valor) do nó
    public void setID(long ID) {
        this.ID = ID;
    }

    //retorna nó anterior
    public No getProximo() {
        return proximo;
    }

    //define nó anterior
    public void setProximo(No prox) {
        this.proximo = prox;
    }   
}
