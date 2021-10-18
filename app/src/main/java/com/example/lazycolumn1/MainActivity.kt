package com.example.lazycolumn1

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lazycolumn1.repository.PersonRepository
import com.example.lazycolumn1.ui.theme.LazyColumn1

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumn1 {
                val personRepository = PersonRepository()
                val getAllData = personRepository.getAllData()
                LazyColumn(
                    contentPadding = PaddingValues(all = 12.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    itemsIndexed(
                        items = getAllData,
                        key = { index, person ->
                            person.id
                        }
                    ) { index, person ->
                        Log.d("MainActivity", index.toString())
                        CustomItem(person = person)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LazyColumn1 {
        val personRepository = PersonRepository()
        val getAllData = personRepository.getAllData()
        LazyColumn(
            contentPadding = PaddingValues(all = 12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            itemsIndexed(
                items = getAllData,
                key = { index, person ->
                    person.id
                }
            ) { index, person ->
                Log.d("MainActivity", index.toString())
                CustomItem(person = person)
            }
        }
    }
}