package com.company.nomeprojeto.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ManipuladorArquivo {

    public static ArrayList leitor(String path) throws IOException {
        ArrayList<String>listaDados = new ArrayList<>();

        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = "";
        while (true) {
            if (linha != null) {
                System.out.println(linha);
            } else {
                break;
            }
            linha = buffRead.readLine();

            listaDados.add(linha);
        }
        buffRead.close();

        return listaDados;
    }

    public static void escritor(String path, String chave, String valor) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));

        String linha = "";

        // Scanner in = new Scanner(System.in);

        // System.out.println("Escreva algo: ");

        linha = "{'" + chave + "':'" + valor + "'}"; // in.nextLine();

        buffWrite.append(linha + "\n");

        buffWrite.close();
    }

}
