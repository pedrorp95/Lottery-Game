import java.util.Scanner;
public class LoteriaV2 {
    //Variables globales
    static double cartera=0.0;
    static int cantidadBoletos = 0;
    static int BoletosLoteria[];
    public static void main(String[] args) {
        //Variables locales
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
        int aleatorio;

        System.out.println("¿Cuántos boletos quieres comprar?");
        cantidadBoletos = TecladoInt();

        BoletosLoteria =new int [cantidadBoletos];
        if (cartera >=5) {
            for (int i = 0; i < cantidadBoletos; i++) {
                aleatorio=(((int)Math.floor(100000*(Math.random())))); //Numeros de 0 a 99.999;
                BoletosLoteria[i]=aleatorio;
                System.out.print(BoletosLoteria[i]);
                System.out.println("");
            }

            compra = cartera- (cantidadBoletos*5);
            cartera = compra;
        }
        else
        System.out.println("Cartera minima de 5$");
    }

    public static void ConsultaBoletosLoteria(){
        System.out.println("Sus boletos de loteria son: ");
        for (int i = 0; i < BoletosLoteria.length; i++) {
            System.out.println(BoletosLoteria[i]);
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
}
