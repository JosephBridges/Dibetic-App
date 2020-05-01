package org.wit.diabeticapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.diabetic_card.view.*
import org.wit.diabeticapp.R
import org.wit.diabeticapp.models.DiabeticModel
import jp.wasabeef.picasso.transformations.CropCircleTransformation

interface DiabeticListener {
    fun onDiabeticClick(diabetic: DiabeticModel)
}

//Creating the DiabeticAdapter Class
class DiabeticAdapter constructor(var diabetics: ArrayList<DiabeticModel>,
                                  private val listener: DiabeticListener, infoall: Boolean)
    : RecyclerView.Adapter<DiabeticAdapter.MainHolder>() {

    val infoAll = infoall

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
        holder.bind(diabetic,listener,infoAll)
    }

    override fun getItemCount(): Int = diabetics.size

    fun removeAt(position: Int) {
        diabetics.removeAt(position)
        notifyItemRemoved(position)
    }

    class MainHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(diabetic: DiabeticModel, listener: DiabeticListener, infoAll: Boolean) {
            itemView.tag = diabetic
            itemView.infoNo.text = diabetic.display
            itemView.level.text = diabetic.level
            itemView.imageIcon.setImageResource(R.mipmap.ic_launcher_round)
            itemView.setOnClickListener { listener.onDiabeticClick(diabetic) }

            if(!infoAll)
                itemView.setOnClickListener { listener.onDiabeticClick(diabetic) }

            if(!diabetic.profilepic.isEmpty()) {
                Picasso.get().load(diabetic.profilepic.toUri())
                    //.resize(180, 180)
                    .transform(CropCircleTransformation())
                    .into(itemView.imageIcon)
            }

        }
    }
}