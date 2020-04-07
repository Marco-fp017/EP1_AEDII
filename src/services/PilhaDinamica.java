package services;

public class PilhaDinamica {
    
    private No topo;

    public PilhaDinamica(){
        topo = null;
    }

    public void inserirNo(long ID){
        No novo = new No(ID);
        novo.setProximo(topo);
        topo = novo;
    }
    
    public long removerNo(){
        if(topo == null) throw new NullPointerException("a pilha está vazia");
        else {
            long getid = topo.getID();
            topo = topo.getProximo();
            return getid;
        }       
    }
    
    //imprime diretamente no método
   public void imprimirPilha1(){
        if(topo == null) throw new NullPointerException("Esta pilha está vazia");
        No end = topo;
        System.out.print(end.getID());
        while(end.getProximo() != null){
            System.out.print(" " + end.getID());
            end = end.getProximo();
        }
        System.out.println();
    }    

        //retorna uma string com os valores que devem ser imprimidos
       public String imprimirPilha2(){
        if(topo == null) throw new NullPointerException("Esta pilha está vazia");
        String saida = "" + topo.getID();
        No end = topo.getProximo();
        while(end != null){
            saida += " " + end.getID();
            end = end.getProximo();
        }
        saida += "\n";
        return saida;
    }

   
    public No buscarNaPilha(long IdBuscado){
        if(topo.getID() == IdBuscado) return topo;
        No end = topo;
        
        while(end != null){
            if(end.getID() == IdBuscado) return end;
            end = end.getProximo();
        } 
        return null;
    }

    public long tamanhoPilha(){
        long tam = 0;
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
