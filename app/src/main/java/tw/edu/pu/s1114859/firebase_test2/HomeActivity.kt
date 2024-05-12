package tw.edu.pu.s1114859.firebase_test2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.SearchView
import android.widget.TextView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class HomeActivity : AppCompatActivity() {
    private lateinit var searchView: SearchView
    private val db = Firebase.firestore
    private lateinit var resultTextView:TextView
    var obj = FoundationModel()
    var contacts= mutableListOf<FoundationModel>()
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        searchView = findViewById(R.id.simpleSearchView)
        val listBtn: ImageButton = findViewById(R.id.listBtn)
        resultTextView=findViewById(R.id.resultTextView)

        listBtn.setOnClickListener {
            val intent = Intent(this, FetchingActivity::class.java)
            startActivity(intent)
        }
        // 設定SearchView的監聽器
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                // 提交搜尋時觸發
                searchInDatabase(query)
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                // 文本改變時觸發（可選）
                return false
            }
        })
    }
    private fun searchInDatabase(query: String) {
        db.collection("TC_opendata")
            .whereEqualTo("category", query)
            .get()
            .addOnSuccessListener { documents ->
                if (documents.isEmpty) {
                    resultTextView.text = "找不到匹配的項目"
                } else {
                        val stringBuilder = StringBuilder()
                        for (document in documents) {
                            val data = document.data
                            val result = data["Fd_name"].toString()
                            stringBuilder.append("$result,")
                    }
                        resultTextView.text = "搜尋結果為:"+stringBuilder.toString()+"請至列表查看\n"
                    }
                }
            .addOnFailureListener { exception ->
                resultTextView.text = "搜尋失敗: $exception"
            }
            }
}