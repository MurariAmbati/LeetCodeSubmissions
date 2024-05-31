// https://leetcode.com/problems/array-reduce-transformation

function customReduce(nums, fn, init) {
    // If the array is empty, return the initial value
    if (nums.length === 0) {
        return init;
    }

    // Initialize the accumulator with the initial value
    let accumulator = init;

    // Iterate through the array, applying the reducer function
    for (let i = 0; i < nums.length; i++) {
        accumulator = fn(accumulator, nums[i]);
    }

    // Return the final accumulated value
    return accumulator;
}
