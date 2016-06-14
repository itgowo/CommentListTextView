package com.lujianchao.lu_comment_textview_demo;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 * https://github.com/hnsugar
 * Created by Lu on 2016/4/13.
 */
public class Lu_Comment_TextView extends TextView {
    private Lu_PingLun_info_Entity mLu_pingLun_info_entity;
    private boolean isClickName = false;

    public Lu_Comment_TextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Lu_Comment_TextView(Context context) {
        super(context);
    }

    public Lu_PingLun_info_Entity getLu_pingLun_info_entity(String ID, String mUser_A_ID, String mUser_A_Name, String mUser_A_Logo, String mUser_B_ID, String mUser_B_Name, String mUser_B_Logo, String mText, int mNameColor, int mDefaultColor) {
        mLu_pingLun_info_entity = new Lu_PingLun_info_Entity("", "", "");
        mLu_pingLun_info_entity.setNameColor(mNameColor).setID(ID).setUser_A_ID(mUser_A_ID).setUser_A_Name(mUser_A_Name).setUser_B_ID(mUser_B_ID).setUser_B_Name(mUser_B_Name).setText(mText).setDefaultColor(mDefaultColor).setUser_A_Logo(mUser_A_Logo).setUser_B_Logo(mUser_B_Logo);
        return mLu_pingLun_info_entity;
    }

    public Lu_PingLun_info_Entity getLu_pingLun_info_entity(String ID, String mUser_A_ID, String mUser_A_Name, String mUser_A_Logo, String mUser_B_ID, String mUser_B_Name, String mUser_B_Logo, String mText) {
        mLu_pingLun_info_entity = new Lu_PingLun_info_Entity("", "", "");
        mLu_pingLun_info_entity.setUser_A_ID(mUser_A_ID).setID(ID).setUser_A_Name(mUser_A_Name).setUser_B_ID(mUser_B_ID).setUser_B_Name(mUser_B_Name).setText(mText).setUser_B_Logo(mUser_B_Logo).setUser_A_Logo(mUser_A_Logo);
        return mLu_pingLun_info_entity;
    }

    public Lu_PingLun_info_Entity getLu_pingLun_info_entity(String ID, String mUser_A_ID, String mUser_A_Name, String mUser_A_Logo, String mText, int mNameColor, int mDefaultColor) {
        mLu_pingLun_info_entity = new Lu_PingLun_info_Entity("", "", "");
        mLu_pingLun_info_entity.setNameColor(mNameColor).setID(ID).setUser_A_ID(mUser_A_ID).setUser_A_Name(mUser_A_Name).setText(mText).setDefaultColor(mDefaultColor).setUser_A_Logo(mUser_A_Logo);
        return mLu_pingLun_info_entity;
    }

    public Lu_PingLun_info_Entity getLu_pingLun_info_entity(String ID, String mUser_A_ID, String mUser_A_Name, String mUser_A_Logo, String mText) {
        mLu_pingLun_info_entity = new Lu_PingLun_info_Entity("", "", "");
        mLu_pingLun_info_entity.setUser_A_ID(mUser_A_ID).setID(ID).setUser_A_Name(mUser_A_Name).setText(mText).setUser_A_Logo(mUser_A_Logo);
        return mLu_pingLun_info_entity;
    }

