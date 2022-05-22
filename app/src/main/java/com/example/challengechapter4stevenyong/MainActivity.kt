package com.example.challengechapter4stevenyong

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import java.util.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Hide Action Bar di Home Screen
        supportActionBar?.hide()

        //Inisialisasi Pilihan
        val playerBatu = findViewById<ImageView>(R.id.image_batu_player)
        val computerBatu = findViewById<ImageView>(R.id.image_batu_computer)
        val playerKertas = findViewById<ImageView>(R.id.image_kertas_player)
        val computerKertas = findViewById<ImageView>(R.id.image_kertas_computer)
        val playerGunting = findViewById<ImageView>(R.id.image_gunting_player)
        val computerGunting = findViewById<ImageView>(R.id.image_gunting_computer)
        val refresh = findViewById<ImageView>(R.id.image_refresh)
        var statusBattle = findViewById<TextView>(R.id.text_view_result)


        //0 = belum memilih , 1 = Batu , 2 = Gunting , 3 = Kertas
        var pilihanPlayer = 0
        var pilihanComputer= 0

        playerBatu.setOnClickListener {
            pilihanPlayer =1
            Log.d(MainActivity::class.java.simpleName,"Player Memilih : Batu " + "(" + pilihanPlayer.toString() + ")")
            playerBatu.setBackgroundColor(Color.parseColor("#C3DAE9"))
            playerGunting.setBackgroundColor(Color.WHITE)
            playerKertas.setBackgroundColor(Color.WHITE)
            val randomValues = (1..3).shuffled().last()
            pilihanComputer = computerPick(randomValues,computerBatu,computerGunting,computerKertas)
            var tempPilihanComputer= ""
            if(pilihanComputer == 1) {
                tempPilihanComputer= "Batu"
            }
            else if(pilihanComputer == 2) {
                tempPilihanComputer= "Gunting"
            }
            else if(pilihanComputer == 3) {
                tempPilihanComputer= "Kertas"
            }
            Log.d(MainActivity::class.java.simpleName, "Computer Memilih : "+ tempPilihanComputer + " (" + pilihanComputer.toString() + ")")
            var statusSuit = battleSuit(pilihanPlayer,pilihanComputer,statusBattle)
            Log.d(MainActivity::class.java.simpleName, "Hasil Pertandingan : "+ statusSuit)
            // disable button refresh dan button suit lain
            // random computer
            // set result winner , draw , lose
        }

        playerGunting.setOnClickListener {
            pilihanPlayer =2
            Log.d(MainActivity::class.java.simpleName,"Player Memilih Gunting")
            playerBatu.setBackgroundColor(Color.WHITE)
            playerGunting.setBackgroundColor(Color.parseColor("#C3DAE9"))
            playerKertas.setBackgroundColor(Color.WHITE)
            val randomValues = (1..3).shuffled().last()
            pilihanComputer = computerPick(randomValues,computerBatu,computerGunting,computerKertas)
            var tempPilihanComputer= ""
            if(pilihanComputer == 1) {
                tempPilihanComputer= "Batu"
            }
            else if(pilihanComputer == 2) {
                tempPilihanComputer= "Gunting"
            }
            else if(pilihanComputer == 3) {
                tempPilihanComputer= "Kertas"
            }
            Log.d(MainActivity::class.java.simpleName, "Computer Memilih : "+ tempPilihanComputer + " (" + pilihanComputer.toString() + ")")
            var statusSuit = battleSuit(pilihanPlayer,pilihanComputer,statusBattle)
            Log.d(MainActivity::class.java.simpleName, "Hasil Pertandingan : "+ statusSuit)
        }

        playerKertas.setOnClickListener {
            pilihanPlayer =3
            Log.d(MainActivity::class.java.simpleName,"Player Memilih Kertas")
            playerBatu.setBackgroundColor(Color.WHITE)
            playerGunting.setBackgroundColor(Color.WHITE)
            playerKertas.setBackgroundColor(Color.parseColor("#C3DAE9"))
            val randomValues = (1..3).shuffled().last()
            pilihanComputer = computerPick(randomValues,computerBatu,computerGunting,computerKertas)
            var tempPilihanComputer= ""
            if(pilihanComputer == 1) {
                tempPilihanComputer= "Batu"
            }
            else if(pilihanComputer == 2) {
                tempPilihanComputer= "Gunting"
            }
            else if(pilihanComputer == 3) {
                tempPilihanComputer= "Kertas"
            }
            Log.d(MainActivity::class.java.simpleName, "Computer Memilih : "+ tempPilihanComputer + " (" + pilihanComputer.toString() + ")")
            var statusSuit = battleSuit(pilihanPlayer,pilihanComputer,statusBattle)
            Log.d(MainActivity::class.java.simpleName, "Hasil Pertandingan : "+ statusSuit)
        }

        refresh.setOnClickListener {
            Log.d(MainActivity::class.java.simpleName, "Refresh dilakukan")
            statusBattle.setText("VS")
            statusBattle.setBackgroundColor(Color.parseColor("#FFFFFF"))
            statusBattle.setTextColor(Color.parseColor("#d80024"))
            statusBattle.setRotation(-15f)
            statusBattle.setTextSize(48f)
            pilihanComputer = 0
            pilihanPlayer= 0
            computerBatu.setBackgroundColor(Color.WHITE)
            computerGunting.setBackgroundColor(Color.WHITE)
            computerKertas.setBackgroundColor(Color.WHITE)
            playerBatu.setBackgroundColor(Color.WHITE)
            playerGunting.setBackgroundColor(Color.WHITE)
            playerKertas.setBackgroundColor(Color.WHITE)
        }
    }
    private fun computerPick(parameterRandom : Int ,paramComputerBatu : ImageView, paramComputerGunting: ImageView, paramComputerKertas : ImageView): Int {
        var pilihanComputer = 0
        if(parameterRandom == 1) {
            pilihanComputer = 1
            paramComputerBatu.setBackgroundColor(Color.parseColor("#C3DAE9"))
            paramComputerGunting.setBackgroundColor(Color.WHITE)
            paramComputerKertas.setBackgroundColor(Color.WHITE)
        }
        else if(parameterRandom == 2) {
            pilihanComputer = 2
            paramComputerBatu.setBackgroundColor(Color.WHITE)
            paramComputerGunting.setBackgroundColor(Color.parseColor("#C3DAE9"))
            paramComputerKertas.setBackgroundColor(Color.WHITE)
        }
        else if(parameterRandom == 3) {
            pilihanComputer = 3
            paramComputerBatu.setBackgroundColor(Color.WHITE)
            paramComputerGunting.setBackgroundColor(Color.WHITE)
            paramComputerKertas.setBackgroundColor(Color.parseColor("#C3DAE9"))
        }
        else{
            pilihanComputer = 0
            paramComputerBatu.setBackgroundColor(Color.WHITE)
            paramComputerGunting.setBackgroundColor(Color.WHITE)
            paramComputerKertas.setBackgroundColor(Color.WHITE)
        }
        return pilihanComputer
    }

    private fun battleSuit(playerPick : Int , computerPick : Int , statusBattle: TextView): String {
        var status= ""
        if(playerPick == 1) {
            if(computerPick == 1) {
                status="DRAW"
                statusBattle.setText(status)
                statusBattle.setBackgroundColor(Color.parseColor("#0070C0"))
                statusBattle.setTextColor(Color.parseColor("#FFFFFF"))
                statusBattle.setRotation(-15f)
                statusBattle.setTextSize(24f)
            }
            else if(computerPick == 2) {
                status= "Pemain 1 MENANG!"
                statusBattle.setText(status)
                statusBattle.setBackgroundColor(Color.parseColor("#92D050"))
                statusBattle.setTextColor(Color.parseColor("#FFFFFF"))
                statusBattle.setRotation(-15f)
                statusBattle.setTextSize(24f)
            }
            else if(computerPick == 3){
                status= "Pemain 2 MENANG!"
                statusBattle.setText(status)
                statusBattle.setBackgroundColor(Color.parseColor("#92D050"))
                statusBattle.setTextColor(Color.parseColor("#FFFFFF"))
                statusBattle.setRotation(-15f)
                statusBattle.setTextSize(24f)
            }
            else {
                status= "Something Went Wrong , Please Try Again"
            }
        }
        else if(playerPick == 2) {
            if(computerPick == 1) {
                status="Pemain 2 MENANG!"
                statusBattle.setText(status)
                statusBattle.setBackgroundColor(Color.parseColor("#92D050"))
                statusBattle.setTextColor(Color.parseColor("#FFFFFF"))
                statusBattle.setRotation(-15f)
                statusBattle.setTextSize(24f)
            }
            else if(computerPick == 2) {
                status= "DRAW"
                statusBattle.setText(status)
                statusBattle.setBackgroundColor(Color.parseColor("#0070C0"))
                statusBattle.setTextColor(Color.parseColor("#FFFFFF"))
                statusBattle.setRotation(-15f)
                statusBattle.setTextSize(24f)
            }
            else if(computerPick == 3){
                status= "Pemain 1 MENANG!"
                statusBattle.setText(status)
                statusBattle.setBackgroundColor(Color.parseColor("#92D050"))
                statusBattle.setTextColor(Color.parseColor("#FFFFFF"))
                statusBattle.setRotation(-15f)
                statusBattle.setTextSize(24f)
            }
            else {
                status= "Something Went Wrong , Please Try Again"
            }
        }
        else if(playerPick == 3) {
            if(computerPick == 1) {
                status="Pemain 1 MENANG!"
                statusBattle.setText(status)
                statusBattle.setBackgroundColor(Color.parseColor("#92D050"))
                statusBattle.setTextColor(Color.parseColor("#FFFFFF"))
                statusBattle.setRotation(-15f)
                statusBattle.setTextSize(24f)
            }
            else if(computerPick == 2) {
                status= "Pemain 2 MENANG!"
                statusBattle.setText(status)
                statusBattle.setBackgroundColor(Color.parseColor("#92D050"))
                statusBattle.setTextColor(Color.parseColor("#FFFFFF"))
                statusBattle.setRotation(-15f)
                statusBattle.setTextSize(24f)
            }
            else if(computerPick == 3){
                status= "DRAW"
                statusBattle.setText(status)
                statusBattle.setBackgroundColor(Color.parseColor("#0070C0"))
                statusBattle.setTextColor(Color.parseColor("#FFFFFF"))
                statusBattle.setRotation(-15f)
                statusBattle.setTextSize(24f)
            }
            else {
                status= "Something Went Wrong , Please Try Again"
            }
        }
        else{
            status= "Something Went Wrong , Please Try Again"
        }

        return status
    }
}