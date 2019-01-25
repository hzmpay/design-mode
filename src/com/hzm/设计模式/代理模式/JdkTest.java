package com.hzm.设计模式.代理模式;

/**
 * JdkTest
 *
 * @author Hezeming
 * @version 1.0
 * @date 2019年01月25日
 */
public class JdkTest {

    public static void main(String[] args) {
        int index = 2;
        Object[] elementData = new Object[]{0, 1, 2, 3, 4, 5, 6};
        int size = elementData.length;
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index + 1, elementData, index,
                    numMoved);
        for (Object elementDatum : elementData) {

            System.out.println(elementDatum);
        }

        System.out.println("=================================");

        Object[] result = new Object[7];
        System.arraycopy(elementData, 1, result, 0, 2);

        for (Object o : result) {
            System.out.println(o);
        }
    }
}
