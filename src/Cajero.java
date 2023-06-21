public class Cajero {
    private double cantidad;
    private Cuenta[] cuentas;

    public Cajero(Cuenta[] cuentas, double cantidad) {
        this.cantidad = cantidad;
        this.cuentas = cuentas;
    }

    public void obtenerInformacion(String nombre, int PIN){
        Cuenta cuenta = this.getCuenta(nombre);

        if(cuenta == null || cuenta.getPIN() != PIN){
            System.err.println("El nombre de la cuenta o el PIN está incorrecto");
            return;
        }

        System.out.println(cuenta);
    }

    public double extraerDinero(String nombre, double monto, int PIN) {
        Cuenta cuenta = this.getCuenta(nombre);

        if(cuenta == null || cuenta.getPIN() != PIN){
            System.err.println("El nombre de la cuenta o el PIN está incorrecto");
            return 0;
        }

        if (!cuenta.verificarSaldoPrevioRetiro(monto)) {
            return 0;
        }

        if (monto > this.cantidad) {
            System.err.println("El cajero no tiene suficiente dinero");
            return 0;
        }
        
        System.out.println("Informacion Inicial de la Cuenta\n");
        System.out.println(cuenta);
        System.out.println("\nBalance Inicial del cajero: " + this.getCantidad());

        this.cantidad -= monto;
        double nuevoBalanceCuenta = cuenta.getSaldo() - monto;

        cuenta.setSaldo(nuevoBalanceCuenta);
        
        System.out.println("Monto extraido: " + monto);
        System.out.println("Informacion Final de la Cuenta\n");
        System.out.println(cuenta);
        System.out.println("\nBalance Final del cajero: " + this.getCantidad());

        return this.cantidad;
    }

    private Cuenta getCuenta(String nombre){
        for (Cuenta cuenta : this.cuentas) {
            if (cuenta.getNombre().equals(nombre)) {
                return cuenta;
            }
        }

        return null;
    }

    private double getCantidad(){
        return this.cantidad;
    }
}
