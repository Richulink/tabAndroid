package com.example.tabmenu.ViewPager2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tabmenu.R

class Fragment2 : Fragment() {
    // Este método se llama cuando el sistema crea la vista de este Fragment
    override fun onCreateView(
        inflater: LayoutInflater, // El LayoutInflater que puedes usar para inflar cualquier vista en el Fragment
        container: ViewGroup?, // El ViewGroup padre al que se va a añadir la vista del Fragment después de inflarse
        savedInstanceState: Bundle? // Si no es nulo, este Fragment se está recreando a partir de un estado guardado anterior
    ): View? {
        // Infla el layout para este Fragment
        // R.layout.fragment_1 es la referencia al archivo XML del layout que acabamos de crear
        return inflater.inflate(R.layout.fragment_2, container, false)
    }
}