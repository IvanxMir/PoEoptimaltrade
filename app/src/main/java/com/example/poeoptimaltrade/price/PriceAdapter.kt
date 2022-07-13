package com.example.poeoptimaltrade.price

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.poeoptimaltrade.database.entity.*
import com.example.poeoptimaltrade.databinding.PriceItemViewBinding

class PriceAdapter(val categoryId: Int): ListAdapter<Any, PriceItemViewHolder>(PriceDiffCallbackk()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PriceItemViewHolder {
        return PriceItemViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: PriceItemViewHolder, position: Int) {
        holder.bind(getItem(position), categoryId)
    }
}

class PriceItemViewHolder private constructor(val binding: PriceItemViewBinding):
      RecyclerView.ViewHolder(binding.root) {
    val priceImg: ImageView = binding.priceImg
    val priceName: TextView = binding.priceName
    val priceLeague: TextView = binding.priceLeague
    val priceStandard: TextView = binding.priceStandard
    val priceDifference:TextView = binding.priceDifference

    fun bind(item: Any, categoryId: Int) {
        when(categoryId) {
            1 -> if(item is Currency) bind(item)
            2 -> if(item is Fragment) bind(item)
            3 -> if(item is DivinationCard) bind(item)
            4 -> if(item is Scarab) bind(item)
            5 -> if(item is Fossil) bind(item)
            6 -> if(item is DeliriumOrb) bind(item)
            7 -> if(item is Oil) bind(item)
            8 -> if(item is Sentinel) bind(item)
            9 -> if(item is Beast) bind(item)
            10 -> if(item is Artifact) bind(item)
            11 -> if(item is Resonator) bind(item)
            12 -> if(item is Vial) bind(item)
        }
    }

    fun bind(item: Currency) {
        priceName.text = item.name.toString()
        priceLeague.text = item.leaguePrice.toString()
        priceStandard.text = item.standardPrice.toString()
        val difference = (item.standardPrice!! / item.leaguePrice!!) * 100
        priceDifference.text = difference.toInt().toString() + "%"
        Glide.with(binding.priceImg.context).load(item.img_url).into(priceImg)
    }

    fun bind(item: Fragment) {
        priceName.text = item.name.toString()
        priceLeague.text = item.leaguePrice.toString()
        priceStandard.text = item.standardPrice.toString()
        val difference = (item.standardPrice!! / item.leaguePrice!!) * 100
        priceDifference.text = difference.toInt().toString() + "%"
        Glide.with(binding.priceImg.context).load(item.img_url).into(priceImg)
    }

    fun bind(item: DivinationCard) {
        priceName.text = item.name.toString()
        priceLeague.text = item.leaguePrice.toString()
        priceStandard.text = item.standardPrice.toString()
        val difference = (item.standardPrice!! / item.leaguePrice!!) * 100
        priceDifference.text = difference.toInt().toString() + "%"
        Glide.with(binding.priceImg.context).load(item.img_url).into(priceImg)
    }

    fun bind(item: Scarab) {
        priceName.text = item.name.toString()
        priceLeague.text = item.leaguePrice.toString()
        priceStandard.text = item.standardPrice.toString()
        val difference = (item.standardPrice!! / item.leaguePrice!!) * 100
        priceDifference.text = difference.toInt().toString() + "%"
        Glide.with(binding.priceImg.context).load(item.img_url).into(priceImg)
    }

    fun bind(item: Fossil) {
        priceName.text = item.name.toString()
        priceLeague.text = item.leaguePrice.toString()
        priceStandard.text = item.standardPrice.toString()
        val difference = (item.standardPrice!! / item.leaguePrice!!) * 100
        priceDifference.text = difference.toInt().toString() + "%"
        Glide.with(binding.priceImg.context).load(item.img_url).into(priceImg)
    }

    fun bind(item: DeliriumOrb) {
        priceName.text = item.name.toString()
        priceLeague.text = item.leaguePrice.toString()
        priceStandard.text = item.standardPrice.toString()
        val difference = (item.standardPrice!! / item.leaguePrice!!) * 100
        priceDifference.text = difference.toInt().toString() + "%"
        Glide.with(binding.priceImg.context).load(item.img_url).into(priceImg)
    }

    fun bind(item: Oil) {
        priceName.text = item.name.toString()
        priceLeague.text = item.leaguePrice.toString()
        priceStandard.text = item.standardPrice.toString()
        val difference = (item.standardPrice!! / item.leaguePrice!!) * 100
        priceDifference.text = difference.toInt().toString() + "%"
        Glide.with(binding.priceImg.context).load(item.img_url).into(priceImg)
    }

    fun bind(item: Sentinel) {
        priceName.text = item.name.toString()
        priceLeague.text = item.leaguePrice.toString()
        priceStandard.text = item.standardPrice.toString()
        val difference = (item.standardPrice!! / item.leaguePrice!!) * 100
        priceDifference.text = difference.toInt().toString() + "%"
        Glide.with(binding.priceImg.context).load(item.img_url).into(priceImg)
    }

    fun bind(item: Beast) {
        priceName.text = item.name.toString()
        priceLeague.text = item.leaguePrice.toString()
        priceStandard.text = item.standardPrice.toString()
        val difference = (item.standardPrice!! / item.leaguePrice!!) * 100
        priceDifference.text = difference.toInt().toString() + "%"
        Glide.with(binding.priceImg.context).load(item.img_url).into(priceImg)
    }

    fun bind(item: Artifact) {
        priceName.text = item.name.toString()
        priceLeague.text = item.leaguePrice.toString()
        priceStandard.text = item.standardPrice.toString()
        val difference = (item.standardPrice!! / item.leaguePrice!!) * 100
        priceDifference.text = difference.toInt().toString() + "%"
        Glide.with(binding.priceImg.context).load(item.img_url).into(priceImg)
    }

    fun bind(item: Resonator) {
        priceName.text = item.name.toString()
        priceLeague.text = item.leaguePrice.toString()
        priceStandard.text = item.standardPrice.toString()
        val difference = (item.standardPrice!! / item.leaguePrice!!) * 100
        priceDifference.text = difference.toInt().toString() + "%"
        Glide.with(binding.priceImg.context).load(item.img_url).into(priceImg)
    }

    fun bind(item: Vial) {
        priceName.text = item.name.toString()
        priceLeague.text = item.leaguePrice.toString()
        priceStandard.text = item.standardPrice.toString()
        val difference = (item.standardPrice!! / item.leaguePrice!!) * 100
        priceDifference.text = difference.toInt().toString() + "%"
        Glide.with(binding.priceImg.context).load(item.img_url).into(priceImg)
    }

    companion object {
        fun from(parent: ViewGroup): PriceItemViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = PriceItemViewBinding.inflate(layoutInflater, parent, false)
            return PriceItemViewHolder(binding)
        }
    }
}

