package cantarino.deterministicfiniteautomaton;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        String caminho = "./inputFiles/automaton1.txt";
        
        DFA dfa = new DFA(caminho);
        
        while(true){
            System.out.println("Digite uma palavra a ser testada ou digite 'sair' para sair: ");
            String input = scanner.nextLine();
            if(input.equals("sair")) break;
            String resultado = dfa.testaPalavra(input)?"Aceita":"Rejeitada";
            System.out.println(resultado);
        }
        
        scanner.close();
        
    }
}
