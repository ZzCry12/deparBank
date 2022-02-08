package deparBank;

public class CuentaBancaria {

    private String iban, titular;
    private double saldo;
    private double[] movimiento = new double[100];
    /*
     * Control de movimientos
     * cuando sea igual a 10 no permitirá más
     * y evitará usar bucles para cada nuevo movimiento
     */
    private int countIndex = 0;

    /*
     * Establecerá el límite de movimientos
     * 10, según lo expuesto en la pregunta
     */
    private int dailyLimit = 100;

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
        if (saldo < 0) {
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

    public void ingreso(Double cantidad) {
        /*
         * Verificamos dos cosas:
         * 1. Si cantidad es legal (no excede 3,000)
         * 2. Si todavía le quedan transacciones
         * Usaremos métodos dedicados, porque se necesitarán
         * también para retirar
         * Si la condición no se cumple, no cuenta como una
         * transacción, por eso no se aumenta a countIndex
         * si debe ser de otro modo, debes decidirlo tú
         */
        if (cantidadlegal(cantidad)) {
            movimiento[countIndex] = cantidad;
            saldo = (saldo + cantidad);
            countIndex++;
            mensajeconfirmacion(1, cantidad);
        }
    }

    /*
     * Antes de retirar verificaremos dos cosas:
     * 1. Si no ha excedido la cuota de movimientos
     * 2. Si tiene fondos... Cada uno con su método
     * Es importante centralizar ciertas operaciones en métodos
     * primero, porque los puedes necesitar en otras partes
     * segundo, porque el código queda más limpo
     * Si la condición no se cumple, no cuenta como una
     * transacción, por eso no se aumenta a countIndex
     * si debe ser de otro modo, debes decidirlo tú
     */

    public void retirada(Double cantidad) {
        if (cantidadlegal(cantidad) && tienedinero(cantidad)) {
            movimiento[countIndex] = cantidad;
            saldo = (saldo - cantidad);
            countIndex++;
            mensajeconfirmacion(2, cantidad);
        }
    }

    public void movimientos() {
        System.out.println("\n\nMOVIMIENTOS:\n");

        for (int i = 0; i < movimiento.length; i++) {
            if(movimiento[i]!=0.00){
                System.out.println(movimiento[i]);
            }
        }
    }

    /*
     * Este método sirve para verificar si no ha excedido
     * la cuota de movimientos.
     * Se usará desde ingreso() y desde retiro()
     * Si no tiene cuota lo advertirá en un mensaje
     */
    private boolean tienedinero() {
        boolean tienedinero = (countIndex != dailyLimit) ? true : false;
        if (!tienedinero) {
            limitemovimientos();
        }
        return tienedinero;
    }

    /*
     * Este método determinará si la operación
     * de ingreso/retiro es legal.
     * Es decir, si no excede la cantidad de 3000
     * Si es ilegal, imprimirá un mensaje advirtiéndolo.
     * Si es legal, verificará también si tiene cuota
     * para hacer transacciones.
     * La verificación de la cuota se ha centralizado aquí
     * y aunque no tenga cuota, se advertirá sobre hacienda
     * Si no debe advertirse, puedes invertir los if
     * verificando primero si tiene cuota
     */
    private boolean cantidadlegal(Double cantidad) {
        boolean cantidadlegal = true;
        if (cantidad > 3000.00) {
            cantidadlegal = false;
            mensajehacienda();
        } else {
            return tienedinero();
        }
        return cantidadlegal;
    }

    /*
     * Este método verifica si tiene fondos
     * 1. Según tu código original, si el saldo
     * es menor de 50, no se le permite retirar
     * 2. Se debe verificar además si la cantidad solicitada
     * no es mayor a la cantidad disponible
     */

    private boolean tienedinero(Double cantidad) {
        boolean tienedinero = false;
        if (saldo > 50 && saldo > cantidad) {
            tienedinero = true;
        } else {
            mensajeError(cantidad);
        }
        return tienedinero;
    }

    /*
     * Estos son métodos informativos ...
     * que puedes usar desde ingreso() o retiro()
     * o desde las verificaciones, según el caso
     */
    private void limitemovimientos() {
        System.out.printf("\n[AVISO] *Has agotado los movimientos por hoy. %d movimientos hechos", dailyLimit);
    }

    private void mensajehacienda() {
        System.out.println("\n[AVISO] *Se notificará a hacienda.");
    }

    private void mensajeconfirmacion(int type, Double cantidad) {
        String typeDescription = (type == 1) ? "ingreso" : "retiro";
        System.out.printf("\n[AVISO] %d.\tHa ocurrido un %s de %s\tSaldo: %.2f", countIndex, typeDescription, cantidad,
                this.saldo);
    }

    private void mensajeError(Double cantidad) {
        System.out.printf("\n[AVISO] *No puedes retirar %.2f\tSaldo: %.2f", cantidad, this.saldo);
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

    public void mostrartitular(String titularcuenta) {

        System.out.println("*******[DeparBank]*******");
        System.out.println("\nTitular de la cuenta: " + titularcuenta);
        System.out.println("\n*******[DeparBank]*******");
    }

    public void mostrarsaldo() {

        System.out.println("*******[DeparBank]*******");
        System.out.println("\nSaldo de la cuenta: " + getsaldo());
        System.out.println("\n*******[DeparBank]*******");
    }

    public void retiradasaldo() {

        System.out.println("*******[DeparBank]*******");
        System.out.println("\nSaldo de la cuenta: " + getsaldo());
        System.out.println("\n*******[DeparBank]*******");
    }
}
