# Lu_comment_TextView #
 

## 说明

#### 我是将朋友圈分成了几个独立模块单独自定义的View，通过回调完成交互，耦合性算是非常低了，主要有以下及部分： 

1.评论布局（自定义TextView）

2.点赞布局（原理和评论的自定义TextView一样，都是用的SpannableString）

3.图片列表（出门右转，理论上没有数量限制，和listView配合使用也很好，缓存也自己处理了）

我也是找第三方例子不好找，于是自己写了一个，我和同事还打算做一套IM系统，app和后台都要做，我们自己定义sdk，我们还要封装H5，类似hbuilder如果有什么问题，可以联系我，

QQ:1264957104

## 示例 ##
![](http://i.imgur.com/jPYrFn9.gif)
![](http://i.imgur.com/BDFkB82.png)

单独写了一个布局管理，增加了回调参数，此textview是独立的可以单独使用，布局管理出门右转

## onNameClickListener ##
会传回name、id和logo，如果是谁回复谁格式，则返回的是被点击的人的相关信息，position是点击位置，如果是1是第一个人，2是第二个人，3是评论的内容，3不用判断，不会返回.如果被评论人传参为null和“”会被识别为一个人评论。

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
        Lu_Comment_TextView.Lu_PingLun_info_Entity mLu_pingLun_info_entity1 = tv1.getLu_pingLun_info_entity("评论ID", "我是ID001", "张三", "A头像", "我是ID002", "李四", "b头像", "你好啊你好啊");
        tv1.setText_PingLun(mLu_pingLun_info_entity1, new Lu_Comment_TextView.Lu_PingLunListener() {

            @Override
            public void onNameClickListener(String onClickID, String onClickName, String onClickLogo, Lu_Comment_TextView.Lu_PingLun_info_Entity mLu_pingLun_info_entity, int position) {
                System.out.println("onClickID = [" + onClickID + "], onClickName = [" + onClickName + "], onClickLogo = [" + onClickLogo + "], mLu_pingLun_info_entity = [" + mLu_pingLun_info_entity + "], position = [" + position + "]");
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
        Lu_Comment_TextView.Lu_PingLun_info_Entity mLu_pingLun_info_entity2 = tv2.getLu_pingLun_info_entity("评论ID", "111", "王五", "a头像", null, null, null, "你好啊你好啊");
        tv2.setText_PingLun(mLu_pingLun_info_entity2, new Lu_Comment_TextView.Lu_PingLunListener() {

            @Override
            public void onNameClickListener(String onClickID, String onClickName, String onClickLogo, Lu_Comment_TextView.Lu_PingLun_info_Entity mLu_pingLun_info_entity, int position) {

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