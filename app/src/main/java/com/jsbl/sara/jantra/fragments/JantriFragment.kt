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
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
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
class JantriFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var rootView : View

    private lateinit  var bottomView2: LinearLayout
    lateinit var myViewHolderAdapterJori: RecyclerView.Adapter<MyViewHolder>
    private lateinit var recyclerViewJori: RecyclerView


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
        rootView = inflater.inflate(R.layout.fragment_jantri, container, false)

        bottomView2 = rootView.findViewById(R.id.line)

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

        setRecyclerViewJori()
        setRecyclerViewAndarHaruf()
        setRecyclerViewBaharHaruf()

        return rootView
    }

    private fun setRecyclerViewJori() {

        recyclerViewJori = rootView.findViewById(R.id.recyclerViewJori)
        myViewHolderAdapterJori = object : RecyclerView.Adapter<MyViewHolder>() {
            override fun onCreateViewHolder(
                viewGroup: ViewGroup,
                ViewType: Int,
            ): MyViewHolder {
                return MyViewHolder(LayoutInflater.from(viewGroup.context)
                    .inflate(R.layout.blueprint_jantri_item, viewGroup, false))
            }

            @SuppressLint("DefaultLocale", "SetTextI18n", "NotifyDataSetChanged",
                "UseCompatLoadingForDrawables")
            override fun onBindViewHolder(
                viewHolderRt: MyViewHolder,
                i: Int,
            ) {

                var finalIndex = i+1
                if(finalIndex<10){
                    viewHolderRt.tvTitle.text = "0${finalIndex}"
                }else if(finalIndex==100){
                    viewHolderRt.tvTitle.text = "00"
                }else{
                    viewHolderRt.tvTitle.text = "${finalIndex}"
                }


            }

            override fun getItemCount(): Int {

                return 100
            }
            
        }

        recyclerViewJori.layoutManager = GridLayoutManager(requireContext(), 10)

        recyclerViewJori.adapter = myViewHolderAdapterJori
    }

    private fun setRecyclerViewAndarHaruf() {

        var recyclerViewAndarHaruf : RecyclerView = rootView.findViewById(R.id.recyclerView_andar_Haruf)
       var myViewHolderAdapterAndarHaruf = object : RecyclerView.Adapter<MyViewHolder>() {
            override fun onCreateViewHolder(
                viewGroup: ViewGroup,
                ViewType: Int,
            ): MyViewHolder {
                return MyViewHolder(LayoutInflater.from(viewGroup.context)
                    .inflate(R.layout.blueprint_jantri_item, viewGroup, false))
            }

            @SuppressLint("DefaultLocale", "SetTextI18n", "NotifyDataSetChanged",
                "UseCompatLoadingForDrawables")
            override fun onBindViewHolder(
                viewHolderRt: MyViewHolder,
                i: Int,
            ) {

                var finalIndex = i+1
               if(finalIndex==10){
                    viewHolderRt.tvTitle.text = "0"
                }else{
                    viewHolderRt.tvTitle.text = "${finalIndex}"
                }

            }

            override fun getItemCount(): Int {

                return 10
            }

        }

        recyclerViewAndarHaruf.layoutManager = GridLayoutManager(requireContext(), 10)

        recyclerViewAndarHaruf.adapter = myViewHolderAdapterAndarHaruf
    }

    private fun setRecyclerViewBaharHaruf() {

        var recyclerViewBaharHaruf : RecyclerView = rootView.findViewById(R.id.recyclerView_bahar_Haruf)
        var myViewHolderAdapterBaharHaruf = object : RecyclerView.Adapter<MyViewHolder>() {
            override fun onCreateViewHolder(
                viewGroup: ViewGroup,
                ViewType: Int,
            ): MyViewHolder {
                return MyViewHolder(LayoutInflater.from(viewGroup.context)
                    .inflate(R.layout.blueprint_jantri_item, viewGroup, false))
            }

            @SuppressLint("DefaultLocale", "SetTextI18n", "NotifyDataSetChanged",
                "UseCompatLoadingForDrawables")
            override fun onBindViewHolder(
                viewHolderRt: MyViewHolder,
                i: Int,
            ) {

                var finalIndex = i+1
                if(finalIndex==10){
                    viewHolderRt.tvTitle.text = "000"
                }else{
                    viewHolderRt.tvTitle.text = "${finalIndex}${finalIndex}${finalIndex}"
                }

            }

            override fun getItemCount(): Int {

                return 10
            }

        }

        recyclerViewBaharHaruf.layoutManager = GridLayoutManager(requireContext(), 10)

        recyclerViewBaharHaruf.adapter = myViewHolderAdapterBaharHaruf
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvTitle: TextView = itemView.findViewById(R.id.tv_title)
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