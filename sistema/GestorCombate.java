package sistema;

import personajes.*;

public class GestorCombate {
   public static void combate(Personaje p1, Personaje p2) {
      System.out.println("\n  INICIANDO COMBATE ENTRE " + p1.getNombre().toUpperCase() + " Y "
            + p2.getNombre().toUpperCase() + " 🗡️");
      System.out.println("=============================================================");

      int turno = 1;
      while (p1.isEstaVivo() && p2.isEstaVivo() && turno <= 10) { // Límite de turnos para evitar bucles infinitos
         System.out.println("\n--- TURNO " + turno + " ---");

         // Turno del personaje 1
         if (p1.isEstaVivo()) {
            double danio1 = p1.atacar();
            if (danio1 > 0) {
               p2.recibirDanio(danio1);
            }
         }

         // Turno del personaje 2
         if (p2.isEstaVivo()) {
            double danio2 = p2.atacar();
            if (danio2 > 0) {
               p1.recibirDanio(danio2);
            }
         }

         turno++;
      }

      System.out.println("\n***************RESULTADO DEL COMBATE ***************");
      if (!p1.isEstaVivo() && !p2.isEstaVivo()) {
         System.out.println("¡Es un empate! Ambos personajes han caido.");
      } else if (p1.isEstaVivo()) {
         System.out.println(" ¡" + p1.getNombre() + " es el ganador!");
      } else {
         System.out.println(" ¡" + p2.getNombre() + " es el ganador!");
      }
      System.out.println("===========================================================");
   }
}