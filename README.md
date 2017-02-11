## RecycleView4种定位滚动方式演示

相信大家在项目中使用RecyclerView时，经常会遇到这样的需求：
将RecyclerView滑动到指定位置，或者检索RecyclerView的某一项（各个项的高度不确定），然后定位滚动这到一项，将它显示。

下面就讲解4种RecyclerView定位滚动的方式及具体效果演示。

## scrollBy 
![recyclerView.scrollBy(x, y)](http://7xq7yd.com1.z0.glb.clouddn.com/RecycleView-ScrollBy.gif)

使用：` recyclerView.scrollBy(x, y)`

`scrollBy(x, y)`这个方法是自己去控制移动的距离，单位是像素,所以在使用`scrollBy(x, y)`需要自己去计算移动的高度或宽度。


## scrollToPosition
![recyclerView.scrollToPosition(position)](http://7xq7yd.com1.z0.glb.clouddn.com/RecycleView-ScrollToPosition.gif)

使用： `recyclerView.scrollToPosition(position)`

`scrollToPosition(position)`这个方法的作用是定位到指定项，就是把你想显示的项显示出来，但是在屏幕的什么位置是不管的，只要那一项现在看得到了，那它就罢工了！ 

## smoothScrollToPosition
![recyclerView.smoothScrollToPosition(position)](http://7xq7yd.com1.z0.glb.clouddn.com/RecycleView-SmoothScriollToPosition.gif)

使用： `recyclerView.smoothScrollToPosition(position)`

`smoothScrollToPosition(position)`和`scrollToPosition(position)`效果基本相似，也是把你想显示的项显示出来，只要那一项现在看得到了，那它就罢工了，不同的是smoothScrollToPosition是平滑到你想显示的项，而scrollToPosition是直接定位显示！

## scrollToPositionWithOffset
![recyclerView.smoothScrollToPosition(position)](http://7xq7yd.com1.z0.glb.clouddn.com/RecycleView-ScrollToPositionWithOffset.gif)

使用： `  ((LinearLayoutManager)recyclerView.getLayoutManager()).scrollToPositionWithOffset(position,0);`

主角总是最后才登场，这种方式是定位到指定项如果该项可以置顶就将其置顶显示。比如:微信联系人的字母索引定位就是采用这种方式实现。

## 资源下载

[app-release.apk](https://raw.githubusercontent.com/z-chu/RecyclerView-Scroll-Sample/master/app/app-release.apk)

## 其他资料

[Android RecyclerView滚动定位](http://blog.csdn.net/tyzlmjj/article/details/49227601 " Android RecyclerView滚动定位")

[RecyclerView调用smoothScrollToPosition() 控制滑动速度](http://blog.csdn.net/a86261566/article/details/50906456)

[RecyclerView使用技巧-自动滚动](http://www.jianshu.com/p/b3edc873b42d)

[如何获取 RecyclerView 的滑动距离？](https://www.zhihu.com/question/31270461)

[ RecyclerView滚动到指定位置](http://blog.csdn.net/csdn_lqr/article/details/53859707 "RecyclerView滚动到指定位置")




