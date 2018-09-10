package pe.edu.upc.catchup.models

import pe.edu.upc.catchup.network.LogoApi

data class Source(val id: String,
                  val name: String,
                  val description: String = "",
                  val url:String = "",
                  val category:String = "",
                  val languaje:String = "",
                  val country:String = ""){

    //fun urlToLogo():String{
    //    return LogoApi.urlToLogo(url)
    //}

    val urlToLogo = "${LogoApi.urlToLogo(url)}"

}