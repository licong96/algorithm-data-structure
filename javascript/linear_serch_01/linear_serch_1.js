/**
 * 线性查找算法
 */
class LinearSerch {

  search(data, target) {
    for (let i = 0; i < data.length; i++) {
      if (data[i] === target) {
        return i
      }
    }
    return -1
  }
  
}

const data = [10, 31, 42, 52, 1, 25, 35, 64]
const linear = new LinearSerch();

const n1 = linear.search(data, 1)
console.log(n1)

const n2 = linear.search(data, 3)
console.log(n2)