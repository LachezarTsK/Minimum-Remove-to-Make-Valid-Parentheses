
#include <set>
#include <deque>
using namespace std;

class Solution {
    
public:
    string minRemoveToMakeValid(string s) {

        deque<int> stackIndexBrackets;
        set<int> indexBracketsToRemove;
        int size = s.length();

        for (int i = 0; i < size; i++) {

            if (s[i] == '(') {
                stackIndexBrackets.push_back(i);
            } else if (s[i] == ')') {

                if (!stackIndexBrackets.empty()) {
                    stackIndexBrackets.pop_back();
                } else {
                    indexBracketsToRemove.insert(i);
                }
            }
        }

        while (!stackIndexBrackets.empty()) {
            indexBracketsToRemove.insert(stackIndexBrackets.front());
            stackIndexBrackets.pop_front();
        }

        string validExpression{};
        for (int i = 0; i < size; i++) {
            if (indexBracketsToRemove.find(i) == indexBracketsToRemove.end()) {
                validExpression.push_back(s[i]);
            }
        }
        return validExpression;
    }
};
