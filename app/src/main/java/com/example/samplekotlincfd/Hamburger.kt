package com.samplekotlincfd

import android.os.Bundle
import android.os.Debug
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Hamburger.newInstance] factory method to
 * create an instance of this fragment.
 */
class Hamburger : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hamburger, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args: HamburgerArgs by navArgs()

        var burger_quantity = view.findViewById<TextView>(R.id.burger_quantity).text.toString().toInt()
        view.findViewById<Button>(R.id.burger_minus_button).setOnClickListener {
            if(burger_quantity  <= 1) {

                burger_quantity = 1
            }
            else {
                burger_quantity -= 1
            }
            view.findViewById<TextView>(R.id.burger_quantity).text = burger_quantity.toString()
        }
        view.findViewById<Button>(R.id.burger_plus_button).setOnClickListener {
            burger_quantity += 1
            view.findViewById<TextView>(R.id.burger_quantity).text = burger_quantity.toString()
        }

        view.findViewById<Button>(R.id.add_to_cart_burger).setOnClickListener {
            var foodItems = arrayOf<String>()
            var cost = intArrayOf()
            for (i in 1..burger_quantity)
            {
                foodItems += "hamburger"
                cost += 12
            }
            val MenuAction = HamburgerDirections.actionHamburgerToCart(cost, foodItems)
            findNavController().navigate(MenuAction)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Hamburger.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Hamburger().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}