package com.example.iftm.quiz

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.iftm.MainActivity
import com.example.iftm.databinding.FragmentBasicComputerQuizBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class BasicComputerQuizFragment : Fragment() {

    private lateinit var binding: FragmentBasicComputerQuizBinding
    private var basicComputerQuizModel: BasicComputerQuizModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBasicComputerQuizBinding.inflate(layoutInflater, container, false)

        val showBasicComputerQuizAdapter: ShowBasicComputerQuizAdapter

        (activity as MainActivity).binding.navigation.visibility = View.GONE

        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()


        val arrQuiz= ArrayList<BasicComputerQuizModel>()

        val firebaseDatabase = FirebaseDatabase.getInstance()

        firebaseDatabase.getReference("basicComputerQuiz").addValueEventListener(object :
            ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                arrQuiz?.clear()
                for(postSnapshot in snapshot.children){
                    basicComputerQuizModel = postSnapshot.getValue(BasicComputerQuizModel::class.java)
                    Log.i(ContentValues.TAG, "onCreateView: Data > " + postSnapshot.value)
                    arrQuiz?.add(basicComputerQuizModel!!)

                }
                binding.recyclerview.layoutManager = LinearLayoutManager(
                    context,
                    RecyclerView.VERTICAL,
                    false
                )

                binding.recyclerview.adapter = ShowBasicComputerQuizAdapter(arrQuiz!!,context)
            }
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
            }
        })



        return binding.root
    }
}