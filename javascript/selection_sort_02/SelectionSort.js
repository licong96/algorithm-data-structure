// 选择排序
class SelectionSort {

  sort(arr) {
    for (let i = 0; i < arr.length; i++) {
      let minIndex = i;
      for (let j = i; j < arr.length; j++) {
        if (arr[j] < arr[minIndex]) {
          minIndex = j;
        }
      }
      SelectionSort.swap(arr, i, minIndex)
    }
    return arr;
  }

  // 交换位置
  static swap(arr, i, minIndex) {
    const temp = arr[i];
    arr[i] = arr[minIndex];
    arr[minIndex] = temp;
  }
}

const arr = [4, 2, 6, 8, 11, 3, 1, 9, 15, 7, 12];
const s = new SelectionSort();

console.log(s.sort(arr));

