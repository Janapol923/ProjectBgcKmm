package com.example.projectbgckmm.android.weatherforecast

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.projectbgckmm.Greeting
import com.example.projectbgckmm.android.common.DialogBoxLoading
import com.example.projectbgckmm.android.navigation.Routes
import com.example.projectbgckmm.models.Response
import com.example.projectbgckmm.models.WeatherForecastResponse

@Composable
fun ForecastScreen(
    navController: NavController,
    viewModel: ForecastViewModel = viewModel(),
) {

    fun launch() {
        viewModel.fetchWeatherForecast()
    }

    launch()

    Surface {
        val forecastResponse = viewModel.forecastState.collectAsState()
            //when () {
            //when (val forecastResponse = viewModel.forecastState.collect()) {
        when (forecastResponse.value) {
                is Response.Failure -> {
                    val res = forecastResponse.value as Response.Failure
                    Text(text = "FAILURE: ${res.e}")
                }
                is Response.Loading -> Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    DialogBoxLoading()
                }

                is Response.Success -> {
                    val res = forecastResponse.value as Response.Success
                    res.data?.forecast?.forecastday?.let {
                        ForecastList(
                            viewModel = viewModel,
                            navController = navController,
                            forecastDay = it
                        )
                    }
                }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ForecastList(
    viewModel: ForecastViewModel = viewModel(),
    navController: NavController,
    forecastDay: ArrayList<WeatherForecastResponse.Forecast.Forecastday>,
) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth()
    ) {
        stickyHeader {
            TopAppBar(title = {
                Text(text = "Weather Forecast")
            })
        }
        items(count = forecastDay.size) { item ->
            Row(modifier = Modifier
                .height(64.dp)
                .padding(8.dp)) {
                forecastDay[item].day?.condition?.icon?.let {
                    Image(
                        painter = rememberAsyncImagePainter("https:$it"),
                        contentDescription = null,
                        modifier = Modifier.size(64.dp),
                    )
                }
                forecastDay[item].day?.condition?.text?.let {
                    Row(
                        modifier = Modifier.fillMaxHeight(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = it, modifier = Modifier.padding(8.dp))
                    }
                }
            }
        }

        val greet = Greeting()

        item {
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                onClick = {
                    navController.navigate(Routes.WeatherDetailsScreen.destination)
                }) {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = "Navigate to Details: ${greet.greet()}"
                )
            }
        }
    }
}
