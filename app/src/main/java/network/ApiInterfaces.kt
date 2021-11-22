package network

import model.Pro
import model.Product
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterfaces
{


    @GET("api/products")
    fun getProduct() : Call<Pro>

    companion object {

        var BASE_URL = "https://reqres.in/"

        fun create() : ApiInterfaces {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiInterfaces::class.java)

        }
    }




}