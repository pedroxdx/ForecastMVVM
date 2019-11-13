package com.example.forecastmvvm.ui.weather

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.forecastmvvm.R
import com.example.forecastmvvm.data.*
import kotlinx.android.synthetic.main.current_weather_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CurrentWeatherFragment : Fragment() {

    companion object {
        fun newInstance() = CurrentWeatherFragment()
    }

    private lateinit var viewModel: CurrentWeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.current_weather_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CurrentWeatherViewModel::class.java)
        // TODO: Use the ViewModel

        val apiService = ApixuWeatherApiService()

        GlobalScope.launch(Dispatchers.Main){
            val currentWeatherResponse = apiService.getCurrentWeather("Merida").await()
            current_text.setText(currentWeatherResponse.current.toString())
        }

        /*
        val apiService = EmpleosApiService.invoke()

        GlobalScope.launch(Dispatchers.Main){
            val listEmpleos = apiService.getEmpleos().await()
            val xdes : StringBuilder = StringBuilder()
            for (empleo in listEmpleos){
                xdes.append("${empleo.empleo}\n")
            }
            current_text.setText(xdes.toString())
        }
        */

        /*
        val apiService = ApixuWeatherApiService()

        apiService.getCurrentWeather("London")
            .enqueue(object: Callback<CurrentWeatherResponse>{
                override fun onFailure(call: Call<CurrentWeatherResponse>, t: Throwable) {
                    Toast.makeText(view?.context, t.message, Toast.LENGTH_LONG).show()
                }

                override fun onResponse(
                    call: Call<CurrentWeatherResponse>,
                    response: Response<CurrentWeatherResponse>
                ) {
                    val x = 50
                    val y = 56
                }

            })
        */

        /*
        RetrofitClient.instance.getEmpleos()
            .enqueue(object: Callback<List<EmpleosResponse>>{
                override fun onFailure(call: Call<List<EmpleosResponse>>, t: Throwable) {
                    Toast.makeText(view?.context, t.message, Toast.LENGTH_LONG).show()
                }

                override fun onResponse(
                    call: Call<List<EmpleosResponse>>,
                    response: Response<List<EmpleosResponse>>
                ) {
                    val x = 50
                    val y = 56
                }


            })
         */
    }

}
