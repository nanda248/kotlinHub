package com.example.nanda.kotlinhub.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nanda.kotlinhub.R
import kotlinx.android.synthetic.main.fragment_home_view.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class home_view : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home_view, container, false)

        val view: View = inflater!!.inflate(R.layout.fragment_home_view, container, false)

        view.btn_basic_concept.setOnClickListener {

        }

        return view
    }

}
