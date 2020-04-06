package services;

public class PilhaDinamica {
    
    private No topo;

    public PilhaDinamica(){
        topo = null;
    }

    public void inserirNo(int ID){
        No novo = new No(ID);
        novo.setProximo(topo);
        topo = novo;
    }
    
    public int removerNo(){
        if(topo == null) throw new NullPointerException("a pilha está vazia");
        else {
            int getid = topo.getID();
            topo = topo.getProximo();
            return getid;
        }       
    }
    
    public void imprimirPilha(){
        if(topo == null) throw new NullPointerException("Esta pilha está vazia");
        No end = topo;
//        System.out.print("Pilha:{");
        System.out.print(end.getID());
        while(end.getProximo() != null){
            System.out.print(" " + end.getID());
            end = end.getProximo();
        }
        System.out.println();
    }
    
    public No buscarNaPilha(int IdBuscado){
        if(topo.getID() == IdBuscado) return topo;
        No end = topo;
        
        while(end != null){
            if(end.getID() == IdBuscado) return end;
            end = end.getProximo();
        } 
        return null;
    }

    public int tamanhoPilha(){
        int tam = 0;
        No end = topo;
        while(end != null){
            tam++;
            end = end.getProximo();
        }
        return tam;
    }
    
    public boolean estaVazia(){
        if(topo == null) return true;
        return false;
    }
}
