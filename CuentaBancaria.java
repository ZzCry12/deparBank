package deparBank;

public class CuentaBancaria {

    private String iban, titular;
    private double saldo;
    private double[] movimiento;
    private int nMovimientos = 10;
    
    movimiento = new movimiento[nMovimientos];

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
        if(saldo<0){
            System.out.println("[AVISO] SALDO NEGATIVO");
        }
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


    public void ingreso(Double cantidad){
        
        if(cantidad > 3000.00){
            System.out.println("\n[AVISO] Se notificará a hacienda");
        }
        
        System.out.println("Ha ingresado " + cantidad + " Euros.");

        saldo = saldo+cantidad;
        //ingresar la cantidad en el vector
    }

    public void retirada(Double cantidad){
        
        if(cantidad > 3000.00){
            System.out.println("\n[AVISO] Se notificará a hacienda");
        }

        if(saldo>50){
            saldo = saldo-cantidad;
            System.out.println("Ha retirado " + cantidad + " Euros.");
        }else{
            System.out.println("[ERROR] INGRESE DINERO");
        }
        

    }

    public void movimientomas(Double cantidad){

        for(int i=0; i<movimiento.length; i++){
            if(movimiento[nMovimientos] == 0){
                movimiento[nMovimientos] = cantidad;
                nMovimientos++;
            }
        }
    }

    public void movimientos(){

        for(int i=0; i<movimiento.length; i++){
            System.out.println(movimiento[nMovimientos]);
        }
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

    public void mostrarsaldo(){

        System.out.println("*******[DeparBank]*******");
        System.out.println("\nSaldo de la cuenta: " + getsaldo());
        System.out.println("\n*******[DeparBank]*******");
    }

    public void retiradasaldo(){

        System.out.println("*******[DeparBank]*******");
        System.out.println("\nSaldo de la cuenta: " + getsaldo());
        System.out.println("\n*******[DeparBank]*******");
    }
}
