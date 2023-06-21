public class Cuenta {
    private String nombre;
    private double saldo;
    private int PIN;

    public Cuenta(String nombre, double saldo, int PIN) {
        this.nombre = nombre;
        this.saldo = saldo;
        this.PIN = PIN;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double monto) {
        this.saldo = monto;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPIN() {
        return this.PIN;
    }
    
    public void setPIN(int PIN) {
        this.PIN = PIN;
    }

    @Override
    public String toString() {
        return "Cuenta [nombre=" + nombre + ", saldo=" + saldo + ", PIN=" + PIN + "]";
    }

    

}
