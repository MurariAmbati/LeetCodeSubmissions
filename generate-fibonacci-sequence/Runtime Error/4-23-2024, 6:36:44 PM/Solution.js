// https://leetcode.com/problems/generate-fibonacci-sequence

/**
 * @return {Generator<number>}
 */
function* fibGenerator() {
    let prev = 0;
    let curr = 1;
    
    // If callCount is 0, return an empty sequence
    if (callCount === 0) {
        return [];
    }
    
    // Yield the first two numbers in the sequence
    yield prev;
    if (callCount === 1) return;
    yield curr;

    // Generate the rest of the sequence
    for (let i = 2; i < callCount; i++) {
        const next = prev + curr;
        yield next;
        prev = curr;
        curr = next;
    }
}

/**
 * const gen = fibGenerator();
 * gen.next().value; // 0
 * gen.next().value; // 1
 */