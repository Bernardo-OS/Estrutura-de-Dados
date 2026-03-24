/** 
 * Classe Aluno representa um aluno com nome e email. O email é gerado automaticamente com base no nome do aluno.
*/
public class Aluno{
    String nome;
    String email;

    /**
     * 
     * @param nome O nome do aluno, que será usado para gerar o email.
     * @param email O email do aluno, que é gerado automaticamente a partir do nome.
     */
    public Aluno(String nome, String email) {
        this.nome = nome;
        this.email = gerarEmail(nome);
    }

    public String getNome() {
        return nome;
    }
    
    /**
     * Função que gera o email do aluno com base no nome.
     * @param nome O nome do aluno.
     * @return O email gerado.
     */
    public String gerarEmail(String nome) {
        String[] dadosNome = nome.split(" ");
        this.email = dadosNome[0].toLowerCase() + "." + dadosNome[dadosNome.length - 1].toLowerCase() + "@ufn.edu.br";
        return email;
    }

    @Override
    public String toString() {
        return "Aluno [nome=" + nome + ", email=" + email + "]";
    }
}