    public void setText_PingLun(final Lu_PingLun_info_Entity mText, final Lu_PingLunListener mListener) {
        mLu_pingLun_info_entity = mText;
        setTextColor(mText.getDefaultColor());
        setHighlightColor(Color.TRANSPARENT);
        setMovementMethod(LinkMovementMethod.getInstance());
        setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onClickListener(mText);
                if (isClickName) {
                    isClickName = false;
                    return;
                }
                mListener.onClickOtherListener(mText);
            }
        });
        setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mListener.onLongClickListener(mText);
                return false;
            }
        });
        if (mText.getUser_B_ID() != null && !mText.getUser_B_ID().equals("") && mText.getUser_B_Name() != null && !mText.getUser_B_Name().equals("")) {
            SpannableString spanText1 = new SpannableString(mText.getUser_A_Name() + "回复" + mText.getUser_B_Name() + "：" + mText.getText());
            spanText1.setSpan(new ForegroundColorSpan(mText.getNameColor()), 0, mText.getUser_A_Name().length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            spanText1.setSpan(new Lu_PingLunNameonClick(mText, 1, mListener), 0, mText.getUser_A_Name().length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            spanText1.setSpan(new ForegroundColorSpan(mText.getNameColor()), (mText.getUser_A_Name() + "回复").length(), (mText.getUser_A_Name() + "回复" + mText.getUser_B_Name() + "：").length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            spanText1.setSpan(new Lu_PingLunNameonClick(mText, 2, mListener), (mText.getUser_A_Name() + "回复").length(), (mText.getUser_A_Name() + "回复" + mText.getUser_B_Name() + "：").length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            spanText1.setSpan(new Lu_PingLunNameonClick(mText, 3, mListener), (mText.getUser_A_Name() + "回复" + mText.getUser_B_Name() + "：").length(), spanText1.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            setText(spanText1);
        } else {
            SpannableString spanText1 = new SpannableString(mText.getUser_A_Name() + "：" + mText.getText());
            spanText1.setSpan(new ForegroundColorSpan(mText.getNameColor()), 0, spanText1.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            spanText1.setSpan(new Lu_PingLunNameonClick(mText, 1, mListener), 0, mText.getUser_A_Name().length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            spanText1.setSpan(new Lu_PingLunNameonClick(mText, 3, mListener), (mText.getUser_A_Name() + "：").length(), spanText1.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            setText(spanText1);
        }
    }

    public static CharSequence getSpanTextFormColor(String string, int start, int end, int color) {
        SpannableString spanText1 = new SpannableString(string);
        spanText1.setSpan(new ForegroundColorSpan(color), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spanText1;
    }

    public class Lu_PingLun_info_Entity {
        private int NameColor = 0xff576b95;
        private int DefaultColor = 0xff000333;
        private String ID = null;
        private String mUser_A_ID = null;
        private String mUser_A_Name = null;
        private String mUser_A_Logo = null;
        private String mUser_B_ID = null;
        private String mUser_B_Name = null;
        private String mUser_B_Logo = null;
        private String mText = null;
        private String mTag = null;
        private Object mObjectTag = null;

        public String getID() {
            return ID;
        }

        public Lu_PingLun_info_Entity setID(String mID) {
            ID = mID;
            return this;
        }

        public String getTag() {
            return mTag;
        }

        public void setTag(String mTag) {
            this.mTag = mTag;
        }

        public Object getObjectTag() {
            return mObjectTag;
        }

        public void setObjectTag(Object mObjectTag) {
            this.mObjectTag = mObjectTag;
        }

        @Override
        public String toString() {
            return "Lu_PingLun_info_Entity{" +
                    "NameColor=" + NameColor +
                    ", DefaultColor=" + DefaultColor +
                    ", mUser_A_ID='" + mUser_A_ID + '\'' +
                    ", mUser_A_Name='" + mUser_A_Name + '\'' +
                    ", mUser_A_Logo='" + mUser_A_Logo + '\'' +
                    ", mUser_B_ID='" + mUser_B_ID + '\'' +
                    ", mUser_B_Name='" + mUser_B_Name + '\'' +
                    ", mUser_B_Logo='" + mUser_B_Logo + '\'' +
                    ", mText='" + mText + '\'' +
                    ", mTag='" + mTag + '\'' +
                    ", mObjectTag=" + mObjectTag +
                    '}';
        }

        public Lu_PingLun_info_Entity(String mUser_A_ID, String mUser_A_Name, String mUser_A_Logo, String mUser_B_ID, String mUser_B_Name, String mUser_B_Logo, String mText, int mNameColor, int mDefaultcolor) {
            NameColor = mNameColor;
            this.mUser_A_ID = mUser_A_ID;
            this.mUser_A_Name = mUser_A_Name;
            this.mUser_A_Logo = mUser_A_Logo;
            this.mUser_B_ID = mUser_B_ID;
            this.mUser_B_Name = mUser_B_Name;
            this.mUser_B_Logo = mUser_B_Logo;
            this.mText = mText;
            DefaultColor = mDefaultcolor;
        }

        public Lu_PingLun_info_Entity(String mUser_A_ID, String mUser_A_Name, String mUser_A_Logo, String mUser_B_ID, String mUser_B_Name, String mUser_B_Logo, String mText) {
            this.mUser_A_ID = mUser_A_ID;
            this.mUser_A_Name = mUser_A_Name;
            this.mUser_A_Logo = mUser_A_Logo;
            this.mUser_B_ID = mUser_B_ID;
            this.mUser_B_Name = mUser_B_Name;
            this.mUser_B_Logo = mUser_B_Logo;
            this.mText = mText;
        }

        public Lu_PingLun_info_Entity(String mUser_A_ID, String mUser_A_Name, String mText) {
            this.mUser_A_ID = mUser_A_ID;
            this.mUser_A_Name = mUser_A_Name;
            this.mText = mText;
        }

        public int getNameColor() {
            return NameColor;
        }

        public Lu_PingLun_info_Entity setNameColor(int mNameColor) {
            NameColor = mNameColor;
            return this;
        }

        public int getDefaultColor() {
            return DefaultColor;
        }

        public Lu_PingLun_info_Entity setDefaultColor(int mDefaultColor) {
            DefaultColor = mDefaultColor;
            return this;
        }

        public String getUser_A_ID() {
            return mUser_A_ID;
        }

        public Lu_PingLun_info_Entity setUser_A_ID(String mUser_A_ID) {
            this.mUser_A_ID = mUser_A_ID;
            return this;
        }

        public String getUser_A_Name() {
            return mUser_A_Name;
        }

        public Lu_PingLun_info_Entity setUser_A_Name(String mUser_A_Name) {
            this.mUser_A_Name = mUser_A_Name;
            return this;
        }

        public String getUser_B_ID() {
            return mUser_B_ID;
        }

        public Lu_PingLun_info_Entity setUser_B_ID(String mUser_B_ID) {
            this.mUser_B_ID = mUser_B_ID;
            return this;
        }

        public String getUser_B_Name() {
            return mUser_B_Name;
        }

        public Lu_PingLun_info_Entity setUser_B_Name(String mUser_B_Name) {
            this.mUser_B_Name = mUser_B_Name;
            return this;
        }

        public String getText() {
            return mText;
        }

        public Lu_PingLun_info_Entity setText(String mText) {
            this.mText = mText;
            return this;
        }

        public String getUser_A_Logo() {
            return mUser_A_Logo;
        }

        public Lu_PingLun_info_Entity setUser_A_Logo(String mUser_A_Logo) {
            this.mUser_A_Logo = mUser_A_Logo;
            return this;
        }

        public String getUser_B_Logo() {
            return mUser_B_Logo;
        }

        public Lu_PingLun_info_Entity setUser_B_Logo(String mUser_B_Logo) {
            this.mUser_B_Logo = mUser_B_Logo;
            return this;
        }
    }

    public class Lu_PingLunNameonClick extends ClickableSpan {
        private Lu_PingLun_info_Entity mLu_pingLun_info_entity;
        private Lu_PingLunListener mLu_pingLunNameonClickListener;
        private int position;

        public Lu_PingLunNameonClick(Lu_PingLun_info_Entity mLu_pingLun_info_entity, int position, Lu_PingLunListener mListener) {
            this.mLu_pingLun_info_entity = mLu_pingLun_info_entity;
            this.position = position;
            this.mLu_pingLunNameonClickListener = mListener;
        }

        @Override
        public void onClick(View widget) {
            isClickName = true;
            if (position == 1) {
                mLu_pingLunNameonClickListener.onNameClickListener(mLu_pingLun_info_entity.mUser_A_ID, mLu_pingLun_info_entity.mUser_A_Name, mLu_pingLun_info_entity.mUser_A_Logo, mLu_pingLun_info_entity, position);
            } else if (position == 2) {
                mLu_pingLunNameonClickListener.onNameClickListener(mLu_pingLun_info_entity.mUser_B_ID, mLu_pingLun_info_entity.mUser_B_Name, mLu_pingLun_info_entity.mUser_B_Logo, mLu_pingLun_info_entity, position);
            } else if (position == 3) {
                mLu_pingLunNameonClickListener.onTextClickListener(mLu_pingLun_info_entity.mText, mLu_pingLun_info_entity, 3);
            }
        }

        @Override
        public void updateDrawState(TextPaint ds) {
            super.updateDrawState(ds);
            ds.setUnderlineText(false);
            if (position == 1 || position == 2) {
                ds.setColor(mLu_pingLun_info_entity.getNameColor());
            } else {
                ds.setColor(mLu_pingLun_info_entity.getDefaultColor());
            }
        }
    }

    public interface Lu_PingLunListener {
        /**
         * 返回点击评论区被选择人信息
         * 为什么要传回这么多参数？总比少了强，哪个方便用哪个！！！
         *
         * @param onClickID               被点击用户ID
         * @param onClickName             被点击用户名
         * @param mLu_pingLun_info_entity 评论消息对象
         * @param position                被点击位置，1为第一个人，2为第二个人，3为评论区点击
         */
        public void onNameClickListener(String onClickID, String onClickName, String onClickLogo, Lu_PingLun_info_Entity mLu_pingLun_info_entity, int position);

        /**
         * 评论文本监听
         *
         * @param onClickText
         * @param mLu_pingLun_info_entity
         * @param position
         */
        public void onTextClickListener(String onClickText, Lu_PingLun_info_Entity mLu_pingLun_info_entity, int position);

        /**
         * 点击其他区域监听
         *
         * @param mLu_pingLun_info_entity
         */
        public void onClickOtherListener(Lu_PingLun_info_Entity mLu_pingLun_info_entity);

        /**
         * 长按任何位置监听
         *
         * @param mLu_pingLun_info_entity
         */
        public void onLongClickListener(Lu_PingLun_info_Entity mLu_pingLun_info_entity);

        /**
         * 任何位置点击监听
         *
         * @param mLu_pingLun_info_entity
         */
        public void onClickListener(Lu_PingLun_info_Entity mLu_pingLun_info_entity);
    }
}