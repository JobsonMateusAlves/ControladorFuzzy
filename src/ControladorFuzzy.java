import net.sourceforge.jFuzzyLogic.FIS;
import org.antlr.runtime.RecognitionException;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.util.Scanner;

public class ControladorFuzzy {

    public static void main(String[] args) throws URISyntaxException, RecognitionException, IOException {

//        Scanner scan = new Scanner(System.in);

//        Entradas entradas = leitura();
        File arquivoFis = new File(ControladorFuzzy.class.getResource("ControladorFuzzyConfig.flc").toURI());

        String conteudoArquivoFis = new String(Files.readAllBytes(arquivoFis.toPath()));
        FIS fis = FIS.createFromString(conteudoArquivoFis, true);

        fis.setVariable("velocidadeDoVento", 45.0);
        fis.setVariable("umidadeDoAr", 96.0);
        fis.setVariable("periodoDoAno", 10.0);
        fis.setVariable("pressaoAtmosferica", 0.0);

        fis.evaluate();

        Double resultado = fis.getVariable("indicePluviometrico").getValue();

        System.out.println(resultado);

//        FIS fis = FIS.load("ControladorFuzzyConfig.flc");
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
