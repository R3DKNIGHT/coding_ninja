package com.example.codingninja

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Savebutton.setOnClickListener{
            val id:String = IDField.text.toString()
            val name:String = NameField.text.toString()
            val age:String = AgeField.text.toString()
            val userData = UserData(name,age)
            val ref = FirebaseDatabase.getInstance().getReference("${id}/")

            ref.setValue(userData)
                .addOnSuccessListener {
                    Toast.makeText(this,"Data Saved Succesfully!", Toast.LENGTH_SHORT).show()

                }
                .addOnFailureListener{
                    Toast.makeText(this,"Data Could Not Be Saved!", Toast.LENGTH_SHORT).show()
                }

        }
    }
}

data class UserData(val name: String, val age:String){
    constructor(): this("","")

}