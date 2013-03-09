package contacorrente;

public class ContaCorrente {

    private int nr;
    private String nomeCliente;
    protected double saldo;
    
    public ContaCorrente(int nr, String nomeCliente) {
        this.nr = nr;
        this.nomeCliente = nomeCliente;
        this.saldo = 0;
    }
    
    public void sacar(double umValor) {
        if ( (this.saldo - umValor >= 0) && (umValor > 0) ) {
            this.saldo = this.saldo - umValor;
        }
    }
    
    public void depositar(double umValor) {
        if (umValor > 0) {
            this.saldo = this.saldo + umValor;
        }
    }
    
    public double pegarSaldo() {
        return this.saldo;
    }
    
    public void transferir(ContaCorrente obj, double valor) {
        this.sacar(valor);
        obj.depositar(valor);
    }
    
    public static void main(String[] args) {
        ContaCorrente c1 = new ContaCorrente(123, "Alguém");
        ContaCorrente c2 = new ContaCorrente(321, "OutroAlguém");
        ContaEspecial c3 = new ContaEspecial(000, "Ninguém", 1000);
        
        c1.depositar(120.0);
        c2.transferir(c1, 200.0);
        c3.depositar(2000);
        c3.sacar(500);
        
        System.out.println("Saldo: " + c1.pegarSaldo());
        System.out.println("Saldo: " + c3.pegarSaldo());
    }
}
