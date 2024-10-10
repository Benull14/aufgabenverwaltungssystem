package com.aws.view;

import com.aws.model.Aufgabe;
import com.aws.service.AufgabenService;
import java.util.Scanner;

public class KonsoleUI {
    private AufgabenService aufgabenService;
    private Scanner scanner;

    public KonsoleUI() {
        aufgabenService = new AufgabenService();
        scanner = new Scanner(System.in);
    }

    public void start() {
        boolean run = true;
        while (run) {
            menueAnzeigen();
            int wahl = scanner.nextInt();
            scanner.nextLine(); // Puffer leeren
            switch (wahl) {
                case 1:
                    aufgabeHinzufuegenUI();
                    break;
                case 2:
                    aufgabenAnzeigenUI();
                    break;
                case 3:
                    aufgabeErledigenUI();
                    break;
                case 0:
                    run = false;
                    break;
                default:
                    System.out.println("Ungültige Auswahl. Bitte versuchen Sie es erneut.");
            }
        }
    }

    private void menueAnzeigen() {
        System.out.println("\n--- Aufgabenverwaltung ---");
        System.out.println("1. Aufgabe hinzufügen");
        System.out.println("2. Aufgaben anzeigen");
        System.out.println("3. Aufgabe als erledigt markieren");
        System.out.println("0. Beenden");
        System.out.print("Auswahl: ");
    }

    private void aufgabeHinzufuegenUI() {
        System.out.print("Titel: ");
        String titel = scanner.nextLine();
        System.out.print("Beschreibung: ");
        String beschreibung = scanner.nextLine();
        System.out.print("Priorität (1=Hoch, 2=Mittel, 3=Niedrig): ");
        int prioritaet = scanner.nextInt();
        scanner.nextLine(); // Puffer leeren

        Aufgabe aufgabe = new Aufgabe(titel, beschreibung, prioritaet);
        aufgabenService.aufgabeHinzufuegen(aufgabe);
    }

    private void aufgabenAnzeigenUI() {
        System.out.println("\n--- Aktuelle Aufgabenliste ---");
        System.out.printf("%-20s | %-10s | %-8s | %s\n", "Titel", "Priorität", "Status", "Beschreibung");
        System.out.println("----------------------------------------------------------------------");
        for (Aufgabe aufgabe : aufgabenService.getAufgabenListe()) {
            System.out.println(aufgabe);
        }
    }

    private void aufgabeErledigenUI() {
        System.out.print("Titel der Aufgabe, die als erledigt markiert werden soll: ");
        String titel = scanner.nextLine();
        aufgabenService.aufgabeAlsErledigtMarkieren(titel);
    }
}
