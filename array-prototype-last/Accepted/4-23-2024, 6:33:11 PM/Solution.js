// https://leetcode.com/problems/array-prototype-last

// Extend Array prototype
Array.prototype.last = function() {
    // Check if the array is empty
    if (this.length === 0) {
        return -1;
    } else {
        // Return the last element of the array
        return this[this.length - 1];
    }
};


