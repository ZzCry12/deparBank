package deparBank;

import java.util.Scanner;

public class DeparBank {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        CuentaBancaria cuenta = new CuentaBancaria();

        System.out.println("*******[DeparBank]*******");
        System.out.println("Bienvenido a DeparBank (De Perduts al Riu Bank)"
                + "\n\nPara continuar introduce tu Nombre y Apellidos, porfavor.");

        String titularcuenta = sc.nextLine();

        System.out.println("*******[DeparBank]*******");

        cuenta.settitular(titularcuenta);

        if (cuenta.gettitular().equals(titularcuenta)) {
            do {
                System.out.println("\n1. Datos de la cuenta");
                System.out.println("2. IBAN");
                System.out.println("3. Titular");
                System.out.println("4. Saldo");
                System.out.println("5. Ingreso");
                System.out.println("6. Retirada");
                System.out.println("7. Movimientos");
                System.out.println("8. Salir");
                System.out.println("*******[DeparBank]*******");

                int menu = sc.nextInt();

                switch (menu) {

                    case 1:

                        System.out.println("Datos de la cuenta");
                        cuenta.mostrardatoscuenta();

                        break;
                    case 2:

                        System.out.println("IBAN");
                        cuenta.mostrariban();
                        break;

                    case 3:

                        System.out.println("Titular");
                        cuenta.mostrartitular(titularcuenta);
                        break;

                    case 4:

                        // construcción
                        break;
                    case 5:

                        // construcción
                        break;
                    case 6:

                        // construcción
                        break;
                    case 7:

                        // construcción
                        break;
                    case 8:

                        System.out.println("\n\n\n\n\n\n\n\n\n*******[DeparBank]*******");
                        System.out.println("\nProcesando salida....");
                        System.out.println("\n*******[DeparBank]*******");
                        exit = true;
                        break;
                    default:
                        System.out.println("\nIntroduce una opción porfavor.");
                        break;
                }
            } while (!exit);
        } else {
            System.out.println("ERROR CRÍTICO, EN 5 SEGUNDOS EXPLOTARÁ EL EQUIPO");
        }
    }
}
