import java.util.TreeSet;

public class Arvore {
    public static void main(String[] args) {
        arvore.add(15);

        for (Integer elemento : arvore) {
            System.out.println("Elemento" + elemento);
        }

        if (arvore.contains(10)) {
            Sysem.out.println("A árvore contém o elemento 10.");
            arvore.remove(10);
            Syste.out.println("Elemento 10 removido da árvore.")
        }
    }