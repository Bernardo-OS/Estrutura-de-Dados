namespace Examplo
{
    public class Aluno
    {
        public string Nome { get; set; }
        public string Email { get; set; }

        public Aluno(string nome)
        {
            Nome = nome;
            Email = GerarEmail(nome);
        }

        private string GerarEmail(string nome)
        {
            string[] dadosNome = nome.Split(' ');
            return dadosNome[0].ToLower() +"." + dadosNome[dadosNome.Length - 1].ToLower() + "@ufn.edu.br";
        }

        public override string ToString()
        {
            return $"Nome: {Nome}, Email: {Email}";
        }
    }
}