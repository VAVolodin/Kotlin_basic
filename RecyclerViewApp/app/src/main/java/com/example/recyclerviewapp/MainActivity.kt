package com.example.recyclerviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val userNameList: List<String> = listOf("Абрам","Аваз","Август","Авдей","Автандил","Адам","Адис","Адольф","Адриан","Азарий","Аким","Алан","Ален","Александр","Алексей","Альберт","Альфред","Амадей","Амадеус","Амаяк","Анатолий","Ангел","Андоим","Андрей","Аникита","Антон","Ануфрий","Онуфрий","Арам","Арий","Аристарх","Аркадий","Арно","Арнольд","Арон","Арсен, ","Арсений","Артем")

        val userRecyclerView: RecyclerView = findViewById(R.id.users_recyclerView)
        userRecyclerView.layoutManager =
            LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false)
        userRecyclerView.addItemDecoration(
            DividerItemDecoration(
                this,DividerItemDecoration.VERTICAL
            )
        )
        userRecyclerView.adapter = UserAdapter(userNameList)
    }


    }

