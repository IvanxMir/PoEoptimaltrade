package com.example.poeoptimaltrade.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.poeoptimaltrade.R
import com.example.poeoptimaltrade.database.PoeTradeDatabase
import com.example.poeoptimaltrade.databinding.FragmentCategoriesBinding

class CategoriesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        val binding = DataBindingUtil.inflate<FragmentCategoriesBinding>(
            inflater, R.layout.fragment_categories, container, false)

        val application = requireNotNull(this.activity).application
        val dataSource = PoeTradeDatabase.getInstance(application)
        val viewModelFactory = CategoriesViewModelFactory(dataSource, application)
        val categoriesViewModel = ViewModelProvider(this, viewModelFactory).get(CategoriesViewModel::class.java)

        binding.lifecycleOwner = this
        binding.categoryViewModel = categoriesViewModel

        val adapter = CategoryAdapter(CategoryListener {
                categoryId -> categoriesViewModel.onCategoryClicked(categoryId)
        })

        binding.categoriesList.adapter = adapter
        binding.categoriesList.layoutManager = GridLayoutManager(activity, 2)

        categoriesViewModel.navigateToPrice.observe(viewLifecycleOwner, Observer { categoryId ->
            categoryId?.let {
                this.findNavController().navigate(CategoriesFragmentDirections.actionCategoriesFragmentToPriceFragment(categoryId))
                categoriesViewModel.onPriceNavigated()
            }
        })

        categoriesViewModel.categories.observe(viewLifecycleOwner, Observer {
            it.let {
                adapter.submitList(it)
            }
        })

        return binding.root
    }
}