class PriceDiffCallbackk: DiffUtil.ItemCallback<Any>() {
    override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean {
        if(oldItem is Currency && newItem is Currency && oldItem.currencyId == newItem.currencyId) return true
        if(oldItem is Fragment && newItem is Fragment && oldItem.id == newItem.id) return true
        if(oldItem is DivinationCard && newItem is DivinationCard && oldItem.id == newItem.id) return true
        if(oldItem is Scarab && newItem is Scarab && oldItem.id == newItem.id) return true
        if(oldItem is Fossil && newItem is Fossil && oldItem.id == newItem.id) return true
        if(oldItem is DeliriumOrb && newItem is DeliriumOrb && oldItem.id == newItem.id) return true
        if(oldItem is Oil && newItem is Oil && oldItem.id == newItem.id) return true
        if(oldItem is Sentinel && newItem is Sentinel && oldItem.id == newItem.id) return true
        if(oldItem is Beast && newItem is Beast && oldItem.id == newItem.id) return true
        if(oldItem is Artifact && newItem is Artifact && oldItem.id == newItem.id) return true
        if(oldItem is Resonator && newItem is Resonator && oldItem.id == newItem.id) return true
        if(oldItem is Vial && newItem is Vial && oldItem.id == newItem.id) return true
        return false
    }

    override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean {
        if(oldItem is Currency && newItem is Currency && oldItem == newItem) return true
        if(oldItem is Fragment && newItem is Fragment && oldItem == newItem) return true
        if(oldItem is DivinationCard && newItem is DivinationCard && oldItem == newItem) return true
        if(oldItem is Scarab && newItem is Scarab && oldItem == newItem) return true
        if(oldItem is Fossil && newItem is Fossil && oldItem == newItem) return true
        if(oldItem is DeliriumOrb && newItem is DeliriumOrb && oldItem == newItem) return true
        if(oldItem is Oil && newItem is Oil && oldItem == newItem) return true
        if(oldItem is Sentinel && newItem is Sentinel && oldItem == newItem) return true
        if(oldItem is Beast && newItem is Beast && oldItem == newItem) return true
        if(oldItem is Artifact && newItem is Artifact && oldItem == newItem) return true
        if(oldItem is Resonator && newItem is Resonator && oldItem == newItem) return true
        if(oldItem is Vial && newItem is Vial && oldItem == newItem) return true
        return false
    }
}

/*class PriceAdapter(): ListAdapter<Currency, PriceItemViewHolder>(PriceDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PriceItemViewHolder {
        return PriceItemViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: PriceItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class PriceDiffCallback: DiffUtil.ItemCallback<Currency>() {
    override fun areItemsTheSame(oldItem: Currency, newItem: Currency): Boolean {
        return oldItem.currencyId == newItem.currencyId
    }

    override fun areContentsTheSame(oldItem: Currency, newItem: Currency): Boolean {
        return oldItem == newItem
    }
}
 */