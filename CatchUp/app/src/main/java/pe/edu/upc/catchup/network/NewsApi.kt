package pe.edu.upc.catchup.network

class NewsApi{
    /*subsana la fala de variables statics en kotlin*/
    companion object {
        val baseUrl = "https://newsapi.org/"
        val topHeadlinesUrl = "$baseUrl/v2/top-headlines"
        val everythingUrl = "$baseUrl/v2/everything"
        val sourcesUrl = "$baseUrl/v2/sources"
    }

}

/*si yo o le pongo nombre*/
//NewsApi.Companion.baseUrl
/**/

//NewsApi.Constant.baseUrl
//NewsApi.baseUrl