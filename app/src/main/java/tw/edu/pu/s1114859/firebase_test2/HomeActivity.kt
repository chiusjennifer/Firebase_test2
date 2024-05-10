package tw.edu.pu.s1114859.firebase_test2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class HomeActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val listBtn:ImageButton=findViewById(R.id.listBtn)

        listBtn.setOnClickListener {
            val intent= Intent(this,FetchingActivity::class.java)
            startActivity(intent)
        }

    }
}