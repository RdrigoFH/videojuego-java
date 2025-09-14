package personajes;

class Espadachin extends Personaje {
   private double resistencia;
   private boolean modoDefensivo;

   public Espadachin(String nombre, int nivel, double salud) {
      super(nombre, nivel, salud);
      this.resistencia = 100.0;
      this.modoDefensivo = false;
      equiparArma("Espada de Acero");
   }

   @Override
   public double atacar() {
      if (!estaVivo) {
         System.out.println(nombre + " no puede atacar porque esta muerto.");
         return 0;
      }

      if (resistencia < 10) {
         System.out.println(nombre + " esta demasiado cansado para atacar.");
         return 0;
      }

      resistencia -= 10;
      double danio = calcularDanioBase();

      if (modoDefensivo) {
         danio *= 0.7; // Menos daño en modo defensivo
         System.out.println(nombre + " ataca defensivamente causando " + String.format("%.1f", danio) + " de daño.");
      } else {
         danio *= 1.3; // Más daño en modo agresivo
         System.out.println(nombre + " ataca agresivamente causando " + String.format("%.1f", danio) + " de daño.");
      }

      System.out.println("Resistencia restante: " + String.format("%.1f", resistencia));
      return danio;
   }

   @Override
   public void recibirDanio(double danio) {
      if (modoDefensivo) {
         danio *= 0.5; // Reducir daño recibido en modo defensivo
         System.out.println(nombre + " bloquea parte del ataque.");
      }
      super.recibirDanio(danio);
   }

   public void descansar() {
      resistencia = Math.min(resistencia + 25, 100);
      System.out.println(nombre + " descansa y recupera resistencia: " + String.format("%.1f", resistencia));
   }

   public void cambiarModoDefensivo() {
      modoDefensivo = !modoDefensivo;
      System.out.println(nombre + " cambia a modo " + (modoDefensivo ? "defensivo" : "agresivo"));
   }

   // Habilidad especial
   public double ataqueEspecial() {
      if (!estaVivo || resistencia < 30) {
         System.out.println(nombre + " no puede realizar ataque especial.");
         return 0;
      }

      resistencia -= 30;
      double danio = calcularDanioBase() * 2.0; // Doble daño
      System.out.println(
            nombre + " realiza un ataque especial devastador causando " + String.format("%.1f", danio) + " de daño!");
      return danio;
   }

   // Getters y Setters específicos
   public double getResistencia() {
      return resistencia;
   }

   public boolean isModoDefensivo() {
      return modoDefensivo;
   }

   public void setModoDefensivo(boolean modoDefensivo) {
      this.modoDefensivo = modoDefensivo;
   }
}