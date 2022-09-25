public class ExercicioExcecao {
    public static void main(String args[]) {
		ContaCorrente cc = null;
		try {
			cc = new ContaCorrente(1000);
			System.out.println("Saldo inicial: " + cc.getSaldo());
			cc.deposito(2000);
			cc.retirada(3000);
			System.out.println("Saldo final: " + cc.getSaldo());
		} catch (Exception e) {
			System.out.println("Mensagem da excecao: " + e.getMessage());
			System.out.print("Rastreabilidade de erro: ");
			e.printStackTrace();
		}
	}
    }