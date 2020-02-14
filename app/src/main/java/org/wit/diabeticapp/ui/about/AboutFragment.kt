package org.wit.diabeticapp.ui.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.wit.diabeticapp.R
import org.wit.diabeticapp.R.layout.fragment_about

//1
class AboutFragment : Fragment() {

    //2
    companion object {

        fun newInstance(): AboutFragment {
            return AboutFragment()
        }
    }

    //3
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(fragment_about, container, false)
    }

}

