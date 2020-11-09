package com.example.employeesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.employee_item.*
import org.json.JSONObject

class EmployeeActivity : AppCompatActivity() {
    // EmployeeActivity's onCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee)

        // get data from intent
        val bundle: Bundle? = intent.extras;
        if (bundle != null) {
            val employeeString = bundle!!.getString("employee")
            val employee = JSONObject(employeeString)

            nameTextView.text = employee["firstName"].toString()
            nameTextView.text = employee["lastName"].toString() + " " + employee["firstName"].toString()
            // title, email, phone, department, image
            titleTextView.text = employee["title"].toString()
            emailTextView.text = employee["email"].toString()
            phoneTextView.text = employee["phone"].toString()
            departmentTextView.text = employee["department"].toString()
            // to get context in Glide, you can use holder.imageView.context
            val imageUrl = employee["image"].toString()
            Glide.with(this).load(imageUrl).centerCrop().into(photoImageView);
        }
    }
}
