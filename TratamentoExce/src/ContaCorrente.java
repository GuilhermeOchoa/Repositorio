public class ContaCorrente {
    private double saldo;
    public ContaCorrente(double saldoInicial) {
    this.saldo = saldoInicial;
    }
    public void deposito(double valor) {
    saldo += valor;
    }
    public void retirada(double valor) {
    saldo -= valor;
}
public double getSaldo(){
return saldo;
}
}