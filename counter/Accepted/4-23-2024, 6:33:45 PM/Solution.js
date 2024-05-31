// https://leetcode.com/problems/counter

function createCounter(n) {
    // Initialize a variable to store the current value
    let currentValue = n;

    // Define the counter function
    function counter() {
        // Increment the current value and return it
        return currentValue++;
    }

    // Return the counter function
    return counter;
}

// Example usage:
function testCounter(n, calls) {
    const counter = createCounter(n);
    const result = [];
    for (let i = 0; i < calls.length; i++) {
        if (calls[i] === "call") {
            result.push(counter());
        }
    }
    return result;
}