package pe.edu.upc.catchup.network

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import pe.edu.upc.catchup.viewControllers.adapters.SourceAdapter

class NewsApi{
    /*subsana la fala de variables statics en kotlin*/
    companion object {
        val baseUrl = "https://newsapi.org/"
        val topHeadlinesUrl = "$baseUrl/v2/top-headlines"
        val everythingUrl = "$baseUrl/v2/everything"
        val sourcesUrl = "$baseUrl/v2/sources"

        fun requestHeadlines(key: String, responseHandler: (ArticleResponse?) -> Unit,
                             errorHandler: (ANError?) -> Unit){
            AndroidNetworking.get(NewsApi.topHeadlinesUrl)
                    .addQueryParameter("apikey", key)
                    .addQueryParameter("country","en")
                    .setPriority(Priority.LOW)
                    .setTag("CatchUp")
                    .build()
                    .getAsObject(ArticleResponse::class.java, object: ParsedRequestListener<ArticleResponse> {
                        override fun onResponse(response: ArticleResponse?) {
                            responseHandler(response)
                        }

                        override fun onError(anError: ANError?) {
                            errorHandler(anError)
                        }

                    })
        }

        fun requestSources(key: String, responseHandler: (SourcesResponse?) -> Unit,
                           errorHandler: (ANError?) -> Unit){
            AndroidNetworking.get(NewsApi.sourcesUrl)
                    .addQueryParameter("apikey", key)
                    .addQueryParameter("country","en")
                    .setPriority(Priority.LOW)
                    .setTag("CatchUp")
                    .build()
                    .getAsObject(SourcesResponse::class.java, object: ParsedRequestListener<SourcesResponse> {
                        override fun onResponse(response: SourcesResponse?) {
                            responseHandler(response)
                        }

                        override fun onError(anError: ANError?) {
                            errorHandler(anError)
                        }

                    })
        }

        fun hanlerResponse(response: SourcesResponse?) {

        }


    }

}

/*si yo o le pongo nombre*/
//NewsApi.Companion.baseUrl
/**/

//NewsApi.Constant.baseUrl
//NewsApi.baseUrl