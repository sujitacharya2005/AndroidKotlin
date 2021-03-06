package com.sa.achitecuturalcomponents.fragmentbackbutton


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.sa.achitecuturalcomponents.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
private const val TAG =  "Fragment1"

class Fragment1 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return Button(activity).apply {
            setText("Fragment1")
            setBackgroundColor(resources.getColor(android.R.color.holo_purple))

            setOnClickListener{
                activity?.apply {
                    supportFragmentManager.apply {
                            beginTransaction().apply {
                                replace(R.id.container, Fragment2())
                                addToBackStack("Fragment2")
                                commit()
                            }
                    }
                }
            }
        }
    }


}
