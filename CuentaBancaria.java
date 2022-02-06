package deparBank;

public class CuentaBancaria {

    private String iban, titular;
    private double saldo;
    // falta la variable de movimientos

    CuentaBancaria() {
        this.iban = "ES6621000418401234567891";
        this.saldo = 0.00;
    }

    // getter y setter

    public String getiban() {
        return iban;
    }

    public String gettitular() {
        return titular;
    }

    public double getsaldo() {
        return saldo;
    }

    public void setiban(String iban) {
        this.iban = iban;
    }

    public void settitular(String titular) {
        this.titular = titular;
    }

    public void setsaldo(Double saldo) {
        this.saldo = saldo;
    }

    public void mostrardatoscuenta() {

        System.out.println("\n*******[DeparBank]*******"
                + "\n\nIBAN: " + iban + "\nTitular: " + titular + "\nSaldo: " + saldo + "€"
                + "\n\n*******[DeparBank]*******");
    }

    public void mostrariban() {

        System.out.println("*******[DeparBank]*******");
        System.out.println("\nIBAN: " + iban);
        System.out.println("\n*******[DeparBank]*******");
    }

    public void mostrartitular(String titularcuenta){

        System.out.println("*******[DeparBank]*******");
        System.out.println("\nTitular de la cuenta: " + titularcuenta);
        System.out.println("\n*******[DeparBank]*******");
    }
}
