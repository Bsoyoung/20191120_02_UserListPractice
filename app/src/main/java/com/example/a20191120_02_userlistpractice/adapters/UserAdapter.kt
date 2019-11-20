package com.example.a20191120_02_userlistpractice.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.a20191120_02_userlistpractice.R
import com.example.a20191120_02_userlistpractice.datas.User

class UserAdapter(context: Context, res:Int, list:ArrayList<User>) : ArrayAdapter<User>(context,res,list) {

    var mContext = context
    var mList = list

    var inf = LayoutInflater.from(mContext)

    constructor(context:Context,list:ArrayList<User>):this(context,R.layout.user_list_item,list)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView

        if(tempRow==null){
            tempRow = inf.inflate(R.layout.user_list_item,null)
        }

        var row = tempRow!!

        var logoImg = row.findViewById<ImageView>(R.id.categoryColorImg)
        var bankNameTxt = row.findViewById<TextView>(R.id.userNameTxt)

        var data =mList.get(position)


      //  Glide.with(mContext).load(data.logo).into(logoImg)
        bankNameTxt.text = data.name





        return row
    }


}