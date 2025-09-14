package personajes;

class Arquero extends Personaje {
   private int flechas;
   private double precision;

   public Arquero(String nombre, int nivel, double salud) {
      super(nombre, nivel, salud);
      this.flechas = 30;
      this.precision = 0.8;
      equiparArma("Arco Élfico");
   }

   @Override
   public double atacar() {
      if (!estaVivo) {
         System.out.println(nombre + " no puede atacar porque está muerto.");
         return 0;
      }

      if (flechas <= 0) {
         System.out.println(nombre + " no tiene flechas para atacar.");
         return 0;
      }

      flechas--;
      double danio = calcularDanioBase() * 1.2; // Bonus de daño para arqueros

      // Verificar precisión
      if (Math.random() > precision) {
         System.out.println(nombre + " falla el disparo. Flechas restantes: " + flechas);
         return 0;
      }

      System.out.println(nombre + " dispara una flecha causando " + String.format("%.1f", danio)
            + " de daño. Flechas restantes: " + flechas);
      return danio;
   }

   public void recargarFlechas(int cantidad) {
      flechas += cantidad;
      System.out.println(nombre + " recarga " + cantidad + " flechas. Total: " + flechas);
   }

   // Habilidad especial
   public double disparoMultiple(int objetivos) {
      if (!estaVivo || flechas < objetivos) {
         System.out.println(nombre + " no puede realizar disparo múltiple.");
         return 0;
      }

      flechas -= objetivos;
      double danio = calcularDanioBase() * 0.8; // Menos daño por flecha pero múltiple
      System.out.println(nombre + " realiza disparo múltiple a " + objetivos + " objetivos causando "
            + String.format("%.1f", danio) + " de daño cada uno.");
      return danio;
   }

   // Getters específicos
   public int getFlechas() {
      return flechas;
   }

   public double getPrecision() {
      return precision;
   }

   public void setPrecision(double precision) {
      if (precision >= 0.0 && precision <= 1.0) {
         this.precision = precision;
      }
   }
}