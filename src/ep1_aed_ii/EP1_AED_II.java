package ep1_aed_ii;

import entities.Localidades;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EP1_AED_II {
    public static List<Localidades> localidades = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe o caminho de entrada do arquivo a ser lido: ");

        //Lendo o arquivo .csv contendo as informações das viagens
        try (BufferedReader bf = new BufferedReader (new FileReader(sc.nextLine()))){
            String aux = bf.readLine(); // linha de legendas
            String line = bf.readLine();
            
            while(line != null){
                String[] viagens = line.split(",");
                
                Localidades domicilio = null;
                if (!viagens[2].equals("0") && !viagens[3].equals("0")) {
                    domicilio = criaLocalidade(viagens, 2, 3);
                    inserirCoordenadas(domicilio, Long.parseLong(viagens[43]));
                }
                
                Localidades escola = null;
                if (!viagens[57].equals("0") && !viagens[58].equals("0")) {                
                    escola = criaLocalidade(viagens, 57, 58);                
                    inserirCoordenadas(escola, Long.parseLong(viagens[43]));
                }
                
                Localidades trabalho1 = null;
                if (!viagens[62].equals("0") && !viagens[63].equals("0")) {                
                    trabalho1 = criaLocalidade(viagens, 62, 63);                
                    inserirCoordenadas(trabalho1, Long.parseLong(viagens[43]));
                }
                
                Localidades trabalho2 = null;
                if (!viagens[71].equals("0") && !viagens[72].equals("0")) {                
                    trabalho2 = criaLocalidade(viagens, 71, 72);                
                    inserirCoordenadas(trabalho2, Long.parseLong(viagens[43]));
                }
                
                Localidades origemViagem = null;
                if (!viagens[84].equals("0") && !viagens[85].equals("0")) {                
                    origemViagem = criaLocalidade(viagens, 84, 85);                
                    inserirCoordenadas(origemViagem, Long.parseLong(viagens[43]));
                }

                Localidades destinoViagem = null;
                if (!viagens[88].equals("0") && !viagens[89].equals("0")) {                
                    destinoViagem = criaLocalidade(viagens, 88, 89);                
                    inserirCoordenadas(destinoViagem, Long.parseLong(viagens[43]));
                }
                
                Localidades transferencia1 = null;
                if (!viagens[92].equals("0") && !viagens[93].equals("0")) {                
                    transferencia1 = criaLocalidade(viagens, 92, 93);                
                    inserirCoordenadas(transferencia1, Long.parseLong(viagens[43]));
                }
                
                Localidades transferencia2 = null;
                if (!viagens[96].equals("0") && !viagens[97].equals("0")) {                
                    transferencia2 = criaLocalidade(viagens, 96, 97);                
                    inserirCoordenadas(transferencia2, Long.parseLong(viagens[43]));
                }

                Localidades transferencia3 = null;
                if (!viagens[100].equals("0") && !viagens[101].equals("0")) {                
                    transferencia3 = criaLocalidade(viagens, 100, 101);                
                    inserirCoordenadas(transferencia3, Long.parseLong(viagens[43]));
                }               
                
                line = bf.readLine();
            }

            System.out.print("Informe o caminha completo de saída do arquivo: ");
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(sc.nextLine()))){
                
                for (Localidades l : localidades){
                    bw.write(l.getCoordenada_x() + ", " + l.getCoordenada_y() + ": " + l.tamanhoPilha());
//                    bw.write(l.getCoordenada_x() + ", " + l.getCoordenada_y() + ": " + l.imprimirPilha2());
                    bw.newLine();
//                    System.out.print(l.getCoordenada_x() + ", " + l.getCoordenada_y() + ": " + l.imprimirPilha2());
                }
            }catch (IOException e){
                e.getMessage();
                e.printStackTrace();
            }        
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

    public static void inserirCoordenadas(Localidades loc, long ID){
        if(localidades.contains(loc)){
            for(Localidades localidade : localidades){
                if(loc.equals(localidade) && localidade.buscarNaPilha(ID) == null){
                    localidade.inserirNo(ID);
                    break;
                }
            }        
        }else{
            localidades.add(loc);
            loc.inserirNo(ID);
        }       
    }
    //C:\\Users\\marco\\Desktop\\Viagens.csv
    //C:\\Users\\marco\\Desktop\\out\\summary2.cvs
}
