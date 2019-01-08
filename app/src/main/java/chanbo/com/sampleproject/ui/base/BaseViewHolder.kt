package chanbo.com.sampleproject.ui.base

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView

abstract class BaseViewHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

    abstract fun bind(position: Int)
}