# 简介
一个 安卓开发的单例工厂，当项目里需要用到大量单例模式时用此单例工厂进行快速开发
使用 LruCache维护所有已经产生的单例，可以设置MAX_SIZE大小来改变LruCache中单例的最大数量。
 
# 使用方法
 Apple apple =InstanceFctrory.getInsFactory().getInstance(Apple.class);
 
