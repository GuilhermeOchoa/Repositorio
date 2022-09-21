import java.util.Locale;
import java.util.Scanner;

public class AplicacaoConverteTemperatura {

    public void executa() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Conversor de temperaturas");
        System.out.println("Escalas: C-Celsius, K-Kelvin, F-Fahreiheit, R-Rankine");
        System.out.print("Indique a escala de origem: ");
        String origem = entrada.nextLine().toUpperCase();
        System.out.print("Indique a escala de destino: ");
        String destino = entrada.nextLine().toUpperCase();
        System.out.print("Indique a temperatura a converter (graus "+origem+"): ");
        double temperaturaOrigem = entrada.nextDouble();
        double temperaturaDestino;
        ConversorTemperatura conversor = null;
        switch(origem) {
            case "C":
                switch(destino) {
                    case "C":
                        break;
                    case "K":
                        conversor = new CelsiusKelvin();
                        break;
                    case "F":
                        //conversor = new CelsiusFahrenheit();
                        break;
                    case "":
                        //conversor = new CelsiusRankine();
                        break;
                    default:
                        System.out.println("Escala de destino invalida.");
                }
                break;
            case "K":
                switch(destino) {
                    case "C":
                        // conversor = new KelvinCelsius();
                        break;
                    case "K":
                        break;
                    case "F":
                        // conversor = new KelvinFahrenheit();
                        break;
                    case "R":
                        // conversor = new KelvinRankine();
                        break;
                    default:
                        System.out.println("Escala de destino invalida.");
                }
                break;
            case "F":
                switch(destino) {
                    case "C":
                        // conversor = new FahrenheitCelsius();
                        break;
                    case "K":
                        // conversor = new FahrenheitKelvin();
                        break;
                    case "F":
                        break;
                    case "R":
                        // conversor = new FahrenheitRankine();
                        break;
                    default:
                        System.out.println("Escala de destino invalida.");
                }
                break;
            case "R":
                switch(destino) {
                    case "C":
                        // conversor = new RankineCelsius();
                        break;
                    case "K":
                        // conversor = new RankineKelvin();
                        break;
                    case "F":
                        // conversor = new RankineFahrenheit();
                        break;
                    case "R":
                        break;
                    default:
                        System.out.println("Escala de destino invalida.");
                }
                break;
            default:
                System.out.println("Escala de origem invalida.");
        }
        if(origem.equals(destino))
            temperaturaDestino = temperaturaOrigem;
        else
            temperaturaDestino = conversor.converteTemperatura(temperaturaOrigem);
        System.out.println("Temperatura convertida: " + temperaturaDestino+" (graus " + destino+")");
    }

}

