import java.util.Scanner;

public class ControladorFuzzy {



    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Entradas entradas = leitura();

        System.out.println(entradas);
    }

    public static Entradas leitura() {

        Scanner scan = new Scanner(System.in);

        Entradas entradas = new Entradas();

        System.out.println("Informe a velocidade do vento (m/s):");
        entradas.velocidadeDoVento = scan.nextDouble();

        System.out.println("Informe a umidade do ar (%):");
        entradas.umidadeDoAr = scan.nextDouble();

        System.out.println("Informe o mes (1 à 12):");
        entradas.periodoDoAno = scan.nextInt();

        System.out.println("Informe a pressao atmosferica(miliBar):");
        entradas.pressaoAtmosferica = scan.nextDouble();

        return entradas;
    }
}

enum IndicePluviometrico {

    BAIXA,
    FRACA,
    MODERADA,
    FORTE,
    VIOLENTA
}

class Entradas {
    double velocidadeDoVento = 0;
    double umidadeDoAr = 0;
    int periodoDoAno = 0;
    double pressaoAtmosferica = 0;
}
