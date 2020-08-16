package com.example.template.ui.page1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.template.databinding.FragmentHomeBinding
import com.example.template.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Page1Fragment : Fragment() {
    lateinit var _binding: FragmentHomeBinding

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val viewModel by activityViewModels<ViewModel>()
    private var mainAdapter: MainAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainAdapter = MainAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        _binding.recyclerview.adapter = mainAdapter
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.fetchCocktailList("margarita").observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is Resource.Loading -> {
                    _binding.progress.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    _binding.progress.visibility = View.GONE
                    if (true == result.data?.isEmpty()) {
                        return@Observer
                    }
                    mainAdapter?.setCocktailList(result.data ?: listOf())
                }
                is Resource.Failure -> {
                    _binding.progress.visibility = View.GONE
                    Toast.makeText(
                        requireContext(),
                        "Data cannot be found ${result.exception}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        })
    }
}