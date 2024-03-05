package com.example.tabmenu.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tabmenu.R
import com.example.tabmenu.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        // URL de la imagen de portada y del usuario (reemplaza con tus URLs reales)
        val coverImageUrl = "https://picsum.photos/400/200" // Ejemplo de URL de portada
        val userImageUrl = "https://picsum.photos/70" // Ejemplo de URL de imagen de usuario

        // Cargar la imagen de portada
        Glide.with(this)
            .load(coverImageUrl)
            .centerCrop()
            .into(binding.coverImage)

        // Cargar la imagen de usuario (circular)
        Glide.with(this)
            .load(userImageUrl)
            .circleCrop()
            .into(binding.userImage)

        return view
    }


        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myDataset = arrayOf("Categoría 1", "Categoría 2", "Categoría 3", "Categoría 3", "Categoría 3", "Categoría 3" ,"Categoría 3","Categoría 3" ,"Categoría 3" ,"Categoría 3" ,"Categoría 3" ,"Categoría 3" ,"Categoría 3")

        viewManager = LinearLayoutManager(context)
        viewAdapter = CardsAdapter(myDataset)

        recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}