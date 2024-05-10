package tw.edu.pu.s1114859.firebase_test2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class FetchingActivity : AppCompatActivity() {

    private lateinit var mRecyclerView: RecyclerView
    val db =Firebase.firestore
    var obj = FoundationModel()
    var contacts= mutableListOf<FoundationModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fetching)


        mRecyclerView = findViewById(R.id.rvFd)
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mRecyclerView.setHasFixedSize(true)
        db.collection("TC_opendata")
            .get()
            .addOnSuccessListener { documentsRf ->
                for(document in documentsRf){
                    val data =document.data
                    obj = FoundationModel(data["Fd_name"].toString(),
                        data["phone"].toString(),data["fax"].toString(),
                        data["mail"].toString(),data["address"].toString(),
                        data["district"].toString(),data["url"].toString(),
                        data["updated"].toString(),data["serve_ob"].toString(),
                        data["category"].toString(),data["age_ob"].toString()
                    )
                    contacts.add(obj)
                }
                val fdAdapter = FdAdapter(contacts)
                mRecyclerView.adapter= fdAdapter
                fdAdapter.setOnItemClickListener(object:FdAdapter.onItemClickListener{
                    override fun onItemClick(position: Int) {
                        //intent
                        val intent =Intent(this@FetchingActivity,FoundationDetailActivity::class.java)
                        //put extras

                        intent.putExtra("fd",contacts[position])
                        startActivity(intent)
                    }
                })

            }
    }
}



