package juegocartas;

import java.util.Random;
import javax.swing.JPanel;
import java.util.*;

public class Jugador {

    private int TOTAL_CARTAS = 10;
    private int MARGEN = 20;
    private int DISTANCIA = 50;

    private Carta[] cartas = new Carta[TOTAL_CARTAS];

    private Random r = new Random();

    public void repartir() {
        for (int i = 0; i < TOTAL_CARTAS; i++) {
            cartas[i] = new Carta(r);
        }
    }

    public void mostrar(JPanel pnl) {
        pnl.removeAll();
        int x = MARGEN;
        //recorrido objetual por una lista de objetos
        for (Carta c : cartas) {
            c.mostrar(pnl, x, MARGEN);
            x += DISTANCIA;
        }

        pnl.repaint();
    }

    public String getGrupos() {
        String mensaje = "No se encontraron grupos";
        int[] contadores = new int[NombreCarta.values().length];
        for (Carta c : cartas) {
            contadores[c.getNombre().ordinal()]++;
        }

        int totalGrupos = 0;
        for (int c : contadores) {
            if (c >= 2) {
                totalGrupos++;
            }
        }
        if (totalGrupos > 0) {
            mensaje = "Los grupos encontrados fueron:\n";
            for (int i = 0; i < contadores.length; i++) {
                if (contadores[i] >= 2) {
                    mensaje += Grupo.values()[contadores[i]] + " de " + NombreCarta.values()[i] + "\n";
                }
            }
        }
        return mensaje;
    }
    

    
public int calcularPuntaje() {
    int puntaje = 0;

    // Calcular el puntaje base sumando los valores de las cartas
    for (Carta c : cartas) {
        NombreCarta nombre = c.getNombre();
        int valorCarta = nombre.getValor(); // Obtener el valor asignado a la carta
        if (nombre == NombreCarta.AS || nombre == NombreCarta.QUEEN || nombre == NombreCarta.KING || nombre == NombreCarta.JACK) {
            puntaje += 10;
        } else {
            puntaje += valorCarta;
        }
    }

    // Detectar grupos mayores a par y restar su valor total
    int[] contadores = new int[NombreCarta.values().length];
    for (Carta c : cartas) {
        contadores[c.getNombre().ordinal()]++;
    }
    for (int i = 0; i < contadores.length; i++) {
        if (contadores[i] > 2) { // Consideramos grupos de tamaño 3 o más como mayores a par
            // Obtener el valor de la carta correspondiente al índice i
            int valorCarta = NombreCarta.values()[i].getValor();
            // Restar el valor total del grupo
            puntaje -= contadores[i] * valorCarta;
        }
    }

    // Restar el valor de las escaleras si alguno de sus valores está presente en un grupo
    List<String> escaleras = obtenerEscaleras();
    for (String escalera : escaleras) {
        String[] nombresCartasEscalera = escalera.split(":")[1].trim().split(" ");
        int valorEscalera = 0;
        for (String nombreCarta : nombresCartasEscalera) {
            NombreCarta nombre = NombreCarta.valueOf(nombreCarta);
            int valorCarta = nombre.getValor();
            if (contadores[nombre.ordinal()] > 0) {
                valorEscalera += valorCarta;
            }
        }
        puntaje -= valorEscalera;
    }

    return puntaje;
}


  public List<String> obtenerEscaleras() {
        List<String> infoEscaleras = new ArrayList<>();
        for (Pinta pinta : Pinta.values()) {
            List<Carta> escalera = new ArrayList<>();
            for (NombreCarta nombre : NombreCarta.values()) {
                Carta carta = null;
                for (Carta c : cartas) {
                    if (c.getPinta() == pinta && c.getNombre() == nombre) {
                        carta = c;
                        break;
                    }
                }
                if (carta != null) {
                    escalera.add(carta);
                } else {
                    if (escalera.size() >= 3) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Escalera de ").append(pinta).append(": ");
                        for (Carta cartaEscalera : escalera) {
                            sb.append(cartaEscalera.getNombre()).append(" ");
                        }
                        infoEscaleras.add(sb.toString());
                    }
                    escalera.clear();
                }
            }
            if (escalera.size() >= 3) {
                StringBuilder sb = new StringBuilder();
                sb.append("Escalera de ").append(pinta).append(": ");
                for (Carta cartaEscalera : escalera) {
                    sb.append(cartaEscalera.getNombre()).append(" ");
                }
                infoEscaleras.add(sb.toString());
            }
        }
        return infoEscaleras;
    }


}
