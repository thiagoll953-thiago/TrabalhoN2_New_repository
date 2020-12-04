package com.thiago.trabalhon2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Banco extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "Controle_Combustivel";
    private static final int VERSAO_BANCO = 1;

    public Banco(Context context){
        super(context, NOME_BANCO, null , VERSAO_BANCO );
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL( "CREATE TABLE IF NOT EXISTS Veiculos ( " +
                " id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT , " +
                " nome_veiculo TEXT NOT NULL , " +
                " kmAtual_veiculo INTEGER NOT NULL, " +
                " capacidade_tanque DOUBLE NOT NULL, " +
                " MediaKM DOUBLE  ) "
        );
        sqLiteDatabase.execSQL( "CREATE TABLE IF NOT EXISTS Abastecimentos ( " +
                " id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT , " +
                " veiculo_id INTEGER NOT NULL , " +
                " Dt_Abastecimento DATETIME NOT NULL , " +
                " kmAbastecimento_veiculo INTEGER NOT NULL , " +
                " Combs_indicado TEXT NOT NULL , " +
                " Combs_selecionado TEXT NOT NULL , " +
                " L_abastecidos DOUBLE  ) " );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
