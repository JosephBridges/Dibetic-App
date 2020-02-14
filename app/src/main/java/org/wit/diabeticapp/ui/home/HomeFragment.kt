package org.wit.diabeticapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.diabetic_card.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import org.wit.diabeticapp.R
import org.wit.diabeticapp.main.DiabeticApp
import org.wit.diabeticapp.models.DiabeticModel
import android.view.View as View1

class HomeFragment : Fragment() {

    lateinit var app: DiabeticApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        app = activity?.application as DiabeticApp
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View1? {

        val root = inflater.inflate(R.layout.fragment_home, container, false)
        activity?.title = getString(R.string.action_home)

        setButtonListener(root)
        return root;
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            HomeFragment().apply {
                arguments = Bundle().apply {}
            }
    }

    fun setButtonListener( layout: View1) {
        layout.homeButton.setOnClickListener {
            val displayno = (layout.InfoNo.text.isNotEmpty())
                layout.InfoNo.text.toString()
            app.diabeticStore.create(DiabeticModel(displayno = displayno.toString()))

        }
    }

}
