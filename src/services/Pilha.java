package services;

public class Pilha {
    
    private No topo = null;

    public void inserirNo(int ID){
        No novo = new No();
        novo.setID(ID);
        novo.setAnt(topo);
        topo = novo;
    }
    
    public int removerNo(No excluir){
        if(topo == null) throw new NullPointerException("a pilha está vazia");
        else {
            int getid = topo.getID();
            topo = topo.getAnt();
            return getid;
        }       
    }
    
    public void imprimirPilha(){
        if(topo == null) throw new NullPointerException("Esta pilha está vazia");
        
        No newTopo = topo;
        System.out.print("Pilha: \n{");
        System.out.print(newTopo.getID());
        while(newTopo.getAnt() != null){
            System.out.print(", ");
            newTopo = newTopo.getAnt();
            System.out.print(newTopo.getID());
        }
        System.out.println("}");
    }
    
    public No buscarNaPilha(int IdBuscado){
        if(topo.getID() == IdBuscado) return topo;
        No auxBusca = topo.getAnt();
        
        while(auxBusca != null){
            if(auxBusca.getID() == IdBuscado) return auxBusca;
            auxBusca = auxBusca.getAnt();
        } 
        throw new NullPointerException("ID buscado não existe");
    
    }   
    public int tamanhoPilha(){
        int cont = 0;
        No newTopo = topo;
        while(newTopo != null){
            cont++;
            newTopo = newTopo.getAnt();
        }
        return cont;
    }
    
    public boolean estaVazia(){
        if(topo == null) return true;
        return false;
    }
}
