package com.pepivsky.fragmentsynavigationcomponent

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize //hagregando Parcelize para que los objetos creados puedan ser enviados por intents (es necesario agregar el plugin en el graddle)
data class Persona(val nombre: String, val apellido: String) : Parcelable //hereda de parcelable
