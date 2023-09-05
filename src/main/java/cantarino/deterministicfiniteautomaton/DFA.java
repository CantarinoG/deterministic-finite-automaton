package cantarino.deterministicfiniteautomaton;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class DFA {
    
    private char[] letras;
    private int[] estadosFinais;
    private int[][] matriz;
    
    public DFA(String caminho){
        
        leArquivo(caminho);
        
    }
    
    private void leArquivo(String caminho) {
        
        try {
            FileReader fileReader = new FileReader(caminho);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linha;
            String[] valores;
            
            linha = bufferedReader.readLine();
            valores = linha.split(";");
            this.letras = new char[valores.length - 1];
            for (int i = 1; i < valores.length; i++) {
                    this.letras[i - 1] = valores[i].charAt(0);
                }
            
            linha = bufferedReader.readLine();
            valores = linha.split(";");
            this.estadosFinais = new int[valores.length - 1];
            for (int i = 1; i < valores.length; i++) {
                    this.estadosFinais[i - 1] = Integer.parseInt(valores[i]);
                }
            
            linha = bufferedReader.readLine();
            valores = linha.split(";");
            int numLinhas = Integer.parseInt(valores[1]);
            int numColunas = Integer.parseInt(valores[2]);
            this.matriz = new int[numLinhas][numColunas];
            
            for(int i = 0; i < numLinhas; i++){
                if ((linha = bufferedReader.readLine()) != null) {
                    
                    valores = linha.split(";");
                    
                    for(int j = 0; j < valores.length; j++) {
                        this.matriz[i][j] = Integer.parseInt(valores[j]);
                    }
                    
                }
            }
            
            bufferedReader.close();
            fileReader.close();

        } catch (IOException e) {

            System.out.println("Seu arquivo não foi encontrado ou algo errado ocorreu: ");
            e.printStackTrace();
            System.exit(-1);

        }
        
    }
    
    public boolean testaPalavra(String palavra) {
        
        int estadoAtual = 0;
        
        for(int i = 0; i < palavra.length(); i++){
            
            int letraAtual = Arrays.binarySearch(this.letras, palavra.charAt(i));
            if(matriz[estadoAtual][letraAtual] == -1) return false;
            estadoAtual = matriz[estadoAtual][letraAtual];
            
            if(i == palavra.length() - 1 && Arrays.binarySearch(this.estadosFinais, estadoAtual) >= 0) return true;       
            
        }
        
        return false;
    }
    
    /*public void imprimirValores() {
        System.out.println("Valores dos Atributos:");
        System.out.println("Letras: " + Arrays.toString(letras));
        System.out.println("Estados Finais: " + Arrays.toString(estadosFinais));
        System.out.println("Número de Linhas: " + numLinhas);
        System.out.println("Número de Colunas: " + numColunas);

        System.out.println("Matriz:");
        for (int i = 0; i < numLinhas; i++) {
            for (int j = 0; j < numColunas; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }*/
    
}
