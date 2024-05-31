// https://leetcode.com/problems/function-composition

function composeFunctions(functions) {
    // If the array of functions is empty, return the identity function
    if (functions.length === 0) {
        return x => x;
    }
    
    // If there's only one function, return it
    if (functions.length === 1) {
        return functions[0];
    }
    
    // Recursive case: Compose the last function with the composition of the rest
    return function(x) {
        // Apply the last function to the result of the composition of the rest
        return functions[functions.length - 1](composeFunctions(functions.slice(0, -1))(x));
    };
}