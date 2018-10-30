package com.example.proteco.clase6


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*


class SPFragment : Fragment() {

    private lateinit var textView : TextView
    private lateinit var editText: EditText
    private lateinit var applyTextButton: Button
    private lateinit var saveDataButton: Button
    private lateinit var switch: Switch

    private val SHARED_PREFERENCES = "sharedPrefs"
    private val TEXT = "text"
    private val SWITCH = "switch"

    private var text : String = ""
    private var switchOnOff = false


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_s,container,false)
        textView = view.findViewById(R.id.tv_fragmentSP_tv)
        editText = view.findViewById(R.id.et_fragmentSP_edit_text)
        applyTextButton = view.findViewById(R.id.button_fragmentSP_view_data)
        saveDataButton = view.findViewById(R.id.button_fragmentSP_save_data)
        switch = view.findViewById(R.id.switch_1)

        applyTextButton.setOnClickListener {

            if(editText.text.toString().isNotEmpty()){
                textView.text = editText.text.toString();
            }

            saveDataButton.setOnClickListener {

                saveData()

            }

        }
        return view
    }

    private fun saveData(){

        val sharedPreferences = activity?.getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE)

        with(sharedPreferences.edit()){
            if(editText.text.toString().isNotEmpty()){
                putString(TEXT,editText.text.toString())
            }else{
                putString(TEXT,textView.text.toString())
            }

            putBoolean(SWITCH,switch.isChecked)

            apply()
            Toast.makeText(activity,"Data saved",Toast.LENGTH_SHORT)

        }

    }

    private fun loadData(){
        val sharedPreferences = activity?.getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE)
        text = sharedPreferences.getString(TEXT,"")
        switchOnOff = sharedPreferences.getBoolean(SWITCH,false)

        textView.text = text


    }

}
