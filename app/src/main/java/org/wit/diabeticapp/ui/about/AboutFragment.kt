package org.wit.diabeticapp.ui.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.wit.diabeticapp.R

//1
class AboutFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        activity?.title = getString(R.string.aboutus_title)
        return inflater.inflate(R.layout.fragment_about, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            AboutFragment().apply {
                arguments = Bundle().apply { }
            }
    }
}

