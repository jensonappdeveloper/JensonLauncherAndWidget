package com.example.mylauncher.adapter


import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mylauncher.databinding.AppListRowBinding
import com.example.mylauncher.model.Item
import com.example.mylauncher.ui.AppsListActivity

class AppListAdapter (
    private var appsList: MutableList<Item>,
    private val clickListner: AppsListActivity
) :
    RecyclerView.Adapter<AppListAdapter.MyViewHolerView>() {

    class MyViewHolerView(binding: AppListRowBinding) : RecyclerView.ViewHolder(binding.root) {
        var appname = binding.appname
        var appicon = binding.appimage


        @SuppressLint("ResourceAsColor", "SetTextI18n", "SimpleDateFormat")
        fun initialize(
            item: Item,
            clickListner: AppsListActivity,
        ) {

            appname.setText(item.name)
            appicon.setImageDrawable(item.icon)

            itemView.setOnClickListener {
                clickListner.onItemClickListener(item.label)
            }


        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AppListAdapter.MyViewHolerView {
        val appRowBinding =
            AppListRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolerView(appRowBinding)
    }

    override fun onBindViewHolder(holder: AppListAdapter.MyViewHolerView, position: Int) {
        holder.initialize(appsList[position], clickListner)
    }

    override fun getItemCount(): Int {
        return appsList.size
    }
}