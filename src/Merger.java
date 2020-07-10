public interface Merger<E> {
    E merge(E a, E b);//将两个参数转换为元素E

}
