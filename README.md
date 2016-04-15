# Lu_comment_TextView #


我也是找第三方例子不好找，于是自己写了一个，我和同事还打算做一套IM系统，app和后台都要做，我们自己定义sdk，我们还要封装H5，类似hbuilder如果有什么问题，可以联系我，

QQ:1264957104

## 示例 ##
![](http://i.imgur.com/jPYrFn9.gif)


## onNameClickListener ##
会传回name、id和logo，如果是谁回复谁格式，则返回的是被点击的人的相关信息，position是点击位置，如果是1是第一个人，2是第二个人，3是评论的内容，3不用判断，不会返回.

## onTextClickListener ##
返回评论内容

## onClickOtherListener ##
其他位置被点击，例如“回复”被点击，会触发这个监听

## onClickListener ##
点击监听，任何位置都会触发，注意和其他监听的先后顺序

## onLongClickListener ##
长按监听，任何位置都会触发，注意和其他监听的先后顺序




## 布局 ##
 
`<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context="com.lujianchao.lu_comment_textview_demo.MainActivity">`

    <com.lujianchao.lu_comment_textview_demo.Lu_Comment_TextView
        android:id="@+id/tv1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hello World!"/>
    <com.lujianchao.lu_comment_textview_demo.Lu_Comment_TextView
        android:id="@+id/tv2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hello World!"/>
`</LinearLayout> `



## 代码 ##
    
`public class MainActivity extends AppCompatActivity {
    private Lu_Comment_TextView tv1;
    private Lu_Comment_TextView tv2;
    private Context mContext;`

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        tv1 = (Lu_Comment_TextView) findViewById(R.id.tv1);
        tv2 = (Lu_Comment_TextView) findViewById(R.id.tv2);

        //谁 回复 谁 格式
        Lu_Comment_TextView.Lu_PingLun_info_Entity mLu_pingLun_info_entity1 = tv1.getLu_pingLun_info_entity("我是ID001", "张三", "我是ID002", "李四", "你好啊你好啊");
        tv1.setText_PingLun(mLu_pingLun_info_entity1, new Lu_Comment_TextView.Lu_PingLunListener() {
            @Override
            public void onNameClickListener(String onClickID, String onClickName, Lu_Comment_TextView.Lu_PingLun_info_Entity mLu_pingLun_info_entity, int position) {
                Toast.makeText(mContext, "ID:" + onClickID + "   Name:" + onClickName, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTextClickListener(String onClickText, Lu_Comment_TextView.Lu_PingLun_info_Entity mLu_pingLun_info_entity, int position) {
                Toast.makeText(mContext, onClickText, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onClickOtherListener(Lu_Comment_TextView.Lu_PingLun_info_Entity mLu_pingLun_info_entity) {
                Toast.makeText(mContext, "其他位置", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onClickListener(Lu_Comment_TextView.Lu_PingLun_info_Entity mLu_pingLun_info_entity) {
                Toast.makeText(mContext, "我被点击了", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClickListener(Lu_Comment_TextView.Lu_PingLun_info_Entity mLu_pingLun_info_entity) {
                Toast.makeText(mContext, "我被长按了:", Toast.LENGTH_SHORT).show();
            }
        });

        //谁 说了什么
        Lu_Comment_TextView.Lu_PingLun_info_Entity mLu_pingLun_info_entity2 = tv2.getLu_pingLun_info_entity("aaa1111", "王五", "你好啊你好啊");
        tv2.setText_PingLun(mLu_pingLun_info_entity2, new Lu_Comment_TextView.Lu_PingLunListener() {
            @Override
            public void onNameClickListener(String onClickID, String onClickName, Lu_Comment_TextView.Lu_PingLun_info_Entity mLu_pingLun_info_entity, int position) {
                Toast.makeText(mContext, "ID:" + onClickID + "   Name:" + onClickName, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTextClickListener(String onClickText, Lu_Comment_TextView.Lu_PingLun_info_Entity mLu_pingLun_info_entity, int position) {
                Toast.makeText(mContext, onClickText, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onClickOtherListener(Lu_Comment_TextView.Lu_PingLun_info_Entity mLu_pingLun_info_entity) {
                Toast.makeText(mContext, "其他位置", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onClickListener(Lu_Comment_TextView.Lu_PingLun_info_Entity mLu_pingLun_info_entity) {
                Toast.makeText(mContext, "我被点击了", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClickListener(Lu_Comment_TextView.Lu_PingLun_info_Entity mLu_pingLun_info_entity) {
                Toast.makeText(mContext, "我被长按了:", Toast.LENGTH_SHORT).show();
            }
        });
    }
`}`