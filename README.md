# CommentListTextView#
 

## 说明

#### 我是将朋友圈分成了几个独立模块单独自定义的View，通过回调完成交互，耦合性算是非常低了，主要有以下及部分： 

1.评论布局（自定义TextView）

[CommentListTextView](https://github.com/hnsugar/CommentListTextView/)

[Lu_PingLunLayout](https://github.com/hnsugar/lu_pinglunlayout/)

2.点赞布局（原理和评论的自定义TextView一样，都是用的SpannableString）

[PraiseTextView](https://github.com/hnsugar/PraiseTextView/)
 
 
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
####设置监听

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
	
	package com.lujianchao.commentlisttextview.commentlisttextview;

	import android.content.Context;
	import android.graphics.Color;
	import android.text.SpannableString;
	import android.text.SpannableStringBuilder;
	import android.text.Spanned;
	import android.text.TextPaint;
	import android.text.method.LinkMovementMethod;
	import android.text.style.ClickableSpan;
	import android.text.style.ForegroundColorSpan;
	import android.util.AttributeSet;
	import android.view.View;
	import android.widget.TextView;
	
	import java.util.List;
	
	/**
	 * Created by lujianchao on 2017/1/19.
	 *
	 * @author lujianchao
	 */
	
	public class CommentListTextView extends TextView {
	    /**
	     * 所有评论数据
	     */
	    private List<CommentInfo> mInfos;
	    private onCommentListener mListener;
	
	    /**
	     * 点击文字会触发两个回调，用这个变量控制屏蔽掉一个
	     */
	    private boolean isNickNameClick = false;
	
	
	    /**
	     * 最大显示行数，超过指定行数多一行显示为查看更多文本，可设置文本
	     */
	    private int mMaxlines = 6;
	    /**
	     * 当超过n行后，n+1行显示为这个文本；
	     */
	    private String mMoreStr = "查看全部评论";
	    /**
	     * 谁回复谁中回复字符串，可以变成别的
	     */
	    private String mTalkStr = "回复";
	    /**
	     * 人名称颜色
	     */
	    private int mNameColor = Color.parseColor ("#fe671e");
	    private int mCommentColor = Color.parseColor ("#242424");
	    private int mTalkColor = Color.parseColor ("#242424");
	
	    public int getTalkColor () {
	        return mTalkColor;
	    }
	
	    public CommentListTextView setTalkColor (final int mTalkColor) {
	        this.mTalkColor = mTalkColor;
	        return this;
	    }
	
	    public int getMaxlines () {
	        return mMaxlines;
	    }
	
	    public CommentListTextView setMaxlines (final int mMaxlines) {
	        this.mMaxlines = mMaxlines;
	        return this;
	    }
	
	    public String getMoreStr () {
	        return mMoreStr;
	    }
	
	    public CommentListTextView setMoreStr (final String mMoreStr) {
	        this.mMoreStr = mMoreStr;
	        return this;
	    }
	
	    public String getTalkStr () {
	        return mTalkStr;
	    }
	
	    public CommentListTextView setTalkStr (final String mTalkStr) {
	        this.mTalkStr = mTalkStr;
	        return this;
	    }
	
	    public int getNameColor () {
	        return mNameColor;
	    }
	
	    public CommentListTextView setNameColor (final int mNameColor) {
	        this.mNameColor = mNameColor;
	        return this;
	    }
	
	    public int getCommentColor () {
	        return mCommentColor;
	    }
	
	    public CommentListTextView setCommentColor (final int mCommentColor) {
	        this.mCommentColor = mCommentColor;
	        return this;
	    }
	
	    public CommentListTextView (final Context context) {
	        super (context);
	    }
	
	
	
	    public CommentListTextView (final Context context, final AttributeSet attrs) {
	        super (context, attrs);
	    }
	
	    public CommentListTextView setonCommentListener (final onCommentListener mListener) {
	        this.mListener = mListener;
	        return this;
	    }
	
	    public void setData (List<CommentInfo> mInfos) {
	        this.mInfos = mInfos;
	        /**
	         * textview必须设置，否则自定义点击事件没响应
	         */
	        setMovementMethod (LinkMovementMethod.getInstance ());
	        setHighlightColor (Color.TRANSPARENT);
	        setText (getCommentString ());
	        setOnClickListener (new OnClickListener () {
	            @Override
	            public void onClick (final View v) {
	                if (isNickNameClick) {
	                    isNickNameClick = false;
	                    return;
	                }
	                if (mListener != null) {
	                    mListener.onOtherClick ();
	                }
	            }
	        });
	    }
	
	    private SpannableStringBuilder getCommentString () {
	        SpannableStringBuilder mStringBuilder = new SpannableStringBuilder ();
	        /**
	         * 对评论数据进行处理，默认超过mMaxlines条则第mMaxlines+1条显示查看全部
	         */
	        for (int mI = 0; mI < mInfos.size (); mI++) {
	            final CommentInfo mInfo = mInfos.get (mI);
	            /**
	             * 拼接成“张三：今天天气真好”这种形式，就是一行显示的文本。
	             * 或者为张三 回复 李四：今天天气真好
	             */
	            String mS = null;
	            if (mInfo.getTonickname () == null || mInfo.getTonickname ().equals ("")) {
	                mS = mInfo.getNickname () + "：" + mInfo.getComment ();
	            } else {
	                mS = mInfo.getNickname () + mTalkStr + mInfo.getTonickname () + "：" + mInfo.getComment ();
	            }
	            /**
	             * 获得一个SpannableString文本的对象
	             */
	            SpannableString mString = new SpannableString (mS);
	            /**
	             * 我们假设“张三：今天天气真好”这句话中“张三：”这三个字符为橘红色字体并且添加点击事件，其余评论内容单独添加事件，一般业务需求是点击人名跳到个人主页或者聊天，点击评论内容是对这条评论进行评论。
	             * 谁回复谁同理，就不写了
	             */
	            int start = 0;
	            int end = (mInfo.getNickname ()).length ();
	            final int finalMI = mI;
	            /**
	             * 处理第一个人名
	             * 设置文本从第0个开始到end位置具有点击事件，点击后回调，updateDrawState中设置文本从第0个到第end位置的文本前景色就是文字颜色为橘红色
	             */
	            mString.setSpan (new ClickableSpan () {
	
	                @Override
	                public void updateDrawState (TextPaint ds) {
	                    /**
	                     * 是否有下划线
	                     */
	                    ds.setUnderlineText (false);
	                    /**
	                     * 橘红色字体
	                     */
	                    ds.setColor (mNameColor);
	                }
	
	                @Override
	                public void onClick (final View widget) {
	                    isNickNameClick = true;
	                    if (mListener != null) {
	                        mListener.onNickNameClick (finalMI, mInfos.get (finalMI));
	                    }
	                }
	            }, 0, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
	            mString.setSpan (new ForegroundColorSpan (mTalkColor),mInfo.getNickname ().length (),mInfo.getNickname ().length ()+mTalkStr.length (),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
	
	            /**
	             * 处理第二个人名
	             */
	            if (mInfo.getTonickname () != null && !mInfo.getTonickname ().equals ("")) {
	                start = mInfo.getNickname ().length () + mTalkStr.length ();
	                end = mInfo.getNickname ().length () + mTalkStr.length () + mInfo.getTonickname ().length ();
	                mString.setSpan (new ClickableSpan () {
	                    @Override
	                    public void updateDrawState (TextPaint ds) {
	                        /**
	                         * 是否有下划线
	                         */
	                        ds.setUnderlineText (false);
	                        /**
	                         * 橘红色字体
	                         */
	                        ds.setColor (mNameColor);
	                    }
	
	                    @Override
	                    public void onClick (final View widget) {
	                        isNickNameClick = true;
	                        if (mListener != null) {
	                            mListener.onToNickNameClick (finalMI, mInfos.get (finalMI));
	                        }
	                    }
	                }, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
	            }
	
	            /**
	             * 设置文本从第end个开始到最后位置具有点击事件，点击后回调，updateDrawState中设置文本从第end个到最后的文本前景色就是文字颜色为黑色
	             */
	
	            mString.setSpan (new ClickableSpan () {
	
	                @Override
	                public void updateDrawState (TextPaint ds) {
	                    /**
	                     * 是否有下划线
	                     */
	                    ds.setUnderlineText (false);
	                    /**
	                     * 黑色字体
	                     */
	                    ds.setColor (mCommentColor);
	                }
	
	                @Override
	                public void onClick (final View widget) {
	                    isNickNameClick = true;
	                    if (mListener != null) {
	                        mListener.onCommentItemClick (finalMI, mInfos.get (finalMI));
	                    }
	                }
	            }, end, mS.length (), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
	            /**
	             * 设置文本从第end个到最后的文本前景色就是文字颜色为黑色，即评论内容为黑色
	             */
	
	            mStringBuilder.append (mString);
	            mStringBuilder.append ("\r\n");
	            if (mI == (mMaxlines - 1)) {
	                break;
	            }
	        }
	        if (mInfos.size () > mMaxlines) {
	            mStringBuilder.append ("查看全部评论");
	        } else {
	            /**
	             * 如果不大于3条，则删除最后的换行
	             */
	            mStringBuilder.delete (mStringBuilder.length () - 2, mStringBuilder.length ());
	        }
	        return mStringBuilder;
	    }
	
	
	    public interface onCommentListener {
	        /**
	         * 点击人名的回调
	         *
	         * @param position 第几条评论  从0开始
	         * @param mInfo    评论相关信息
	         */
	        public void onNickNameClick (int position, CommentInfo mInfo);
	
	        /**
	         * 点击被评论人名的回调
	         *
	         * @param position 第几条评论  从0开始
	         * @param mInfo    评论相关信息
	         */
	        public void onToNickNameClick (int position, CommentInfo mInfo);
	
	        /**
	         * 点击评论文本回调，主要针对对谁回复操作
	         *
	         * @param position
	         * @param mInfo
	         */
	        public void onCommentItemClick (int position, CommentInfo mInfo);
	
	        /**
	         * 点击非文字部分
	         */
	        public void onOtherClick ();
	    }
	
	    public static  class CommentInfo {
	        /**
	         * 评论ID
	         */
	        private int ID;
	        /**
	         * 评论人名称
	         */
	        private String nickname;
	        /**
	         * 评论内容
	         */
	        private String comment;
	        /**
	         * 被评论人名称
	         */
	        private String tonickname;
	
	        @Override
	        public String toString () {
	            return "CommentInfo{" +
	                    "ID=" + ID +
	                    ", nickname='" + nickname + '\'' +
	                    ", comment='" + comment + '\'' +
	                    ", tonickname='" + tonickname + '\'' +
	                    '}';
	        }
	
	        /**
	         * 下面可以继续写自定义需要的属性，需要传什么写什么
	         */
	
	
	        public int getID () {
	            return ID;
	        }
	
	        public CommentInfo setID (final int mID) {
	            ID = mID;
	            return this;
	        }
	
	        public String getNickname () {
	            return nickname;
	        }
	
	        public CommentInfo setNickname (final String mNickname) {
	            nickname = mNickname;
	            return this;
	        }
	
	        public String getComment () {
	            return comment;
	        }
	
	        public CommentInfo setComment (final String mComment) {
	            comment = mComment;
	            return this;
	        }
	
	        public String getTonickname () {
	            return tonickname;
	        }
	
	        public CommentInfo setTonickname (final String mTonickname) {
	            tonickname = mTonickname;
	            return this;
	        }
	    }
	}
