需要具备的ItemDecoration知识
# 1.是什么？
```
1.是分割线，但比分割线功能强大
2.可以绘制在item四周
3.为测量和绘制提供全方位的控制
```
# 2.实现分割的其他方式？
## 1.listview的divider
## 2.在布局中添加
### 1.对性能影响：
```
1.增加view的个数->view的数目越少，性能越好
2.增加布局的层级，为了一个分隔，需要产生额外布局
```
### 2.带来的副作用：
- item动画期间，divider也会跟着一起动画
### 3.缺乏灵活性：

## 3.使用itemdecoration
# 3.如何实现？
## 1.如何实现分割线？用getItemOffsets
```
1.描述列表内容的一种方式，目的在于区分两个条目
2.在真实的itemview上覆盖了矩形框。
3.当矩形框距上下左右的偏移量不为零时，就有了间隙，从而露出下面的背景色。
```

## 2.如何自定义分割线？
- 用onDraw()

## 3.内容如何设置到列表上
- recyclerview， addItemDecoration 方法
【参考链接】

https://blog.csdn.net/briblue/article/details/70161917
https://www.jianshu.com/p/b46a4ff7c10a
https://blog.csdn.net/say_from_wen/article/details/77184666
http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2017/0622/8105.html
https://www.jianshu.com/p/d58cbd61c40a