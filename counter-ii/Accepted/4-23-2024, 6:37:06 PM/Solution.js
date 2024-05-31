// https://leetcode.com/problems/counter-ii

function createCounter(init) {
    let currentValue = init;

    return {
        increment: function() {
            return ++currentValue;
        },
        decrement: function() {
            return --currentValue;
        },
        reset: function() {
            currentValue = init;
            return currentValue;
        }
    };
}