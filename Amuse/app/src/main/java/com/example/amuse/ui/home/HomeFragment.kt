package com.example.amuse.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DiffUtil
import com.example.amuse.R
import com.example.amuse.databinding.FragmentHomeBinding
import com.example.amuse.ui.CardAdapter
import com.yuyakaido.android.cardstackview.CardStackLayoutManager
import com.yuyakaido.android.cardstackview.CardStackListener
import com.yuyakaido.android.cardstackview.CardStackView
import com.yuyakaido.android.cardstackview.StackFrom
import com.yuyakaido.android.cardstackview.SwipeableMethod


//import android.content.Intent
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import androidx.core.view.updateLayoutParams
//import androidx.customview.widget.ViewDragHelper
//import androidx.fragment.app.Fragment
//import androidx.lifecycle.Observer
//import androidx.lifecycle.ViewModelProvider
//import com.example.amuse.MainActivity
//import com.example.amuse.OpenCardActivity
//import com.example.amuse.R
//import com.example.amuse.databinding.FragmentHomeBinding
//import com.google.android.material.card.MaterialCardView

class HomeFragment : Fragment() {
    private lateinit var cardList: ArrayList<Card>
    private lateinit var cardAdapter: CardAdapter
    private lateinit var cardStackView: CardStackView
    private lateinit var cardManager: CardStackLayoutManager
//    private lateinit var binding: FragmentHomeBinding

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        cardStackView = binding.root.findViewById(R.id.card_stack)

        cardManager = CardStackLayoutManager(this.context, object : CardStackListener{
            override fun onCardDragging(direction: Direction, ratio: Float) {
                Log.d(
                    Companion.TAG,
                    "onCardDragging: d=" + direction.name() + " ratio=" + ratio
                )
            }

            override fun onCardSwiped(direction: Direction) {
                Log.d(
                    Companion.TAG,
                    "onCardSwiped: p=" + manager!!.topPosition + " d=" + direction
                )
                if (direction === Direction.Right) {
                    Toast.makeText(this@MainActivity, "Direction Right", Toast.LENGTH_SHORT)
                        .show()
                }
                if (direction === Direction.Top) {
                    Toast.makeText(this@MainActivity, "Direction Top", Toast.LENGTH_SHORT)
                        .show()
                }
                if (direction === Direction.Left) {
                    Toast.makeText(this@MainActivity, "Direction Left", Toast.LENGTH_SHORT)
                        .show()
                }
                if (direction === Direction.Bottom) {
                    Toast.makeText(
                        this@MainActivity,
                        "Direction Bottom",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                // Paginating
                if (manager!!.topPosition == adapter.getItemCount() - 5) {
                    paginate()
                }
            }

        })


        cardList = ArrayList()

        // Card 1
        cardList.add(Card("Hiking", "Laurel Trail (2.1 km)", "★★★☆☆", "$", "2 groups", "100 interested", R.drawable.card1_media))

        // Card 2
        cardList.add(Card("Fancy Dinner", "Shinwa (1.8 km)", "★★★★★", "$$", "1 groups", "2 interested", R.drawable.card2_media))

        // Card 3
        cardList.add(Card("Clubbing", "Allure (2 km)", "★☆☆☆☆", "$$$$", "0 groups", "0 interested", R.drawable.card3_media))

        cardAdapter = CardAdapter(cardList)
        cardStackView.adapter = cardAdapter

        return root
    }
//
//    private lateinit var homeViewModel: HomeViewModel
//    private var _binding: FragmentHomeBinding? = null
//
//    // This property is only valid between onCreateView and
//    // onDestroyView.
//    private val binding get() = _binding!!
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        homeViewModel =
//            ViewModelProvider(this).get(HomeViewModel::class.java)
//
//        _binding = FragmentHomeBinding.inflate(inflater, container, false)
//        val root: View = binding.root
//
//        /*
//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
//        */
//
//        binding.card1.setOnClickListener {
//            requireActivity().run {
//                startActivity(Intent(this, OpenCardActivity::class.java).putExtra("cardID", "card2"))
//                finish()
//            }
//        }
//
//        binding.card2.setOnClickListener {
//            requireActivity().run {
//                startActivity(Intent(this, OpenCardActivity::class.java).putExtra("cardID", "card2"))
//                finish()
//            }
//        }
//
//        binding.card3.setOnClickListener {
//            requireActivity().run {
//                startActivity(Intent(this, OpenCardActivity::class.java).putExtra("cardID", "card3"))
//                finish()
//            }
//        }
//
//        return root
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}