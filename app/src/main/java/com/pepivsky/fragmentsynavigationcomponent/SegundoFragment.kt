package com.pepivsky.fragmentsynavigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.pepivsky.fragmentsynavigationcomponent.databinding.FragmentSegundoBinding


class SegundoFragment : Fragment() {

    private lateinit var binding: FragmentSegundoBinding //binding
    private lateinit var nombre: String

    private var persona: Persona? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_segundo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSegundoBinding.bind(view)

        //cachar el bundle que viene en los arguments
        arguments?.let {
            nombre = it.getString("name").toString()
            persona = it.getParcelable("persona") //recibiendo el objeto persona por los arugments
        }

        Toast.makeText(context, "${persona?.nombre} ${persona?.apellido}", Toast.LENGTH_SHORT).show()

        //setenado el nombre
        binding.tvNombre.text = nombre

        //navegacion con boton
        binding.btnGotoFragment3.setOnClickListener {
            findNavController().navigate(R.id.action_segundoFragment_to_tercerFragment) //accion de ir del segundo al tercer fragment
        }
    }


}