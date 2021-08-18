package org.idea.design.pattern.create;

/**
 * 建造者模式
 *
 * 当 isRef 为 true 的时候，arg 表示 String 类型的 refBeanId，type 不需要设置；
 * 当 isRef 为 false 的时候，arg、type 都需要设置
 */
public class ConstructArg {

    private boolean isRef;
    private Class type;
    private Object arg;

    private ConstructArg() {
    }

    public static Builder builder() {
        return Builder.builder();
    }

    public boolean isRef() {
        return isRef;
    }

    public Class getType() {
        return type;
    }

    public Object getArg() {
        return arg;
    }

    private void setRef(boolean ref) {
        isRef = ref;
    }

    private void setType(Class type) {
        this.type = type;
    }

    private void setArg(Object arg) {
        this.arg = arg;
    }

    /**
     * public static:   Builder作为内部静态类
     */
    public static class Builder {
        private static Builder builder;
        private boolean isRef;
        private Class type;
        private Object arg;

//        public Builder() {}
        private Builder() {}

        public static Builder builder() {
            if (builder == null) {//第一重检测，避免首次创建后，后续不必要的加锁
                synchronized (Builder.class) {
                    if (builder == null) {//第二重检测，避免首次创建后，后续重复创建
                        builder = new Builder();
                    }
                }
            }
            clear();//保证每次获取的建造者对象都是init状态
            return builder;
        }

        public Builder setRef(boolean ref) {
            this.isRef = ref;
            return this;
        }

        public Builder setType(Class type) {
            this.type = type;
            return this;
        }

        public Builder setArg(Object arg) {
            this.arg = arg;
            return this;
        }

        public ConstructArg build() {
            if (this.isRef) {
                if (this.type != null) {
                    throw new IllegalArgumentException("type must empty");
                }
            } else {
                if (this.type == null) {
                    throw new IllegalArgumentException("type must not empty");
                }
                if (this.arg == null) {
                    throw new IllegalArgumentException("arg must not empty");
                }
            }
            ConstructArg obj = build(this);
            return obj;
        }

        private static void clear() {
            builder.setRef(false);
            builder.setType(null);
            builder.setArg(null);
        }

        private ConstructArg build(Builder builder) {
            ConstructArg constructArg = new ConstructArg();
            constructArg.setRef(builder.isRef);
            constructArg.setType(builder.type);
            constructArg.setArg(builder.arg);
            return constructArg;
        }
    }
}
