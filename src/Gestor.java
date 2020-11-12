import java.util.Arrays;
import java.util.Scanner;

public class Gestor {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] nomEquips = new String[4];
        String[] jugadorsEquip = new String[12];
        int[] puntsEquips = new int[4];
        String equip;
        int contador = 0;
        int opcio;
        String nomEquipaEditar;
        int opcioEditar;
        boolean bucle = true;
        int contadorJugadors = 0;

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
            System.out.println("1 - Entrar un equip / Entrar un jugador.");
            System.out.println("2 - Editar un equip.");
            System.out.println("3 - Esborrar un equip.");
            System.out.println("4 - Veure rànking (Ordenat aflabèticament).");
            System.out.println("5 - Llistar tots els equips (Ordenat aflabèticament).");
            System.out.println("6 - Llistar jugadors registrats (Abans heu de registrar algun jugador).");
            System.out.println("7 - COMENÇAR TEMPORADA!");

            opcio = sc.nextInt();
            sc.nextLine();

            switch (opcio) {

                case 0:
                    bucle = false;
                    break;
                case 1:
                    System.out.println("Que voleu entrar?");
                    System.out.println("0 - Sortir");
                    System.out.println("1 - Equip");
                    System.out.println("2 - Jugador");
                    opcio = sc.nextInt();
                    sc.nextLine();
                    if (opcio == 0) {
                        break;
                    } else if (opcio == 1) {
                        while (true) {
                            System.out.println("Introdueix un equip (SIGLES) (0 per finalitzar.): ");
                            equip = sc.nextLine();
                            if (equip.equals("0")) {
                                break;
                            }
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
                    } else if (opcio == 2) {
                        for (int i = 0; i < jugadorsEquip.length; i++) {
                            System.out.println("Entra el nom del jugador (Només nom | 0 per sortir): ");
                            String resposta = sc.nextLine();
                            if (resposta.equals("0")) {
                                break;
                            } else {
                                jugadorsEquip[i] = resposta;
                                System.out.println("Jugador introduït correctament.");
                                contadorJugadors++;
                            }
                        }
                    }
                    break;
                case 2:
                    System.out.println("Entra el nom del equip a editar: ");
                    nomEquipaEditar = sc.next();
                    while (true) {
                        int i = 0;
                        if (nomEquipaEditar.equalsIgnoreCase(nomEquips[i])) {
                            System.out.println("Equip a editar: " + nomEquips[i]);
                            System.out.println("Que vols modificar? ");
                            System.out.println("0 - Sortir.");
                            System.out.println("1 - Nom del equip.");
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
                                    break;
                                }
                            } else {
                                System.out.println("Error, torna a provar-ho.");
                                continue;
                            }
                        } else {
                            System.out.println("Equip no trobat.");
                            break;
                        }
                        i++;
                    }
                    break;
                case 3:
                    System.out.println("Introdueix el nom de l'equip a esborrar: ");
                    String equipAEsborrar = sc.nextLine();
                    boolean trobat=false;
                    for (int i = 0; i < nomEquips.length; i++) {
                        if (nomEquips[i].equals(equipAEsborrar)) {
                            trobat = true;
                            System.out.println("Estàs segur de voler esborrar " + equipAEsborrar + " ? S/N");
                            String resposta = sc.nextLine();
                            if (resposta.equals("S")) {
                                nomEquips[i] = null;
                                System.out.println("L'equip s'ha esborrat correctament. ");
                            } else if (resposta.equals("N")) {
                                System.out.println("L'equip NO s'ha esborrat.");
                                break;
                            } else {
                                System.out.println("Resposta no vàlida.");
                                continue;
                            }
                        }
                        if (i==nomEquips.length-1 && !trobat){
                                System.out.println("Equip no trobat. ");
                        }
                    }
                    break;
                case 4:
                    System.out.println("#######");
                    System.out.println("RÀNKING");
                    System.out.println("#######");
                    System.out.println();
                    for (int i = 0; i < contador; i++) {
                        if (nomEquips[i] != null) {
                            Arrays.sort(nomEquips);
                            System.out.println((i + 1) + " - " + nomEquips[i] + " punts: " + puntsEquips[i]);
                        }
                    }
                    break;
                case 5:
                    System.out.println("Total de equips: "+contador);
                    int index = 0;
                    System.out.println("##################");
                    System.out.println("Equips registrats.");
                    System.out.println("##################");
                    System.out.println();
                    if (contador == 0) {
                        System.out.println("No hi ha cap equip registrat.");
                    } else {
                        for (int i = 0; i < nomEquips.length; i++) {
                            if (nomEquips[i] != null) {
                                System.out.println((index + 1) + " - " + (nomEquips[i]));
                                index++;
                            }
                        }
                    }
                    break;
                case 6:
                    System.out.println("Total jugadors: "+contadorJugadors);
                    for (int i = 0; i < jugadorsEquip.length; i++) {
                        if (jugadorsEquip[i] != null) {
                            System.out.println((i + 1) + " - " + jugadorsEquip[i]);
                        }
                    }
                    break;
                case 7:
                    for (int i = 0; i < nomEquips.length; i++) {
                        System.out.println("Introdueix els punts de l'equip " + nomEquips[i] + " : ");
                        puntsEquips[i] = sc.nextInt();
                        sc.nextLine();
                    }
                    break;
            }
        }
    }
}



