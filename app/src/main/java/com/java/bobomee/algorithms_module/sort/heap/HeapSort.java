/*
 *  Copyright (C) 2017.  BoBoMEe(wbwjx115@gmail.com)
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.java.bobomee.algorithms_module.sort.heap;

import com.java.bobomee.algorithms_module.Utils;

import static com.java.bobomee.algorithms_module.Utils.swap;

/**
 * @author 汪波
 * @version 1.0
 * @since 2017/4/14 汪波 first commit
 *
 * http://bubkoo.com/2014/01/14/sort-algorithm/heap-sort/
 */
public class HeapSort {
  private static <T extends Comparable<T>> void heapSort(T[] arr) {
    int len = arr.length - 1;
    for (int i = len / 2 - 1; i >= 0; i--) { //堆构造
      heapAdjust(arr, i, len);
    }
    while (len >= 0) {
      Utils.swap(arr, 0, len--);    //将堆顶元素与尾节点交换后，长度减1，尾元素最大
      heapAdjust(arr, 0, len);    //再次对堆进行调整
    }
  }

  private static <T extends Comparable<T>> void heapAdjust(T[] arr, int i, int len) {
    int left, right, j;
    while ((left = 2 * i + 1) <= len) {    //判断当前父节点有无左节点（即有无孩子节点，left为左节点）
      right = left + 1;  //右节点
      j = left;   //j"指针指向左节点"
      if (j < len && arr[left].compareTo(arr[right]) < 0)    //右节点大于左节点
      {
        j++;     //当前把"指针"指向右节点
      }
      if (arr[i].compareTo(arr[j]) < 0)    //将父节点与孩子节点交换（如果上面if为真，则arr[j]为右节点，如果为假arr[j]则为左节点）
      {
        swap(arr, i, j);
      } else         //说明比孩子节点都大，直接跳出循环语句
      {
        break;
      }
      i = j;
    }
  }

  public static void main(String[] args) {
    Integer a[] = { 20, 50, 20, 40, 70, 10, 80, 30, 60 };
    System.out.println("before sort:");
    Utils.print(a);

    heapSort(a); // 桶排序

    System.out.println("after  sort:");
    Utils.print(a);
  }
}
