// https://leetcode.com/problems/apply-transform-over-each-element-in-array

/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
function map(arr, fn) {
    const mappedArr = [];
    
    // Iterate over the array and apply the mapping function
    for (let i = 0; i < arr.length; i++) {
        // Apply the mapping function to the element and add it to the mapped array
        mappedArr.push(fn(arr[i], i));
    }
    
    return mappedArr;
}