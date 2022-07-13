package com.example.poeoptimaltrade.price

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.*
import androidx.lifecycle.Observer
import com.example.poeoptimaltrade.R
import com.example.poeoptimaltrade.database.PoeTradeDatabase

import com.example.poeoptimaltrade.databinding.FragmentPriceBinding
import kotlinx.coroutines.launch

class PriceFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        val binding = DataBindingUtil.inflate<FragmentPriceBinding>(
            inflater, R.layout.fragment_price, container, false)

        val application = requireNotNull(this.activity).application
        val dataSource = PoeTradeDatabase.getInstance(application)
        val arguments = PriceFragmentArgs.fromBundle(requireArguments())
        val viewModelFactory = PriceViewModelFactory(arguments.categoryId,  dataSource, application)
        val priceViewModel = ViewModelProvider(this, viewModelFactory).get(PriceViewModel::class.java)

        val adapter = PriceAdapter(arguments.categoryId)
        binding.lifecycleOwner = this
        binding.priceViewModel = priceViewModel
        binding.priceList.adapter = adapter
        priceViewModel.getData()
        adapter.submitList(priceViewModel.data)

        priceViewModel.categoryData.observe(viewLifecycleOwner, Observer {
            it.let {
                priceViewModel.getData()
                adapter.submitList(priceViewModel.data)
            }
        }
        )

        binding.editText.addTextChangedListener {
            val text = binding.editText.text.toString()

            adapter.submitList(priceViewModel.getSearchData(priceViewModel.data, text))
        }
        return binding.root
    }
}

//val currency = dataSource.currencyDao.getAllCurrencys()
/*currency.observe(viewLifecycleOwner, Observer {
    it.let {
        adapter.submitList(it)
        //adapter.submitList(it.sortedBy { it.standardPrice!! / it.leaguePrice!! }.asReversed())
    }
}
)*/