package pe.edu.upc.catchup.models

import android.os.Bundle
import pe.edu.upc.catchup.network.LogoApi

data class Source(val id: String,
                  val name: String,
                  val description: String? = "",
                  val url:String? = "",
                  val category:String? = "",
                  val languaje:String? = "",
                  val country:String? = ""){

    //fun urlToLogo():String{
    //    return LogoApi.urlToLogo(url)
    //}

    //val urlToLogo = "${LogoApi.urlToLogo(url)}"

    companion object {
        fun from (bundle: Bundle) : Source{
            return Source(
                    bundle.getString("id"),
                    bundle.getString("name"),
                    bundle.getString("description"),
                    bundle.getString("url"),
                    bundle.getString("category"),
                    bundle.getString("languaje"),
                    bundle.getString("country")
            )
        }
    }

    fun urlToLogo() = LogoApi.urlToLogo(url!!)

    fun toBundle() : Bundle {
        val bundle = Bundle()
        bundle.putString("id", id)
        bundle.putString("name", name)
        bundle.putString("description", description)
        bundle.putString("url", url)
        bundle.putString("languaje", languaje)
        bundle.putString("country", country)
        return bundle
    }

}