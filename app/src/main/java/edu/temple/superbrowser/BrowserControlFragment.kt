package edu.temple.superbrowser

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton

class BrowserControlFragment : Fragment() {


    private lateinit var pageButton : ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_browser_control, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        pageButton = view.findViewById(R.id.imageButton)

        pageButton.setOnClickListener{

            activity?.run{
                if(this is DataInterface)
                    (this as DataInterface).addPage()
            }

        }
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BrowserControlFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}