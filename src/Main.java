public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();
        arvoreBinaria.inserir(10);
        arvoreBinaria.inserir(7);
        arvoreBinaria.inserir(35);
        arvoreBinaria.inserir(15);
        arvoreBinaria.inserir(26);
        System.out.println("Pré-ordem: ");
        arvoreBinaria.preOrdem(arvoreBinaria.getRaiz());
        System.out.println("Em ordem: ");
        arvoreBinaria.emOrdem(arvoreBinaria.getRaiz());
        System.out.println("Pós ordem: ");
        arvoreBinaria.posOrdem(arvoreBinaria.getRaiz());
        arvoreBinaria.remover(10);

        System.out.println("");
        System.out.println("Pré-ordem pós remoção: ");
        arvoreBinaria.preOrdem(arvoreBinaria.getRaiz());

    }
}