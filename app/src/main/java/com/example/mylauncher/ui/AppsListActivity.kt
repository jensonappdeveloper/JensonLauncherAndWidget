package com.example.mylauncher.ui

import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.ResolveInfo
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mylauncher.adapter.AppListAdapter
import com.example.mylauncher.databinding.ActivityAppsListBinding
import com.example.mylauncher.model.Item


class AppsListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAppsListBinding
    private lateinit var manager : PackageManager
    private lateinit var apps : ArrayList<Item>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppsListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadApps()
        loadListView()
    }


    private fun loadApps() {
        apps = ArrayList<Item>()
        manager = this.packageManager
        val intent = Intent(Intent.ACTION_MAIN, null)
        intent.addCategory(Intent.CATEGORY_LAUNCHER)

        try{
            val availableActivities : List<ResolveInfo>  = manager.queryIntentActivities(intent,0)

        availableActivities.forEach {
            var app: Item= Item(it.activityInfo.packageName,it.loadLabel(manager).toString(),it.loadIcon(manager))
            apps.add(app)
        }

        }catch (e:Exception){
            Log.d("CheckApps",e.message.toString())
        }
    }

    private fun loadListView() {
        val adapter = AppListAdapter(apps, this)
        binding.appList.layoutManager = GridLayoutManager(this,4)
        binding.appList.setHasFixedSize(true)
        binding.appList.adapter = adapter
    }


    fun onItemClickListener(itemlabel: String) {
        val mainIntent: Intent? = manager.getLaunchIntentForPackage(itemlabel)
        startActivity(mainIntent)
    }

}