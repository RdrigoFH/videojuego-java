import personajes.*;
import sistema.*;

public class Main {
   public static void main(String[] args) {
      System.out.println("🎮 SISTEMA DE PERSONAJES - DEMO 🎮\n");

      // Crear instancias de personajes
      Arquero legolas = new Arquero("Legolas", 8, 120);
      Espadachin aragorn = new Espadachin("Aragorn", 10, 150);

      // Mostrar información inicial
      legolas.mostrarInformacion();
      System.out.println();
      aragorn.mostrarInformacion();

      // Demostrar funcionalidades
      System.out.println("\n📦 DEMOSTRANDO FUNCIONALIDADES 📦");

      // Agregar objetos al inventario
      legolas.agregarObjeto("Poción de curación");
      legolas.agregarObjeto("Flechas mágicas");
      aragorn.agregarObjeto("Escudo de mithril");

      // Cambiar armas
      legolas.equiparArma("Arco de los Vientos");
      aragorn.equiparArma("Andúril");

      // Usar setters
      legolas.setPrecision(0.95);
      aragorn.setModoDefensivo(true);

      // Demostrar habilidades especiales
      System.out.println("\n⚡ HABILIDADES ESPECIALES ⚡");
      legolas.disparoMultiple(3);
      legolas.recargarFlechas(20);
      aragorn.cambiarModoDefensivo();
      aragorn.ataqueEspecial();
      aragorn.descansar();

      // Curar personajes antes del combate
      legolas.curar(30);
      aragorn.curar(25);

      // Realizar combate
      GestorCombate.combate(legolas, aragorn);

      // Mostrar estado final
      System.out.println("\n📊 ESTADO FINAL DE LOS PERSONAJES 📊");
      legolas.mostrarInformacion();
      System.out.println();
      aragorn.mostrarInformacion();
   }
}