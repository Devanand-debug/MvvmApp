package com.example.myapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.adapter.PostDataAdapter
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.viewmodel.PostViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding

    val viewModel : PostViewModel by viewModels<PostViewModel>()
    private lateinit var adapter : PostDataAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        binding.progressBar.visibility = View.VISIBLE
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel._userData.observe(viewLifecycleOwner) {
            binding.progressBar.visibility = View.GONE
            val dataList = it.toList()

            adapter = PostDataAdapter(dataList)
            binding.rv.layoutManager = LinearLayoutManager(requireContext())
            binding.rv.adapter = adapter

        }
    }

}