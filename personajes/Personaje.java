package personajes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import interfaces.IEquipable;
import interfaces.ICombateable;

public abstract class Personaje implements ICombateable, IEquipable {
   // Variables de diferentes tipos
   protected String nombre; // String
   protected int nivel; // int
   protected double salud; // double
   protected boolean estaVivo; // boolean
   protected List<String> inventario; // List (colección)

   // Variables privadas para encapsulamiento
   private double saludMaxima;
   private String armaEquipada;
   private static final Random random = new Random(); // static para todas las instancias

   // Constructor
   public Personaje(String nombre, int nivel, double salud) {
      this.nombre = nombre;
      this.nivel = nivel;
      this.salud = salud;
      this.saludMaxima = salud;
      this.estaVivo = true;
      this.inventario = new ArrayList<>();
      this.armaEquipada = "Puños";
   }

   // Método público
   public void mostrarInformacion() {
      System.out.println("=== INFORMACIÓN DEL PERSONAJE ===");
      System.out.println("Nombre: " + nombre);
      System.out.println("Nivel: " + nivel);
      System.out.println("Salud: " + String.format("%.1f", salud) + "/" + String.format("%.1f", saludMaxima));
      System.out.println("Estado: " + (estaVivo ? "Vivo" : "Muerto"));
      System.out.println("Arma equipada: " + armaEquipada);
      System.out.println("Inventario: " + inventario);
      System.out.println("Clase: " + this.getClass().getSimpleName());
   }

   // Método protegido para uso por subclases
   protected double calcularDanioBase() {
      return nivel * 5.0 + random.nextInt(10) + 1;
   }

   // Método privado (solo accesible dentro de esta clase)
   private void verificarEstadoVital() {
      if (salud <= 0) {
         salud = 0;
         estaVivo = false;
      }
   }

   // Implementación de ICombateable
   @Override
   public void recibirDanio(double danio) {
      if (estaVivo) {
         salud -= danio;
         verificarEstadoVital();
         System.out.println(nombre + " recibe " + String.format("%.1f", danio) + " de daño. Salud restante: "
               + String.format("%.1f", salud));

         if (!estaVivo) {
            System.out.println("¡" + nombre + " ha sido derrotado!");
         }
      }
   }

   // Implementación de IEquipable
   @Override
   public void equiparArma(String arma) {
      this.armaEquipada = arma;
      System.out.println(nombre + " ha equipado: " + arma);
   }

   @Override
   public String obtenerArmaEquipada() {
      return armaEquipada;
   }

   // Metodo abstracto que deben implementar las subclases
   public abstract double atacar();

   // Metodo para agregar objetos al inventario
   public void agregarObjeto(String objeto) {
      inventario.add(objeto);
      System.out.println(nombre + " ha obtenido: " + objeto);
   }

   // Método para curar
   public void curar(double cantidad) {
      if (estaVivo) {
         salud = Math.min(salud + cantidad, saludMaxima);
         System.out.println(nombre + " se ha curado " + String.format("%.1f", cantidad) + " puntos de salud.");
      }
   }

   // Getters y Setters
   public String getNombre() {
      return nombre;
   }

   public void setNombre(String nombre) {
      if (nombre != null && !nombre.trim().isEmpty()) {
         this.nombre = nombre;
      }
   }

   public int getNivel() {
      return nivel;
   }

   public void setNivel(int nivel) {
      if (nivel > 0) {
         this.nivel = nivel;
      }
   }

   public double getSalud() {
      return salud;
   }

   public boolean isEstaVivo() {
      return estaVivo;
   }

   public List<String> getInventario() {
      return new ArrayList<>(inventario); // Retorna copia para mantener encapsulamiento
   }
}