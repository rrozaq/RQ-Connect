package id.credeva.rqconnect.data.adapter.payment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import id.credeva.rqconnect.R
import id.credeva.rqconnect.data.db.entities.payment.Late
import id.credeva.rqconnect.databinding.ItemLateBinding

class LateAdapter(
    private val late: List<Late>
) : RecyclerView.Adapter<LateAdapter.LateViewHolder>() {

    override fun getItemCount() = late.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = LateViewHolder(
        DataBindingUtil.inflate<ItemLateBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_late,
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: LateViewHolder, position: Int) {
        holder.itemLateBinding.late = late[position]
    }

    inner class LateViewHolder(
        val itemLateBinding: ItemLateBinding
    ) : RecyclerView.ViewHolder(itemLateBinding.root)

}