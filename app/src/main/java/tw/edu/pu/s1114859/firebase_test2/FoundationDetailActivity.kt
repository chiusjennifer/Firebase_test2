package tw.edu.pu.s1114859.firebase_test2

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlin.contracts.contract

class FoundationDetailActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foundation_details)
        val mapBtn:ImageButton=findViewById(R.id.mapBtn)
        val homeBtn:ImageButton=findViewById(R.id.homeBtn)
        val returnBtn:ImageButton=findViewById(R.id.returnBtn)
        val name:TextView=findViewById(R.id.dataname)
        val phone:TextView=findViewById(R.id.dataphone)
        val fax:TextView=findViewById(R.id.datafax)
        val mail:TextView=findViewById(R.id.datamail)
        val district:TextView=findViewById(R.id.datarea)
        val link:TextView=findViewById(R.id.datalink)
        val updated:TextView=findViewById(R.id.dataupdated)
        val server_ob:TextView=findViewById(R.id.dataob)
        val category:TextView=findViewById(R.id.datacategory)
        val age:TextView=findViewById(R.id.datage)
        val contract:FoundationModel

       contract= intent.extras?.get("fd") as FoundationModel
        name.text = contract.fdname
        phone.text = contract.fdphone
        fax.text = contract.fdfax
        mail.text = contract.fdmail
        district.text = contract.fdistrict.toString().trim()
        link.text = contract.fdlink
        updated.text = contract.fdupdated
        server_ob.text = contract.fdob
        category.text = contract.fdcategory
        age.text = contract.fdage



        mapBtn.setOnClickListener {
            val intent=Intent(Intent.ACTION_VIEW)
            intent.data= Uri.parse("geo:"+contract.geo)
            startActivity(intent)
        }
        homeBtn.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)

        }
        returnBtn.setOnClickListener {
            val intent=Intent(this,FetchingActivity::class.java)
            startActivity(intent)
        }


    }
}