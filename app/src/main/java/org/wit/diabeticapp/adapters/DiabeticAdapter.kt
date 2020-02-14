package org.wit.diabeticapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.diabetic_card.view.*
import org.wit.diabeticapp.R
import org.wit.diabeticapp.models.DiabeticModel

class DiabeticAdapter constructor(private var diabetics: List<DiabeticModel>)
    : RecyclerView.Adapter<DiabeticAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        return MainHolder(
            LayoutInflater.from(parent?.context).inflate(
                R.layout.diabetic_card,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val diabetic = diabetics[holder.adapterPosition]
        holder.bind(diabetic)
    }

    override fun getItemCount(): Int = diabetics.size

    class MainHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(diabetic: DiabeticModel) {
            itemView.paymentamount.text = diabetic.amount.toString()
            itemView.paymentmethod.text = diabetic.paymentmethod
            itemView.imageIcon.setImageResource(R.mipmap.ic_launcher_round)
        }
    }
}