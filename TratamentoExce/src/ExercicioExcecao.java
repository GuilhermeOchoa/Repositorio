public class ExercicioExcecao {
    public static void main(String args[]) {
    ContaCorrente cc = null;
    cc = new ContaCorrente(1000);
    System.out.println("Saldo inicial: " +
    cc.getSaldo());
    cc.deposito(1000);
    cc.retirada(3000);
    System.out.println("Saldo final: " +
    cc.getSaldo());
    }
    }