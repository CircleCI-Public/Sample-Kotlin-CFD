package com.samplekotlincfd

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
 * Use the [Cart.newInstance] factory method to
 * create an instance of this fragment.
 */
class Cart : Fragment() {
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
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args: CartArgs by navArgs()
        var costs = args.cost
        var foodItems = args.foodItems

        foodItems.size

        var foodList = ""
        for(i in 0 .. costs.size - 1) {
            var currentCost = costs[i]
            var currentFood = foodItems[i]
            foodList = foodList + "$currentFood                $$currentCost \n"
        }
        view.findViewById<TextView>(R.id.cart_items).text = foodList
        var cost = 0
        for(i in costs!!)
        {
            cost += i
        }
        var totalCost = "Total: $$cost"
        view.findViewById<TextView>(R.id.cart_total).text = totalCost

        view.findViewById<Button>(R.id.empty_button).setOnClickListener {
            val MenuAction = CartDirections.actionCartToMenu()
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
         * @return A new instance of fragment Cart.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Cart().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}