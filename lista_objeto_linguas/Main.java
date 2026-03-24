import java.util.ArrayList;
import java.util.List;

/**
 * Classe principal para executar o programa de geração de emails.
 */
public class Main {
    public static void main(String[] args) {
        List<Aluno> alunos = new ArrayList<>();

        alunos.add(new Aluno("João Silva", ""));
        alunos.add(new Aluno("Maria Oliveira", ""));

        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }
    }
}