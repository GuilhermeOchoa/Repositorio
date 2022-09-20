public class CelsiusKelvin implements ConversorTemperatura {
    @Override
    public double converteTemperatura(double temperatura) {
        return temperatura + 273.15;
    }
}
