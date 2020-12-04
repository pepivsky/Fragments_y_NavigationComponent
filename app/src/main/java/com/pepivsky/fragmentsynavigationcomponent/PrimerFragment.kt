package com.pepivsky.fragmentsynavigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.pepivsky.fragmentsynavigationcomponent.databinding.FragmentPrimerBinding


class PrimerFragment : Fragment() {

    private lateinit var binding: FragmentPrimerBinding //usando viewBinding (genera una clase y la instanciamos)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_primer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) { //metodo que se llama cuando la vista (el fragemnt ya esta creado)
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPrimerBinding.bind(view) //pasandole el view a binding para poder acceder a todos los recursos del fragment

        binding.btnGotoFragment2.setOnClickListener {
            val bundle = bundleOf("name" to "pepe") //clave valor en bundle

            //pasando un objeto como argumento
            val bundleConObjeto = Bundle()
            bundleConObjeto.putParcelable("persona", Persona("jose", "Paredes")) //enviando el objeto parcelable
            bundleConObjeto.putString("name", "pepe") //pasando tambien el string

            findNavController().navigate(R.id.action_primerFragment_to_segundoFragment, bundleConObjeto) //asignado la action de navegacion usando el nav graph y pasandole el bundle con los datos (pasa datos de fragment a fragment)
        }
    }




}