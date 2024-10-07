package com.muhamaddafa.belajar_crud_firebase

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.muhamaddafa.belajar_crud_firebase.models.Mahasiswa
import org.w3c.dom.Text

class HomeFragment : Fragment() {

    private lateinit var  firebase: FirebaseDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        firebase = FirebaseDatabase.getInstance()
        firebase.reference.child("mahasiswa").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val data = snapshot.value
                Log.d("DataDP", data.toString())
            }
            override fun onCancelled(error: DatabaseError) {
                Log.e("Error", error.message)
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
}