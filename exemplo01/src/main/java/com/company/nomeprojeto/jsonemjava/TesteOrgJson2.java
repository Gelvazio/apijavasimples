package com.company.nomeprojeto.jsonemjava;

import org.json.JSONException;
import org.json.JSONObject;

public class TesteOrgJson2 {

    public static void main(String[] args) throws JSONException {

        /* -------------------------------------------------------
         * TESTE 2
         * cria um JSONObject a partir de uma string
         * -------------------------------------------------------*/

        //string json
        String json_str = "{\"titulo\":\"Os Arquivos JSON\",\"ano\":1998,\"genero\":\"Ficção\"}";

        //instancia um novo JSONObject passando a string como entrada
        JSONObject my_obj = new JSONObject(json_str);

        //recupera campo por campo com o método get() e imprime cada um
        String titulo = my_obj.getString("titulo");
        Integer ano = my_obj.getInt("ano");
        String genero = my_obj.getString("genero");

        System.out.println("titulo: " + titulo);
        System.out.println("ano: " + ano);
        System.out.println("genero: " + genero);

    }
}