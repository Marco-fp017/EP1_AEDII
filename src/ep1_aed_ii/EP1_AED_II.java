package ep1_aed_ii;

import entities.Localidades;
import java.io.BufferedReader;
//import java.io.BufferedWriter;
import java.io.FileReader;
//import java.io.FileWriter;
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
            String aux = bf.readLine(); // linha de legendas
            String line = bf.readLine();
            
            while(line != null){
                String[] viagens = line.split(",");
                
                Localidades domicilio = null;
                if (!viagens[2].equals("0") && !viagens[3].equals("0")) {
                    domicilio = criaLocalidade(viagens, 2, 3);
                    inserirCoordenadas(domicilio, Integer.parseInt(viagens[43]));
                }
                
                Localidades escola = null;
                if (!viagens[57].equals("0") && !viagens[58].equals("0")) {                
                    escola = criaLocalidade(viagens, 57, 58);                
                    inserirCoordenadas(escola, Integer.parseInt(viagens[43]));
                }
                
                Localidades trabalho1 = null;
                if (!viagens[62].equals("0") && !viagens[63].equals("0")) {                
                    trabalho1 = criaLocalidade(viagens, 62, 63);                
                    inserirCoordenadas(trabalho1, Integer.parseInt(viagens[43]));
                }
                
                Localidades trabalho2 = null;
                if (!viagens[71].equals("0") && !viagens[72].equals("0")) {                
                    trabalho2 = criaLocalidade(viagens, 71, 72);                
                    inserirCoordenadas(trabalho2, Integer.parseInt(viagens[43]));
                }
                
                Localidades origemViagem = null;
                if (!viagens[84].equals("0") && !viagens[85].equals("0")) {                
                    origemViagem = criaLocalidade(viagens, 84, 85);                
                    inserirCoordenadas(origemViagem, Integer.parseInt(viagens[43]));
                }

                Localidades destinoViagem = null;
                if (!viagens[88].equals("0") && !viagens[89].equals("0")) {                
                    destinoViagem = criaLocalidade(viagens, 88, 89);                
                    inserirCoordenadas(destinoViagem, Integer.parseInt(viagens[43]));
                }
                
                Localidades transferencia1 = null;
                if (!viagens[92].equals("0") && !viagens[93].equals("0")) {                
                    transferencia1 = criaLocalidade(viagens, 92, 93);                
                    inserirCoordenadas(transferencia1, Integer.parseInt(viagens[43]));
                }
                
                Localidades transferencia2 = null;
                if (!viagens[96].equals("0") && !viagens[97].equals("0")) {                
                    transferencia2 = criaLocalidade(viagens, 96, 97);                
                    inserirCoordenadas(transferencia2, Integer.parseInt(viagens[43]));
                }

                Localidades transferencia3 = null;
                if (!viagens[100].equals("0") && !viagens[101].equals("0")) {                
                    transferencia3 = criaLocalidade(viagens, 100, 101);                
                    inserirCoordenadas(transferencia3, Integer.parseInt(viagens[43]));
                }               
                
                line = bf.readLine();
            }
               
            for (Localidades l : localidades){
                System.out.println(l.getCoordenada_x() + ", " + l.getCoordenada_y());
            }

        }catch (IOException e){
            e.getMessage();
            e.printStackTrace();
        }
        finally{
                for (Localidades l : localidades){
                    System.out.print(l.getCoordenada_x() + ", " + l.getCoordenada_y() + ": ");
                    l.imprimirPilha();
                }
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
    //C:\Users\marco\Desktop\Escolar\Matérias\3°Semestre\AED II\Viagens.csv
    //C:\Users\marco\Desktop\Viagens.csv
}

                /*System.out.println("coordenada_x domicilio: " + viagens[2]);
                System.out.println("coordenada_y domicilio: " + viagens[3]);
                System.out.println();
                System.out.println("ID: " + viagens[43]);
                System.out.println("IDPRP: " + viagens[44]);
                System.out.println();
                System.out.println("coordenada_x escola: " + viagens[57]);
                System.out.println("coordenada_y escola: " + viagens[58]);
                System.out.println();
                System.out.println("coordenada_x 1° trabalho: " + viagens[62]);
                System.out.println("coordenada_y 1° trabalho: " + viagens[63]);                
                System.out.println();
                System.out.println("coordenada_x 2° trabalho: " + viagens[71]);
                System.out.println("coordenada_y 2° trabalho: " + viagens[72]);

                System.out.println();
                System.out.println("coordenada_x origem viagem: " + viagens[84]);
                System.out.println("coordenada_y origem viagem: " + viagens[85]);
                System.out.println();
                System.out.println("coordenada_x 2° destino viagem: " + viagens[88]);
                System.out.println("coordenada_y 2° destino viagem: " + viagens[89]);
                System.out.println();
                System.out.println("coordenada_x 1° transferência: " + viagens[92]);
                System.out.println("coordenada_y 1° transferência: " + viagens[93]);
                System.out.println();
                System.out.println("coordenada_x 2° transferência: " + viagens[96]);
                System.out.println("coordenada_y 2° transferência: " + viagens[97]);
                System.out.println();
                System.out.println("coordenada_x 3° transferência: " + viagens[100]);
                System.out.println("coordenada_y 3° transferência: " + viagens[101]);*/
