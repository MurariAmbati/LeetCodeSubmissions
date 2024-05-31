// https://leetcode.com/problems/sleep

function sleep(millis) {
    return new Promise(resolve => {
        setTimeout(resolve, millis);
    });
}
