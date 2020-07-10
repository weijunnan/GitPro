public class SegmentTree<E> {

    private E[] tree;
    private E[] data;
    private Merger<E> merger;

    public SegmentTree(E[] arr,Merger<E> merger) {
        this.merger=merger;

        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];

        }
        tree = (E[])new Object[4 * arr.length];
        //线段树初始化时候
        bulidSegementTree(0,0,arr.length-1);

    }

    //更新操作将index位置，修改为元素e
    public void set(int index, E e) {
        if (index < 0 || index >=data.length) {
            throw new IllegalArgumentException("index is illegal");
        }
        //将index索引为的元素修改为e,初始化set函数
        data[index]=e;
        set(0, 0, data.length - 1, index,e);
    }

    private void set(int treeindex, int L, int R,int index, E e) {
        //递归到底的情况
        if (L == R) {
            tree[treeindex]=e;
            return;
        }
        int mid = L + (R - L) / 2;
        int lefttreeIndex = leftChild(treeindex);
        int righttreeIndex = rightChild(treeindex);

        //递归调用，判断在左子树还是在右子树
        //1:在右子树
        if (index >= mid + 1) {
            set(righttreeIndex, mid + 1, R, index,e);
        } else if (index <= mid) {
            set(lefttreeIndex,0,mid,index,e);
        }
        //修改更新了子节点所以父辈节点与需要修改,父辈节点tree【treeindex】
        tree[treeindex] = merger.merge(tree[lefttreeIndex], tree[righttreeIndex]);

    }


    //查询区间函数
    public E Query(int queryL, int queryR) {
        if (queryL < 0 || queryL >= data.length || queryR < 0 || queryR >= data.length || queryL > queryR) {
            throw new IllegalArgumentException("Index is illegal ");
        }
        //初始化查询函数,以根节点
        return Query(0,0,data.length-1,queryL,queryR);
    }

    private E Query(int treeindex,int L,int R,int queryL,int queryR) {
        //1:递归到底的情况
        if (L == queryL && R == queryR) {
            return tree[treeindex];
        }
        //此时需要结果的在左右孩子树中,获取索引
        int mid = L + (R - L) / 2;
        int leftTreeIndex = leftChild(treeindex);
        int rightTreeIndex = rightChild(treeindex);

        //2:判断特殊与左右孩子无关的情况
        if (queryL >=mid + 1) {//与左孩子无关
            return Query(rightTreeIndex, mid + 1,R, queryL, queryR);

        } else if (queryR <= mid) {//与右孩子无关，去左孩子找
            return Query(leftTreeIndex, L, mid, queryL, queryR);
        }

        //3:当左右孩子都包含想要的区间时候
        E leftResult = Query(leftTreeIndex, L, mid, queryL, mid);
        E rightResult = Query(rightTreeIndex, mid + 1, R, mid + 1, queryR);

        return merger.merge(leftResult, rightResult);

    }

    private void bulidSegementTree(int treeindex, int L, int R) {
        //递归书写线段树1:递归到底的
        if (L == R) {
            tree[treeindex] = data[R];
            return;
        }
        //2当有左右区间孩子树的时候,获取索引
        int leftTreeindex = leftChild(treeindex);
        int rightTreeindex = rightChild(treeindex);
        //设置分割变量Mid
        int mid = L + (R - L) / 2;
        //基于左右两个区间递归的调用线段树
        bulidSegementTree(leftTreeindex, L, mid);
        bulidSegementTree(rightTreeindex, mid + 1, R);

        tree[treeindex] = merger.merge(tree[leftTreeindex], tree[rightTreeindex]);

    }

    public int getSize(){
        return data.length;
    }

    public E get(int index){
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Index is illegal ");
        }
        return data[index];
    }

    //返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index) {
        return 2*index+1;
    }

    //返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index) {
        return 2*index+2;
    }

    //重写toString方法

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append('[');
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null) {
                res.append(tree[i]);
            }
            else
                res.append(" null ");
            if (i != tree.length - 1) {
                res.append(',');
            }

        }
        res.append(']');
        return res.toString();
    }
}




