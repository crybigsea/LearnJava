package demo.sort.BubbleSorts;

import java.util.List;

import demo.sort.BaseSort;

/**
 * 冒泡排序
 */
public class BubbleSort extends BaseSort {
    public BubbleSort(){
        super("冒泡排序");
    }

    @Override
    public List<Integer> Run(List<Integer> list) {
        int temp;
        int size = list.size();
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
        return list;
    }
}