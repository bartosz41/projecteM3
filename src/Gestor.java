import java.util.Scanner;

public class Gestor {
    public static void main(String[] args) {

        String[] nomEquips = new String[4];
        String[] nomJugadors = new String[3];

        Scanner sc = new Scanner(System.in);
        String equip;
        int contador = 0;
        int opcio;
        String nomEquipaEditar;
        int opcioEditar;
        boolean bucle = true;

        System.out.println("#######################");
        System.out.println("Equips de la temporada.");
        System.out.println("#######################");
        System.out.println();
        System.out.println("Encara no hi han equips inscrits.");
        System.out.println();
        System.out.println("Que vols fer? ");

        while (bucle) {
            System.out.println();
            System.out.println("0 - Sortir del programa.");
            System.out.println("1 - Entrar un equip.");
            System.out.println("2 - Editar un equip.");
            System.out.println("3 - Veure rànking.");
            System.out.println("4 - Esborrar un equip.");
            System.out.println("5 - Llistar tots els equips.");

            opcio = sc.nextInt();
            sc.nextLine();

            switch (opcio) {

                case 0:
                    bucle = false;
                    break;
                case 1:
                    while (true) {
                        System.out.println("Introdueix un equip (SIGLES) (0 per finalitzar.): ");
                        equip = sc.nextLine();
                        if (equip.length() == 3 && equip.equals(equip.toUpperCase())) {
                            nomEquips[contador] = equip;
                            contador++;
                        } else {
                            System.out.println();
                            System.out.println("Nom invàlid.");
                        }

                        if (contador == 4) {
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Entra el nom del equip a editar: ");
                    nomEquipaEditar = sc.next();
                    for (int i = 0; i < nomEquips.length; i++) {
                        if (nomEquipaEditar.equalsIgnoreCase(nomEquips[i])) {
                            System.out.println("Equip a editar: " + nomEquips[i]);
                            System.out.println("Que vols modificar? ");
                            System.out.println("0 - Sortir.");
                            System.out.println("1 - Nom del equip.");
                            System.out.println("2 - Introduir un jugador.");
                            opcioEditar = sc.nextInt();
                            sc.nextLine();
                            if (opcioEditar == 0) {
                                break;
                            } else if (opcioEditar == 1) {
                                System.out.println("Introdueix el nou nom de l'equip: ");
                                String nouNomEq = sc.nextLine();
                                if (nouNomEq.length() == 3 && nouNomEq.equals(nouNomEq.toUpperCase())) {
                                    nomEquips[i] = nouNomEq;
                                    System.out.println("El nou nom de l'equip és: " + nomEquips[i]);
                                }
                            } else if (opcioEditar == 2) {
                                for (int y = 0; y < nomJugadors.length; y++) {
                                    System.out.println("Introdueix el jugador " + (y + 1) + ": ");
                                    String jugador = sc.nextLine();
                                    nomJugadors[y] = jugador;
                                }
                            }
                        }
                    }
                    break;
                case 3:
                case 4:
                case 5:
                    for (int i = 0; i < nomEquips.length; i++) {
                        System.out.println((i + 1) + " - " + (nomEquips[i]));
                    }
            }
        }
    }
}
