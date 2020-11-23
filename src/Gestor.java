import javax.swing.*;
import java.util.Arrays;
import java.util.Scanner;

public class Gestor {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] nomEquips = new String[4];
        String[] jugadorsEquip = new String[12];
        int[] puntsEquips = new int[4];
        int[] victoriesEq = new int[nomEquips.length];
        int[] derrotesEq = new int[nomEquips.length];
        int[] rendimentJugadors = new int[jugadorsEquip.length];
        String equip;
        int contador = 0;
        String nomEquipaEditar;
        int opcioEditar;
        boolean bucle = true;
        int contadorJugadors = 0;
        int contadorDerrotes = 0;
        int contadorRendiment = 0;

        System.out.println("#######################");
        System.out.println("Equips de la temporada.");
        System.out.println("#######################");
        System.out.println();
        System.out.println("Encara no hi han equips inscrits.");
        System.out.println();
        System.out.println("Que vols fer? ");
        System.out.println();
        System.out.println("Nota, les opcions amb (TEMPORADA) signifiquen que has de començar la temporada abans de poder-les fer servir ;)");
        System.out.println();

        while (bucle) {
            System.out.println();
            System.out.println("0 - Sortir del programa.");
            System.out.println("1 - Entrar un equip / Entrar un jugador.");
            System.out.println("2 - Editar un equip / Editar un jugador.");
            System.out.println("3 - Esborrar un equip.");
            System.out.println("4 - Veure Rànking (TEMPORADA)");
            System.out.println("5 - Llistar tots els equips (Ordenat aflabèticament).");
            System.out.println("6 - Llistar jugadors registrats (Abans heu de registrar algun jugador).");
            System.out.println("7 - COMENÇAR TEMPORADA!");
            System.out.println("8 - Veure V/D (TEMPORADA)");
            System.out.println("9 - Introduir rendiment d'un jugador (TEMPORADA).");
            System.out.println("10 - Veure rendiment de tots els jugadors (TEMPORADA).");

            String opcio = sc.nextLine();

            if (!(opcio.equals("0") || opcio.equals("1") || opcio.equals("2") || opcio.equals("3") || opcio.equals("4") || opcio.equals("5") || opcio.equals("6") || opcio.equals("7") || opcio.equals("8") || opcio.equals("9") || opcio.equals("10"))) {
                System.out.println("Opció invàlida.");
                continue;

            } else {
                boolean temporada = false;

                switch (opcio) {

                    case "0":
                        bucle = false;
                        break;
                    case "1":
                        System.out.println("Que voleu entrar?");
                        System.out.println("0 - Sortir");
                        System.out.println("1 - Equip");
                        System.out.println("2 - Jugador");
                        String opcio1 = sc.nextLine();

                        if (!(opcio1.equalsIgnoreCase("0") || opcio1.equalsIgnoreCase("1") || opcio1.equalsIgnoreCase("2"))) {
                            System.out.println("Opció invàlida.");
                            break;
                        } else {

                            if (opcio1.equalsIgnoreCase("0")) {
                                break;
                            } else if (opcio1.equalsIgnoreCase("1")) {
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
                            } else if (opcio1.equalsIgnoreCase("2")) {
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
                        }
                        break;
                    case "2":
                        System.out.println("Entra el nom del equip a editar: ");
                        nomEquipaEditar = sc.nextLine();

                        while (true) {
                            int i = 0;
                            if (nomEquipaEditar.equalsIgnoreCase(nomEquips[i])) {
                                System.out.println("Equip a editar: " + nomEquips[i]);
                                System.out.println("Que vols modificar? ");
                                System.out.println("0 - Sortir.");
                                System.out.println("1 - Nom del equip.");
                                System.out.println("2 - Nom del jugador.");
                                opcioEditar = sc.nextInt();
                                sc.nextLine();
                                if (opcioEditar == 0) {
                                    break;
                                } else if (opcioEditar == 1) {
                                    System.out.println("Introdueix el nou nom de l'equip: ");
                                    String nouNomEq = sc.nextLine();
                                    if (nouNomEq.length() == 3 && nouNomEq.equals(nouNomEq.toUpperCase())) {
                                        nomEquips[i] = nouNomEq;
                                        Arrays.sort(nomEquips);
                                        System.out.println("El nou nom de l'equip és: " + nomEquips[i]);
                                        break;
                                    } else if (opcioEditar == 2) {
                                        System.out.println("Introdueix el nom del jugador: ");
                                        String nouNomJg = sc.nextLine();
                                        for (int y = 0; y < contadorJugadors; y++) {
                                            if (nouNomJg.equalsIgnoreCase(jugadorsEquip[i])) {
                                                jugadorsEquip[i] = nouNomJg;
                                                System.out.println("El nou nom del jugador és: " + jugadorsEquip[i]);
                                                break;
                                            }
                                        }
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
                    case "3":
                        System.out.println("Introdueix el nom de l'equip a esborrar: ");
                        String equipAEsborrar = sc.nextLine();
                        if (equipAEsborrar.length() == 3) {
                            boolean trobat = false;
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
                                if (i == nomEquips.length - 1 && !trobat) {
                                    System.out.println("Equip no trobat. ");
                                }
                            }
                        } else {
                            System.out.println("El nom de l'equip és invàlid, assegurat de que és el mateix nom.");
                            break;
                        }
                        break;
                    case "4":
                        if (temporada = true) {
                            System.out.println("RANKING NO DISPONIBLE");
                        } else {
                            System.out.println("Primer has de començar la temporada.");
                            break;
                        }
                        break;
                    case "5":
                        if (contador > 0) {
                            System.out.println("Total de equips: " + contador);
                            int index = 0;
                            System.out.println("##################");
                            System.out.println("Equips registrats.");
                            System.out.println("##################");
                            System.out.println();
                            Arrays.sort(nomEquips);
                            for (int i = 0; i < nomEquips.length; i++) {
                                if (nomEquips[i] != null) {
                                    System.out.println((index + 1) + " - " + (nomEquips[i] + ". Victòries: " + victoriesEq[i]));
                                    index++;
                                }
                            }
                        } else {
                            System.out.println("No hi ha cap equip registrat.");
                            break;
                        }
                        break;
                    case "6":
                        if (!(contadorJugadors < 0)) {
                            System.out.println("Total jugadors: " + contadorJugadors);
                            for (int i = 0; i < jugadorsEquip.length; i++) {
                                if (jugadorsEquip[i] != null) {
                                    System.out.println((i + 1) + " - " + jugadorsEquip[i]);
                                }
                            }
                        } else {
                            System.out.println("No has introduit cap jugador. Siusplau, introdueix un.");
                            break;
                        }
                        break;
                    case "7":
                        if (contador == 4) {
                            temporada = true;
                            boolean bucle1 = true;
                            while (bucle1) {
                                int vicIntroduides = 0;
                                for (int i = 0; i < contador; i++) {
                                    int resposta = -1;
                                    while (!(resposta >= 0 && resposta <= 3)) {
                                        System.out.println("Introdueix les victòries de l'equip " + nomEquips[i] + " (Com a màxim 3) :");
                                        resposta = sc.nextInt();
                                        if (!(resposta >= 0 && resposta <= 3)) {
                                            System.out.println("Número invàlid");
                                            continue;
                                        } else {
                                            victoriesEq[i] = resposta;
                                            vicIntroduides++;
                                        }
                                        if (vicIntroduides == 4) {
                                            System.out.println("Victòries introduides correctament.");
                                            bucle1 = false;
                                        }
                                    }
                                }
                            }
                            for (int i = 0; i < contador; i++) {
                                System.out.println("Victòries de l'equip " + nomEquips[i] + " : " + victoriesEq[i]);
                            }

                            while (true) {
                                int derIntroduides = 0;

                                for (int i = 0; i < nomEquips.length; i++) {

                                    if (victoriesEq[i] == 3) {
                                        derrotesEq[i] = 0;
                                        derIntroduides++;
                                    } else if (victoriesEq[i] == 2) {
                                        derrotesEq[i] = 1;
                                        derIntroduides++;
                                    } else if (victoriesEq[i] == 1) {
                                        derrotesEq[i] = 2;
                                        derIntroduides++;
                                    } else if (victoriesEq[i] == 0) {
                                        derrotesEq[i] = 3;
                                        derIntroduides++;
                                    }

                                }
                                if (derIntroduides == 4) {
                                    contadorDerrotes++;
                                    break;
                                }
                                System.out.println("Les derrotes s'han introduit automàticament.");
                            }
                            for (int i = 0; i < nomEquips.length; i++) {
                                System.out.println(nomEquips[i] + " - " + " Victóries: " + victoriesEq[i] + " Derrotes: " + derrotesEq[i]);
                            }

                        } else {
                            System.out.println("No hi han suficients equips per començar la temporada. (Actualment hi han " + contador + " equips registrats, han de ser 4.)");
                            break;
                        }
                        break;
                    case "8":
                        if (temporada = true) {
                            if (contadorDerrotes == 1) {
                                System.out.println("#### EQUIPS ####");
                                for (int i = 0; i < nomEquips.length; i++) {
                                    System.out.println(nomEquips[i] + " - " + " Victóries: " + victoriesEq[i] + " Derrotes: " + derrotesEq[i]);
                                }
                            } else {
                                System.out.println("Primer has de començar la temporada.");
                                break;
                            }
                        } else {
                            System.out.println("Primer has de començar la temporada.");
                            break;
                        }
                        break;
                    case "9":
                        if (temporada = true) {
                            if (contadorJugadors > 0) {
                                for (int i = 0; i < contadorJugadors; i++) {
                                    System.out.println("Introdueix el rendiment del jugador " + jugadorsEquip[i] + " (De 1 a 100): ");
                                    int resposta = sc.nextInt();
                                    while (true) {
                                        if (resposta > 100 || resposta < 1) {
                                            System.out.println("Numero no vàlid.");
                                            continue;
                                        } else {
                                            rendimentJugadors[i] = resposta;
                                            contadorRendiment++;
                                            System.out.println("Rendiment introduit correctament.");
                                        }

                                        if (contadorRendiment > jugadorsEquip.length) {
                                            break;
                                        } else {
                                            continue;
                                        }
                                    }
                                }
                            } else {
                                System.out.println("No has entrat cap jugador.");
                                break;

                            }
                        } else {
                            System.out.println("Primer has de començar la temporada.");
                            break;
                        }
                        break;
                    case "10":
                        if (temporada = true) {
                            if (contadorRendiment != 0) {
                                System.out.println("#### JUGADORS ####");
                                for (int i = 0; i < contadorJugadors; i++) {
                                    System.out.println(jugadorsEquip[i] + " : " + rendimentJugadors[i] + ".");
                                }
                            } else {
                                System.out.println("No s'ha introduit cap rendiment.");
                                break;
                            }
                        } else {
                            System.out.println("Primer has de començar la temporada.");
                            break;
                        }
                        break;
                }
            }
        }
    }
}



