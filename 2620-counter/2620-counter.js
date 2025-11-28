/**
 * @param {number} n
 * @return {Function} counter
 */
var createCounter = function(n) {
    let currentCount = n;    // store the initial number
    
    return function() {
        return currentCount++;   // return then increment
    };
};


/** 
 * const counter = createCounter(10)
 * counter() // 10
 * counter() // 11
 * counter() // 12
 */