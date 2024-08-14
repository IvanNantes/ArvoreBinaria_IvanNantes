public class ArvoreBinaria {
    private No raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public void inserir(int valor) {
        No novoNo = new No(valor);
        if(this.raiz == null) {
            this.raiz = novoNo;
        } else {
            No atual = this.raiz;
            No pai = null;
            boolean esquerda = false;
            while(atual != null) {
                if(novoNo.getValor() < atual.getValor()) {
                    pai = atual;
                    atual = atual.getEsq();
                    esquerda = true;
                } else {
                    pai = atual;
                    atual = atual.getDir();
                    esquerda = false;
                }
            }
            if(esquerda) {
                pai.setEsq(novoNo);
            } else {
                pai.setDir(novoNo);
            }
        }
    }

    public No getRaiz() {
        return this.raiz;
    }

    public void preOrdem(No no) {
        if(no == null) {
            return;
        }
        System.out.println(no.getValor());
        preOrdem(no.getEsq());
        preOrdem(no.getDir());
    }

    public void emOrdem(No no) {
        if(no == null) {
            return;
        }
        emOrdem(no.getEsq());
        System.out.println(no.getValor());
        emOrdem(no.getDir());
    }

    public void posOrdem(No no) {
        if(no == null) {
            return;
        }
        posOrdem(no.getEsq());
        posOrdem(no.getDir());
        System.out.println(no.getValor());
    }

    public void remover(int valorRemover) {
        No atual = this.raiz;
        No pai = null;
        boolean esquerda = false;
        while(atual != null && atual.getValor() != valorRemover) {
            if (valorRemover < atual.getValor()) {
                pai = atual;
                atual = atual.getEsq();
                esquerda = true;
            } else if (valorRemover > atual.getValor()) {
                pai = atual;
                atual = atual.getDir();
                esquerda = false;
            }
        }
            if(atual == null) {
                System.out.println("Valor não encontrado.");
                return;
            } else {
                System.out.println("O valor "+ valorRemover +" foi removido com sucesso.");
            }
            if(atual.getDir() == null && atual.getEsq() == null) { //Folha
                if (pai == null) {
                    raiz = null;
                    return;
                }
                if (!esquerda) {
                    pai.setDir(null);
                } else {
                    pai.setEsq(null);
                }
            } else if(atual.getDir() != null && atual.getEsq() == null){ //Filho direita
                if (pai == null) {
                    this.raiz = this.raiz.getDir();
                } else {
                    if (!esquerda){
                        pai.setDir(atual.getDir());
                    } else {
                        pai.setEsq(atual.getDir());
                    }
                }
            } else if(atual.getDir() == null && atual.getEsq() != null){ //Filho esquerda
                if (pai == null) {
                    this.raiz = this.raiz.getEsq();
                } else {
                    if (!esquerda){
                        pai.setDir(atual.getEsq());
                    } else {
                        pai.setEsq(atual.getEsq());
                    }
                }
            } else {  // 2 filhos
                No reserva = atual;
                No paiReserva = pai;
                No direita = atual.getDir(); // caso tenha mais de 2 nós a esquerda
                boolean esquerdaReserva = false;
                boolean eRaiz = false;
                paiReserva = reserva;
                reserva = atual.getDir();
                while(reserva.getEsq() != null){ //Caso tenha um numero menor a esquerda.
                    paiReserva = reserva;
                    reserva = reserva.getEsq();
                    esquerdaReserva = true;
                }

                if (!esquerdaReserva){
                    if (pai == null) {
                        eRaiz = true;
                    } else if (!esquerda) {
                            pai.setDir(reserva);
                        } else {
                            pai.setEsq(reserva);
                        }
                    reserva.setEsq(atual.getEsq());
                    if (eRaiz){
                        this.raiz = reserva;
                    }
                } else {
                    if (pai == null){
                        eRaiz = true;
                    } else if (!esquerda) {
                        pai.setDir(reserva);
                    } else {
                        pai.setEsq(reserva);
                    }
                    reserva.setEsq(atual.getEsq());
                    if (reserva.getDir() != null){ //caso o numero substituindo tenha nó a direita
                        paiReserva.setEsq(reserva.getDir());
                    } else {
                        paiReserva.setEsq(null);
                    }
                    reserva.setDir(direita);
                    if (eRaiz){
                        this.raiz = reserva;
                    }

                }
            }
    }
}