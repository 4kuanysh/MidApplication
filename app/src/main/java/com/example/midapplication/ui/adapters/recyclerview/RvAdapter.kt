package com.example.midapplication.ui.adapters.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.midapplication.R
import com.example.midapplication.data.entities.fact.FactResponse
import kotlinx.android.synthetic.main.layout_fact_item.view.*

class RvAdapter: RecyclerView.Adapter<RvAdapter.RvViewHolder>() {

    private val facts = ArrayList<FactResponse.All>()

    fun setFacts(data: List<FactResponse.All>) {
        facts.clear()
        facts.addAll(data)

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvViewHolder {
        return RvViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_fact_item, parent, false))
    }

    override fun getItemCount(): Int = facts.size

    override fun onBindViewHolder(holder: RvViewHolder, position: Int) {
        holder.bindView(facts[position])
    }

    inner class RvViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(fact: FactResponse.All) {
            with(itemView) {
                type.text = fact.type
                text.text = fact.text
            }
        }
    }
}