package com.example.a20191120_02_userlistpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import com.example.a20191120_02_userlistpractice.adapters.UserAdapter
import com.example.a20191120_02_userlistpractice.datas.User
import com.example.a20191120_02_userlistpractice.utils.ConnectServer
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : BaseActivity() {

    var userList = ArrayList<User>()
    var userAdapter:ArrayAdapter<User>?  = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setValues()
        setupEvents()
    }

    override fun setupEvents() {
    }

    override fun setValues() {
        userAdapter = UserAdapter(mContext,userList)
        userListView.adapter = userAdapter
    }

    override fun onResume() {
        super.onResume()
        getUserListFromServer()
    }

    fun getUserListFromServer(){
        ConnectServer.getRequestUserList(mContext,"ALL",object : ConnectServer.JsonResponseHandler{
            override fun onResponse(json: JSONObject) {
                Log.d("사용자목록응답",json.toString())

                var code = json.getInt("code")
                if(code==200){
                    val data = json.getJSONObject("data")
                    val usersAll = data.getJSONArray("users")

                    //기존에 받아둔 데이터들을 삭제
                    userList.clear()
                    for(i in 0 .. usersAll.length()-1){
                        val userData = User.getUserFromJson(usersAll.getJSONObject(i))
                        userList.add(userData)
                    }

                    runOnUiThread{
                        userAdapter?.notifyDataSetChanged()
                    }
                }

            }

        })
    }

}
