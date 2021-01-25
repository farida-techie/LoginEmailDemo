package com.malkinfo.loginemaildemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loginMail()
    }
     fun loginMail(){
         edMail.addTextChangedListener(object :TextWatcher{
             override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

             override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (android.util.Patterns.EMAIL_ADDRESS.matcher(edMail.text.toString()).matches()){
                    loginBtn.isEnabled = true
                }else{
                    loginBtn.isEnabled = false
                    edMail.error = "Invalid Email"
                }
             }

             override fun afterTextChanged(s: Editable?) {}

         })
         loginBtn.setOnClickListener {
             edMail.setText("")
             pass.setText("")
             startActivity(Intent(this,NewActivity::class.java))
             Toast.makeText(this,"Login is Successfully",Toast.LENGTH_SHORT).show()
         }
     }
    /**ok now run it*/
}