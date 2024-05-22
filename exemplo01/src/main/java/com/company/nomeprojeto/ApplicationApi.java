package com.company.nomeprojeto;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import com.company.nomeprojeto.utils.ManipuladorArquivo;


@SpringBootApplication
public class ApplicationApi {

    public static void main(String[] args) throws IOException {

        // ApplicationApi.leArquivo(args);

        SpringApplication.run(ApplicationApi.class, args);
    }

    // public static void leArquivo(String args[]) throws IOException {
    //     String path = "database/database.json";

    //     ManipuladorArquivo.escritor(path, "codigo", "11");

    //     ArrayList<String> listaDados = new ArrayList<>();
    //     listaDados = ManipuladorArquivo.leitor(path);

    //     for(String valor : listaDados){
    //         System.out.println("valor lido: " + valor);
    //     }
    // }
}
