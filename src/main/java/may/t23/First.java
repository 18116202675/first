package may.t23;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class First {
  public static void main(String[] args) {
    //    changeArgs("你好", "我好", "大家好");
    //    primeNumber();
    SingaleTest a = SingaleTest.getInstance();
    //    SingaleTest a = new SingaleTest();
    System.out.println(a);
  }

  /*
       质数输出
        实现思路: 定义一个  标识是否为质数
        循环判断 满足条件时 改变标识状态
        优化 满足条件时 即可跳出当前循环 循环次数可改成对当前数进行 取根处理
  */
  public static void primeNumber() {
    System.out.println("开始输出100以内的质数");
    boolean flg = true;

    for (int i = 2; i <= 100; i++) {
      for (int j = 2; j <= Math.sqrt(i); j++) {
        if (i % j == 0) {
          flg = false;
          break;
        }
      }
      if (flg) {
        System.out.println(i);
      }
      flg = true;
    }
  }

  /*
     可变参数  会以数组的形式进行传参
  */
  public static void changeArgs(String... s) {
    System.out.println("你想要输出的是:");

    for (int i = 0; i < s.length; i++) {
      System.out.println(s[i]);
    }
  }

  /*
     冒泡排序
      实现思路  双重for循环
      第一层循环数组所有值 第二层循环当前比对的值的后面的数
      比较逻辑 当前值满足条件时(大于或者小于), 跟对比的值交换位置
  */
  @Test
  public void pSotr() {
    int[] s = new int[] {88, 55, 96, 36, 74, 47, 51};
    System.out.println(Arrays.toString(s));
    for (int i = 0; i < s.length - 1; i++) {
      for (int j = i + 1; j < s.length; j++) {
        if (s[i] > s[j]) {
          int t = s[i];
          s[i] = s[j];
          s[j] = t;
        }
      }
    }
    System.out.println(Arrays.toString(s));
  }
}

/*
 单例模式 实现  饿汉式  在类初始化的时候  就生成这个对象
*/
class SingaleTest {

  static SingaleTest a = new SingaleTest();

  private SingaleTest() {}

  public static SingaleTest getInstance() {
    return a;
  }
}

/*
 单例模式 实现  懒汉式  延迟类的加载 在被调用的时候进行初始化
*/
class SingaleTest2 {
  static SingaleTest2 a = null;

  private SingaleTest2() {}

  public static SingaleTest2 getInstance() {
    if (a == null) {
      a = new SingaleTest2();
    }
    return a;
  }

  interface d {
    int x = 1;
  }

  class c {
    int x = 0;
  }

  class e extends c implements d {
    // 因为不明确x到底是哪个的  所以会编译异常
    public void sou() {
      //      System.out.println(x);
    }
  }
}
