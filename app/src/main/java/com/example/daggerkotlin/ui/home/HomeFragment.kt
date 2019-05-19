package com.example.daggerkotlin.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.daggerkotlin.MyApplication
import com.example.daggerkotlin.R
import com.example.daggerkotlin.di.component.DaggerFragmentComponent
import com.example.daggerkotlin.di.module.FragmentModule
import kotlinx.android.synthetic.main.fragment_home.view.*
import javax.inject.Inject

class HomeFragment : Fragment(){



    companion object {

        const val TAG : String = "HomeFragment"
        //val TAG = "HomeFragment"

        fun newInstance(): HomeFragment{

            val args = Bundle()
            val fragment = HomeFragment()
            fragment.arguments = args
            return fragment
        }
    }

    private lateinit var dataTv: TextView

    @Inject
    lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        getDependencies()
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(view)
    }

    private fun init(view: View){

        dataTv = view.findViewById(R.id.tv_message)
        dataTv.text = homeViewModel.getSomeData()
    }

    private fun getDependencies(){
        DaggerFragmentComponent
            .builder()
            .applicationComponent(
                (context!!
                    .applicationContext as MyApplication).applicationComponent
            )
            .fragmentModule(FragmentModule(this))
            .build()
            .inject(this)

        Log.d("DEBUG", homeViewModel.toString())
    }

}