package uz.behad.rewardsapp

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainAdapter(
    private val onBottomReachChangeListener: OnBottomReachChangeListener,
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var rewards: ArrayList<Reward> = ArrayList()

    companion object {
        val GAINED = 0
        val NOT_GAINED = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (viewType == GAINED) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_reward, parent, false)
            return RewardViewHolder(view)
        }

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_reward_not_gained, parent, false)

        return NotGainedRewardViewHolder(view)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (rewards.size - 1 == position) {
            onBottomReachChangeListener.onReach(position)
        }

        Log.d("PositionAdapter", "onBindViewHolder: $position")

        if (rewards[position].type == GAINED) {
            val gainedHolder = holder as RewardViewHolder
            gainedHolder.ratingBar.rating = rewards[position].star.toFloat()
            gainedHolder.tvLevel.text = rewards[position].level
            gainedHolder.tvTitle.text = rewards[position].title
        }

        if (rewards[position].type == NOT_GAINED) {
            val notGainedHolder = holder as NotGainedRewardViewHolder
            notGainedHolder.tvDescription.text = rewards[position].level
            notGainedHolder.tvTitle.text = rewards[position].title
        }

    }

    override fun getItemCount(): Int = rewards.size

    interface OnBottomReachChangeListener {
        fun onReach(position: Int)
    }

    fun submitList(rewards: ArrayList<Reward>) {
        this.rewards.addAll(rewards)
    }

    override fun getItemViewType(position: Int): Int {
        return rewards[position].type
    }

    class RewardViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        val tvTitle = view.findViewById<TextView>(R.id.tv_title)
        val tvLevel = view.findViewById<TextView>(R.id.tv_level)
        val ratingBar = view.findViewById<RatingBar>(R.id.rb_level)

    }


    //Holder
    class NotGainedRewardViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        val tvTitle = view.findViewById<TextView>(R.id.tv_title)
        val tvDescription = view.findViewById<TextView>(R.id.tv_description)

    }

}