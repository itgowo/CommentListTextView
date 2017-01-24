# CommentListTextView#
 

## 说明

#### 我是将朋友圈分成了几个独立模块单独自定义的View，通过回调完成交互，耦合性算是非常低了，主要有以下及部分： 

1.评论布局（自定义TextView）

[CommentListTextView](https://github.com/hnsugar/CommentListTextView/)

[Lu_PingLunLayout](https://github.com/hnsugar/lu_pinglunlayout/)

2.点赞布局（原理和评论的自定义TextView一样，都是用的SpannableString）

3.图片列表（出门右转，理论上没有数量限制，和listView配合使用也很好，缓存也自己处理了）

[MultiImageViewLayout](https://github.com/hnsugar/MultiImageViewLayout/)

我也是找第三方例子不好找，于是自己写了一个，我和同事还打算做一套IM系统，app和后台都要做，我们自己定义sdk，我们还要封装H5，类似hbuilder如果有什么问题，可以联系我，

QQ:1264957104

CSDN:http://blog.csdn.net/hnsugar

GitHub:https://github.com/hnsugar

个人做测试项目的服务器:http://lujianchao.com

链接是跳转到GitHub的，部分文章我会直接贴出关键View的代码。

## 示例 ##

![](http://img.blog.csdn.net/20170123154509101?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvaG5zdWdhcg==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
![](http://img.blog.csdn.net/20170123155306974?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvaG5zdWdhcg==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
![](http://i.imgur.com/BDFkB82.png)

##主要方法##
####设置评论最大显示行数####
	mCommentListTextView.setMaxlines (6);
####设置超过最大行数下面显示的提示文本####
	mCommentListTextView.setMoreStr ("查看更多");
####设置名字文本显示颜色####
	mCommentListTextView.setNameColor (Color.parseColor ("#fe671e"));
####设置评论内容文本颜色####
	mCommentListTextView.setCommentColor (Color.parseColor ("#242424"));
####设置名字之间的文本####
	mCommentListTextView.setTalkStr ("回复");
####设置名字之间的文本颜色####
	mCommentListTextView.setTalkColor (Color.parseColor ("#242424"));
####设置显示数据####
	mCommentListTextView.setData (mCommentInfos);
####设置监听####
	mCommentListTextView.setonCommentListener (new CommentListTextView.onCommentListener ())
## onNickNameClick (int position, CommentListTextView.CommentInfo mInfo)  ##
“A回复B”中A名称被点击
position是第几条评论，mInfo是这条评论的信息

## onToNickNameClick (int position, CommentListTextView.CommentInfo mInfo) ##
“A回复B”中B名称被点击
position是第几条评论，mInfo是这条评论的信息

## onCommentItemClick (int position, CommentListTextView.CommentInfo mInfo)  ##
position是第几条评论，mInfo是这条评论的信息

## onOtherClick ##
内部处理了点击文字会触发两个回调的问题，这个是点击非文字或者没有单独定义点击事件的回调

 




## 布局 ##
 
	<?xml version="1.0" encoding="utf-8"?>
		<LinearLayout
		xmlns:android="http://schemas.android.com/apk/res/android"
		xmlns:tools="http://schemas.android.com/tools"
		android:id="@+id/activity_main"
		android:layout_width="match_parent"
		android:layout_height="match_parent"
		android:orientation="vertical"
		android:paddingBottom="@dimen/activity_vertical_margin"
		android:paddingLeft="@dimen/activity_horizontal_margin"
		android:paddingRight="@dimen/activity_horizontal_margin"
		android:paddingTop="@dimen/activity_vertical_margin"
		tools:context="com.lujianchao.commentlisttextview.commentlisttextview.MainActivity">

		<com.lujianchao.commentlisttextview.commentlisttextview.CommentListTextView
			android:id="@+id/commentlist"
			android:layout_width="match_parent"
			android:layout_height="wrap_content"
			android:textSize="15sp"/>

		<TextView
			android:id="@+id/log"
			android:layout_width="match_parent"
			android:scrollbars="vertical"
			android:layout_height="match_parent"/>
	</LinearLayout>




## 代码 ##
    
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





##源码##
	package com.lujianchao.praisetextview;
	
	import android.content.Context;
	import android.graphics.Color;
	import android.graphics.Rect;
	import android.graphics.drawable.Drawable;
	import android.text.Spannable;
	import android.text.SpannableStringBuilder;
	import android.text.Spanned;
	import android.text.TextPaint;
	import android.text.TextUtils;
	import android.text.method.LinkMovementMethod;
	import android.text.style.ClickableSpan;
	import android.text.style.ImageSpan;
	import android.util.AttributeSet;
	import android.view.View;
	import android.widget.TextView;
	
	import java.util.List;
	
	/**
	 * Created by lujianchao on 2017/1/23.
	 *
	 * @author lujianchao
	 */
	
	public class PraiseTextView extends TextView {
	    private List<PraiseInfo> mPraiseInfos;
	    private onPraiseClickListener mListener;
	    /**
	     * 第一个显示的图标
	     */
	    private int mIcon = R.drawable.emoji_1f0cf;
	    /**
	     * 名字文字颜色，分割文本用textview默认的，自行设置即可
	     */
	    private int mNameTextColor = Color.GREEN;
	    /**
	     * 不设置默认与文字大小匹配
	     */
	    private Rect mIconSize = null;
	    /**
	     * 中间分割的文本
	     */
	    private String mMiddleStr = "，";
	    private boolean isClickName = false;
	
	    public PraiseTextView (Context context) {
	        super (context);
	    }
	
	    public PraiseTextView (Context context, AttributeSet attrs) {
	        super (context, attrs);
	    }
	
	    public onPraiseClickListener getonPraiseListener () {
	        return mListener;
	    }
	
	    public PraiseTextView setonPraiseListener (onPraiseClickListener mListener) {
	        this.mListener = mListener;
	        return this;
	    }
	
	    public String getMiddleStr () {
	        return mMiddleStr;
	    }
	
	    public PraiseTextView setMiddleStr (final String mMiddleStr) {
	        this.mMiddleStr = mMiddleStr;
	        return this;
	    }
	
	    public int getIcon () {
	        return mIcon;
	    }
	
	    public PraiseTextView setIcon (int mIcon) {
	        this.mIcon = mIcon;
	        return this;
	    }
	
	    public int getNameTextColor () {
	        return mNameTextColor;
	    }
	
	    public PraiseTextView setNameTextColor (int mNameTextColor) {
	        this.mNameTextColor = mNameTextColor;
	        return this;
	    }
	
	    public Rect getIconSize () {
	        return mIconSize;
	    }
	
	    /**
	     * 不设置默认与文字大小匹配
	     */
	    public PraiseTextView setIconSize (Rect mIconSize) {
	        this.mIconSize = mIconSize;
	        return this;
	    }
	
	    public PraiseTextView setData (List<PraiseInfo> mPraiseInfos) {
	        this.mPraiseInfos = mPraiseInfos;
	        this.setHighlightColor (Color.TRANSPARENT);
	        this.setMovementMethod (LinkMovementMethod.getInstance ());
	        this.setText (getPraiseString ());
	        this.setOnClickListener (new OnClickListener () {
	            @Override
	            public void onClick (final View mView) {
	                if (isClickName) {
	                    isClickName=false;
	                    return;
	                }
	                if (mListener != null) {
	                    mListener.onOtherClick ();
	                }
	            }
	        });
	        return this;
	    }
	
	    private SpannableStringBuilder getPraiseString () {
	        SpannableStringBuilder mBuilder = new SpannableStringBuilder ("我");
	        mBuilder.setSpan (new iconimage (getResources ().getDrawable (mIcon)), 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
	        for (int mI = 0; mI < mPraiseInfos.size (); mI++) {
	            if (!TextUtils.isEmpty (mPraiseInfos.get (mI).getNickname ())) {
	                mBuilder.append (mPraiseInfos.get (mI).getNickname () + mMiddleStr);
	                final int finalMI = mI;
	                mBuilder.setSpan (new ClickableSpan () {
	                    @Override
	                    public void onClick (final View mView) {
	                        isClickName = true;
	                        if (mListener != null) {
	                            mListener.onClick (finalMI, mPraiseInfos.get (finalMI));
	                        }
	                    }
	
	                    @Override
	                    public void updateDrawState (final TextPaint ds) {
	                        super.updateDrawState (ds);
	                        ds.setUnderlineText (false);
	                        ds.setColor (mNameTextColor);
	                    }
	                }, mBuilder.length () - mPraiseInfos.get (mI).getNickname ().length () - mMiddleStr.length (), mBuilder.length () - mMiddleStr.length (), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
	            }
	        }
	        mBuilder = new SpannableStringBuilder (mBuilder, 0, mBuilder.length () - 1);
	        mBuilder.append (" ");
	        return mBuilder;
	    }
	
	    public interface onPraiseClickListener {
	        public void onClick (int position, PraiseInfo mPraiseInfo);
	
	        public void onOtherClick ();
	    }
	
	    public static class PraiseInfo {
	        private int id;
	        private String nickname;
	        private String logo;
	
	        @Override
	        public String toString () {
	            return "PraiseInfo{" +
	                    "id=" + id +
	                    ", nickname='" + nickname + '\'' +
	                    ", logo='" + logo + '\'' +
	                    '}';
	        }
	
	        public int getId () {
	            return id;
	        }
	
	        public PraiseInfo setId (final int mId) {
	            id = mId;
	            return this;
	        }
	
	        public String getNickname () {
	            return nickname;
	        }
	
	        public PraiseInfo setNickname (final String mNickname) {
	            nickname = mNickname;
	            return this;
	        }
	
	        public String getLogo () {
	            return logo;
	        }
	
	        public PraiseInfo setLogo (final String mLogo) {
	            logo = mLogo;
	            return this;
	        }
	    }
	
	    public class iconimage extends ImageSpan {
	        private Drawable mDrawable;
	
	        public iconimage (Drawable d) {
	            super (d);
	            mDrawable = d;
	        }
	
	        @Override
	        public Drawable getDrawable () {
	            if (mIconSize == null) {
	                Rect mRect = new Rect ();
	                getPaint ().getTextBounds ("我", 0, 1, mRect);
	                mDrawable.setBounds (mRect);
	            } else {
	                mDrawable.setBounds (mIconSize);
	            }
	            return mDrawable;
	        }
	    }
	}
