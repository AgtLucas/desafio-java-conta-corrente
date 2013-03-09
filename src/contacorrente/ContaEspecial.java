package contacorrente;

class ContaEspecial extends ContaCorrente {
    private int limiteCredito;
    
    public ContaEspecial(int nr, String nomeCliente, int limite) {
        super(nr, nomeCliente);
        this.limiteCredito = limite;
    }
    
    @Override
    public void sacar(double umValor) {
        if ( ( (super.saldo + this.limiteCredito) - umValor >= 0) && (umValor > 0) ) {
            super.saldo = super.saldo - umValor;
        }
    }
}
