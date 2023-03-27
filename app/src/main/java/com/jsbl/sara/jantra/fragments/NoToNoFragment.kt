package com.jsbl.sara.jantra.fragments

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jsbl.sara.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [JantriFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NoToNoFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var rootView : View

    private lateinit  var bottomView: LinearLayout
    private lateinit  var bottomView2: LinearLayout
    lateinit var myViewHolderAdapter: RecyclerView.Adapter<MyViewHolder>
    private lateinit var recyclerView: RecyclerView
    private var dummyList = ArrayList<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_no_to_no, container, false)

        bottomView = rootView.findViewById(R.id.bottom_view_game)
        bottomView2 = rootView.findViewById(R.id.line)

        rootView.findViewById<Button>(R.id.add).setOnClickListener {
            dummyList.add("1")
            recyclerView.adapter!!.notifyDataSetChanged()
            checkIsListEmpty()

            val dialog = Dialog(requireContext())
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setCancelable(false)
            dialog.window!!.setBackgroundDrawableResource(R.drawable.white_round)
            dialog.setContentView(R.layout.bid_added_dialog_box)

            dialog.findViewById<TextView>(R.id.yes_dialog_box)
                .setOnClickListener { dialog.cancel() }

            dialog.show()
        }

        rootView.findViewById<Button>(R.id.final_submit).setOnClickListener {
            val dialog = Dialog(requireContext())
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setCancelable(false)
            dialog.window!!.setBackgroundDrawableResource(R.drawable.white_round)
            dialog.setContentView(R.layout.submit_game_dialog_box)

            dialog.findViewById<TextView>(R.id.cancel)
                .setOnClickListener { dialog.cancel() }

            dialog.findViewById<TextView>(R.id.submit)
                .setOnClickListener { dialog.cancel() }

            dialog.show()

        }

        checkIsListEmpty()
        setRecyclerView()


        return rootView
    }

    private fun checkIsListEmpty() {
        if(dummyList.isEmpty()){
            bottomView.visibility = View.GONE
            bottomView2.visibility = View.GONE
        }else{
            bottomView.visibility = View.VISIBLE
            bottomView2.visibility = View.VISIBLE
        }
    }

    private fun setRecyclerView() {

        recyclerView = rootView.findViewById(R.id.recyclerView)
        myViewHolderAdapter = object : RecyclerView.Adapter<MyViewHolder>() {
            override fun onCreateViewHolder(
                viewGroup: ViewGroup,
                ViewType: Int,
            ): MyViewHolder {
                return MyViewHolder(LayoutInflater.from(viewGroup.context)
                    .inflate(R.layout.blueprint_game_screen_items_without_status, viewGroup, false))
            }

            @SuppressLint("DefaultLocale", "SetTextI18n", "NotifyDataSetChanged",
                "UseCompatLoadingForDrawables")
            override fun onBindViewHolder(
                viewHolderRt: MyViewHolder,
                i: Int,
            ) {

                viewHolderRt.delete.setOnClickListener {
                    dummyList.removeAt(i)
                    recyclerView.adapter!!.notifyDataSetChanged()
                    checkIsListEmpty()
                }


            }

            override fun getItemCount(): Int {

                return dummyList.size
            }
        }

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        recyclerView.adapter = myViewHolderAdapter
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var delete: ImageView = itemView.findViewById(R.id.delete)
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            JantriFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}