# BundleDemo
![tu](https://github.com/brusewu/BundleDemo/blob/master/vs4xx-m27cv.gif)

什么是Bundle

Bundle主要用于传递数据；它保存的数据是以key-value(键值对)的形式存在的

用途：
我们经常使用Bundle在Activity之间传递数据，传递的数据可以是boolean,byte,int,long,float,double,string等基本类型或它们对应的数组，也可以是对象或对象数组。当Bundle传递的是对象或对象数组时候，必须实现Serializable或Parcelable接口。

传递基本类型：
Bundle提供了各种常用类型的putXxx()/getXxx()方法，用于读写基本类型的数据


传递Parcelable类型的对象：
