package com.example.samplekotlincfd

import android.os.Bundle
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
 * Use the [Pizza.newInstance] factory method to
 * create an instance of this fragment.
 */
class Pizza : Fragment() {
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
        return inflater.inflate(R.layout.fragment_pizza, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args: PizzaArgs by navArgs()

        var pizza_quantity =
            view.findViewById<TextView>(R.id.pizza_quantity).text.toString().toInt()
        view.findViewById<Button>(R.id.pizza_minus_button).setOnClickListener {
            if (pizza_quantity <= 1) {

                pizza_quantity = 1
            } else {
                pizza_quantity -= 1
            }
            view.findViewById<TextView>(R.id.pizza_quantity).text = pizza_quantity.toString()
        }
        view.findViewById<Button>(R.id.pizza_plus_button).setOnClickListener {
            pizza_quantity += 1
            view.findViewById<TextView>(R.id.pizza_quantity).text = pizza_quantity.toString()
        }

        view.findViewById<Button>(R.id.add_to_cart_pizza).setOnClickListener {
            var foodItems = arrayOf<String>()
            var cost = intArrayOf()
            for (i in 1..pizza_quantity)
            {
                foodItems += "pizza"
                cost += 8
            }
            val MenuAction = PizzaDirections.actionPizzaToCart(cost, foodItems)
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
         * @return A new instance of fragment Pizza.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Pizza().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}