package org.idea.design.pattern.create;

/**
 * 建造者模式测试
 */
public class ConstructArgTest {
    public static void main(String[] args) {
        //构造者_v1： 通过new来创建builder对象
        //ConstructArg.Builder builder = new ConstructArg.Builder();
        //builder.build();

        //构造者_v2: 单例模式+静态方法,创建builder对象
//        ConstructArg.Builder builder = ConstructArg.Builder.builder();
//        builder.setRef(true);
//        builder.setType(Object.class);
//        builder.build();

        //构造者_v3: 单例方法暴露给上层，更易用
        ConstructArg.Builder builder = ConstructArg.builder();
        builder.setRef(false);
        builder.setArg(Object.class);
//        builder.setType(Object.class);
        ConstructArg arg = builder.build();
        System.out.println(arg);
    }
}
