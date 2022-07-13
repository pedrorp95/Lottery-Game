import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
public class LoteriaV2 {
    //Variables globales
    static double cartera=0.0;
    static int cantidadBoletos = 0;
    static int BoletosLoteria[];
    static ArrayList<Integer> ListaBoletos = new ArrayList<Integer>();
    
    
    public static void main(String[] args) {
        Menu();
    }

    public static void Menu (){
        int opcionMenu = 0;
        do {
            System.out.println("Menu");
            System.out.println("1. Ingresar Saldo");
            System.out.println("2. Ver cartera");
            System.out.println("3. Compra boletos Loteria");
            System.out.println("4. Consulta sus boletos Loteria");
            System.out.println("5. Premios de la loteria");
            System.out.println("6. Compra y consulta de boletos Euromillon");
            System.out.println("7. Premios Euromillon");
            System.out.println("9. Salir");

            opcionMenu = TecladoInt();

            switch (opcionMenu) {
                case 1:
                    cartera = IngresoSaldo();
                    break;
                case 2:
                    ConsultarSaldo();
                    break;
                case 3:
                    CompraBoletosLoteria();
                    break;
                case 4:
                    ConsultaBoletosLoteria();
                    break;
                default:
                    break;
            }
        } while (opcionMenu !=9);
    }

    public static double IngresoSaldo(){
        System.out.println("Introduce la cantidad de dinero que quiere ingresar.");
        cartera += TecladoDouble();
        return cartera;
    }

    public static void ConsultarSaldo(){
        System.out.println("Su cartera es de: "+cartera);
    }

    public static void CompraBoletosLoteria(){
        double compra=0;
        System.out.println("¿Cuántos boletos quieres comprar?");
        cantidadBoletos = TecladoInt();

        BoletosLoteria =new int [cantidadBoletos];
        compra = cantidadBoletos *3;
        if (compra <= cartera) {
            for (int i = 0; i < BoletosLoteria.length; i++) {
                BoletosLoteria[i]=Aleatorio(11, 5);
                System.out.print(BoletosLoteria[i]);
                System.out.println("");
            }

            for (int i : BoletosLoteria) {
                ListaBoletos.add(i);
            }
            cartera -= cantidadBoletos*3;
        }
        else
        System.out.println("No tiene dinero suficiente");
    }

    public static void ConsultaBoletosLoteria(){
        System.out.println("Sus boletos de loteria son: ");
        System.out.println(ListaBoletos);
    }

    public static int TecladoInt(){
        Scanner sc=new Scanner(System.in);
        int numero;
        numero=sc.nextInt();
        return numero;
    }

    public static double TecladoDouble(){
        Scanner sc = new Scanner(System.in);
        double numero;
        numero = sc.nextDouble();
        return numero;
    }

    public static int Aleatorio(int mayor,int menor) {
        int n = (int)Math.floor((Math.random())*(mayor-menor)+menor);
        //aleatorio = (int)Math.floor((Math.random())*(10-5)+5); de 5 hasta 9
        return n;
    }
}
