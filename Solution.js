
/**
 * @param {string} s
 * @return {string}
 */
var minRemoveToMakeValid = function (s) {

    const stackIndexBrackets = [];
    const indexBracketsToRemove = new Set();
    const size = s.length;

    for (let i = 0; i < size; i++) {

        if (s.charAt(i) === '(') {
            stackIndexBrackets.push(i);
        } else if (s.charAt(i) === ')') {

            if (stackIndexBrackets.length !== 0) {
                stackIndexBrackets.pop();
            } else {
                indexBracketsToRemove.add(i);
            }
        }
    }

    while (stackIndexBrackets.length > 0) {
        indexBracketsToRemove.add(stackIndexBrackets.pop());
    }

    const validExpression = [];
    for (let i = 0; i < size; i++) {
        if (!indexBracketsToRemove.has(i)) {
            validExpression.push(s.charAt(i));
        }
    }
    return validExpression.join('');
};
