package uz.behad.rewardsapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var mainAdapter: MainAdapter
    private lateinit var rewards: ArrayList<Reward>
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rewards = ArrayList()

        addItems()

        initViews()

    }

    private fun initViews() {

        val mainRv = findViewById<RecyclerView>(R.id.rv_main)

        mainAdapter = MainAdapter(object : MainAdapter.OnBottomReachChangeListener {
            override fun onReach(position: Int) {
                Snackbar.make(mainRv, "position = $position", Snackbar.LENGTH_LONG).show()
                mainAdapter.submitList(rewards)
                mainRv.adapter = mainAdapter
                layoutManager.scrollToPositionWithOffset(position, 9)
            }

        })

        mainAdapter.submitList(rewards)
        layoutManager = LinearLayoutManager(this)

        mainRv.adapter = mainAdapter
        mainRv.layoutManager = layoutManager


    }

    //Add items
    private fun addItems() {
        rewards.add(Reward("Senior GIF", "Level 3", 3, true, MainAdapter.GAINED))
        rewards.add(Reward("Senior Alt + Enter", "Level 5", 5, true, MainAdapter.GAINED))
        rewards.add(Reward("Senior Algorithm",
            "This reward not gained yet",
            0,
            false,
            MainAdapter.NOT_GAINED))
        rewards.add(Reward("Senior Logic",
            "This reward not gained yet",
            0,
            false,
            MainAdapter.NOT_GAINED))
        rewards.add(Reward("Senior Database Developer",
            "This reward not gained yet",
            0,
            false,
            MainAdapter.NOT_GAINED))
        rewards.add(Reward("Senior MEME", "Level 3", 3, true, MainAdapter.GAINED))
        rewards.add(Reward("Senior GIF", "Level 3", 3, true, MainAdapter.GAINED))
        rewards.add(Reward("Senior Alt + Enter", "Level 5", 5, true, MainAdapter.GAINED))
        rewards.add(Reward("Senior Algorithm",
            "This reward not gained yet",
            0,
            false,
            MainAdapter.NOT_GAINED))
        rewards.add(Reward("Senior Logic",
            "This reward not gained yet",
            0,
            false,
            MainAdapter.NOT_GAINED))
        rewards.add(Reward("Senior Database Developer",
            "This reward not gained yet",
            0,
            false,
            MainAdapter.NOT_GAINED))
        rewards.add(Reward("Senior MEME", "Level 3", 3, true, MainAdapter.GAINED))
    }
}