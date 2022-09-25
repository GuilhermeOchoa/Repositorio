
public class ContaCorrente {

    private double saldo;   

    public ContaCorrente(double saldoInicial) throws InvalidBalanceException{
    	if(saldoInicial < 0)
    		throw new InvalidBalanceException("Saldo inicial negativo!");
    	else
    		saldo = saldoInicial;
    }

    public void deposito(double valor) throws InvalidBalanceException{
    	if(saldo + valor < 0)
    		throw new InvalidBalanceException("Deposito negativo!");
    	else
    		saldo += valor;

    }

    public void retirada(double valor) throws InvalidBalanceException{
    	if(valor > saldo)
    		throw new InvalidBalanceException("Saque elevado!");
    	else
    		saldo -= valor;

    }

    public double getSaldo(){ return(saldo);   }

}