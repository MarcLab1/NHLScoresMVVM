package com.nhlscores.ui.presentation

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun DatePickerPage(vm: MyViewModel) {
    //var vm: MyViewModel = viewModel()
    var context = LocalContext.current

    val datePicker = DatePickerDialog(context, object : DatePickerDialog.OnDateSetListener {
        override fun onDateSet(view: DatePicker?, year: Int, month: Int, day: Int) {
            vm.loadGames(year, month, day)

        }
    }, vm.year.value, vm.month.value, vm.day.value)
    datePicker.datePicker.maxDate = vm.maxDateLong.value
    datePicker.datePicker.minDate = vm.minDateLong.value

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {

        Row(horizontalArrangement = Arrangement.Center)
        {
            MyCustomIcon(vm.dateString.value, vm.minDateString.value, Icons.Filled.KeyboardArrowLeft, "<", {
                vm.changeDateByOne(false)
                vm.loadGames()
            })

            Text(text = vm.getFormattedDateEEEMMMdyyyy(),
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .clickable { datePicker.show() })

            MyCustomIcon(vm.dateString.value, vm.maxDateString.value, Icons.Filled.KeyboardArrowRight, ">", {
                vm.changeDateByOne(true)
                vm.loadGames()
            })
        }
    }
}

@Composable
fun MyCustomIcon(
    selectedDate: String,
    thresholdDate : String,
    icon: ImageVector,
    contentDescription: String,
    onClick: () -> Unit
) {
    if (selectedDate.equals(thresholdDate)) {
        Icon(
            icon,
            contentDescription = contentDescription,
            //tint = MaterialTheme.colors.primary,
            modifier = Modifier
                .padding(start = 5.dp, end = 5.dp)
                .clickable(enabled = false) {}
                .alpha(0f)
        )
    } else {
        Icon(
            icon,
            contentDescription = contentDescription,
            //tint = MaterialTheme.colors.primary,
            modifier = Modifier
                .padding(start = 5.dp, end = 5.dp)
                .clickable { onClick() }
        )
    }
}