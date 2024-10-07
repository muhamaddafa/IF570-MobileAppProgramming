package com.muhamaddafa.belajar_crud_firebase

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import com.muhamaddafa.belajar_crud_firebase.databinding.ActivityMainBinding
import com.muhamaddafa.belajar_crud_firebase.databinding.FragmentStoreBinding
import com.muhamaddafa.belajar_crud_firebase.models.Mahasiswa

class StoreFragment : Fragment() {
    private var _binding: FragmentStoreBinding? = null
    private val binding get() = _binding!!
    private lateinit var firebase: FirebaseDatabase
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentStoreBinding.inflate(inflater, container, false)
        firebase = FirebaseDatabase.getInstance()
        val firebaseRef = firebase.reference.child("mahasiswa")

        binding.btnTambah.setOnClickListener {
            saveData()
        }

        return binding.root
    }

    private fun saveData() {
        val nim = binding.etNim.text.toString()
        val nama = binding.etNama.text.toString()

        if (nim.isEmpty() || nama.isEmpty()) {
            Toast.makeText(context, "Data tidak boleh kosong", Toast.LENGTH_SHORT).show()
        } else {
            val mahasiswa = Mahasiswa(null, nim, nama)
            val key = firebase.reference.child("mahasiswa").push().key
            if (key != null) {
                firebase.reference.child("mahasiswa").child(key).setValue(mahasiswa).addOnCompleteListener {
                    Toast.makeText(context, "Data berhasil disimpan", Toast.LENGTH_SHORT).show()
                    binding.etNim.text.clear()
                    binding.etNama.text.clear()
                }
            }
        }
    }
}