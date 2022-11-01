
package tarea_1_andrescanobarboza;

import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JOptionPane;

/*
Universidad Estatal a Distancia
Cátedra de Ingeniería de Software
ORIENTACIÓN ACADÉMICA
Estructura de datos
Código: 00825 Créditos: 3
Grado académico: Diplomado
Encargado de cátedra: Percy Cañipa Valdez
Estudiante Andrés Cano Barboza
Tarea 1
SEGUNDO CUATRIMESTRE
2021
 */
public class Tarea_1_AndresCanoBarboza {

    
    public static void main(String[] args) {
        Scanner entrada = new Scanner (System.in);
        
        int opcion;
        String menPrinc = "s";
        /*Se crearon submenus para no tener que devolvera la persona en caso de no introducir un numero o arreglo y dar mayor facilidad de uso del programa*/
        do {
        opcion = Integer.parseInt(JOptionPane.showInputDialog("Bienvenido, escoga una opción del menú para ejecutar:\n"
        + "1. Digitar un número entero.\n"
        + "2. Crear un arreglo de 100 enteros aleatoriamente\n"
        + "3. Terminar.\n")); 
        
        
        switch (opcion) {
            case 1: Tarea_1_AndresCanoBarboza.operacionNumero();
            break;        
            
            case 2: Tarea_1_AndresCanoBarboza.arreglo();
            break;   
            
            case 3: 
            break;
        }   
        menPrinc = JOptionPane.showInputDialog("Desea volver al menú principal? (S/N)"); //Repetir también si la persona decide Terminar por si quiere volver
        }while(menPrinc.equalsIgnoreCase("s"));
    } //Final main
    
    public static void operacionNumero() { //metodo para opcion numero 1
        Scanner entrada = new Scanner (System.in);
        int numero;
        int opcion_num;
        int resultado;  
      
        numero = Integer.parseInt(JOptionPane.showInputDialog("Digite un número: "));
   
        
        opcion_num = Integer.parseInt(JOptionPane.showInputDialog("Escoga una opción del menú para aplicar al número digitado:\n"
                + "1. Sumar dígitos del número ingresado.\n"
                + "2. Invertir dígitos de número ingresado.\n"));
        
        switch (opcion_num) { 
            case 1: JOptionPane.showMessageDialog(null, "El resultado de sumar los digitos es: "+sumaRecursiva(numero));
                               
            break;
            case 2:
                int cifrasNum = String.valueOf(numero).length();
                JOptionPane.showMessageDialog(null, "El número invertido es: "+inversoNumero(numero, cifrasNum - 1));
            break;    
        }        
    
    }
    

public static int sumaRecursiva(int num) { // metodo para realizar la suma, llamado desde operacionNumero
    if(num == 0){
        return 0; }
    
    else {
        return sumaRecursiva(num / 10) + num % 10; }
        
} // Fin metodo

public static int inversoNumero(int num, int pos) { // metodo inverso llamado de operaciónNumero
    
    if(num < 10) {
        return num; }
    else {
        return num % 10 * (int)Math.pow(10, pos) + inversoNumero(num / 10, pos - 1); }  //(num % 10) + inversoNumero(num / 10); }
        
} //Fin metodo inverso
    
public static void arreglo() {
    
    int opcionArreglo;
    int max;
    int[] arreglo = new int[99];
    
                    for (int i=0; i < arreglo.length; i++) {
                    arreglo[i] = (int)(Math.random()*100)+1; }
                    
                    JOptionPane.showMessageDialog(null, Arrays.toString(arreglo));
                    
    opcionArreglo = Integer.parseInt(JOptionPane.showInputDialog("Escoga una opción del menú para aplicar al arreglo realizado:\n"
                + "1. Mostrar el número y posición del número mayor dentro del arreglo generado.\n"
                + "2. Mostrar el número y posición del número menor dentro del arreglo generado.\n"
                + "3. Contar los números pares del arreglo generado.\n"
                + "4. Contar los números impares del arreglo generado.\n"));
   
    switch (opcionArreglo) {
        case 1: JOptionPane.showMessageDialog(null, "El valor máximo es: "+maxValor(arreglo, 0, arreglo[0]));
        break;
        
        case 2: JOptionPane.showMessageDialog(null, "El valor mínimo es: "+minValor(arreglo, 0, arreglo[0]));
        break;
        
        case 3: JOptionPane.showMessageDialog(null,"La cantida de números pares es: "+contaPar(arreglo, 0));
        break;
        
        case 4: JOptionPane.showMessageDialog(null,"La cantida de números impares es: "+contaImpar(arreglo, 0));
        break;        
    }
}  
 
public static int maxValor(int [] arreglo, int indice, int max) {
    int pos;
    if (indice != arreglo.length - 1) {
        
        if (arreglo[indice] > max) {
            max = maxValor(arreglo, indice + 1, arreglo[indice]); }  
             
        else {
            max = maxValor(arreglo, indice + 1, max); }
    }
    
    if (arreglo[indice] == max) {
        pos = indice ; 
        JOptionPane.showMessageDialog(null, "En la posición: "+ pos);}    
return max;
            
}  //Fin metodo  
    
    
    public static int minValor(int [] arreglo, int indice, int min) {
    int pos;
    if (indice != arreglo.length - 1) {
        
        if (arreglo[indice] < min) {
            min = minValor(arreglo, indice + 1, arreglo[indice]); }  
             
        else {
            min = minValor(arreglo, indice + 1, min); }
    }
    
    if (arreglo[indice] == min) {
        pos = indice ; 
        JOptionPane.showMessageDialog(null, "En la posición: "+ pos);}    
return min;
    
}  //Fin metodo  
    
public static int contaPar(int [] arreglo, int pos)  {

int contPar = 0;

    if (pos < arreglo.length) {
        contPar = contaPar(arreglo,pos+1);
        if (arreglo[pos] % 2 == 0) {
            contPar++; }
    }

return contPar; 

} //Fin metodo

public static int contaImpar(int [] arreglo, int pos)  {

//int impar = 0;
int contImpar = 0;
//int indice = 0;
    if (pos < arreglo.length) {
        contImpar = contaImpar(arreglo,pos+1);
        if (arreglo[pos] % 2 != 0) {
            contImpar = contImpar +1; }
            
    }
   
return contImpar; 

} //Fin metodo

} //Fin Programa

/* Notas de pendientes: 
Validaciones en los menús
Validación en pregunta "Desea volver al menú principal
Crear sub menús para mayor comodidad para el usuario
*/




    

 