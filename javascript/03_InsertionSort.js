// 插入排序
class InsertionSort {

  sort(arr) {

    for (let i = 0; i < arr.length; i++) {

      for (let j = i; j - 1 >= 0; j--) {
        if (arr[j] < arr[j - 1]) {
          InsertionSort.swap(arr, j, j-1);
        } else {
          break;
        }
      }
    }
  }

  // 小优化版本
  sort2(arr) {

    for (let i = 0; i < arr.length; i++) {

      let temp = arr[i];
      let j = i;
      for (; j - 1 >= 0 && temp < arr[j - 1]; j--) {
        arr[j] = arr[j - 1];
      }
      arr[j] = temp;
    }
  }

  // 交换位置
  static swap(arr, i, j) {
    let temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  // 测试排序性能
  testSort(arr) {
    const startTime = Date.now();
    this.sort2(arr)
    const endTime = Date.now();

    if (!InsertionSort.isSorted(arr)) {
      return "Error 排序功能有误"
    }
    return `Success 数据量:${arr.length}，用时: ${(endTime - startTime) / 1000}秒`;
  }

  // 验证排序正确性
  static isSorted(arr) {
    for (let i = 0; i < arr.length - 1; i++) {
      if (arr[i] > arr[i + 1]) {
        return false;
      }
    }
    return true;
  }

  // 生成有序数组
  generateOrderedArray(n) {
    const arr = [];
    for (let i = 0; i < n; i++) {
      arr.push(i)
    }
    return arr;
  }

  // 生成随机数组
  generateRandomArray(n, b = 10) {
    const arr = [];
    for (let i = 0; i < n; i++) {
      arr.push(Math.floor(Math.random() * b))
    }
    return arr;
  }
}

const s = new InsertionSort();

const arr = s.generateRandomArray(10000, 100);
const arr2 = s.generateRandomArray(100000, 100);

console.log(s.testSort(arr))
console.log(s.testSort(arr2))

