# CommentListTextView #
 

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

## 示例 ##
![](https://github.com/hnsugar/CommentListTextView/blob/master/pic1.jpg)
![](https://github.com/hnsugar/CommentListTextView/blob/master/pic2.gif)

![](http://i.imgur.com/BDFkB82.png)

 

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
