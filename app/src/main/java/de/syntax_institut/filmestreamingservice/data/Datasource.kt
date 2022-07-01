package de.syntax_institut.filmestreamingservice.data

import android.content.Context

/**
 * Diese Klasse bereitet Daten aus den Ressourcen auf
 */
class Datasource(private val context: Context) {

    private val nrOfImages = 14 // anpassen, wenn Anzahl an Bildern geändert wurde
    private val numberOfTitles = 30 // anpassen, wenn Anzahl an Filmtiteln geändert wurde

    /**
     * Diese Funktion holt die Titel & Bilder aus der Quelldatei
     * und liefert eine Liste aus Filmen zurück
     */
    fun loadMovies(): List<de.syntax_institut.filmestreamingservice.data.model.Movie> {
        // Die Liste an Filmen
        // TODO Schreibe hier deinen Code
        val movieTitles = mutableListOf<de.syntax_institut.filmestreamingservice.data.model.Movie>()

        // Befülle die Liste
        // TODO Schreibe hier deinen Code
        for (index in 1..numberOfTitles) {
            val images = getImage(getTitle(index))
            val text = getTitle(index)
            movieTitles.add(
                de.syntax_institut.filmestreamingservice.data.model.Movie(text, images)

            )
        }


        // Liefere die Liste zurück
        return movieTitles
    }

    /**
     * Diese Funktion liefert den Titel Nummer index aus der Quelle
     */
    private fun getTitle(index: Int): Int {
        return context.resources.getIdentifier(
            "movieTitle$index",
            "string",
            context.packageName
        )
    }

    /**
     * Diese Funktion liefert zu jedem übergebenen Titel das entsprechende Bild
     */
    private fun getImage(titleRes: Int): Int {

        // Hole den Titel aus den Ressourcen
        val title = context.getString(titleRes).lowercase()
            .replace(" ", "_")
            .replace("ü", "_")
            .replace("ö", "_")

        // Liefere das entsprechende Bild aus der Quelle
        return context.resources.getIdentifier(
            title,
            "drawable",
            context.packageName
        )
    }
}
