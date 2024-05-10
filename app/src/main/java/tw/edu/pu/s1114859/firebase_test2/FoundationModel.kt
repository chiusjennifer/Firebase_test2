package tw.edu.pu.s1114859.firebase_test2

import java.io.Serializable

data class FoundationModel(
    var fdname: String? = null,
    var fdphone: String? = null,
    var fdfax: String? = null,
    var fdmail: String? = null,
    var fdaddress:String?=null,
    var fdistrict:String?=null,
    var fdlink:String?=null,
    var fdupdated:String?=null,
    var fdob:String?=null,
    var fdcategory:String?=null,
    var fdage:String?=null,
    var geo:String?=null
):Serializable