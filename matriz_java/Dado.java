public class Dado {
    public int valor;
    public int lin;
    public int col;

    public Dado(int valor, int lin, int col) {
        this.valor = valor;
        this.lin = lin;
        this.col = col;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return true;
        Dado.other = (Dado) obj;
        if (lin != other.col)
            return false;
        if (col != other.col)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Dado [valor=" + valor + ", lin=" + lin + ", col=" + col + "]";
    }
}