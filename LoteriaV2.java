import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
public class LoteriaV2 {
    //Variables globales
    static double cartera=0.0;
    static double compra=0.0;
    static int cantidadBoletos = 0;
    static int cantidadBoletosEuro =0;
    static int premio;
    static int BoletosLoteria[];
    static int BoletosEuro[][];
    static int BoletosEuroPremio [] = new int [7];
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
            System.out.println("6. Compra boletos Euromillon");
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
                case 6:
                    CompraBoletosEuro();
                    break;
                case 7:
                    PremiosEuro();
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
                cartera -= compra;
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
            cartera -= compra;
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

    
    public static void CompraBoletosEuro(){ //AÑLDKFJALÑDKFJAÑLDJKF
        int aleatorio = 0;
        int manualmente = 1000;
        int nmanual = 0;
        boolean insuficiente = false;

        System.out.println("¿Cuántos boletos de euromillón quieres comprar?");
        cantidadBoletosEuro = TecladoInt();

        BoletosEuro = new int [cantidadBoletosEuro][7];
        compra = cantidadBoletosEuro * 2.5;

        if (compra > cartera) {
            insuficiente = true;
            System.out.println("No tiene suficiente saldo");
        }

        if (insuficiente == false) {
            do {
                System.out.println("¿Aleatorio (0) o Manualmente (1)?");
                manualmente = TecladoInt();
            } while (manualmente != 0 && manualmente != 1);
        }

        

        if (manualmente == 0) { //Forma aleatoria
            if (insuficiente == false) {
                for (int i = 0; i <  cantidadBoletosEuro; i++) { //Para los 5 primeros numeros
                    for (int j = 0; j<5; j++) {
                        aleatorio = Aleatorio(50, 1);
                        BoletosEuro[i][j] = aleatorio;
                    }
                    for (int j = 0; j<2; j++) { //Para las dos estrellas del numero
                        aleatorio = Aleatorio(10, 1);
                        BoletosEuro[i][j+5] = aleatorio;
                    }
                }

                for (int i = 0; i < cantidadBoletosEuro; i++) {
                    for (int j = 0; j < 7; j++) {
                        System.out.print(BoletosEuro[i][j]+" ");
                    }
                }
                System.out.println("\n");
                cartera -= compra;
            }
        }

        if (manualmente == 1) { //Forma manual
            int numeros =0;
            int estrellas=0;

            if (insuficiente == false) {
                System.out.println("Por favor introduzca los 5 primeros digitos entre 1 y 49");
                for (int i = 0; i < cantidadBoletosEuro; i++) {
                    for (int j = 0; j < 5; j++) {
                        if (numeros < 5) {
                            do {
                                nmanual = TecladoInt();
                                BoletosEuro[i][j] = nmanual;
                                if (nmanual <1 || nmanual >49) {
                                    System.out.println("Numeros entre 1 y 49");
                                }
                            } while (nmanual <1 || nmanual >49);
                            numeros++;
                        }
                    }

                    System.out.println("Por favor introduce los números de las estrellas, digitos entre 1 y 9");
                    for (int j = 0; j < 2; j++) {
                        if (estrellas <2) {
                            do {
                                nmanual = TecladoInt();
                                BoletosEuro[i][j+5] = nmanual;
                                if (nmanual <1 || nmanual >9) {
                                    System.out.println("Numeros entre 1 y 9");
                                }
                            } while (nmanual <1 || nmanual >9);
                        }
                    }
                }

                for (int i = 0; i < cantidadBoletosEuro; i++) {
                    for (int j = 0; j < 7; j++) {
                        System.out.print(BoletosEuro[i][j]+" ");
                    }
                }
                System.out.print("¡Buena Suerte!"+"\n");
                cartera -= compra;
            }
        }
    }

    public static void PremiosEuro(){
        int numeroserie=0;
        int estrellas=0;
        int naleatorio;

        for (int i = 0; i < 5; i++) { //5 primeros numeros del boleto euro
            naleatorio = Aleatorio(50, 1);
            BoletosEuroPremio[i] = naleatorio;
        }

        for (int i = 0; i < 2; i++) { //2 ultimas estrellas
            naleatorio = Aleatorio(10, 1);
            BoletosEuroPremio[i+5] = naleatorio;
        }
        System.out.println("El numero premiado es: ");
        for (int i = 0; i < BoletosEuroPremio.length; i++) {
            System.out.print(BoletosEuroPremio[i]+" ");
        }
        System.out.println("\n");

        
        
        for (int i = 0; i < cantidadBoletosEuro; i++) {
            
            for(int j=0; j<5; j++){
                if(BoletosEuro[i][j] == BoletosEuroPremio[0]) numeroserie++;
                if(BoletosEuro[i][j] == BoletosEuroPremio[1]) numeroserie++;
                if(BoletosEuro[i][j] == BoletosEuroPremio[2]) numeroserie++;
                if(BoletosEuro[i][j] == BoletosEuroPremio[3]) numeroserie++;
                if(BoletosEuro[i][j] == BoletosEuroPremio[4]) numeroserie++;
            }

            for(int j=5; j<7; j++){
                if(BoletosEuro[i][j] == BoletosEuroPremio[5]) estrellas++;
                if(BoletosEuro[i][j] == BoletosEuroPremio[6]) estrellas++;
                }

            if (numeroserie <2) {
                System.out.println("No te ha tocado nada");
            }
            else if(numeroserie==2 && estrellas==0){
                naleatorio=Aleatorio(7, 1);
                System.out.println("El premio ha sido: "+naleatorio+"💵");
                continue;
            }
            else if(numeroserie==2 && estrellas==1){
                naleatorio=Aleatorio(8, 4);
                System.out.println("El premio ha sido: "+naleatorio+"💵");
                continue;
            }
            else if(numeroserie==3 && estrellas==1){
                naleatorio=Aleatorio(16, 8);
                System.out.println("El premio ha sido: "+naleatorio+"💵");
                continue;
            }
            else if(numeroserie==2 && estrellas==2){
                naleatorio=Aleatorio(21, 10);
                System.out.println("El premio ha sido: "+naleatorio+"💵");
                continue;
            }
            else if(numeroserie==4 && estrellas==0){
                naleatorio=Aleatorio(61, 20);
                System.out.println("El premio ha sido: "+naleatorio+"💵");
                continue;
            }
            else if(numeroserie==3 && estrellas==2){
                naleatorio=Aleatorio(81, 30);
                System.out.println("El premio ha sido: "+naleatorio+"💵");
                continue;
            }
            else if(numeroserie==4 && estrellas==1){
                naleatorio=Aleatorio(601, 90);
                System.out.println("El premio ha sido: "+naleatorio+"💵");
                continue;
            }
            else if(numeroserie==4 && estrellas==2){
                naleatorio=Aleatorio(6001, 750);
                System.out.println("El premio ha sido: "+naleatorio+"💵");
                continue;
            }
            else if(numeroserie==5 && estrellas==0){
                naleatorio=Aleatorio(120001, 80000);
                System.out.println("El premio ha sido: "+naleatorio+"💵");
                continue;
            }
            else if(numeroserie==5 && estrellas==1){
                naleatorio=Aleatorio(2000001, 600000);
                System.out.println("El premio ha sido: "+naleatorio+"💵");
                continue;
            }
            else if(numeroserie==5 && estrellas==2){
                naleatorio=Aleatorio(900000001, 75000000);
                System.out.println("El premio ha sido: "+naleatorio+"💵");
                continue;
            }
        }
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