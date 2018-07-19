> 前言：很早就看到，通过两个列表数据互相关联的、互相影响，来组织需要展现的数据；但是没有仔细思考过如何实现的。这次公司项目用到了类似美团外卖，点餐的列表，所以就动手写了一个demo，分享出来，有需要的童鞋拿去用吧！！😄


# 1.想要模仿的效果是这个样子的

![image.png](https://upload-images.jianshu.io/upload_images/9093439-f42ea6980aacfabc.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

# 2.项目思路：
## 1.布局编写
## 2.数据填充
```
1.左侧
2.右侧
```
## 3.两个列表关联
```
1.左侧列表，item项被点击，使右侧滑动指定位置
2.右侧列表控制左侧列表当前位置
- 1.给列表设滑动监听
- 2.判断当前显示的item==属于那个分类
```

# 3.反思总结：

- 1.列表中的前一项和后一项比较是否相等，有可能越界
- 2.点击之后，列表移动的距离不对


最后实现效果如下

![两个列表互相影响选择.gif](https://upload-images.jianshu.io/upload_images/9093439-455c9da626cc591f.gif?imageMogr2/auto-orient/strip)

------
【参考链接】

[仿美团饿了么选菜界面实现](https://blog.csdn.net/aa4100123/article/details/52919684)

[使用ItemDecoration为RecyclerView打造带悬停头部的分组列表](https://blog.csdn.net/zxt0601/article/details/52355199)
