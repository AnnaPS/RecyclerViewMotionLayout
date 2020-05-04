package com.novadev.recycleranimationpoc

import android.graphics.Outline
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewOutlineProvider
import com.novadev.recycleranimationpoc.extension.toPx
import com.novadev.recycleranimationpoc.model.MovieEntity
import com.novadev.recycleranimationpoc.recycler.MovieAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.movie_item_header.view.*

class MainActivity : AppCompatActivity(),
MovieAdapter.OnMovieClicked{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView() {
//        rvMovies.update(getList(), this)

        val radius = 12F.toPx(this)
        ivHeader.outlineProvider = object : ViewOutlineProvider() {
            override fun getOutline(view: View, outline: Outline) {
                outline.setRoundRect(0, -radius.toInt(), view.width, view.height, radius)
            }
        }
        ivHeader.clipToOutline = true

        ivItem.outlineProvider = object : ViewOutlineProvider() {
            override fun getOutline(view: View, outline: Outline) {
                outline.setRoundRect(0, -radius.toInt(), view.width, view.height, radius)
            }
        }
        ivItem.clipToOutline = true
        ivItem2.outlineProvider = object : ViewOutlineProvider() {
            override fun getOutline(view: View, outline: Outline) {
                outline.setRoundRect(0, -radius.toInt(), view.width, view.height, radius)
            }
        }
        ivItem2.clipToOutline = true
    }

    override fun onMovieClicked(movieEntity: MovieEntity) {

    }

    private fun getList(): MutableList<MovieEntity>{
        var movieList = mutableListOf<MovieEntity>()

        movieList.add(MovieEntity("Avengers: Endgame",
            "Joe Russo, Anthony Russo",
            "Los Vengadores restantes deben encontrar una manera de recuperar a sus aliados para un " +
                    "enfrentamiento épico con Thanos, el malvado que diezmó el planeta y el universo.",
            android.R.color.holo_blue_dark))

        movieList.add(MovieEntity("Star Wars: Episodio IX - El ascenso de Skywalker",
            "J. J. Abrams",
            "La Resistencia sobreviviente se enfrenta a la Primera Orden, y Rey, Finn, Poe y el resto de los " +
                    "héroes encararán nuevos retos y una batalla final con la sabiduría de las generaciones anteriores.",
            android.R.color.holo_red_dark))

        movieList.add(MovieEntity("Bad Boys for Life",
            "Bilall Fallah, Adil El Arbi",
            "Los policías de la vieja escuela Mike Lowery y Marcus Burnett vuelven a " +
                    "patrullar juntos para derrotar al líder vicioso de un cartel de drogas de Miami." +
                    " El recién creado equipo de élite AMMO del departamento de policía de Miami junto" +
                    " con Mike y Marcus se enfrentan al despiadado Armando Armas.",
            android.R.color.holo_orange_dark))

        movieList.add(MovieEntity("Aves de presa",
            "Cathy Yan",
            "Después de separarse de Joker, Harley Quinn y otras tres heroínas, Canario Negro, " +
                    "Cazadora y Renée Montoya, unen sus fuerzas para salvar a una niña del malvado" +
                    " rey del crimen Máscara Negra.",
            android.R.color.holo_purple))
        movieList.add(MovieEntity("Black Widow",
            "Cate Shortland",
            "Al nacer, la Viuda Negra, también conocida como Natasha Romanova, se entrega a " +
                    "la KGB para convertirse en su agente definitivo. Cuando la URSS se separa, " +
                    "el gobierno intenta matarla mientras la acción se traslada a la actual Nueva York.",
            android.R.color.holo_green_dark))

        return movieList
    }
}
