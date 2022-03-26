# ComparatorDemo

# 简单总结

默认情况下：Java实现Comparator排序是升序，即自然排序

根据参数，返回值来判断是否交换

对于a，b两个参数（a在前，b在后）

**jdk官方的升序基于：**

```css
< return -1
> return 1
= return 0
```

**降序就是反过来**

```css
< return 1
> return -1
= return 0
```

底层源码的实现可参考：[java comparator 升序、降序、倒序从源码角度理解](https://blog.csdn.net/u013066244/article/details/78997869)

如果要升序：那么a<b就是想要的顺序，所以return -1 ，false，不交换。

如果要降序：那么a<b就是不想要的顺序，所以return 1，true，要交换。

为了方便记忆，总结了如下的规律：

1. 当不管大于、小于、等于时，我们都返回 -1，那么就是倒序。
2. 当不管大于、小于、等于时，我们都返回0或者1时，效果是一样的，就是不排序。但是0表示的是，相同元素不排序，要是我们把等于返回为-1，那么两个相同的元素会交互顺序；
3. 当需要返回-1、1、0时，返回1的时候进行位置交换。

## 升序

```java
ArrayList< Integer > list = new ArrayList<>();
list.add(2);
list.add(1);
list.add(3);
list.add(4);
list.add(8);
list.add(8);
list.sort(new Comparator< Integer >() {
    @Override
    public int compare(Integer o1, Integer o2) {
        // 升序 返回1的时候进行位置交换
        if (o1 < o2) {
            return -1;
        } else if (o1 > o2) {
            return 1;
        } else {
            return 0;
        }
    }
});
System.out.print("排序后 = ");
for (int i = 0; i < list.size(); i++) {
    Integer integer = list.get(i);
    System.out.print(integer);
    if (i != list.size() - 1) {
        System.out.print("、");
    }
}
// 结果
// 排序后 = 1、2、3、4、8、8
```

## 降序

```java
ArrayList< Integer > list = new ArrayList<>();
list.add(2);
list.add(1);
list.add(3);
list.add(4);
list.add(8);
list.add(8);
list.sort(new Comparator< Integer >() {
    @Override
    public int compare(Integer o1, Integer o2) {
        // 降序 返回1的时候进行位置交换
        if (o1 > o2) {
            return -1;
        } else if (o1 < o2) {
            return 1;
        } else {
            return 0;
        }
    }
});
System.out.print("排序后 = ");
for (int i = 0; i < list.size(); i++) {
    Integer integer = list.get(i);
    System.out.print(integer);
    if (i != list.size() - 1) {
        System.out.print("、");
    }
}
// 结果
// 排序后 = 8、8、4、3、1、2
```

## 倒序

```java
ArrayList< Integer > list = new ArrayList<>();
list.add(2);
list.add(1);
list.add(3);
list.add(4);
list.add(8);
list.add(8);
list.sort(new Comparator< Integer >() {
    @Override
    public int compare(Integer o1, Integer o2) {
        //不管大于、小于和等于 都返回 -1
        return -1;
    }
});
System.out.print("排序后 = ");
for (int i = 0; i < list.size(); i++) {
    Integer integer = list.get(i);
    System.out.print(integer);
    if (i != list.size() - 1) {
        System.out.print("、");
    }
}
// 结果
// 排序后 = 8、8、4、3、1、2
```

## 不变

假设不管`大于、小于、等于`，我们都返回`0` ，会发现顺序没有变；而且你会发现，要是都返回`1`的话，顺序也是没有变的！

当不管`大于、小于、等于`时，我们都返回一个值时，`0`和`1`效果是一样的，就是不排序；`-1`就是倒序。

```java
ArrayList< Integer > list = new ArrayList<>();
list.add(2);
list.add(1);
list.add(3);
list.add(4);
list.add(8);
list.add(8);
list.sort(new Comparator< Integer >() {
    @Override
    public int compare(Integer o1, Integer o2) {
        // 返回0或者1的时候不排序
        return 1;
    }
});
System.out.print("排序后 = ");
for (int i = 0; i < list.size(); i++) {
    Integer integer = list.get(i);
    System.out.print(integer);
    if (i != list.size() - 1) {
        System.out.print("、");
    }
}
// 结果
// 排序后 = 2、1、3、4、8、8
```

其实0表示的是，相同元素不排序，要是我们把等于返回为-1，那么两个相同的元素会交互顺序；

对数字而言交换顺序没有关系，但是里面要是是Map对象的话，那就有关系，因为有时我们是希望相同元素不进行顺序调整的。

