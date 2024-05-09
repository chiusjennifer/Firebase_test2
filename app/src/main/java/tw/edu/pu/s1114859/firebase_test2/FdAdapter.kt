package tw.edu.pu.s1114859.firebase_test2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.api.Context

class FdAdapter(val fdList: List<FoundationModel>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var mListener: onItemClickListener

    fun setOnItemClickListener(clickListener: onItemClickListener){
        mListener = clickListener
    }

    interface onItemClickListener{
        fun onItemClick(position: Int)

    }

    class ViewHolder(view: View, clickListener: onItemClickListener) : RecyclerView.ViewHolder(view) {

        val fdname : TextView = view.findViewById(R.id.tvFdName)
        init {
                view.setOnClickListener {
                clickListener.onItemClick(adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.fd_list_item,parent,false)
        return ViewHolder(view,mListener)
    }

    override fun getItemCount(): Int {
        return fdList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       val lists=fdList[position]
        if(holder is ViewHolder){
            holder.fdname.text =lists.fdname
        }
    }
}

