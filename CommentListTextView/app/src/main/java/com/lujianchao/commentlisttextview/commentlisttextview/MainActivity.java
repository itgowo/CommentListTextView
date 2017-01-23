package com.lujianchao.commentlisttextview.commentlisttextview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private CommentListTextView mCommentListTextView;
    private TextView mTextView;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        mCommentListTextView = (CommentListTextView) findViewById (R.id.commentlist);
        mTextView = (TextView) findViewById (R.id.log);
        test ();
    }

    private void test () {
        mTextView.setMovementMethod (ScrollingMovementMethod.getInstance ());


        mCommentListTextView.setMaxlines (6);
        mCommentListTextView.setMoreStr ("查看更多");
        mCommentListTextView.setNameColor (Color.parseColor ("#fe671e"));
        mCommentListTextView.setCommentColor (Color.parseColor ("#242424"));
        mCommentListTextView.setTalkStr ("回复");
        mCommentListTextView.setTalkColor (Color.parseColor ("#242424"));


        List<CommentListTextView.CommentInfo> mCommentInfos = new ArrayList<> ();
        mCommentInfos.add (new CommentListTextView.CommentInfo ().setID (1111).setComment ("今天天气真好啊！11").setNickname ("张三").setTonickname ("赵四"));
        mCommentInfos.add (new CommentListTextView.CommentInfo ().setID (2222).setComment ("今天天气真好啊！22").setNickname ("赵四"));
        mCommentInfos.add (new CommentListTextView.CommentInfo ().setID (3333).setComment ("今天天气真好啊！33").setNickname ("王五").setTonickname ("小三"));
        mCommentInfos.add (new CommentListTextView.CommentInfo ().setID (4444).setComment ("今天天气真好啊！44").setNickname ("小三").setTonickname ("王五"));
        mCommentInfos.add (new CommentListTextView.CommentInfo ().setID (5555).setComment ("今天天气真好啊！55").setNickname ("李大"));
        mCommentInfos.add (new CommentListTextView.CommentInfo ().setID (6666).setComment ("今天天气真好啊！66").setNickname ("小三").setTonickname ("王五"));
        mCommentInfos.add (new CommentListTextView.CommentInfo ().setID (7777).setComment ("今天天气真好啊！77").setNickname ("李大").setTonickname ("张三"));
        mCommentInfos.add (new CommentListTextView.CommentInfo ().setID (8888).setComment ("今天天气真好啊！88").setNickname ("小三").setTonickname ("王五"));
        mCommentInfos.add (new CommentListTextView.CommentInfo ().setID (9999).setComment ("今天天气真好啊！99").setNickname ("李大").setTonickname ("张三"));
        mCommentListTextView.setData (mCommentInfos);
        mCommentListTextView.setonCommentListener (new CommentListTextView.onCommentListener () {


            @Override
            public void onNickNameClick (final int position, final CommentListTextView.CommentInfo mInfo) {
                mTextView.append ("onNickNameClick  position = [" + position + "], mInfo = [" + mInfo + "]" + "\r\n");
            }

            @Override
            public void onToNickNameClick (final int position, final CommentListTextView.CommentInfo mInfo) {
                mTextView.append ("onToNickNameClick  position = [" + position + "], mInfo = [" + mInfo + "]" + "\r\n");
            }

            @Override
            public void onCommentItemClick (final int position, final CommentListTextView.CommentInfo mInfo) {
                mTextView.append ("onCommentItemClick  position = [" + position + "], mInfo = [" + mInfo + "]" + "\r\n");
            }

            @Override
            public void onOtherClick () {
                mTextView.append ("onOtherClick" + "\r\n");
            }
        });
    }
}
