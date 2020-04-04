package ep1_aed_ii;

import entities.Localidades;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EP1_AED_II {
    public static List<Localidades> localidades = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Informe o caminho completo do arquivo a ser lido: ");
        
        //Lendo o arquivo .csv contendo as informações das viagens
        try (BufferedReader bf = new BufferedReader (new FileReader(sc.nextLine()))){
            String line = bf.readLine(); // linha de legendas
 
            //while(line != null){
                line = bf.readLine();
                
                String[] viagens = line.split(",");

                Localidades loc1 = criaLocalidade(viagens, 2, 3);
                inserirCoordenadas(loc1, Integer.parseInt(viagens[43]));
                
                Localidades loc2 = criaLocalidade(viagens, 2, 3);                
                inserirCoordenadas(loc2, Integer.parseInt(viagens[43]));

                loc1.imprimirPilha();
            //}
        }catch (IOException e){
            e.getMessage();
            e.printStackTrace();
        }
    }

    public static Localidades criaLocalidade(String[] viagem, int x, int y){
        int coordenada_x = Integer.parseInt(viagem[x]);
        int coordenada_y = Integer.parseInt(viagem[y]);
        return new Localidades(coordenada_x, coordenada_y);

    }

    public static void inserirCoordenadas(Localidades loc, int ID){
        if(localidades.contains(loc)){
            for(Localidades localidade : localidades){
                if(loc.equals(localidade)){
                    localidade.inserirNo(ID);
                }
            }        
        }else{
            localidades.add(loc);
            loc.inserirNo(ID);
        }       
    }

}
