package com.company.nomeprojeto.jsonemjava;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TesteOrgJson3 {

    public static void main(String[] args) throws JSONException {

        /* ----------------------------------------------
         * TESTE 3
         * Trabalhando com um array de strings
         * ---------------------------------------------*/

        //instancia um novo JSONObject
        JSONObject my_obj = new JSONObject();

        //preenche o objeto
        my_obj.put("titulo", "JSON x XML: a Batalha Final");
        my_obj.put("ano", 2012);

        //cria um JSONArray e preenche com valores string
        JSONArray my_genres = new JSONArray();

        my_genres.put("aventura");
        my_genres.put("ação");
        my_genres.put("ficção");

        //insere o array no JSONObject com o rótulo "generos"
        my_obj.put("generos", my_genres);

        //serializa para uma string e imprime
        String json_string = my_obj.toString();
        System.out.println(json_string);
    }
}