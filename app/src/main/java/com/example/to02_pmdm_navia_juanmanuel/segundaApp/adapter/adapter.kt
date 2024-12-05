package com.example.to02_pmdm_navia_juanmanuel.segundaApp.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.to02_pmdm_navia_juanmanuel.R
import com.example.to02_pmdm_navia_juanmanuel.segundaApp.sitiosWebs
class adapter(
    var sitiosWebList: List<sitiosWebs>,
    private val onClickListener: (sitiosWebs) -> Unit,
    private val onClickDelete: (Int) -> Unit
) : RecyclerView.Adapter<viewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return viewHolder(layoutInflater.inflate(R.layout.item_sitiosweb, parent, false))
    }

    override fun getItemCount(): Int {
        return sitiosWebList.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val item = sitiosWebList[position]
        holder.render(item, onClickListener, onClickDelete)
    }

    fun updateSitiosWebList(sitiosWebList: List<sitiosWebs>) {
        this.sitiosWebList = sitiosWebList
        notifyDataSetChanged()
    }
}
