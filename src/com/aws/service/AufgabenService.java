package com.aws.service;

import com.aws.model.*;
import java.util.ArrayList;
import java.util.List;

public class AufgabenService {
    private List<Aufgabe> aufgabenListe;

    public AufgabenService() {
        this.aufgabenListe = new ArrayList<>();
    }

    // Methode zum Hinzufügen einer Aufgabe
    public void aufgabeHinzufuegen(Aufgabe aufgabe) {
        aufgabenListe.add(aufgabe);
        System.out.println("Aufgabe hinzugefügt: " + aufgabe.getTitel());
    }

    // Getter für die Aufgabenliste
    public List<Aufgabe> getAufgabenListe() {
        return aufgabenListe;
    }

    // Methode zum Aktualisieren des Aufgabenstatus
    public boolean aufgabeAlsErledigtMarkieren(String titel) {
        for (Aufgabe aufgabe : aufgabenListe) {
            if (aufgabe.getTitel().equalsIgnoreCase(titel)) {
                aufgabe.setErledigt(true);
                System.out.println("Aufgabe als erledigt markiert: " + titel);
                return true;
            }
        }
        System.out.println("Aufgabe nicht gefunden: " + titel);
        return false;
    }
}
