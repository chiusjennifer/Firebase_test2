package tw.edu.pu.s1114859.firebase_test2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class FoundationDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foundation_details)
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

        val contactsString = intent.getStringExtra("fd")
        // 解開資料
        val contactsList = mutableListOf<FoundationModel>()
        if (!contactsString.isNullOrEmpty()) {
            val contactsArray = contactsString.split(",")
            for (contactString in contactsArray) {
                val contactInfo = contactString.split(";")
                if (contactInfo.size == 11) { // 確認每個物件都有11個屬性
                    val foundationModel = FoundationModel(
                        contactInfo[0],
                        contactInfo[1],
                        contactInfo[2],
                        contactInfo[3],
                        contactInfo[4],
                        contactInfo[5],
                        contactInfo[6],
                        contactInfo[7],
                        contactInfo[8],
                        contactInfo[9],
                        contactInfo[10]
                    )
                    contactsList.add(foundationModel)
                }
            }
        }
        // 顯示解開後的細項
        for (contact in contactsList) {
            name.text = contact.fdname
            phone.text = contact.fdphone
            fax.text = contact.fdfax
            mail.text = contact.fdmail
            district.text = contact.fdistrict
            link.text = contact.fdlink
            updated.text = contact.fdupdated
            server_ob.text = contact.fdob
            category.text = contact.fdcategory
            age.text = contact.fdage
        }
    }
}