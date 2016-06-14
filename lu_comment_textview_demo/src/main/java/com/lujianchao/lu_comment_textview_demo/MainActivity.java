package com.lujianchao.lu_comment_textview_demo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Lu_Comment_TextView tv1;
    private Lu_Comment_TextView tv2;
    private Context mContext;

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
}
