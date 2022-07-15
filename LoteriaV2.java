import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
public class LoteriaV2 {
    //Variables globales
    static double cartera=0.0;
    static int cantidadBoletos = 0;
    static int premio;
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
                case 5:
                    PremioLoteria();
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
        int manualmente = 1000;
        int nmanual = 0;
        double compra=0;
        System.out.println("¿Cuántos boletos quieres comprar?");
        cantidadBoletos = TecladoInt();

        BoletosLoteria =new int [cantidadBoletos];
        compra = cantidadBoletos *3;

        switch (cantidadBoletos) {
            default:
            if (compra > cartera) {
                System.out.println("No tiene dinero suficiente");
            }
                break;
        }


        if (compra <= cartera) {
            do {

                System.out.println("¿Aleatorio (0) o Manualmente (1)?");
                manualmente = TecladoInt();
    
            } while (manualmente != 0 && manualmente != 1);
        }
        
        if (manualmente == 0) { //Forma aleatoria
            if (compra <= cartera) {
                for (int i = 0; i < BoletosLoteria.length; i++) {
                    BoletosLoteria[i]=Aleatorio(100000, 10000);
                    System.out.print(BoletosLoteria[i]+"\n");
                }
    
                for (int i : BoletosLoteria) {
                    ListaBoletos.add(i);
                }
                cartera -= cantidadBoletos*3;
            }
        }

        if (manualmente == 1) { //Forma manual

            int tam = 0;
            String cadena ="";

            do {
                System.out.println("Por favor introduzca los 5 dígitos del boleto.");
                nmanual= TecladoInt();
                cadena = String.valueOf(nmanual);
                tam = cadena.length();
            } while (tam !=5);

            for (int i = 0; i < BoletosLoteria.length; i++) {
                BoletosLoteria[i] = nmanual;
                System.out.print(BoletosLoteria[i]+"\n");
            }

            for (int i : BoletosLoteria) {
                ListaBoletos.add(i);
            }
            cartera -= cantidadBoletos*3;
        }
    }

    public static void ConsultaBoletosLoteria(){
        System.out.println("Sus boletos de loteria son: \n"+ListaBoletos);
    }


    public static void PremioLoteria(){
        int aleatorio = Aleatorio(100000, 10000);
        System.out.println("El número premiado es: ***"+aleatorio+"***");
        
        int parse=0;
        int dinero=0;
        boolean restapremio = false;

        for (int i = 0; i < ListaBoletos.size(); i++) {
            parse = ListaBoletos.get(i);

            if (parse%10 == aleatorio%10) {
                System.out.println("¡Reintegro de 3$!");
                dinero +=3;
                restapremio = true;
            }
            if (parse%100 == aleatorio%100) {
                System.out.println("¡Premio de 6$!");
                dinero +=6;
                if (restapremio == true) {
                   dinero -= 3; 
                }
            }
            if (parse%1000 == aleatorio%1000) {
                System.out.println("¡Premio de 15$!");
                dinero +=15;
                if (restapremio == true) {
                    dinero -= 6; 
                 }
            }
            if (parse%10000 == aleatorio%10000) {
                System.out.println("¡Premio de 75$!");
                dinero +=75;
                if (restapremio == true) {
                    dinero -= 15; 
                 }
            }
            if (parse%100000 +1 == aleatorio || parse%100000 -1 == aleatorio) {
                System.out.println("¡Reintegro de 1200$!");
                dinero +=1200;
            }
            if (parse%100000 == aleatorio%100000) {
                System.out.println("***ENHORABUENA HA CONSEGUIDO EL PREMIO GORDO*** 30.000$");
                dinero +=30000;
                if (restapremio == true) {
                    dinero -= 75; 
                 }
            }
        }
        System.out.println("Ha ganado un total de: "+dinero+"$");
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