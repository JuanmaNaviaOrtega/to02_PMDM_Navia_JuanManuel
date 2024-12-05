package com.example.to02_pmdm_navia_juanmanuel.segundaApp.adapter


import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.to02_pmdm_navia_juanmanuel.R
import com.example.to02_pmdm_navia_juanmanuel.databinding.ItemSitioswebBinding
import com.example.to02_pmdm_navia_juanmanuel.segundaApp.sitiosWebs
class viewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val binding = ItemSitioswebBinding.bind(view)
    val sitioWebName = view.findViewById<TextView>(R.id.tvSitioWebName)
    val sitioWebLink = view.findViewById<TextView>(R.id.tvSitioWebLink)
    val sitioWebPhoto = view.findViewById<ImageView>(R.id.ivSitioWeb)
    val btnDelete = view.findViewById<ImageButton>(R.id.btnDelete)

    fun render(
        sitiosWebsModel: sitiosWebs,
        onClickListener: (sitiosWebs) -> Unit,
        onClickDelete: (Int) -> Unit
    ) {
        sitioWebName.text = sitiosWebsModel.name
        sitioWebLink.text = sitiosWebsModel.link
        Glide.with(sitioWebPhoto.context).load(sitiosWebsModel.photo).into(sitioWebPhoto)
        btnDelete.setOnClickListener { onClickDelete(adapterPosition) }
        itemView.setOnClickListener { onClickListener(sitiosWebsModel) }
    }
}
