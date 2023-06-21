public class App {
    public static void main(String[] args) throws Exception {
        Cuenta cuentaMatias = new Cuenta("Matias", 150, 1234);
        Cuenta cuentaAlex = new Cuenta("Alex", 5000, 4321);

        Cuenta[] cuentas = { cuentaMatias, cuentaAlex };

        Cajero cajero = new Cajero(cuentas, 1000);

        // Error Credenciales incorrectas
        System.out.println(cajero.extraerDinero("Matias", 100, 4321));

        // Error dinero insuficiente
        System.out.println(cajero.extraerDinero("Matias", 1000, 1234));

        // Error cajero sin dinero
        System.out.println(cajero.extraerDinero("Alex", 2000, 4321));

        // Exito
        System.out.println(cajero.extraerDinero("Matias", 100, 1234));
    }
}
