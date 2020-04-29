package org.wit.diabeticapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.wit.diabeticapp.R
import org.wit.diabeticapp.main.DiabeticApp
import org.wit.diabeticapp.models.DiabeticModel
import org.wit.diabeticapp.utils.*
import java.util.HashMap
import android.view.View as View1

class HomeFragment : Fragment(), AnkoLogger {

    lateinit var app: DiabeticApp
    lateinit var loader : AlertDialog
    lateinit var eventListener : ValueEventListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        app = activity?.application as DiabeticApp
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View1? {

        val root = inflater.inflate(R.layout.fragment_home, container, false)
        loader = createLoader(activity!!)
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
            val display = InfoNo.text.toString()
            val level = Level.text.toString()
            writeNewDiabetic(DiabeticModel(display = display, level = level, email = app.auth.currentUser?.email))

        }
    }

    override fun onPause() {
        super.onPause()
        app.database.child("user-diabetics")
            .child(app.auth.currentUser!!.uid)
            .removeEventListener(eventListener)
    }

    fun writeNewDiabetic(diabetic: DiabeticModel) {
        showLoader(loader, "Adding Diabetic to Firebase")
        info("Firebase DB Reference : $app.database")
        val uid = app.auth.currentUser!!.uid
        val key = app.database.child("diabetics").push().key
        if (key == null) {
            info("Firebase Error : Key Empty")
            return
        }
        diabetic.uid = key
        val diabeticValues = diabetic.toMap()

        val childUpdates = HashMap<String, Any>()
        childUpdates["/diabetics/$key"] = diabeticValues
        childUpdates["/user-diabetics/$uid/$key"] = diabeticValues

        app.database.updateChildren(childUpdates)
        hideLoader(loader)
    }


}
