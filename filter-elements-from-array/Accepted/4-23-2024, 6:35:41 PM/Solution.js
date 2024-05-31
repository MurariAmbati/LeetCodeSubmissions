// https://leetcode.com/problems/filter-elements-from-array

function filter(arr, fn) {
    const filteredArr = [];
    
    // Iterate over the array and apply the filtering function
    for (let i = 0; i < arr.length; i++) {
        // Check if the filtering function evaluates to a truthy value
        if (fn(arr[i], i)) {
            // If true, add the element to the filtered array
            filteredArr.push(arr[i]);
        }
    }
    
    return filteredArr;
}